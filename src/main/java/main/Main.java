package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MirrorServlet;

/**
 * Created by mardv_000 on 12/23/15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        MirrorServlet mirrorServlet = new MirrorServlet();

        ServletContextHandler contex = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contex.addServlet(new ServletHolder(mirrorServlet), "/mirror");

        Server server = new Server(8080);
        server.setHandler(contex);

        server.start();
        server.join();

    }
}
