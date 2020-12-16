package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;

    @Mock
    Car car;

    @Mock
    CellPhone cellPhone;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        deliveryDriver = new DeliveryDriver("Vic", car,  cellPhone);
    }

    @Test
    void itShouldWasteTime() {
        //given
        boolean expectedTimeWasted = true;
        when(cellPhone.browseCatMemes()).thenReturn(true);

        //when
        boolean actualTimeWasted = deliveryDriver.wasteTime();

        //then
        assertEquals(expectedTimeWasted, actualTimeWasted);
    }

    @Test
    void itShouldRefuel() {
        //given
        boolean expectedRefueled = true;
        int octaneGrade = 85;
        when(car.fillTank(octaneGrade)).thenReturn(true);

        //when
        boolean actualRefueled = deliveryDriver.refuel(octaneGrade);

        //then
        assertEquals(expectedRefueled, actualRefueled);
    }

    @Test
    void itShouldContactCustomer() {
        //given
        String cellPhoneNumber  = "CELL_PHONE_NUMBER";
        boolean expectedContacted = true;
        when(cellPhone.call(cellPhoneNumber)).thenReturn(true);

        //when
        boolean actualContacted = deliveryDriver.contactCustomer(cellPhoneNumber);

        //then
        assertEquals(expectedContacted, actualContacted);
    }

}