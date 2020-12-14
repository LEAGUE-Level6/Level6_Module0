package _02_cat_facts_API;

import _03_intro_to_authenticated_APIs.NewsApi;
import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class CatFactsApiTest {

    CatFactsApi catFactsApi;

    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<ApiExampleWrapper> apiExampleWrapperMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        catFactsApi = new CatFactsApi();
        catFactsApi.setWebClient(webClientMock);
    }

    @Test
    void itShouldGetCatFact() {
        //given
        //when
        //then
    }

}