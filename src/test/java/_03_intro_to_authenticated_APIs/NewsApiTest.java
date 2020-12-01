package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.*;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.ArrayList;
import java.util.function.Function;

    import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {

    NewsApi underTest;

    @Mock
    WebClient webClientMock;

    @Mock
    RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    ResponseSpec responseSpecMock;

    @Mock
    ApiExampleWrapper apiExampleWrapperMock;

    @Mock
    Article articleMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new NewsApi();
        underTest.setWebClient(webClientMock);
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //Given
        String topic = "Cows";
        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToFlux(ApiExampleWrapper.class))
                .thenReturn(Flux.just(apiExampleWrapperMock));
        when(apiExampleWrapperMock.getArticles())
                .thenReturn(new ArrayList<Article>() {{
                    add(articleMock);
                }});


        when(articleMock.getTitle())
                .thenReturn("Cows: Nature's Menace?");
        when(articleMock.getContent())
                .thenReturn("No, they are not.");
        when(articleMock.getUrl())
                .thenReturn("www.cowtruth.com");

        //When
        underTest.getNewsStoryByTopic(topic);

        //Then
        verify(webClientMock, times(1)).get();


    }


}