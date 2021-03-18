import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFromJSON {
//    {
//        "users" : [{
//          "id" : "user.id",
//          "operations" : [{
//            "op" : "replace",
//            "field" : "state",
//            "value" : {
//              "current" : "ACTIVE",
//              "prev": "ADDED",
//              "timestamp" :123
//            }
//          }]
//        }],
//        "scope": {
//          "company": "cname"
//       }
//     }


    public static void main(String[] args) throws IOException, ParseException {
        // TODO Auto-generated method stub
        JSONParser jp = new JSONParser();
        FileReader fr = new FileReader("//Users//apathak//Documents//workspace//JsonJava//employee1.json");
        JSONObject jo = (JSONObject)jp.parse(fr);

        JSONArray ar = (JSONArray)jo.get("users");
        for(int i=0;i<ar.size();i++)
        {
            JSONObject jo1 = (JSONObject)ar.get(i);
            System.out.println(" ID :"+jo1.get("id"));
            JSONArray ar1 = (JSONArray)jo1.get("operations");
            for(int j=0;j<ar1.size();j++)
            {
                JSONObject jo2 = (JSONObject)ar1.get(j);
                System.out.println(" State :"+jo2.get("field"));
                JSONObject jo3 = (JSONObject)jo2.get("value");
                System.out.println(" timestamp :"+jo3.get("timestamp"));
            }
        }
        JSONObject jo4 = (JSONObject)jo.get("scope");
        System.out.println(" company :"+jo4.get("company"));
      }
}
