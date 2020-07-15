package _03_jeopardy_api;

import _03_jeopardy_api.pojo.ClueWrapper;
import com.google.gson.Gson;

import javax.json.*;
import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/*
Now lets use a Jeopardy API to make a (modified) game.
To simplify things a little bit, we will just ask the user one question from each
 */

public class JeopardyApi {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {

       // System.out.println(clue.getQuestion());

        //create a score variable
        int score = 0;

        //add a for loop where i starts at 100,
        //continues while i <= 1000
        //increments by 100
       for (int i=100; i<=1000; i+=100){

           //if i == 700 or i == 900, continue;
           //there are no questions for these values
           if(i==700 || i==900){
               continue;
           }

           //call the getClue() method with i
                ClueWrapper clue = getClue(i);
                System.out.println(clue.getAnswer());
           System.out.println(i);

                //save the question in a String variable
                String question = clue.getQuestion();

                //save the answer in a String variable
                String answer = clue.getAnswer();

                //save the title in a String variable
                //note that this is part of the Category object
                String title = clue.getCategory().getTitle();

                //use a JOptionPane to display the question
                String guess = JOptionPane.showInputDialog(null, question, title, JOptionPane.QUESTION_MESSAGE);

                //if they got the question correct, add the value of that question to their score
                if(answer.equals(guess)){
                    score += clue.getValue();
                    JOptionPane.showMessageDialog(null, "Correct!  Your score is now " + score);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Sorry.  The correct answer was " + clue.getAnswer());
                }

        }

       //tell the user their final score
        JOptionPane.showMessageDialog(null, "You scored " + score + " points!");


    }

    public static ClueWrapper getClue(int value) {

        //create the request URL
        //can be found in the documentation: http://jservice.io/
        String requestURL = "http://jservice.io/api/clues?value=" + value;

        try {
            //enter to code from the NewsAPI example to make the request
            URL url = new URL(requestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            JsonReader jsonReader = Json.createReader(con.getInputStream());
            JsonArray jsonArray = jsonReader.readArray();
            con.disconnect();

            //1
            //uncomment the next line to see the actual JSON response -
            // this is what was inputted into jsonschema2pojo.com
            System.out.println(jsonArray);

            //2
            //Use http://www.jsonschema2pojo.org/ to generate your POJOs
            //and place them in the cat_facts_API.pojo package
            //select Target Language = java, Source Type = JSON, Annotation Style = Gson

            //3
            //Get a random number less than the size of the jsonArray
            int index = new Random().nextInt(jsonArray.size());

            //deserialize the response into a java object using the class you just created
            ClueWrapper clue = gson.fromJson(jsonArray.get(index).toString(), ClueWrapper.class);

            //4
            //return the clue at that index in the jsonArray
            return clue;

        } catch (Exception e) {
            return null;
        }

    }
}
