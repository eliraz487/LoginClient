package org.example;

import com.google.gson.Gson;
import org.example.vo.TryLoginEntityVO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class LoginClient {

    private static final String URL = "http://localhost:8080/Login/tryLogin";

    public static String tryLogin(TryLoginEntityVO tryLoginEntityVO) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = null;
        String id;
        Gson gson =new Gson();
        String json =gson.toJson(tryLoginEntityVO);

            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            id = postResponse.body().toString();

        return id;
    }
}
