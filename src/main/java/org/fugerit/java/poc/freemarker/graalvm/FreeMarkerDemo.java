package org.fugerit.java.poc.freemarker.graalvm;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerDemo {

    public static void main(String[] args) {
        FreeMarkerDemo demo = new FreeMarkerDemo();
        demo.runVersionTemplate();
    }

    public void runVersionTemplate() {
        try ( StringWriter writer = new StringWriter() ) {
            Map<String, Object> dataModel = new HashMap<>();
            this.testTemplate( writer, "version.ftl", dataModel );
            System.out.println( writer );
        } catch (Throwable t) {
            System.err.println( t.getMessage() );
            t.printStackTrace();
        }
    }

    public void testTemplate(Writer writer, String templatePath, Map<String, Object> dataModel) throws IOException, TemplateException {
        Configuration cfg = new Configuration( Configuration.VERSION_2_3_34 );
        cfg.setClassForTemplateLoading( FreeMarkerDemo.class, "/templates" );
        Template template = cfg.getTemplate( templatePath );
        template.process( dataModel, writer );
    }

}
