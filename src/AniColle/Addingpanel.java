/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jülide
 */
public class Addingpanel extends javax.swing.JFrame {

    /**
     * Creates new form Addingpanel
     */
    String ptt;
    private adminpanel par;
   
     @SuppressWarnings("OverridableMethodCallInConstructor")       
    public Addingpanel(adminpanel addpanel) {
        this.par=addpanel;
        initComponents();
        forstudio();
        forproducer();
        forSeason();
        forcountry();
        forGenres();
        forSource();
        forType();
    }

    private Addingpanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void forstudio(){//method
    MyQuery mq = new MyQuery();
        Connection connect =  mq.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `studios_name` FROM `studios`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                studios.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public void forproducer(){
    ProducerQuery pq = new ProducerQuery();
        Connection connect =  pq.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `producername` FROM `producers`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                producer.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    public void forSeason(){
    SeasonQuery se = new SeasonQuery();
        Connection connect =  se.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `seasonname` FROM `season`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                season.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    public void forcountry(){
    CountryQuery cr = new CountryQuery();
        Connection connect =  cr.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `countryname` FROM `countries`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                country.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    public void forGenres(){
    GenresQuery gr = new GenresQuery();
        Connection connect =  gr.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `genre_name` FROM `genres`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                genre.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    public void forSource(){
    SourceQuery so = new SourceQuery();
        Connection connect =  so.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `sourcename` FROM `sources`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                source.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    public void forType(){
    TypeQuery ty = new TypeQuery();
        Connection connect =  ty.getConnection();
        Statement st;
        ResultSet rs;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            st = connect.createStatement();
            rs = st.executeQuery("SELECT `typename` FROM `types`");			//RETRIEVE THE CITY NAME AND CITY ID FROM THE DATABASE
            while(rs.next()){
                type.addItem(rs.getString(1));						//ADD THE VALUES TO COMBOBOX AREA AS LIST
            }
        } catch (SQLException ex) {
            Logger.getLogger(Addingpanel.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public ImageIcon ResizeImage(String imgPath){			//the method for resizing image
        ImageIcon MyImagee = new ImageIcon(imgPath);		//create an image icon
        Image imgg = MyImagee.getImage();					//define the image with getting from MyImage
        Image newwImage = imgg.getScaledInstance(animephoto.getWidth(), animephoto.getHeight(),Image.SCALE_SMOOTH);		//the default statement
        ImageIcon imagee = new ImageIcon(newwImage);		//create the image by image icon
        return imagee;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        season = new javax.swing.JComboBox<>();
        animephoto = new javax.swing.JLabel();
        animetext = new javax.swing.JTextField();
        plannedeptext = new javax.swing.JTextField();
        currenteptext = new javax.swing.JTextField();
        durationtext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        studios = new javax.swing.JComboBox<>();
        source = new javax.swing.JComboBox<>();
        genre = new javax.swing.JComboBox<>();
        type = new javax.swing.JComboBox<>();
        country = new javax.swing.JComboBox<>();
        producer = new javax.swing.JComboBox<>();
        choosephoto = new javax.swing.JButton();
        confirmbutton = new javax.swing.JButton();

        season.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        animetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animetextActionPerformed(evt);
            }
        });

        durationtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationtextActionPerformed(evt);
            }
        });

        jLabel2.setText("Anime Name");

        jLabel3.setText("Producer");

        jLabel4.setText("Studios");

        jLabel5.setText("Source");

        jLabel6.setText("Genres");

        jLabel7.setText("Planned episode");

        jLabel9.setText("Current episode");

        jLabel10.setText("type");

        jLabel11.setText("duration");

        jLabel12.setText("season");

        jLabel13.setText("country");

        studios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studiosActionPerformed(evt);
            }
        });

        source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceActionPerformed(evt);
            }
        });

        genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreActionPerformed(evt);
            }
        });

        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });

        producer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producerActionPerformed(evt);
            }
        });

        choosephoto.setText("Choose a Picture");
        choosephoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosephotoActionPerformed(evt);
            }
        });

        confirmbutton.setText("CONFIRM");
        confirmbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(animephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(1, 1, 1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(choosephoto)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(studios, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(producer, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(animetext, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(plannedeptext, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currenteptext, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(durationtext, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(confirmbutton)
                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(animetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(producer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studios, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plannedeptext, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(currenteptext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(durationtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(28, 28, 28)
                        .addComponent(confirmbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(animephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(choosephoto)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(studios);
        studios.setBounds(700, 260, 180, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studiosActionPerformed
        
    }//GEN-LAST:event_studiosActionPerformed

    private void sourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceActionPerformed

    private void genreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genreActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void seasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seasonActionPerformed

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryActionPerformed

    private void producerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_producerActionPerformed

    private void animetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animetextActionPerformed

    private void durationtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationtextActionPerformed

    private void choosephotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosephotoActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();          //create a new FileChooser structure for the image choice
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));    //set current directory
         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png","jpeg");      //set current filters
         fileChooser.addChoosableFileFilter(filter);          //add the file with its filters from file
         int result = fileChooser.showSaveDialog(null);         //save the image 
         if(result == javax.swing.JFileChooser.APPROVE_OPTION){             //if the approve the image
             File selectedFile = fileChooser.getSelectedFile();       //the selected file is identified as getting method
             String path = selectedFile.getAbsolutePath();          	//identify the selected file and define the path
             animephoto.setIcon(ResizeImage(path));                     	//set Icon from the file to page
            ptt=path;
            if(path==null){
                JOptionPane.showMessageDialog(null, "Please choose a photo");
            }else{
                JOptionPane.showMessageDialog(null, "Photo is added");
            }
              }
        else if(result == javax.swing.JFileChooser.CANCEL_OPTION){					// if the not choose the image
             JOptionPane.showMessageDialog(null, "No data");	
        }
    }//GEN-LAST:event_choosephotoActionPerformed

    private void confirmbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbuttonActionPerformed
        Connection conn;			
        PreparedStatement sorgu;
  
try
                        {
                            
              String nameofanime= animetext.getText();
        String planep= plannedeptext.getText();
        String currentep= currenteptext.getText();
        String time= durationtext.getText(); 
        String studioo = (String)studios.getSelectedItem();
        String genree = (String)genre.getSelectedItem();
        String seasonn = (String)season.getSelectedItem();
        String typee = (String)type.getSelectedItem();
        String producerr = (String)producer.getSelectedItem();
        String sourcee = (String)source.getSelectedItem();
        String countryy = (String)country.getSelectedItem();
        
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
     
        String insert="INSERT INTO `anime` (`animephoto`, `animename`, `studio`, `genre`, `season`,`type`,`producer`,`source`,`plannedep`,`currentep`,`country`,duration) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
         sorgu = conn.prepareStatement(insert);
         
              InputStream is = new FileInputStream(new File(ptt));
           
         sorgu.setBlob(1, is);
       
          // JOptionPane.showMessageDialog(null, "Photo is added");
     
         sorgu.setString(2,nameofanime);
       sorgu.setString(3, studioo);
       sorgu.setString(4, genree);
       sorgu.setString(5, seasonn);
       sorgu.setString(6, typee);
       sorgu.setString(7, producerr);
         sorgu.setString(8, sourcee);
      try{
         
           int planepp=Integer.parseInt(planep.trim());
            int currentepp=Integer.parseInt(currentep.trim());
      
     
       sorgu.setInt(9, planepp);
       sorgu.setInt(10, currentepp);
      }catch(NumberFormatException numberformat){
            JOptionPane.showMessageDialog(null, "Please, entry a number for the episode area");
        }
       
        sorgu.setString(11, countryy);
        sorgu.setString(12,time);
        
           sorgu.executeUpdate();				//EXECUTE THE SQL
         
         
         
         
JOptionPane.showMessageDialog(null, "The anime is added");
    durationtext.setText("");
    animetext.setText("");
    plannedeptext.setText("");
    currenteptext.setText("");
    studios.setSelectedIndex(0);
    source.setSelectedIndex(0);
    genre.setSelectedIndex(0);
    type.setSelectedIndex(0);
    producer.setSelectedIndex(0);
    country.setSelectedIndex(0);
    season.setSelectedIndex(0);
    animephoto.setText("");
    
        } catch (SQLException e) {
    if (e instanceof SQLIntegrityConstraintViolationException) {
        JOptionPane.showMessageDialog(null, "Kullanıcı adı zaten var");
    }
    else  {
        JOptionPane.showMessageDialog(null, "Please, fill in the required information areas");
    }
    
	
        }
catch (NullPointerException ed) {
              JOptionPane.showMessageDialog(null, "Please choose a photo");
          } catch (FileNotFoundException ex) {   
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } 
catch(NumberFormatException ee){
            JOptionPane.showMessageDialog(null, "Please, entry a number for the age area");
        }
    }//GEN-LAST:event_confirmbuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Addingpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addingpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addingpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addingpanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addingpanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel animephoto;
    private javax.swing.JTextField animetext;
    private javax.swing.JButton choosephoto;
    private javax.swing.JButton confirmbutton;
    private javax.swing.JComboBox<String> country;
    private javax.swing.JTextField currenteptext;
    private javax.swing.JTextField durationtext;
    private javax.swing.JComboBox<String> genre;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField plannedeptext;
    private javax.swing.JComboBox<String> producer;
    private javax.swing.JComboBox<String> season;
    private javax.swing.JComboBox<String> source;
    private javax.swing.JComboBox<String> studios;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
