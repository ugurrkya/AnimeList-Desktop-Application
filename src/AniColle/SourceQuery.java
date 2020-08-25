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
public class SourceQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(SourceQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Source> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Source> listee = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `sourceid`, `sourcename` FROM `sources` WHERE `sourcename` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Source ss;
   while(rs.next()){
   ss = new Source(
   rs.getInt("sourceid"),
   rs.getString("sourcename")
   );
   listee.add(ss);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(SourceQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return listee;
   } }