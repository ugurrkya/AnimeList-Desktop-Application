package AniColle;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
 
 //CREATE A CLASS FOR READY CONNECTION
public class CountryQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(CountryQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Country> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Country> lissstt = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `countryid`, `countryname` FROM `countries` WHERE `countryname` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Country cc;
   while(rs.next()){
   cc = new Country(
   rs.getInt("countryid"),
   rs.getString("countryname")
   );
   lissstt.add(cc);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(CountryQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return lissstt;
   } }