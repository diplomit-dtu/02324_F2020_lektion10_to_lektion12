import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {
    private static Tomcat tomcat;

    public static void main(String [ ] args)
    {
        tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = System.getenv("PORT"); //Environment variable on server
        if (port==null){
            port="85"; //The port number can be any number. Just make sure the port number is not already in use.
        }

        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector();

        tomcat.addWebapp("/", new File("webcontent/lektion_10").getAbsolutePath());
        tomcat.addWebapp("/lektion10", new File("webcontent/lektion_10").getAbsolutePath());
        tomcat.addWebapp("/lektion11", new File("webcontent/lektion_11").getAbsolutePath());
        tomcat.addWebapp("/lektion12", new File("webcontent/lektion_12").getAbsolutePath());

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        tomcat.getServer().await();

    }
}
