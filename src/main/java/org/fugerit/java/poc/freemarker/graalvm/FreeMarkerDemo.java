package org.fugerit.java.poc.freemarker.graalvm;

import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerDemo {

    private final static Logger LOG = Logger.getLogger(FreeMarkerDemo.class.getName());

    public static void main(String[] args) {
        FreeMarkerDemo demo = new FreeMarkerDemo();
        // test a template whose processing will fail
        demo.runKoTemplate();
        // test a template whose processing succeeds
        demo.runVersionTemplate();
    }

    public void runVersionTemplate() {
        this.runDefault( "version.ftl" );
    }

    public void runKoTemplate() {
        this.runDefault( "ko.ftl" );
    }

    private void runDefault( String templateName ) {
        try ( StringWriter writer = new StringWriter() ) {
            Map<String, Object> dataModel = new HashMap<>();
            this.testTemplate( writer, templateName, dataModel );
            LOG.info( "OK, template : %n%s".formatted( writer.toString() ) );
        } catch (Throwable t) {
            LOG.error( "KO, Fatal error : %s".formatted( t ), t );
        }
    }

    private void testTemplate(Writer writer, String templatePath, Map<String, Object> dataModel) throws IOException, TemplateException {
        Configuration cfg = new Configuration( Configuration.VERSION_2_3_34 );
        cfg.setClassForTemplateLoading( FreeMarkerDemo.class, "/templates" );
        Template template = cfg.getTemplate( templatePath );
        template.process( dataModel, writer );
    }

}
