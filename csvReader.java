import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
class BakeryDetails
{    
      String bakeryName;
      String orangCake;
      String mangoCake;
      String strawberryCake;
      String date;
    public String getBakery()
	{
		return bakeryName;
	}
	public void setbakeryName(String bakeryName)
	{
		this.bakeryName=bakeryName;
	}
	public String getmangoCake()
	{
		return mangoCake;
	}
	public void setmangoCake(String mangoCake)
	{
		this.mangoCake=mangoCake;
	}
	public String getorangCake()
	{
		return orangCake;
	}
	public void setorangCake(String orangCake)
	{
		this.orangCake=orangCake;
	}
	public String getstrawberryCake()
	{
		return strawberryCake;
	}
	public void setstrawberryCake(String strawberryCake)
	{
		this.strawberryCake=strawberryCake;
	}
	public String getdate()
	{
		return date;
	}
	public void setdate(String date)
	{
		this.date=date;
	}
}
public class csvReader
{

    public static void main(String [] args) throws FileNotFoundException
    {
        List<BakeryDetails> bakeryDetails= new ArrayList<>();
        List<String[]>rowData= new ArrayList<String[]>();
        List<String[]>header=new ArrayList<String[]>();
        List<String> uniquenames=new ArrayList<String>();
     //   List<HashMap<String,String>>hashMaps = new HashMap<String,String>();
        File file = new File("/home/surya/test.csv");
        Scanner sc = new Scanner(file);
        int linecount=1;
        String row;
        String [] csvData;
        String [] csvData1;
        String data;
        while(sc.hasNextLine())
        {
            row = sc.nextLine();
            if (linecount==1)
            {
                data=row;
                csvData1 = data.split(",");
                header.add(csvData1);             
            }
            if(linecount!=1)
            {
              data=row;
              csvData = data.split(",");
              rowData.add(csvData);
            }
            linecount++;
        }
        //MAPING THE VALUES YO HASHMAP//
        
        for(String [] tempString : rowData)
        {
            BakeryDetails bakeryDtls=new BakeryDetails();
            uniquenames.add(tempString[0]);
            bakeryDtls.setbakeryName(tempString[0]);
            bakeryDtls.setorangCake(tempString[1]);
            bakeryDtls.setmangoCake(tempString[2]);
            bakeryDtls.setstrawberryCake(tempString[3]);
            bakeryDtls.setdate(tempString[4]);
            bakeryDetails.add(bakeryDtls);
        }
        //DUPULICATE NAMES ARE REMOVED//
        Set<String>bakerynames= new HashSet<String>();
        for(String names : uniquenames)
          {
            bakerynames.add(names);
          }
          List<String>sortednames=new ArrayList<String>(bakerynames);
          System.out.println(sortednames);
    sc.close();
    }
}