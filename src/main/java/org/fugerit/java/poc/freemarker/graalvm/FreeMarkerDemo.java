package org.fugerit.java.poc.freemarker.graalvm;

public class FreeMarkerDemo {

    public static void main(String[] args) {
        try {
            if ( args.length > 0 ) {
                Class.forName( args[0] );
            }
            handle();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void handle() {
        FreeMarkerDemoFacade demo = new FreeMarkerDemoFacade();
        // test a template whose processing will fail
        demo.runKoTemplate();
        // test a template whose processing succeeds
        demo.runVersionTemplate();
    }


}
