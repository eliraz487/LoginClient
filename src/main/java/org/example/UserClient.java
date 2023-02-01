package org.example;

import com.google.gson.Gson;
import org.example.vo.UsersEntityUpdateVO;
import org.example.vo.UsersEntityVO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class UserClient {

    private static final String CREATEUSER = "http://localhost:8080/Login/tryLogin";
    private static final String EDITUSERNAME = "http://localhost:8080/Login/tryLogin";
    private static final String EDITPASSWORD = "http://localhost:8080/Login/tryLogin";

    public static String createUser(UsersEntityVO usersEntityVO) throws RuntimeException {

        HttpRequest httpRequest;
        String massege;
        Gson gson = new Gson();
        String json = gson.toJson(usersEntityVO);
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(CREATEUSER))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8)).build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            massege = postResponse.body();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        return massege;
    }


    public static String editUser(UsersEntityUpdateVO usersEntityUpdateVO) throws RuntimeException {
        HttpRequest httpRequest;
        String massege;
        Gson gson = new Gson();
        String json = gson.toJson(usersEntityUpdateVO);
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(EDITUSERNAME))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8)).build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            massege = postResponse.body();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        return massege;
    }

    public static String Editpassword(UsersEntityUpdateVO usersEntityUpdateVO) throws RuntimeException {
        HttpRequest httpRequest = null;
        String massege;
        Gson gson = new Gson();
        String json = gson.toJson(usersEntityUpdateVO);
        try {
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(EDITPASSWORD))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8)).build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            massege = postResponse.body();
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        return massege;
    }
}
