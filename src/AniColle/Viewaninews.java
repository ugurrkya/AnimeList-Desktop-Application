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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jülide
 */
public class Viewaninews extends javax.swing.JFrame {

    /**
     * Creates new form Viewaninews
     */
    private usertimeline getnew1;
    public Viewaninews(usertimeline getfor1) {
        this.getnew1=getfor1;
        initComponents();
        
    }
@SuppressWarnings("OverridableMethodCallInConstructor")
    public Viewaninews (String newsofani) {	//for taking the student name whose login to system 	
        initComponents();
      
       aniinews.setText(newsofani);
      aniinews.setVisible(false);
       
        
       
       try {
            String alnew=aniinews.getText();
        Connection cd;
            cd = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
        Statement st = (Statement) cd.createStatement();
        try(ResultSet rs = st.executeQuery("Select * FROM "+alnew+"")) { //connect to database table
            int colcount = rs.getMetaData().getColumnCount(); //take columns from database as have how much columns and put on these things
            DefaultTableModel tm = new DefaultTableModel(); //creating model
            for(int i = 1;i<=colcount;i++)
                tm.addColumn(rs.getMetaData().getColumnName(i)); //Adding columns to table by names which are the same as database
            while(rs.next())
                {
                    Object[] row = new Object[colcount];				//put data on these columns 
                    for(int i=1;i<=colcount;i++)
                        row[i-1] = rs.getObject(i);						//from index 0 to index i-1
                    tm.addRow(row);
                }
            aninewstable.setModel(tm);
        }
        cd.close();     //burda veritabanı bağlantısını kapatmıs														//disconnect
    } catch (SQLException ex) {     //burası da veritabanına bağlanamazsa vereceği uyarı için kullanılmıs
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
    }
       
       
       
    }
    private Viewaninews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aniinews = new javax.swing.JLabel();
        aninewspane = new javax.swing.JScrollPane();
        aninewstable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1137, 1137));

        aninewstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        aninewstable.setCellSelectionEnabled(true);
        aninewstable.setMaximumSize(new java.awt.Dimension(4124, 2313));
        aninewstable.setMinimumSize(new java.awt.Dimension(500, 500));
        aninewstable.setPreferredSize(new java.awt.Dimension(500, 500));
        aninewstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aninewstableMouseClicked(evt);
            }
        });
        aninewspane.setViewportView(aninewstable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(aniinews, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406))
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(aninewspane, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aniinews, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(aninewspane, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aninewstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aninewstableMouseClicked
        boolean b= aninewstable.isEditing();
        if(b==false){
            JOptionPane.showMessageDialog(null,"You can't edit the news.");
        }
    }//GEN-LAST:event_aninewstableMouseClicked

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
            java.util.logging.Logger.getLogger(Viewaninews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewaninews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewaninews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewaninews.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewaninews().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aniinews;
    private javax.swing.JScrollPane aninewspane;
    private javax.swing.JTable aninewstable;
    // End of variables declaration//GEN-END:variables
}
