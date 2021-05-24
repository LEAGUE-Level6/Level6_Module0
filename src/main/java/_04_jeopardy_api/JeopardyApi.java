package _04_jeopardy_api;

import _01_intro_to_APIs.data_transfer_objects.Result;
import _04_jeopardy_api.data_transfer_objects.Clue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
Now lets use a Jeopardy API to make a (modified) game.
To simplify things a little bit, we will just ask the user one question from each available point category
 */

public class JeopardyApi {

    private final WebClient webClient;

    private static final String baseUrl = "http://jservice.io/api/clues";

    public JeopardyApi() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Clue getClue(int value) {

        //1  Use the WebClient code from the previous exercises to make the request:
        //Note:
        //The base URL has already been provided, but we we need to take the "value" parameter passed into
        //this method and supply it as a query parameter with the name of "value".  This allows us to retrieve a question
        //with the specified point value.
        //
        //Make sure to save the response as type Clue[].class in the bodyToMono() method call


        //2
        //Get a random number less than the size of the Clue array

        //3
        //return the clue at the random index you just created

        return null;
    }
}
