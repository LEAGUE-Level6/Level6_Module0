package _01_intro_to_APIs;

import _01_intro_to_APIs.data_transfer_objects.ApiExampleWrapper;
import _01_intro_to_APIs.data_transfer_objects.Article;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/*
An Application Programming Interface (API) is an access point to an external service.  For example, this News API allows
people to send a request, and receive information about a news story.  This opens a whole world of possibilities, allowing
programs you write to communicate with other applications that are on the internet.  At this point, we will focus on APIs
that allow us to GET information from another program, but some APIs also allow users to change the data that is stored
by that service.

The complete documentation for the NewsAPI can be found here:
https://newsapi.org/docs/get-started
 */


public class NewsApi {

    //Some APIs require a key to verify that you have access to that service
    //API key is received through creating an account on the web site.
    private static final String baseUrl = "http://newsapi.org/v2/everything";
    private static final String apiKey = "59ac01326c584ac0a069a29798794bec";

    private WebClient webClient;

    public NewsApi() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public String getNewsStoryByTopic(String topic) {

            //the following code makes the request and receives the response from newsapi.org
            //the .uri() is used to build the uri on top of the previously specified base url from the constructor.
            //This uri is where are making our GET request
            //the resulting uri would look something like:
            //http://newsapi.org/v2/everything?q=TOPIC&sortBy=popularity&apiKey=59ac01326c584ac0a069a29798794bec
            Flux<ApiExampleWrapper> apiExampleWrapperFlux = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("q", topic)
                            .queryParam("sortBy", "popularity")
                            .queryParam("apiKey", apiKey)
                            .build())
                    .retrieve()
                    /*.onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                            clientResponse -> Mono.empty())*/
                    .bodyToFlux(ApiExampleWrapper.class);


            /*
            JSON (JavaScript Object Notation) is the current standard for transmitting data objects over the internet.
            It consists of attribute-value pairs.  A simple JSON object may look like:
            { name : "John Doe" }

            The response to our request is received in JSON, but we need to turn that into a Java object in order
            manipulate it effectively in our program.

            Notice the classes in the POJO package, these are the Plain Old Java Objects that represent the response
            we expect from our specific request.  There are multiple classes in this case, because some of the fields
            in the response are, themselves, objects.
            You can use a tools like jsonschema2pojo.com to help with creating these classes, by inputting the JSON
            response from a request that you make.
            If using jsonschema2pojo.com, select Target Language = java, Source Type = JSON, Annotation Style = Gson
             */

            //uncomment the next line to see the actual JSON response -
            // this is what was inputted into jsonschema2pojo.com
            //System.out.println(userJSON);

            //deserialize the response into a java object using the classes you just created
            ApiExampleWrapper apiExampleWrapper =  apiExampleWrapperFlux.collectList().block().get(0);

            //get the first article (these are just java objects now)
            Article article = apiExampleWrapper.getArticles().get(0);

            //get the title of the article
            String articleTitle = article.getTitle();

            //get the content of the article
            String articleContent = article.getContent();

            //get the URL of the article
            String articleUrl = article.getUrl();

            //create the message
            String message =
                    articleTitle + " -\n"
                            + articleContent
                            + "\nFull article: " + articleUrl;

            //send the message
            return message;

    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }
}

