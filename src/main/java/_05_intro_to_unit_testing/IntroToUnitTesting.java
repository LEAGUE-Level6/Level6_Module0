package _05_intro_to_unit_testing;

/*
In the real world, no program is complete until it has been properly tested.
The first "level" of testing that can be conducted is manual testing.  This is what you have been doing up until this point;
You write some code, then run the program and try various inputs to verify that your code works.  While this works fine for
small programs, when you begin working on applications with greater complexity, manually testing every piece of functionality
 whenever a change is made becomes a much more difficult task.

This brings us to unit testing.

While we will be looking specifically at writing unit tests in Java, the same concepts are
applicable to all programming languages.

A unit test is responsible for verifying that one small piece (i.e. "unit") works correctly.
Often times a unit of code will be a single method, but later on we will see "units" that are comprised of
only part of a method, and even multiple methods whose functionality are inextricably linked.

The unit tests for this class can be found in a corresponding package under
 src/test/java/_05_intro_to_unit_testing/IntroToUnitTestingTest.java

Please review that code there and understand how it works, then move on to the next section.
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

    public void throwsException(){
        throw new IllegalArgumentException("This should throw an exception");
    }

}
