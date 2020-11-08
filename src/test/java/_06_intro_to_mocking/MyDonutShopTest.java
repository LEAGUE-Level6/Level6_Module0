package _06_intro_to_mocking;

import _06_intro_to_mocking.models.DonutShop;
import _06_intro_to_mocking.models.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyBoolean;
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
Mockito accomplishes this by using reflection to inspect these objects and create fake objects that return default/null values.
This is great because we can now test that MyDonutShop is correct, without relying on the validity of the other objects.


when to mock:
1. resource is unreliable (network call, load from file)
2. a class is hard to instantiate (e.g. interface or complex class)
3. want to verify that a certain behavior in that class happened (e.g. no interactions, certain number of interactions, or methods called in certain order)





Of particular importance are two of this class' dependencies: PaymentService and DeliveryService.  These classes
contact an outside provider in order to help us fill our orders.

When testing our DonutShop class, there are a number of reasons we do NOT want to make actual
requests to our PaymentService or DeliveryService.
1. We don't want them to receive an order every time we run our unit tests
2. We don't want our unit tests to rely on these external services in order to pass.  For example, if our code is good
we don't out unit tests to fail because the internet is down and it can't communicate with one of these external services.


 */

class MyDonutShopTest {

    MyDonutShop underTest;

    @Mock
    DonutShop donutShopMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new MyDonutShop();
        underTest.setDonutShop(donutShopMock);
    }

    @Test
    void itShouldOpenForTheDay() {
        //Given

        //When
        underTest.openForTheDay();

        //Then
        verify(donutShopMock, times(1)).makeDonuts();
        verify(donutShopMock, times(1)).setOpenForBusiness(true);
        verifyNoMoreInteractions(donutShopMock);
    }

    @Test
    void itShouldCloseForTheDay() {
        //Given
        doNothing().when(donutShopMock).throwAwayLeftovers();
        doNothing().when(donutShopMock).setOpenForBusiness(anyBoolean());

        //When
        underTest.closeForTheDay();

        //Then
        verify(donutShopMock, times(1)).throwAwayLeftovers();
        verify(donutShopMock, times(1)).setOpenForBusiness(false);
        verifyNoMoreInteractions(donutShopMock);
    }

    @Test
    void itShouldTakeOrder() {
        //Given
        int numDonuts = 5;
        Order order = new Order("Ichabod Crane", numDonuts);
        when(donutShopMock.getDonutsRemaining()).thenReturn(numDonuts);
        when(donutShopMock.isOpenForBusiness()).thenReturn(true);

        //When
        underTest.takeOrder(order);

        //Then
        verify(donutShopMock, times(1)).addOrder(order);
    }

    @Test
    void itShouldThrowWhenNotOpen() {
        //Given
        Order order = new Order("Ichabod Crane", 5);
        when(donutShopMock.isOpenForBusiness()).thenReturn(false);

        //When
        //Then
        assertThatThrownBy(() -> underTest.takeOrder(order))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Sorry we're currently closed");

    }

    @Test
    void itShouldThrowWhenInsufficientDonuts() {
        //Given
        int numDonuts = 5;
        Order order = new Order("Ichabod Crane", numDonuts);
        when(donutShopMock.getDonutsRemaining()).thenReturn(numDonuts-1);
        when(donutShopMock.isOpenForBusiness()).thenReturn(true);

        //When
        //Then
        assertThatThrownBy(() -> underTest.takeOrder(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Insufficient donuts remaining");

    }


}