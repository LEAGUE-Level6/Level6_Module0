package _01_intro_to_APIs.data_transfer_objects;

import java.util.List;

public class Result {

    private String title;

    private List<String> authors;

    private String link;


    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getLink() {
        return link;
    }
}
