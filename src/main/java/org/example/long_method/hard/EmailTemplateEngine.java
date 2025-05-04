package org.example.long_method.hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("\\{\\{#if (\\w+)\\}(.*?)\\{/if\\}");
        Matcher matcher = pattern.matcher(tpl);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String key = matcher.group(1);
            String body = matcher.group(2);
            String replacement = Boolean.TRUE.equals(context.get(key)) ? body : "";
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        tpl = sb.toString();
        
        // inline CSS stub
        tpl = tpl.replaceAll("<link rel=\"stylesheet\" href=\"(.*?)\" />", "");
        // return
        return tpl;
    }
}
