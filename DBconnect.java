
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnect{


private Connection con;
private Statement st;
private ResultSet rs;

DBconnect(){
try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vesithack","root","");
st= con.createStatement();
}catch(Exception e){
System.out.println("error "+e);
}
}
public static void main(String args[])
{
DBconnect connect=new DBconnect();
connect.getData();
}

public void getData()
{
try{
String query= "select * from stakeholders";
rs=st.executeQuery(query);
while(rs.next())
{
String name= rs.getString("name");
System.out.println("name "+name);
}

}catch(Exception e){
System.out.println("error "+e);
}
}
}
