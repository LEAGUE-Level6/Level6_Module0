package _02_cat_facts_API;

import _02_cat_facts_API.data_transfer_objects.CatWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/*

Use the meow facts API to show the user a random cat fact.
Make an initial request, saving the response as a String to facilitate making your Plain Old Java Objects to represent the request.
Then, write a method that will save the response as an instance of your object, returning the fact from that object.

A swagger page for this very simple API can be found here: https://app.swaggerhub.com/apis-docs/whiterabbit8/meowfacts/1.0.0

 */
public class CatFactsApi {

    private static final String baseUrl = "https://meowfacts.herokuapp.com/";

    private final WebClient webClient;

    public CatFactsApi() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void testRequest(){
        //Use the WebClient to make the request, converting the response to a String
        //this request doesn't require url parameters, so you can omit the .uri() method call entirely
        Flux<String> stringFlux = webClient.get()
                .retrieve()
                .bodyToFlux(String.class);

        //collect the response from the Flux object
        String response = stringFlux.collectList().block().get(0);

        //print out the actual JSON response -
        //this is what you will input into jsonschema2pojo.com
        //System.out.println(response);

        //Use http://www.jsonschema2pojo.org/ to generate your POJOs
        //and place them in the cat_facts_API.data_transfer_objects package.
        //select Target Language = java, Source Type = JSON, Annotation Style = Gson

    }

    public String getCatFact() {

        //Make the request, saving the response in an object of the type that you just created in your
        //data_transfer_objects package
        Flux<CatWrapper> catWrapperFlux = webClient.get()
                .retrieve()
                .bodyToFlux(CatWrapper.class);

        //collect the response into a java object using the class you just created
        CatWrapper catWrapper = catWrapperFlux.collectList().block().get(0);

        //get the cat fact from the response
        String message = catWrapper.getData().get(0);

        //send the message
        return message;

    }
}
