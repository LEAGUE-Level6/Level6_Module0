package _06_intro_to_white_box_testing;

import _06_mocking.models.DeliveryService;
import _06_intro_to_mocking.models.Car;
import _06_mocking.models.Driver;
import _06_intro_to_mocking.models.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;


/*
In the previous unit testing recipes, we examined that the results of calling a method was the result that we were expecting.
This is called black-box testing.  We aren't peering into the method to test how it actually works, we simply invoke the
method and check that it gives us back was we expect.


There are some scenarios when black-box testing will not suffice:
-When the method returns void.
-When we want to verify that a specific behavior occurred within the method.

The first reason above should be clear: we simply cannot verify that a method returns what we are expecting if the method
returns nothing at all.  The second reason is especially important for methods that have a lot of branching logic.

In these scenarios, we want to engage in white-box testing.  White-box testing examines what the method does while it is
being, rather than simply taking a look at what it returns.  There is additional unit testing syntax that allows us to
verify that specific things occurred when the method was called.

 */
class DeliveryServiceTest {

    DeliveryService deliveryService;

    @Mock
    Car car;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //create a Driver
        Driver driver = new Driver(
                "Carlos",
                true,
                true,
                false
        );

       List<Driver> availableDrivers = Collections.singletonList(driver);
       List<Car> availableCars = Collections.singletonList(car);

        deliveryService = new DeliveryService(availableDrivers, availableCars);
    }

    @Test
    void itShouldDeliver() {
        //given
        //when
        //then
    }
}