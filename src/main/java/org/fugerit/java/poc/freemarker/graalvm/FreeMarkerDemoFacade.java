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

public class FreeMarkerDemoFacade {

    private final static Logger LOG = Logger.getLogger(FreeMarkerDemoFacade.class.getName());

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
        cfg.setClassForTemplateLoading( FreeMarkerDemoFacade.class, "/templates" );
        Template template = cfg.getTemplate( templatePath );
        template.process( dataModel, writer );
    }

}
