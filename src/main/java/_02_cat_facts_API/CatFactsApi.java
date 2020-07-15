package _02_cat_facts_API;

import _02_cat_facts_API.pojo.CatWrapper;
import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CatFactsApi {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        String catFact = getCatFact();
        System.out.println(catFact);
    }

    public static String getCatFact() {

        //create the request URL
        //can be found in the documentation: https://catfact.ninja/
        String requestURL = "https://catfact.ninja/fact";

        try {
            //enter to code from the NewsAPI example to make the request
            URL url = new URL(requestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            JsonReader repoReader = Json.createReader(con.getInputStream());
            JsonObject userJSON = ((JsonObject) repoReader.read());
            con.disconnect();

            //uncomment the next line to see the actual JSON response -
            // this is what was inputted into jsonschema2pojo.com
            //System.out.println(userJSON);

            //Use http://www.jsonschema2pojo.org/ to generate your POJOs
            //and place them in the cat_facts_API.pojo package
            //select Target Language = java, Source Type = JSON, Annotation Style = Gson

            //deserialize the response into a java object using the class you just created
            CatWrapper catWrapper = gson.fromJson(userJSON.toString(), CatWrapper.class);

            //get the cat fact from the response
            String fact = catWrapper.getFact();
            //send the message
            return fact;

        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
