package _01_intro_to_APIs;

import _01_intro_to_APIs.data_transfer_objects.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
An Application Programming Interface (API) is an access point to an external service.  For example, this Cheetah Search API allows
people to send a request, and receive information about books.  This opens a whole world of possibilities, allowing
the programs you write to communicate with other applications which are on the internet.  At this point, we will focus on APIs
that allow us to GET information, but some APIs also allow users to change the data that is stored
by that service.

The documentation for the Cheetah Search API can be found here:
https://cheetah.api.jointheleague.org

This API was created by the Cheetah class at the League of Amazing Programmers, for their level 7 project.
 */


public class CheetahSearchApi {

    private static final String baseUrl = "https://cheetah.api.jointheleague.org/searchLocResults";

    //We will use WebClient to make the request
    private WebClient webClient;

    public CheetahSearchApi() {
        //build the WebClient
        this.webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void testRequest() {

        //the following code makes the request and receives the response from newsapi.org
        //the .uri() is used to build the uri on top of the previously specified base url from the constructor.
        //This uri is where are making our GET request
        //the resulting uri would look like:
        //http://newsapi.org/v2/everything?q=pizza&sortBy=popularity&apiKey=59ac01326c584ac0a069a29798794bec
        Mono<String> stringMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", "Java")
                        .build())
                .retrieve()
                .bodyToMono(String.class);


        /*
            JSON (JavaScript Object Notation) is the current standard for transmitting data objects over the internet.
            It consists of attribute-value pairs.  A simple JSON object may look like:
            { name : "John Doe", age : 15 }

            The response to our request is received in JSON, but we need to turn that into a Java object in order
            manipulate it effectively in our program.

            Notice the classes in the data_transfer_objects package, here you have been provided with
            the Plain Old Java Objects that represent the response we expect from our specific request.
            Normally you would need to make these yourself.
            There are multiple classes in this case, because some of the fields in the response are, themselves, objects.
            You can use a tools like jsonschema2pojo.com to help with creating these classes, by inputting the JSON
            response from a request that you make.
            If using jsonschema2pojo.com, select Target Language = java, Source Type = JSON, Annotation Style = Gson
             */

        //Notice on line 55 that we are currently converting the response to String.class.
        //This is how we would get the response as a String in order to create the classes in the
        //data_transfer_objects package.
        //Once we have created those classes, we are able to save the response as a java object, and effectively
        //manipulate the response using getters to pull exactly what we need out of it.
        String response = stringMono.block();

        System.out.println(response);
    }

    public String getBookByTopic(String topic) {

        Mono<Result[]> cheetahWrapperMono = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", topic)
                        .build())
                .retrieve()
                .bodyToMono(Result[].class);

        //collect the response into a java object using the classes you just created
        Result[] cheetahWrapper = cheetahWrapperMono.block();

        //We'll just use the first result from the list
        Result result = cheetahWrapper[0];

        //get the first article (these are just java objects now)
        String bookTitle = result.getTitle();

        //get the title of the article
        String bookLink = result.getLink();

        //create the message
        String message =
                bookTitle + " -\n"
                        + bookLink;

        //send the message
        return message;

    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

}


