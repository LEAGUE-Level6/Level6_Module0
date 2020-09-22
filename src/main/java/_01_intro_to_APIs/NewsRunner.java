package _01_intro_to_APIs;

import javax.swing.*;

public class NewsRunner {

    public static void main(String[] args) {
        NewsApi newsApi = new NewsApi();
        String topic = JOptionPane.showInputDialog("Please enter a topic for a news story");
        newsApi.testRequest();
        //System.out.println(story);
    }

}
