package applesignin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.InputStreamEntity;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ApleSignInServerMain {
    public static void main(String[] args) throws Exception {
        // Create and configure a ThreadPool.
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setName("server");

        // Create a Server instance.
        Server server = new Server(threadPool);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.addConnector(connector);

        // Set a simple Handler to handle requests/responses.
        server.setHandler(new AbstractHandler()
        {
            @Override
            public void handle(String target, Request jettyRequest, HttpServletRequest request, HttpServletResponse response) {
                Map<String, String> headersMap = Collections.list(request.getHeaderNames()).stream()
                        .collect(Collectors.toMap(name -> name, request::getHeader));
                System.out.println(headersMap);
                try {
                    System.out.println(EntityUtils.toString(
                            new InputStreamEntity(
                                    request.getInputStream(),
                                    ContentType.create(request.getContentType()))));
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                // Mark the request as handled so that it
                // will not be processed by other handlers.
                jettyRequest.setHandled(true);
            }
        });

        // Start the Server so it starts accepting connections from clients.
        server.start();
    }
}
