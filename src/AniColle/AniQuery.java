package AniColle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AniQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
        } catch (SQLException ex) {
            Logger.getLogger(AniQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<ForAnimes> BindTable(){
        
   ArrayList<ForAnimes> mylist = new ArrayList<ForAnimes>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT `animephoto`, `animeid`, `animename`, `studio`, `genre`, `season`, `type`, `producer`, `source`, `plannedep`, `currentep`, `country`, `duration` FROM `anime`");
   
   ForAnimes fa;
   while(rs.next()){
   fa = new ForAnimes(
   rs.getBytes("animephoto"),
   rs.getInt("animeid"),
   rs.getString("animename"),
   rs.getString("studio"),
   rs.getString("genre"),
   rs.getString("season"),
   rs.getString("type"),
   rs.getString("producer"),
   rs.getString("source"),
   rs.getInt("plannedep"),
   rs.getInt("currentep"),
   rs.getString("country"),
   rs.getString("duration")
   );
   mylist.add(fa);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(AniQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylist;
   }
}