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

/*
Remember that the point of the unit testing is to ensure that one small part of our program is behaving correctly.
This leads us to a problem when testing methods that require external resources to work.  In MyDonutShop, we want to ensure
that our methods work, but they rely on the PaymentService and DeliveryService classes to function.
We DO NOT want to write unit tests that rely on the validity of those classes, as again,
we are currently only testing MyDonutShop.

The answer: Mocking

We can create mocks of any external objects that we need to use, in this case PaymentService and DeliveryService.
These mocks represent their respective objects, but do not actually do anything when methods are called.
Mockito accomplishes this by using reflection to inspect these objects and create subclasses of these objects that return
default/null values. This is great because we can now test that MyDonutShop is correct, without relying on the validity
of the other objects.


when to mock:
1. resource is unreliable (network call, load from file)
2. a class is hard to instantiate (e.g. interface or complex class)
3. want to verify that a certain behavior in that class happened (e.g. no interactions, certain number of interactions, or methods called in certain order)

Of particular importance are two of this class' dependencies: PaymentService and DeliveryService.  These classes
contact an outside provider in order to help us fill our orders.

when testing our DonutShop class, there are a number of reasons we do NOT want to make actual
requests to our PaymentService or DeliveryService.
1. We don't want them to receive an order every time we run our unit tests
2. We don't want our unit tests to rely on these external services in order to pass.  For example, if our code is good
we don't out unit tests to fail because the internet is down and it can't communicate with one of these external services.


 */

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
    void givenInsufficientDonutsRemaining_whenTakeOrder_thenThrowIllegalArgumentException() throws Exception {
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
    void givenNotOpenForBusiness_whenTakeOrder_thenThrowIllegalStateException() throws Exception {
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