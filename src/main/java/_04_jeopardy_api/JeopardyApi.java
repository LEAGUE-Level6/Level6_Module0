package _04_jeopardy_api;

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

        //create the request URL
        //can be found in the documentation: http://jservice.io/

        Mono<Clue[]> clueWrapperMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("value", value)
                        .build())
                .retrieve()
                /*.onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())*/
                .bodyToMono(Clue[].class);

        //1
        //uncomment the next line to see the actual JSON response -
        // this is what was inputted into jsonschema2pojo.com
        //System.out.println(jsonArray);

        //2
        //Use http://www.jsonschema2pojo.org/ to generate your POJOs
        //and place them in the cat_facts_API.pojo package
        //select Target Language = java, Source Type = JSON, Annotation Style = Gson


        Clue[] clues = clueWrapperMono.block();

        //3
        //Get a random number less than the size of the jsonArray
        int index = new Random().nextInt(clues.length);

        //4
        //return the clue at the random index you just created
        return clues[index];


    }
}
