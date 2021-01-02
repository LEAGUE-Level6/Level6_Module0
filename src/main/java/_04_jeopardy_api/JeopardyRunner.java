package _04_jeopardy_api;

import _04_jeopardy_api.data_transfer_objects.Clue;

import javax.swing.*;

public class JeopardyRunner {

    public static void main(String[] args) {

        JeopardyApi jeopardyApi = new JeopardyApi();

        //create a score variable


        //add a for loop where i starts at 100,
        //continues while i <= 1000
        //increments by 100


            //if i == 700 or i == 900, continue;
            //there are no questions for these values

            //call the getClue() method with i

            //save the question in a String variable

            //save the answer in a String variable

            //save the title in a String variable
            //note that this is part of the Category object

            //use a JOptionPane to display the question

            //if they got the question correct, add the value of that question to their score

        //tell the user their final score


    }

}
