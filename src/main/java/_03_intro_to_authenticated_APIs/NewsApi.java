package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*
Most APIs require that you provide some sort of proof that you have access to that service.  This can be accomplished
in many ways, but typically it is done through providing a secret token each time you make a request.  The token is usually
created by the user via the API's website, and is used when requests are made to authorize yourself.

This News API expects the user to pass the API key as a query parameter, just like the query parameters we saw the
Cheetah Search API.

The complete documentation for the NewsAPI can be found here:
https://newsapi.org/docs/get-started
 */


public class NewsApi {

    //API key is received through creating an account on the web site.
    private static final String baseUrl = "http://newsapi.org/v2/everything";
    private static final String apiKey = "59ac01326c584ac0a069a29798794bec";

    //We will use WebClient to make the request
    private WebClient webClient;

    public NewsApi() {
        //build the WebClient
        this.webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void testRequest() {

        /*
        Just like in the Cheetah Search API, we use the uri() method to add the token as a query parameter
        The resulting uri would look like:
        http://newsapi.org/v2/everything?q=pizza&sortBy=popularity&apiKey=59ac01326c584ac0a069a29798794bec
         */
        Mono<String> stringMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", "pizza")
                        .queryParam("sortBy", "popularity")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class);

        String response = stringMono.block();

        System.out.println(response);
    }

    public ApiExampleWrapper getNewsStoryByTopic(String topic) {
        Mono<ApiExampleWrapper> apiExampleWrapperMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", topic)
                        .queryParam("sortBy", "popularity")
                        .queryParam("apiKey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(ApiExampleWrapper.class);

        return apiExampleWrapperMono.block();
    }

    public String findStory(String topic){

        //Get a story from News API
        ApiExampleWrapper apiExampleWrapper = getNewsStoryByTopic(topic);

        //Get the first article
        Article article = apiExampleWrapper.getArticles().get(0);

        //Get the title of the article
        String articleTitle = article.getTitle();

        //Get the content of the article
        String articleContent = article.getContent();

        //Get the URL of the article
        String articleUrl = article.getUrl();

        //Create the message
        String message =
                articleTitle + " -\n"
                        + articleContent
                        + "\nFull article: " + articleUrl;

        //Send the message
        return message;
    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

}

