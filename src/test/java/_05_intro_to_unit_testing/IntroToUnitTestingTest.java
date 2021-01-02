package _05_intro_to_unit_testing;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class introToUnitTestingTest {

    IntroToUnitTesting introToUnitTesting = new IntroToUnitTesting();

    @Test
    void itShouldAdd() {
        //given
        int a = 10;
        int b = 15;
        int expected = 25;

        //when
        int actual = introToUnitTesting.add(a, b);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void itShouldSayHello() {
        //given
        String name = "Matt";
        String expected = "Hello Matt";

        //when
        String actual = introToUnitTesting.sayHello(name);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateButton() {
        //given
        //when
        Object actual = introToUnitTesting.createButton();
        //then
        assertTrue(actual instanceof JButton);
    }

    @Test
    void itShouldThrowException(){
        //given
        //when
        //then
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> introToUnitTesting.throwsException());
        assertEquals(exceptionThrown.getMessage(), "This should throw an exception");
    }

}