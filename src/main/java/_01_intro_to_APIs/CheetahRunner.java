package _01_intro_to_APIs;

public class CheetahRunner {
    public static void main(String[] args) {
        CheetahSearchApi cheetahSearchApi = new CheetahSearchApi();
        //cheetahSearchApi.testRequest();

       String resultMessage = cheetahSearchApi.findBook("cats");
        System.out.println(resultMessage);
    }
}
