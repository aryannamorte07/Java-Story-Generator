import java.util.ArrayList;

public class TextProcessor {

  private ArrayList<String> textList;
  private String filename;

  public TextProcessor(String filename) {

    this.filename = filename;

    textList = FileReader.toStringList(filename);

  }

  public static int getSemicolon(String input){

    return input.indexOf(":");

  }

  public static int getComma(String input){

    return input.indexOf(",");

  }

  public String getSentimentValue(double userSentiment) {

    double difference = 0.0;

    double smallest = 100;

    String book = "";

    Double [] values = new Double[textList.size()];

    String [] titles = new String[textList.size()];

    for(int i = 0; i < textList.size(); i++){

      int index = getSemicolon(textList.get(i)) + 1;

      values[i] = Double.parseDouble(textList.get(i).substring(index));

      titles[i] = textList.get(i).substring(0, index - 1);

    }

    for(int j = 0; j < values.length; j++){

      difference = Math.abs(userSentiment - values[j]);

      if(smallest > difference){

        smallest = difference;

        book = titles[j];

      }

    }

    return book;
  }

}
