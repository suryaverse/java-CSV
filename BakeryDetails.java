import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BakeryDetails {
  String bakeryName;
  String orangCake;
  String mangoCake;
  String strawberryCake;
  String date;

  public String getBakery() {
    return bakeryName;
  }

  public void setName(String bakeryName) {
    this.bakeryName = bakeryName;
  }

  public String getmangoCake() {
    return mangoCake;
  }

  public void setmangoCake(String mangoCake) {
    this.mangoCake = mangoCake;

  }

  public String getorangCake() {
    return orangCake;
  }

  public void setorangCake(String orangCake) {
    this.orangCake = orangCake;
  }

  public String getstrawberryCake() {
    return strawberryCake;
  }

  public void setstrawberryCake(String strawberryCake) {
    this.strawberryCake = strawberryCake;
  }

  public String getdate() {
    return date;
  }

  public void setdate(String date) {
    this.date = date;
  }

  public static void main(String[] args) throws FileNotFoundException {
    BakeryDetails bakeryDetails = new BakeryDetails();
    bakeryDetails.csvReader();
  }

  List<String[]> rowData = new ArrayList<String[]>();
  List<String[]> header = new ArrayList<String[]>();
  List<String> uniquenames = new ArrayList<String>();
  List<BakeryDetails> bakeryDetails = new ArrayList<>();

  public void csvReader() throws FileNotFoundException {

    File file = new File("/home/surya/test.csv");
    Scanner sc = new Scanner(file);
    int linecount = 1;
    String row;
    String[] csvData;
    String[] csvData1;
    String data;
    while (sc.hasNextLine()) {
      row = sc.nextLine();
      if (linecount == 1) {
        data = row;
        csvData1 = data.split(",");
        header.add(csvData1);
      }
      if (linecount != 1) {
        data = row;
        csvData = data.split(",");
        rowData.add(csvData);
      }
      linecount++;
    }
    setValue(rowData);
    aggregation(uniquenames, bakeryDetails);
  }

  public void setValue(List<String[]> rowData) {

    for (String[] tempString : rowData) {
      BakeryDetails bakery = new BakeryDetails();
      uniquenames.add(tempString[0]);
      bakery.setName(tempString[0]);
      bakery.setorangCake(tempString[1]);
      bakery.setmangoCake(tempString[2]);
      bakery.setstrawberryCake(tempString[3]);
      bakery.setdate(tempString[4]);
      bakeryDetails.add(bakery);
    }
  }

  public void aggregation(List<String> uniquenames, List<BakeryDetails> bakeryDetails) {
    // DUPULICATE NAMES ARE REMOVED//
    Set<String> bakerynames = new HashSet<String>();
    for (String names : uniquenames) {
      bakerynames.add(names);
    }
    List<String> sortednames = new ArrayList<String>(bakerynames);
    // AGGREGATION//
    for (int i = 0; i < sortednames.size(); i++) {
      int mangocount = 0;
      int orangecount = 0;
      int strawberrycount = 0;
      float mangoAvg = 0;
      float orangeAvg;
      float strawberryAvg;
      int maximumsale = 0;
      int minimumsale = 0;
      int count = 0;
      for (int j = 0; j < bakeryDetails.size(); j++) {
        if (sortednames.get(i).equals(bakeryDetails.get(j).getBakery())) {
          // TOTAL OF MANGO//
          mangocount = mangocount + Integer.parseInt(bakeryDetails.get(j).getmangoCake());
          // TOTAL OF ORANGE//
          orangecount = orangecount + Integer.parseInt(bakeryDetails.get(j).getorangCake());
          // TOTAL OF STRABERRY//
          strawberrycount = strawberrycount + Integer.parseInt(bakeryDetails.get(j).getstrawberryCake());
          // MAXIMUM SALE//
          int tempMax = Integer.parseInt(bakeryDetails.get(j).getmangoCake())
              + Integer.parseInt(bakeryDetails.get(j).getorangCake())
              + Integer.parseInt(bakeryDetails.get(j).getstrawberryCake());
          if (maximumsale < tempMax) {
            maximumsale = tempMax;
          }
          // MINIMUM SALE//
          int tempMin = Integer.parseInt(bakeryDetails.get(j).getmangoCake())
              + Integer.parseInt(bakeryDetails.get(j).getorangCake())
              + Integer.parseInt(bakeryDetails.get(j).getstrawberryCake());
          minimumsale = tempMin;
          if (minimumsale > tempMin) {
            minimumsale = tempMin;
          }
          count++;
        }
      }
      System.out.println("\n" + sortednames.get(i) + " Total Mango Cake Count is = " + mangocount);
      mangoAvg = mangocount / count;
      System.out.println(sortednames.get(i) + " Average of Mango cake is = " + mangoAvg);
      System.out.println(sortednames.get(i) + " Total Orange Cake Count is = " + orangecount);
      orangeAvg = orangecount / count;
      System.out.println(sortednames.get(i) + " Average of Orange cake is = " + orangeAvg);
      System.out.println(sortednames.get(i) + " Total Strawberry Cake Count is = " + strawberrycount);
      strawberryAvg = strawberrycount / count;
      System.out.println(sortednames.get(i) + " Average of Strawberry Cake is = " + strawberryAvg);
      System.out.println(sortednames.get(i) + " Minimum Sale Of One Day = " + minimumsale);
      System.out.println(sortednames.get(i) + " Maximum Sale Of One Day = " + maximumsale);
    }
  }
}
