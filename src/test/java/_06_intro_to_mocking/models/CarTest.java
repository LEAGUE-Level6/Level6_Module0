package _06_intro_to_mocking.models;

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
        //GIVEN
        boolean  expectedStart = true;
        when(engine.start()).thenReturn(true);

        //WHEN
        boolean actualStart = car.start();

        //THEN
        assertEquals(expectedStart,actualStart);
    }

    @Test
    void itShouldFillTank() {
        //GIVEN
        boolean expectedFilled = true;
        int octane = 85;
        when(gasTank.fill(octane)).thenReturn(true);

        //WHEN
        boolean actualFilled = gasTank.fill(octane);

        //THEN
        assertEquals(expectedFilled, actualFilled);
    }


    @Test
    void itShouldGetFuelLevel() {
        //GIVEN
        double expectedFuelLevelGallons = 12d;
        when(gasTank.getFuelLevel()).thenReturn(expectedFuelLevelGallons);

        //WHEN
        double actualFuelLevelGallons = gasTank.getFuelLevel();

        //THEN
        assertEquals(expectedFuelLevelGallons, actualFuelLevelGallons);
    }
}