package org.fugerit.java.poc.freemarker.graalvm;

public class FreeMarkerDemo {

    public static void main(String[] args) {
        try {
            if ( args.length > 0 ) {
                Class.forName( args[0] );
            }
            Class<?> c = Class.forName( "org.fugerit.java.poc.freemarker.graalvm.FreeMarkerDemoLauncher" );
            c.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
