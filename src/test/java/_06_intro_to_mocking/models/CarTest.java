package _06_intro_to_mocking.models;

import _07_intro_to_mocking.models.Car;
import _07_intro_to_mocking.models.Engine;
import _07_intro_to_mocking.models.GasTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CarTest {

    Car car;

    @Mock
    Engine engine;

    @Mock
    GasTank gasTank;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        car = new Car(engine, gasTank);
    }

    @Test
    void itShouldStart() {
        //given
        boolean  expectedStart = true;
        when(engine.start()).thenReturn(true);

        //when
        boolean actualStart = car.start();

        //then
        assertEquals(expectedStart,actualStart);
    }

    @Test
    void itShouldFillTank() {
        //given
        boolean expectedFilled = true;
        int octane = 85;
        when(gasTank.fill(octane)).thenReturn(true);

        //when
        boolean actualFilled = gasTank.fill(octane);

        //then
        assertEquals(expectedFilled, actualFilled);
    }


    @Test
    void itShouldGetFuelLevel() {
        //given
        double expectedFuelLevelGallons = 12d;
        when(gasTank.getFuelLevel()).thenReturn(expectedFuelLevelGallons);

        //when
        double actualFuelLevelGallons = gasTank.getFuelLevel();

        //then
        assertEquals(expectedFuelLevelGallons, actualFuelLevelGallons);
    }
}