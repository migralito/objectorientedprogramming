package applesignin;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        doHttp();
    }

    private static void doHttp() {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost httpPost = new HttpPost("https://appleid.apple.com/auth/token");
            httpPost.setEntity(new UrlEncodedFormEntity(asList(
                    new BasicNameValuePair("client_id", "com.munitienda.services"),
                    new BasicNameValuePair("client_secret", "eyJraWQiOiJLMjNQWFE4UVRMIiwiYWxnIjoiRVMyNTYifQ.eyJpc3MiOiIzTUoyUjdQNktGIiwiaWF0IjoxNjIyNzI4NDg5LCJleHAiOjE2MzgyODA0ODksImF1ZCI6Imh0dHBzOi8vYXBwbGVpZC5hcHBsZS5jb20iLCJzdWIiOiJjb20ubXVuaXRpZW5kYS5zZXJ2aWNlcyJ9.DeO2qZvipH172OtO8pRsAAIoGHryKNZN7g67CdKrx1sIn-L3a2mo0xc2TBE6tOhIC1U4M-YSuZ9qrqi8teqAsw"),
                    new BasicNameValuePair("code", "CODE"),
                    new BasicNameValuePair("grant_type", "authorization_code")
            )));

            System.out.println("Executing request " + httpPost.getMethod() + " " + httpPost.getUri());

            final String responseBody = httpclient.execute(httpPost, response -> {
                final int status = response.getCode();
                final HttpEntity entity = response.getEntity();
                try {
                    return "HTTP " + status + " " + (entity != null ? EntityUtils.toString(entity) : null);
                } catch (final ParseException ex) {
                    throw new ClientProtocolException(ex);
                }
            });
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
