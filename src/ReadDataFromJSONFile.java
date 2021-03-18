import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {

    public static void main(String[] args) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("//Users//apathak//Documents//workspace//JsonJava//employee.json");
        JSONObject obj = (JSONObject)parser.parse(reader);

        System.out.println("FirstName : "+obj.get("firstName"));
        System.out.println("LastName : "+obj.get("lastName"));
        System.out.println();
        JSONArray ar =  (JSONArray)obj.get("address");
        for(int i=0;i<ar.size();i++)
        {
            JSONObject address = (JSONObject)ar.get(i);
            System.out.println("     Street :"+address.get("street"));
            System.out.println("     City   :"+address.get("city"));
            System.out.println("     State  :"+address.get("state"));
            System.out.println();
        }
    }

}
