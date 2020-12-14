package _01_intro_to_APIs;

import _01_intro_to_APIs.data_transfer_objects.Result;
import _03_intro_to_authenticated_APIs.NewsApi;
import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CheetahSearchApiTest {

    CheetahSearchApi cheetahSearchApi;

    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<Result[]> resultMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cheetahSearchApi = new CheetahSearchApi();
        cheetahSearchApi.setWebClient(webClientMock);
    }

    @Test
    void itShouldGetBookByTopic() {
        //given
        String topic = "Cows";

        Result result = new Result();
        Result[] expectedResults = {result};

        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Result[].class))
                .thenReturn(resultMonoMock);
        when(resultMonoMock.block())
                .thenReturn(expectedResults);

        //when
        Result[] actualResults = cheetahSearchApi.getBookByTopic(topic);

        //then
        verify(webClientMock, times(1)).get();
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void itShouldFindBook() {
        //given
        String topic = "Cows";
        String bookTitle = "Rise of the Ruminants";
        String bookLink = "www.cowtruth.com";

        Result result = new Result();
        result.setTitle(bookTitle);
        result.setLink(bookLink);
        Result[] expectedResults = {result};

        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Result[].class))
                .thenReturn(resultMonoMock);
        when(resultMonoMock.block())
                .thenReturn(expectedResults);

        String expectedBook =
                bookTitle + " -\n"
                        + bookLink;
        //when
        String actualBook = cheetahSearchApi.findBook(topic);

        //then
        verify(webClientMock, times(1)).get();
        assertEquals(expectedBook, actualBook);
    }

}