package _05_intro_to_unit_testing;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class introToUnitTestingTest {

    IntroToUnitTesting underTest = new IntroToUnitTesting();

    @Test
    void itShouldAdd() {
        //given
        int a = 10;
        int b = 15;
        int expected = 25;

        //when
        //then
        assertEquals(expected, underTest.add(a, b));
    }

    @Test
    void itShouldSayHello() {
        //given
        String name = "Matt";
        String expected = "Hello Matt";

        //when
        //then
        String actual = underTest.sayHello(name);
        assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateButton() {
        //given
        //when
        //then
        assertTrue(underTest.createButton() instanceof JButton);
    }

    @Test
    void itShouldThrowException(){
        //given
        //when
        //then
        Throwable exceptionThrown = assertThrows(IllegalArgumentException.class, () -> underTest.throwsException());
        assertEquals(exceptionThrown.getMessage(), "This should throw an exception");
    }

}