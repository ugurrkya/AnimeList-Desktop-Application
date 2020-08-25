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
public class GenresQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(GenresQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Genres> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Genres> listtt = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `genres_id`, `genre_name` FROM `genres` WHERE `genre_name` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Genres dd;
   while(rs.next()){
   dd = new Genres(
   rs.getInt("genres_id"),
   rs.getString("genre_name")
   );
   listtt.add(dd);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(GenresQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return listtt;
   } }