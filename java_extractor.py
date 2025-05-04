#!/usr/bin/env python3
import re
import os
import sys
import argparse

def extract_java_files(input_file, package_name="org.example", subfolder=None, use_maven_layout=False):
    """Extract Java files and organize them in Maven-style structure or custom layout"""
    
    # Define base paths
    if use_maven_layout:
        main_base = os.path.join("src", "main", "java")
        test_base = os.path.join("src", "test", "java")
    else:
        main_base = "src"
        test_base = "test"
    
    # Add package path
    package_path = package_name.replace('.', os.sep)
    
    # Add subfolder if specified
    if subfolder:
        subfolder_path = subfolder.replace('/', os.sep)
        main_folder = os.path.join(main_base, package_path, subfolder_path)
        test_folder = os.path.join(test_base, package_path, subfolder_path)
    else:
        main_folder = os.path.join(main_base, package_path)
        test_folder = os.path.join(test_base, package_path)
    
    # Create folders if they don't exist
    os.makedirs(main_folder, exist_ok=True)
    os.makedirs(test_folder, exist_ok=True)
    
    # Read the input file
    try:
        with open(input_file, 'r') as f:
            content = f.read()
    except FileNotFoundError:
        print(f"Error: File '{input_file}' not found.")
        sys.exit(1)
    
    # Split by file markers (// File: filename.java)
    file_pattern = r'//\s*File:\s*(\w+\.java)'
    
    # Find all file markers
    file_markers = list(re.finditer(file_pattern, content))
    
    if not file_markers:
        print("No Java files found in the input file.")
        sys.exit(1)
    
    # Extract each file
    for i, marker in enumerate(file_markers):
        filename = marker.group(1)
        start_pos = marker.end()
        
        # Find the end of the file (next file marker or end of content)
        if i < len(file_markers) - 1:
            end_pos = file_markers[i + 1].start()
        else:
            end_pos = len(content)
        
        # Extract the file content
        file_content = content[start_pos:end_pos].strip()
        
        # Add package declaration
        if not file_content.startswith('package'):
            if subfolder:
                # For subfolders, append the subfolder to package name
                subfolder_package = subfolder.replace('/', '.')
                full_package = f"{package_name}.{subfolder_package}"
            else:
                full_package = package_name
            
            package_declaration = f"package {full_package};\n\n"
            file_content = package_declaration + file_content
        
        # Determine the target folder
        if filename.endswith('Test.java'):
            target_folder = test_folder
        else:
            target_folder = main_folder
            
        # Full path for the file
        file_path = os.path.join(target_folder, filename)
        
        # Create the file
        with open(file_path, 'w') as f:
            f.write(file_content + '\n')
        
        print(f"Created: {file_path}")
    
    return len(file_markers)

def show_directory_structure(path, prefix=""):
    """Recursively display directory structure"""
    items = sorted(os.listdir(path))
    for i, item in enumerate(items):
        item_path = os.path.join(path, item)
        is_last = i == len(items) - 1
        
        if os.path.isdir(item_path):
            print(f"{prefix}{'└── ' if is_last else '├── '}{item}/")
            new_prefix = prefix + ('    ' if is_last else '│   ')
            show_directory_structure(item_path, new_prefix)
        else:
            print(f"{prefix}{'└── ' if is_last else '├── '}{item}")

def main():
    parser = argparse.ArgumentParser(description='Extract Java files and organize in Maven-style structure')
    parser.add_argument('input_file', help='Input file containing Java code')
    parser.add_argument('--package', default='org.example', help='Package name (default: org.example)')
    parser.add_argument('--subfolder', help='Subfolder within package (e.g., long_method/easy)')
    parser.add_argument('--maven', action='store_true', help='Use Maven-style layout (src/main/java, src/test/java)')
    parser.add_argument('--tree', action='store_true', help='Show directory tree after extraction')
    
    args = parser.parse_args()
    
    file_count = extract_java_files(args.input_file, args.package, args.subfolder, args.maven)
    
    print(f"\nExtracted {file_count} Java files successfully!")
    
    if args.maven:
        print(f"Main files are in: src/main/java/{args.package.replace('.', '/')}/")
        print(f"Test files are in: src/test/java/{args.package.replace('.', '/')}/")
    else:
        print(f"Main files are in: src/{args.package.replace('.', '/')}/")
        print(f"Test files are in: test/{args.package.replace('.', '/')}/")
    
    if args.subfolder:
        print(f"Subfolder: {args.subfolder}")
    
    if args.tree:
        print("\nDirectory structure:")
        print(".")
        if args.maven:
            show_directory_structure("src")
        else:
            if os.path.exists("src"):
                print("├── src/")
                show_directory_structure("src", "│   ")
            if os.path.exists("test"):
                print("└── test/")
                show_directory_structure("test", "    ")

if __name__ == "__main__":
    main()
