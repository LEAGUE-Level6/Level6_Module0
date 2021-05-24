package _04_jeopardy_api;

import _04_jeopardy_api.data_transfer_objects.Clue;

import javax.swing.*;

public class JeopardyRunner {

    public static void main(String[] args) {

        JeopardyApi jeopardyApi = new JeopardyApi();

        //1. Create a score variable
        int score = 0;

        //2. Add a for loop where:
        //i starts at 100,
        //continues while i <= 1000
        //increments by 100
        for (int i = 100; i <= 1000; i += 100) {


            //3. If i == 700 or i == 900, continue;
            //there are no questions for these values
            if (i == 700 || i == 900) {
                continue;
            }

            //4. Call the getClue() method with i.  You will use this same clue object for steps 5-10.
            Clue clue = jeopardyApi.getClue(i);

            //5. Save the question in a String variable
            String question = clue.getQuestion();

            //6. Save the answer in a String variable
            String answer = clue.getAnswer();

            //7. Save the title in a String variable
            //note that this is part of the Category object
            String title = clue.getCategory().getTitle();

            //8. Use the JOptionPane below to display the question.
            //String guess = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);
            String guess = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);

            //9. If they got the question correct, add the value of that question to their score
            if (answer.equals(guess)) {
                score += clue.getValue();
                JOptionPane.showMessageDialog(null, "Correct!  Your score is now " + score);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry.  The correct answer was " + clue.getAnswer());
            }
            //10.  If they got the question wrong, tell them the correct answer.

            //11. Tell the user their final score
            JOptionPane.showMessageDialog(null, "You scored " + score + " points!");

        }
    }
}
