/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Uğur
 */
 
 //CREATE A CLASS FOR READY CONNECTION
public class MyQuery {
    
   public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
        } catch (SQLException ex) {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public ArrayList<Studios> getData(String Name){				//ARRAYLIST CLASS FOR CITY CHECKBOX AREAS

   ArrayList<Studios> list = new ArrayList<>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   //SQL STATEMENTS
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT  `studios_id`, `studios_name` FROM `studios` WHERE `studios_name` = "+ Name);
   //IDENTIFYING CITY VALUES TO CHECKBOX
   Studios p;
   while(rs.next()){
   p = new Studios(
   rs.getInt("studios_id"),
   rs.getString("studios_name")
   );
   list.add(p);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return list;
   } }