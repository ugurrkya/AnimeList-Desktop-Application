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
public class TypeQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(TypeQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Type> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Type> lisstt = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `typeid`, `typename` FROM `types` WHERE `typename` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Type tt;
   while(rs.next()){
   tt = new Type(
   rs.getInt("typeid"),
   rs.getString("typename")
   );
   lisstt.add(tt);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(TypeQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return lisstt;
   } }