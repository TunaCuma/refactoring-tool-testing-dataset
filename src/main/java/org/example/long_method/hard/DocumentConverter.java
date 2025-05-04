package org.example.long_method.hard;

public class DocumentConverter {
    /**
     * Loads DOCX, extracts text, converts to Markdown, embeds images,
     * writes output file, and returns path.
     */
    public String convert(String docxPath, String mdPath) {
        try {
            // stub: read binary
            byte[] data = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(docxPath));
            String text = new String(data); // fake extraction
            // convert headings
            String md = text.replaceAll("<h(\d)>(.*?)</h\1>", "#$1 $2
");
            // images
            md = md.replaceAll("<img src=\"(.*?)\" />", "![]($1)");
            java.nio.file.Files.writeString(java.nio.file.Paths.get(mdPath), md);
            return mdPath;
        } catch (Exception e) {
            return null;
        }
    }
}
