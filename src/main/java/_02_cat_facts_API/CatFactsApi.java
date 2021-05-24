package _02_cat_facts_API;

import _02_cat_facts_API.data_transfer_objects.CatWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*

Use the meow facts API to show the user a random cat fact.
In the testRequest() method, we will make an initial request, saving the response as a String as you would if you needed
to generate the Plain Old Java Objects to represent the request.  Then, write a method that will save the response as an instance of
CatWrapper, returning the fact from that object.  You will find that the custom CatWrapper object that represents the response
from this request as been provided for you in the data_transfer_objects package.

A swagger page for this very simple API can be found here: https://app.swaggerhub.com/apis-docs/whiterabbit8/meowfacts/1.0.0

 */
public class CatFactsApi {

    private static final String baseUrl = "https://meowfacts.herokuapp.com/";

    private WebClient webClient;

    public CatFactsApi() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void testRequest(){
        /*
        Use WebClient to make the request, converting the response to String.class.
        This request doesn't require url parameters, so you can omit the .uri() method call entirely
        */



        /*
        Print out the actual JSON response -
        this is what you would input into jsonschema2pojo.com
         */


        /*
        Use could use http://www.jsonschema2pojo.org/ to generate your POJO
        and place it in the cat_facts_API.data_transfer_objects package.
        Select:
        Class name: CatWrapper
        Target Language = java
        Source Type = JSON
        Annotation Style = Gson
        */
    }

    public CatWrapper getCatFact() {

        //Make the request, saving the response in an object of the type that you just created in your
        //data_transfer_objects package (CatWrapper)


        //return the Object
        return null;

    }

    public String findCatFact(){
        //use the getCatFact method to retrieve a cat fact

        //return the first (and only) String in the Arraylist of data in the response
        return null;
    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }
}
