package _99_extra._00_league_of_amazing_astronauts;

import _99_extra._00_league_of_amazing_astronauts.LeagueOfAmazingAstronauts;
import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

/*

When writing the tests, mock both the Rocketship and Astronaut for the sake of practice.
 */
class LeagueOfAmazingAstronautsTest {

    LeagueOfAmazingAstronauts underTest = new LeagueOfAmazingAstronauts();

    @Mock
    Astronaut astronautMock;

    @Mock
    Rocketship rocketshipMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        underTest = new LeagueOfAmazingAstronauts();
        underTest.setRocketship(rocketshipMock);
    }

    @Test
    void itShouldPrepareAstronaut() {
        //given
        doNothing().when(astronautMock).train();
        doNothing().when(rocketshipMock).loadOccupant(astronautMock);

        //when
        underTest.prepareAstronaut(astronautMock);

        //then
        verify(astronautMock, times(1)).train();
        verify(rocketshipMock, times(1)).loadOccupant(astronautMock);
        verifyNoMoreInteractions(astronautMock);
        verifyNoMoreInteractions(rocketshipMock);
    }

    @Test
    void itShouldLaunchRocket() {
        //given
        String destination = "Mars";
        int milesToDesination = 68_000_000;
        when(rocketshipMock.isLoaded()).thenReturn(true);

        //when
        underTest.launchRocket(destination);

        //then
        verify(rocketshipMock, times(1)).isLoaded();
        verify(rocketshipMock, times(1)).setDestination("Mars", milesToDesination);
        verify(rocketshipMock, times(1)).launch();
        verifyNoMoreInteractions(astronautMock);
        verifyNoMoreInteractions(rocketshipMock);
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given
        String destination = "Saturn";
        int milesToDesination = 834_000_000;
        when(rocketshipMock.isLoaded()).thenReturn(true);

        //when
        //then
        assertThatThrownBy(() -> underTest.launchRocket(destination))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Destination is unavailable");
    }

    @Test
    void itShouldThrowNotLoaded() {
        //given
        String destination = "Saturn";
        int milesToDesination = 834_000_000;
        when(rocketshipMock.isLoaded()).thenReturn(false);

        //when
        //then
        assertThatThrownBy(() -> underTest.launchRocket(destination))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Rocketship is not loaded");

    }
}