package _02_cat_facts_API;

import _02_cat_facts_API.data_transfer_objects.CatWrapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

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

    public String getCatFact() {

        //create the request URL
        //a swagger page for this very simple API can be found here: https://app.swaggerhub.com/apis-docs/whiterabbit8/meowfacts/1.0.0
        //this request doesn't require url parameters, so you can omit the .uri() method call
        Flux<CatWrapper> catWrapperFlux = webClient.get()
                .retrieve()
                /*.onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())*/
                .bodyToFlux(CatWrapper.class);

        //uncomment the next line to see the actual JSON response -
        // this is what was inputted into jsonschema2pojo.com
        //System.out.println(userJSON);

        //Use http://www.jsonschema2pojo.org/ to generate your POJOs
        //and place them in the cat_facts_API.pojo package
        //select Target Language = java, Source Type = JSON, Annotation Style = Gson

        //deserialize the response into a java object using the class you just created
        CatWrapper catWrapper = catWrapperFlux.collectList().block().get(0);

        //get the cat fact from the response
       // String fact = catWrapper.getFact();
        //send the message
        return catWrapper.getData().get(0);

    }
}
