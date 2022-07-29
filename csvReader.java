import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
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

public void aggregation()
{
  
    //   int orangeCakeCount = Integer.parseInt(orangCake);
    //   int mangoCakeCount =Integer.parseInt(mangoCake); 
    //   int strawberryCakeCount =Integer.parseInt(strawberryCake);
    //   int totalCount = orangeCakeCount+mangoCakeCount+strawberryCakeCount;
    //   System.out.println(totalCount);
    
}
}
public class csvReader
{

    public static void main(String [] args) throws FileNotFoundException
    {
        BakeryDetails bakery= new BakeryDetails();
        bakery.aggregation();
        List<BakeryDetails> bakeryDetails= new ArrayList<>();
        List<String[]>rowData= new ArrayList<String[]>();
        List<String[]>header=new ArrayList<String[]>();
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
        for(String [] tempString : rowData)
        {
            BakeryDetails bakeryDtls=new BakeryDetails();
            bakeryDtls.setbakeryName(tempString[0]);
            bakeryDtls.setorangCake(tempString[1]);
            bakeryDtls.setmangoCake(tempString[2]);
            bakeryDtls.setstrawberryCake(tempString[3]);
            bakeryDtls.setdate(tempString[4]);
            bakeryDetails.add(bakeryDtls);
        }
        for(String [] temp:bakeryDetails)
        {
           System.out.println("Which Bakery Aggerigation Do You Want?\n1 For Winners Bakery\n2 For Iyyangar Bakery\n3 For A2B Snacks");
           int entry = sc.nextInt();
           if(entry==1)
           {
              if(temp[0].equals("Winners Bakery"))
               {
                  System.out.println("hi");
               }
              else 
               {
                 System.out.println("bye");
               }
           } 
        }
       
    sc.close();
    }
}