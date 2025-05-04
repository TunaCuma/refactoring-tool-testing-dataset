package org.example.long_method.hard;

public class EmailTemplateEngine {
    /**
     * Loads template, replaces placeholders, processes conditional sections,
     * inlines CSS, and returns HTML content.
     */
    public String render(String templatePath, java.util.Map<String, Object> context) {
        String tpl;
        try {
            tpl = java.nio.file.Files.readString(java.nio.file.Paths.get(templatePath));
        } catch (Exception e) {
            return "Template load error";
        }
        // replace placeholders
        for (var entry : context.entrySet()) {
            tpl = tpl.replace("{{" + entry.getKey() + "}}", String.valueOf(entry.getValue()));
        }
        // conditionals: {{#if key}}...{{/if}}
        tpl = tpl.replaceAll("\{\#if (\w+)\}(.*?)\{\/if\}", m -> {
            String key = m.group(1);
            String body = m.group(2);
            return Boolean.TRUE.equals(context.get(key)) ? body : "";
        });
        // inline CSS stub
        tpl = tpl.replaceAll("<link rel=\"stylesheet\" href=\"(.*?)\" />", "");
        // return
        return tpl;
    }
}
