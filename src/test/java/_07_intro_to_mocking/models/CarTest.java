package _07_intro_to_mocking.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CarTest {

    Car car;

    //This @Mock annotation signifies that this object will be a mock
    @Mock
    Engine engine;

    @Mock
    GasTank gasTank;

    @BeforeEach
    void setUp() {
        //The following line instantiates all of the mocks in the given class.  In this case, this class.
        MockitoAnnotations.openMocks(this);

        car = new Car(engine, gasTank);
    }

    @Test
    void itShouldStart() {
        //given
        boolean expectedStart = true;
        //The following line stubs the engine.start() method, so that it will return true when it is invoked
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
        //The following line stubs the gasTank.fill(int octane) method, so that it will return true when it is invoked
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
        //The following line stubs the gasTank.getFuelLevel() method, so that it will return a value when it is invoked
        when(gasTank.getFuelLevel()).thenReturn(expectedFuelLevelGallons);

        //when
        double actualFuelLevelGallons = gasTank.getFuelLevel();

        //then
        assertEquals(expectedFuelLevelGallons, actualFuelLevelGallons);
    }
}