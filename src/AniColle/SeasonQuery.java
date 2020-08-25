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
public class SeasonQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(SeasonQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Season> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Season> lisst = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `seasonid`, `seasonname` FROM `season` WHERE `seasonname` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Season gg;
   while(rs.next()){
   gg = new Season(
   rs.getInt("seasonid"),
   rs.getString("seasonname")
   );
   lisst.add(gg);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(SeasonQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return lisst;
   } }