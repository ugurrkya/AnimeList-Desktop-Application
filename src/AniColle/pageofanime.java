/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jülide
 */
public class pageofanime extends javax.swing.JFrame {

    /**
     * Creates new form denemee
     * @param incomingname     
     * @param userid     
     */
   // private animeviews denee;
    //public denemee(animeviews denee) {
      //  this.denee=denee;
      
        
   // }
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public pageofanime(String incomingname,String userid) {
        initComponents();
        animename.setText(incomingname);
        animename.setVisible(true);
        comingid.setText(userid);
        anipage();
        
        
    }
    

    private pageofanime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public void anipage(){
         
       Connection cnn;								//identify connection
  Statement stt;									//identify statement
  ResultSet rst;									//identify result set

try
                        {
                           String gozukk=animename.getText(); 
                        		//take the data 
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
                            stt = cnn.createStatement();
         rst = stt.executeQuery("SELECT `animephoto`, `animename`, `studio`, `genre`, `season`,`type`,`producer`,`source`,`plannedep`,`currentep`,`country`,`duration` FROM `anime` WHERE `animename` = '"+gozukk+"'");				//retrieve all data from the database on the coming data
              
           
            while(rst.next()){
                
                byte[] imagee = rst.getBytes(1);			//identify a byte variable for the image of the HR department, put the image to page
				
				//create an image icon for put the image to page
            ImageIcon imageicon = new ImageIcon(new ImageIcon(imagee).getImage().getScaledInstance(animeimage.getWidth(), animeimage.getHeight(), Image.SCALE_DEFAULT));
            animeimage.setIcon(imageicon);
            animename.setText(rst.getString(2));
            anistudio.setText(rst.getString(3));//put the image on to label
            anigenre.setText(rst.getString(4));		//put the company name to page
            aniseason.setText(rst.getString(5));	
            anitype.setText(rst.getString(6));	
            aniproducer.setText(rst.getString(7));	
            anisource.setText(rst.getString(8));
            aniplannedep.setText(rst.getString(9));	
            anicurrentep.setText(rst.getString(10));	
            anicountry.setText(rst.getString(11));
            aniduration.setText(rst.getString(12));	
            
            
            }
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(pageofanime.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
public void rate(){
	Connection conn;			
        PreparedStatement dc;
  
try
                        {
                            
              String animenamee= animename.getText();
       
        String usid= comingid.getText();
     
		String rating = (String)ratecombo.getSelectedItem();
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
         
     
		//ADD THESE INFORMATION RELATED TO DATABASE TABLE 
         String insert="INSERT INTO `rating` (`animename`, `user_id`, `rating`) VALUES(?,?,?)";
         dc = conn.prepareStatement(insert);
		dc.setString(1,animenamee);
         dc.setString(2,usid);
         dc.setString(3,rating);
         
		  dc.executeUpdate();	
		  JOptionPane.showMessageDialog(null, "Rate is "+rating);			//SHOW THE MESSAGE IF REPORT SENT 
        } catch (SQLException e) {											//SHOW THE MESSAGE IF THERE IS ALREADY ANOTHER REPORT 	
          JOptionPane.showMessageDialog(null, "You already rated.");
        }
	
}

public void addlist(){
	Connection conn;			
        PreparedStatement dc;
       
  
try
                        {
                     String usid= comingid.getText();
                    
              String animenamee= animename.getText();
            
          
              
		String liste = (String)listt.getSelectedItem();
	
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
         
		 
         String insert="INSERT INTO "+liste+" (`userid`, `animename`,`watchedep`,`plannedep`) VALUES (?,?,?,?)";
       
      
         dc = conn.prepareStatement(insert);
     
		dc.setString(1,usid);
         dc.setString(2,animenamee);
         try{
        String watched="0";
        
        String planned=aniplannedep.getText();
         int watcheed = Integer.parseInt(watched.trim());
          int plannedd = Integer.parseInt(planned.trim());
       dc.setInt(3,watcheed); 
       dc.setInt(4, plannedd);
       
      }catch(NumberFormatException numberformat){
            JOptionPane.showMessageDialog(null, "Please, entry a number for the episode area");
        }
        
         
		  dc.executeUpdate();	
		  JOptionPane.showMessageDialog(null, "Added to "+liste);			//SHOW THE MESSAGE IF REPORT SENT 
         }catch (SQLException e) {											//SHOW THE MESSAGE IF THERE IS ALREADY ANOTHER REPORT 	
          JOptionPane.showMessageDialog(null, "You already added to list.");
        } 
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        animename = new javax.swing.JLabel();
        addrate = new javax.swing.JButton();
        animeimage = new javax.swing.JLabel();
        anigenre = new javax.swing.JLabel();
        comingid = new javax.swing.JLabel();
        anistudio = new javax.swing.JLabel();
        anisource = new javax.swing.JLabel();
        aniproducer = new javax.swing.JLabel();
        aniplannedep = new javax.swing.JLabel();
        anicurrentep = new javax.swing.JLabel();
        anicountry = new javax.swing.JLabel();
        aniseason = new javax.swing.JLabel();
        anitype = new javax.swing.JLabel();
        aniduration = new javax.swing.JLabel();
        ratecombo = new javax.swing.JComboBox<>();
        addlist = new javax.swing.JButton();
        listt = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addrate.setText("RATE");
        addrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrateActionPerformed(evt);
            }
        });

        ratecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        addlist.setText("Add to List");
        addlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addlistActionPerformed(evt);
            }
        });

        listt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "watching", "completed", "dropped", "ptw" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(anicurrentep)
                        .addGap(213, 213, 213))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(aniproducer))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(aniseason))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(aniduration)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(animeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(addrate)
                                .addGap(287, 287, 287))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(anitype)
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(137, 137, 137)
                                        .addComponent(anistudio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ratecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(animename, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(anicountry, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aniplannedep, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(addlist)
                                        .addGap(41, 41, 41)
                                        .addComponent(listt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(anigenre, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comingid, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(anisource)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(animeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aniproducer)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(anicurrentep)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(aniseason)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aniduration)))
                        .addGap(22, 22, 22)
                        .addComponent(ratecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comingid, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anigenre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(animename, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(anisource))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(addrate)
                        .addGap(11, 11, 11)
                        .addComponent(anistudio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addlist)
                    .addComponent(listt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aniplannedep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(anicountry)
                .addGap(12, 12, 12)
                .addComponent(anitype)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrateActionPerformed
rate();
       
    }//GEN-LAST:event_addrateActionPerformed

    private void addlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addlistActionPerformed
      addlist();
    }//GEN-LAST:event_addlistActionPerformed

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
            java.util.logging.Logger.getLogger(pageofanime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pageofanime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pageofanime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pageofanime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pageofanime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addlist;
    private javax.swing.JButton addrate;
    private javax.swing.JLabel anicountry;
    private javax.swing.JLabel anicurrentep;
    private javax.swing.JLabel aniduration;
    private javax.swing.JLabel anigenre;
    private javax.swing.JLabel animeimage;
    private javax.swing.JLabel animename;
    private javax.swing.JLabel aniplannedep;
    private javax.swing.JLabel aniproducer;
    private javax.swing.JLabel aniseason;
    private javax.swing.JLabel anisource;
    private javax.swing.JLabel anistudio;
    private javax.swing.JLabel anitype;
    private javax.swing.JLabel comingid;
    private javax.swing.JComboBox<String> listt;
    private javax.swing.JComboBox<String> ratecombo;
    // End of variables declaration//GEN-END:variables
}
