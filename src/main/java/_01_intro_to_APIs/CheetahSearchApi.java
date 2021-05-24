package _01_intro_to_APIs;

import _01_intro_to_APIs.data_transfer_objects.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
In a broad sense, an Application Programming Interface (API) is an interface that defines the interactions that are
possible between two applications.  In practice, you can think of API as a list of request that can be made to another application over
the internet, which result in retrieving data, or manipulating the data managed by that application.  For example, the Cheetah Search API allows
people to send a request, and receive information about books.  Having your the applications you write utilize APIs opens
a whole world of possibilities, allowing you to take advantage of the vast amounts of data and services present on the internet.
At this point we will focus on simply retrieving data from an API, but some APIs also allow users to change the data that is stored
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

        /*
        The following code makes the request and receives the response from cheetah.api.jointheleague.org.
        In this scenario the .uri() method is is used to add our search term as a URL parameter
        at the end of the previously specified base url from the constructor.
        This uri is where we are making our GET request, and in its complete form looks like:
        https://cheetah.api.jointheleague.org/searchLocResults?q=java
        */
        String response = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", "Java")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(response);

        /*
            JSON (JavaScript Object Notation) is the current standard for transmitting complex data (i.e. objects) over the internet.
            It consists of attribute-value pairs.  A simple JSON object might look like:
            { name : "John Doe", age : 15 }

            The response to our request is received in JSON, but we need to turn that into a Java object in order
            manipulate it effectively within our program.

            Notice the classes in the data_transfer_objects package.  Here you have been provided with
            the Plain Old Java Objects that represent the response we expect from our specific request.
            Normally you would need to make these yourself.
            There are multiple classes in this case, because some of the fields in the response are, themselves, objects.
            You can use a tools like jsonschema2pojo.com to help with creating these classes, by inputting the JSON
            response from a sample request that you make.
            If using jsonschema2pojo.com, select Target Language = java, Source Type = JSON, Annotation Style = Gson
             */

        /*
        Notice that due to the parameter we provide when calling bodyToMono() above, we are currently converting the response to String.class.
        This is how we would get the response as a String, in order to create the classes in the
        data_transfer_objects package.
        Once we have created those classes, we are able to save the response as a bespoke java object, and effectively
        manipulate the response using getters to pull exactly what we need out of it.
         */

    }

    /*
    This method uses the bespoke "Result" class, discussed above, to save the response in a format which we can easily pull data out of.
     */
    public Result[] getBookByTopic(String topic) {
        Result[] results = webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", topic)
                        .build())
                .retrieve()
                .bodyToMono(Result[].class)
                .block();

        return results;
    }

    public String findBook(String topic) {
        //collect the response into a java object using the classes you just created
        Result[] results = getBookByTopic(topic);

        //take the first Result in the array
        Result result = results[0];

        //get the first article
        String bookTitle = result.getTitle();

        //get the title of the article
        String bookLink = result.getLink();

        //create the message
        String message =
                bookTitle + " -\n"
                        + bookLink;

        //return the message
        return message;
    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

}


