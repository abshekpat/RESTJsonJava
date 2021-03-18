import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {
        // TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        ArrayList<CustomerDetails> ar = new ArrayList<>();
        Connection conn =null;
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "rootuser");
        Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE()-9 and Location ='Asia';");
        while(rs.next()) {
            CustomerDetails cd = new CustomerDetails();
            cd.setCourseName(rs.getString(1));
            cd.setPurchasedDate(rs.getString(2));
            cd.setAmount(rs.getInt(3));
            cd.setLocation(rs.getString(4));
            ar.add(cd);
        }

        for(int i=0;i<ar.size();i++) {
        ObjectMapper ob = new ObjectMapper();
        ob.writeValue(new File("//Users//apathak//Documents//workspace//JsonJava//customerInfo"+i+".json"), ar.get(i));
        }
        conn.close();
    }

}
