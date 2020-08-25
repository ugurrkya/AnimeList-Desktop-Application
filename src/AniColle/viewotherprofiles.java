/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jülide
 */
public class viewotherprofiles extends javax.swing.JFrame {

    /**
     * Creates new form viewotherprofiles
     */
    
    private usertimeline getuser;
    public viewotherprofiles(usertimeline userr) {
        this.getuser=userr;
      initComponents();
     // username.setText(userr);
    }
    public viewotherprofiles(String gettingusername) {	//for taking the student name whose login to system 	
        initComponents();
        
        username.setText(gettingusername);
        username.setVisible(true);
        otherpane.setVisible(false);
       othertable.setVisible(false);
     
         Connection cnn;								//identify connection
  Statement stt;									//identify statement
  ResultSet rst;									//identify result set

try
                        {
                            
                        foto.setText(gettingusername);		//take the data 
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
                            stt = cnn.createStatement();
            rst = stt.executeQuery("SELECT `userpic`,`nickname`,`age`,`email` FROM `users` WHERE `userid` = '"+gettingusername+"'");			//retrieve all data from the database on the coming data
              
           
            while(rst.next()){
                
                byte[] imagee = rst.getBytes(1);			//identify a byte variable for the image of the HR department, put the image to page
				
				//create an image icon for put the image to page
            ImageIcon imageicon = new ImageIcon(new ImageIcon(imagee).getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
            foto.setIcon(imageicon);			//put the image on to label
            maill.setText(rst.getString(4));		//put the company name to page
            nicker.setText(rst.getString(2));		//put the mail to page 
            
            
            // put the company ID to page
            agee.setText(rst.getString(3));
            //put the about me information to the page
           
            }
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(viewotherprofiles.class.getName()).log(Level.SEVERE, null, ex);
        }
      
     
}

    private viewotherprofiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
        } catch (SQLException ex) {
            Logger.getLogger(viewotherprofiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    public ArrayList<ForLists> ListTable(){
   ArrayList<ForLists> myliste = new ArrayList<ForLists>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   
   String usidm= username.getText();
   String myli=otherlist.getText();
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `animephoto`, `anime`.`animename`,`watchedep`, `anime`.`plannedep` FROM `anime`, `"+myli+"`  WHERE `anime`.`animename`= `"+myli+"`.`animename` AND `"+myli+"`.`userid`='"+usidm+"'");
   
   ForLists fl;
   while(rs.next()){
   fl = new ForLists(
   rs.getBytes("animephoto"),
   rs.getString("animename"),
   rs.getInt("watchedep"),
rs.getInt("plannedep")
   );
   myliste.add(fl);
   
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(viewotherprofiles.class.getName()).log(Level.SEVERE, null, ex);
   }
   return myliste;
   }
    
    
    public void populateLists(){
        ArrayList<ForLists> listem = ListTable();
        String[] columnName = {"animephoto","animename","watchedep","plannedep"};
        
        Object[][] rows = new Object[listem.size()][4];
        for(int i = 0; i < listem.size(); i++){
    if(listem.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(listem.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
            
            
            rows[i][1] = listem.get(i).getName();
            rows[i][2] = listem.get(i).getWatchedep();
            rows[i][3] = listem.get(i).getPlannedep();
            
            
        }
        
        AniModel model = new AniModel(rows, columnName);
        
        othertable.setModel(model);
        othertable.setRowHeight(120);
        othertable.getColumnModel().getColumn(0).setPreferredWidth(150);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JLabel();
        watching = new javax.swing.JButton();
        completed = new javax.swing.JButton();
        ptw = new javax.swing.JButton();
        dropped = new javax.swing.JButton();
        otherpane = new javax.swing.JScrollPane();
        othertable = new javax.swing.JTable();
        otherlist = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        maill = new javax.swing.JLabel();
        agee = new javax.swing.JLabel();
        nicker = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        watching.setText("watching");
        watching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchingActionPerformed(evt);
            }
        });

        completed.setText("completed");
        completed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedActionPerformed(evt);
            }
        });

        ptw.setText("ptw");
        ptw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptwActionPerformed(evt);
            }
        });

        dropped.setText("dropped");
        dropped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                droppedActionPerformed(evt);
            }
        });

        othertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        otherpane.setViewportView(othertable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(otherpane)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(maill))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agee)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(watching, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(completed, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(ptw, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dropped, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(otherlist, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nicker)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(watching, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(completed, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ptw, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dropped, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(otherlist)
                                    .addComponent(maill)))
                            .addComponent(agee))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nicker)))
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(otherpane, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void watchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchingActionPerformed
        String usname=username.getText();
        username.setText(usname);
        String wh=watching.getLabel();
  otherlist.setText(wh);
       populateLists();
       otherpane.setVisible(true);
       othertable.setVisible(true);
    }//GEN-LAST:event_watchingActionPerformed

    private void completedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedActionPerformed
        String usname=username.getText();
        username.setText(usname);   
        String cm=completed.getLabel();
        otherlist.setText(cm);
       populateLists();
       otherpane.setVisible(true);
       othertable.setVisible(true);
    }//GEN-LAST:event_completedActionPerformed

    private void ptwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptwActionPerformed
       String usname=username.getText();
       username.setText(usname);
       String pt=ptw.getLabel();
       otherlist.setText(pt);
       populateLists();
       otherpane.setVisible(true);
       othertable.setVisible(true);
    }//GEN-LAST:event_ptwActionPerformed

    private void droppedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_droppedActionPerformed
        String usname=username.getText();
        username.setText(usname);    
        String dr=dropped.getLabel();
   otherlist.setText(dr);
       populateLists();
       otherpane.setVisible(true);
       othertable.setVisible(true);
    }//GEN-LAST:event_droppedActionPerformed

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
            java.util.logging.Logger.getLogger(viewotherprofiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewotherprofiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewotherprofiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewotherprofiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewotherprofiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agee;
    private javax.swing.JButton completed;
    private javax.swing.JButton dropped;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel maill;
    private javax.swing.JLabel nicker;
    private javax.swing.JLabel otherlist;
    private javax.swing.JScrollPane otherpane;
    private javax.swing.JTable othertable;
    private javax.swing.JButton ptw;
    private javax.swing.JLabel username;
    private javax.swing.JButton watching;
    // End of variables declaration//GEN-END:variables
}
