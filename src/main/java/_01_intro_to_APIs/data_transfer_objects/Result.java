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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
