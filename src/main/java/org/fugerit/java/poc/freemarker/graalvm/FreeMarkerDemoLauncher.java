package org.fugerit.java.poc.freemarker.graalvm;

public class FreeMarkerDemoLauncher {

    public FreeMarkerDemoLauncher() {
        FreeMarkerDemoFacade demo = new FreeMarkerDemoFacade();
        // test a template whose processing will fail
        demo.runKoTemplate();
        // test a template whose processing succeeds
        demo.runVersionTemplate();
    }

}
