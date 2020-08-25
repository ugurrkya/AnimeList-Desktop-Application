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
public class ProducerQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProducerQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Producer> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Producer> plist = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `producerid`, `producername` FROM `producers` WHERE `producername` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Producer pp;
   while(rs.next()){
   pp = new Producer(
   rs.getInt("producerid"),
   rs.getString("producername")
   );
   plist.add(pp);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(ProducerQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return plist;
   } }