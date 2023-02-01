package org.example;

import org.example.vo.TryLoginEntityVO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Login {

    private static final String URL = "http://localhost:8080/Login/tryLogin";

    public static String tryLogin(TryLoginEntityVO tryLoginEntityVO) {
        HttpRequest httpRequest = null;
        String id;
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL))
                    .GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            id = postResponse.body();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
