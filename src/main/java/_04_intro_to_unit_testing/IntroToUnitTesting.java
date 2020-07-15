package _04_intro_to_unit_testing;

/*
In the real world, no program is complete until it has been properly tested.
Writing test is soemthing that all software developers should be familiar with.
While we will be looking specifically at writing unit tests in Java, the same concepts are
applicable to all programming languages.

A unit test is responsible for verifying that one small piece (i.e. "unit") works correctly.
Typically this may be a single method.
 */

import javax.swing.*;

public class IntroToUnitTesting {

    public int add(int a, int b){
        return a + b;
    }

    public String sayHello(String name){
        return "Hello " + name;
    }

    public JButton createButton(){
        return new JButton("Click Here!");
    }

    public void throwsExcpetion(){
        throw new IllegalArgumentException("This should throw an exception");
    }

}
