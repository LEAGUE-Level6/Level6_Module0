package _04_intro_to_unit_testing;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
        assertThat(expected).isEqualTo(underTest.add(a, b));
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
        assertThat(underTest.createButton()).isInstanceOf(JButton.class);
    }

    @Test
    void itShouldThrow(){
        //Given
        //When
        //Then
        assertThatThrownBy(() -> underTest.throwsExcpetion())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This should throw an exception");
    }

}