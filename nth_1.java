import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class nth_1 
{

    public static void main(String[] args) 
    {

        JSONParser parser = new JSONParser();
        String[][] Arr=new String[162][6];
        try (Reader reader = new FileReader("C:\\Users\\sejal\\Desktop\\Stock List.json")) 
        {

        	JSONObject jsonObject = (JSONObject) parser.parse(reader);
    	    JSONArray arr= (JSONArray) jsonObject.get("stock");
    	    System.out.println(jsonObject);
        	for(int i=0;i<162;i++)
        	{
        		int j;
        		j=0;
        	    JSONObject stk = (JSONObject) arr.get(i);
        	    String Symbol = (String) stk.get("symbol");
        	    Arr[i][j]=Symbol;
        	    String Date = (String) stk.get("date");
        	    Arr[i][j+1]=Date;
        	    Arr[i][j+2]=String.valueOf(stk.get("uOpen"));
        	    Arr[i][j+3]=String.valueOf(stk.get("uClose"));
        	    Arr[i][j+4]=String.valueOf(stk.get("uHigh"));
        	    Arr[i][j+5]=String.valueOf(stk.get("uLow"));
        	}
        	for(int i=0;i<162;i++)
        	{
        		for(int j=0;j<6;j++)
        		{
        			System.out.print(Arr[i][j]+"\t");
        		}
        		System.out.println();
        	}

        } catch (IOException e) 
        {
            e.printStackTrace();
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }
    }
}
