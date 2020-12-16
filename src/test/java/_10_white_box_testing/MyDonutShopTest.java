package _10_white_box_testing;

import _09_intro_to_white_box_testing.models.DeliveryService;
import _09_intro_to_white_box_testing.models.Order;
import _10_white_box_testing.models.BakeryService;
import _10_white_box_testing.models.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MyDonutShopTest {

    MyDonutShop myDonutShop;

    @Mock
    PaymentService paymentService;

    @Mock
    DeliveryService deliveryService;

    @Mock
    BakeryService bakeryService;

    @BeforeEach
    void setUp() {
        //This line initializes all of the mocks declared above
        MockitoAnnotations.openMocks(this);

        myDonutShop = new MyDonutShop(paymentService, deliveryService, bakeryService);
        //injecting the mocks into MyDonutShop using setters
        myDonutShop.setPaymentService(paymentService);
        myDonutShop.setDeliveryService(deliveryService);
    }

    @Test
    void itShouldTakeDeliveryOrder() throws Exception {
        //given
        Order order = new Order(
                "Ichabod Crane",
                "PHONE_NUMBER",
                5,
                5.00,
                "CREDIT_CARD_NUMBER",
                true
        );

        when(paymentService.charge(order)).thenReturn(true);
        when(bakeryService.getDonutsRemaining()).thenReturn(5);

        //when
        myDonutShop.openForTheDay();
        myDonutShop.takeOrder(order);

        //then
        verify(deliveryService, times(1)).scheduleDelivery(order);
    }

    @Test
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() {
        //given
        Order order = new Order(
                "Ichabod Crane",
                "PHONE_NUMBER",
                5,
                5.00,
                "CREDIT_CARD_NUMBER",
                true
        );

        when(paymentService.charge(order)).thenReturn(true);
        when(bakeryService.getDonutsRemaining()).thenReturn(0);

        //when
        myDonutShop.openForTheDay();

        //then
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> myDonutShop.takeOrder(order));
        assertEquals(exceptionThrown.getMessage(), "Insufficient donuts remaining");
    }

    @Test
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException(){
        //given
        Order order = new Order(
                "Ichabod Crane",
                "PHONE_NUMBER",
                5,
                5.00,
                "CREDIT_CARD_NUMBER",
                true
        );

        when(paymentService.charge(order)).thenReturn(true);

        //when
        myDonutShop.closeForTheDay();

        //then
        Throwable exceptionThrown = assertThrows(IllegalStateException.class, () -> myDonutShop.takeOrder(order));
        assertEquals(exceptionThrown.getMessage(), "Sorry we're currently closed");
    }

}