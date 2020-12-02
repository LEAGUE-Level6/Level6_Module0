package _05_intro_to_unit_testing;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class introToUnitTestingTest {

    IntroToUnitTesting underTest = new IntroToUnitTesting();

    @Test
    void itShouldAdd() {
        //Given
        int a = 10;
        int b = 15;
        int expected = 25;

        //When
        //Then
        assertEquals(expected, underTest.add(a, b));
    }

    @Test
    void itShouldSayHello() {
        //Given
        String name = "Matt";
        String expected = "Hello Matt";

        //When
        //Then
        String actual = underTest.sayHello(name);
        assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateButton() {
        //Given
        //When
        //Then
        assertTrue(underTest.createButton() instanceof JButton);
    }

    @Test
    void itShouldThrowException(){
        //Given
        //When
        //Then
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> underTest.throwsException());
        assertEquals(exceptionThrown.getMessage(), "This should throw an exception");
    }

}