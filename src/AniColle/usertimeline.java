/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AniColle;


import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Jülide
 */

public class usertimeline extends javax.swing.JFrame {

    /**
     * Creates new form usertimeline
     */
    private animelist parentt;
    public usertimeline(animelist userpage) {
        this.parentt=userpage;
        initComponents();
    }
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public usertimeline(String incoming) {	//for taking the student name whose login to system 	
        initComponents();
        seasonalmenu();
        gettingid.setText(incoming);
        gettingid.setVisible(false);
       ratebutton.setVisible(true);
        episodeup.setVisible(false);
        epnumber.setVisible(false);
       delete.setVisible(false);
       ratebutton.setVisible(true);
       userpane.setVisible(false);
       usertable.setVisible(false);
       populateAni();
           Connection cnn;								//identify connection
  Statement stt;									//identify statement
  ResultSet rst;									//identify result set

try
                        {
                            
                        myfoto.setText(incoming);		//take the data 
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
                            stt = cnn.createStatement();
            rst = stt.executeQuery("SELECT `userpic`,`nickname`,`age`,`email` FROM `users` WHERE `userid` = '"+incoming+"'");			//retrieve all data from the database on the coming data
              
           
            while(rst.next()){
                
                byte[] imagee = rst.getBytes(1);			//identify a byte variable for the image of the HR department, put the image to page
				
				//create an image icon for put the image to page
            ImageIcon imageicon = new ImageIcon(new ImageIcon(imagee).getImage().getScaledInstance(myfoto.getWidth(), myfoto.getHeight(), Image.SCALE_DEFAULT));
            myfoto.setIcon(imageicon);			//put the image on to label
            		//put the company name to page
            mynick.setText(rst.getString(2));		//put the mail to page 
            mymail.setText(rst.getString(4));
            
            // put the company ID to page
            myage.setText(rst.getString(3));
            //put the about me information to the page
           
            }
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(viewotherprofiles.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
}
        
    

    private usertimeline() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
        } catch (SQLException ex) {
            Logger.getLogger(AniQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
     public ArrayList<ForUsers> UsersTable(){
        
   ArrayList<ForUsers> mylist = new ArrayList<ForUsers>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   String seeusers= profilesearch.getText();
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT `userpic`, `userid`, `password`, `nickname`, `age`, `email` FROM `users` WHERE `userid`= '"+seeusers+"'");
   
   ForUsers fu;
   while(rs.next()){
   fu = new ForUsers(
   rs.getBytes("userpic"),
   rs.getString("userid"),
   rs.getString("password"),
   rs.getString("nickname"),
   rs.getInt("age"),
   rs.getString("email")
   );
   mylist.add(fu);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(usertimeline.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylist;
   }
    
    public void populateUserTable(){
        ArrayList<ForUsers> list = UsersTable();
        String[] columnName = {"userpic","userid","nickname","age","email"};
        
        Object[][] rows = new Object[list.size()][5];
        for(int i = 0; i < list.size(); i++){
    if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
            
            rows[i][1] = list.get(i).getID();
            //rows[i][2] = list.get(i).getPass();
            rows[i][2] = list.get(i).getNick();
            rows[i][3] = list.get(i).getAged();
            rows[i][4] = list.get(i).getEmail();
            
        }
        
        AniModel model = new AniModel(rows, columnName);
        usertable.setModel(model);
        usertable.setRowHeight(120);
        usertable.getColumnModel().getColumn(0).setPreferredWidth(150);
    } 
    
    
    public ArrayList<ForSeason> SeasonTable(){
   ArrayList<ForSeason> mylist = new ArrayList<ForSeason>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   String seas=seasonn.getText();
   
   
   try {
       
   st = con.createStatement();
   rs = st.executeQuery("SELECT `animephoto`, `animeid`, `animename`, `studio`, `genre`,`season`, `type`, `producer`, `source`, `plannedep`, `currentep`, `country`, `duration` FROM `anime` WHERE `season`= '"+seas+"'");
   
   ForSeason da;
   while(rs.next()){
   da = new ForSeason(
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
   mylist.add(da);
   
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(usertimeline.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylist;
   }
     public void populateAniTable(){
        ArrayList<ForSeason> list = SeasonTable();
        String[] columnName = {"animephoto","animename","studio","genre","type","producer","source","plannedep","currentep","country","duration"};
        
        Object[][] rows = new Object[list.size()][11];
        for(int i = 0; i < list.size(); i++){
    if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
            
            //rows[i][1] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getStudio();
            rows[i][3] = list.get(i).getGenre();
           // rows[i][4] = list.get(i).getSeason();
            rows[i][4] = list.get(i).getType();
            rows[i][5] = list.get(i).getProducer();
            rows[i][6] = list.get(i).getSource();
            rows[i][7] = list.get(i).getPlannedep();
            rows[i][8] = list.get(i).getCurrentep();
            rows[i][9] = list.get(i).getCountry();
            rows[i][10] = list.get(i).getDuration();
        }
        
        AniModel model = new AniModel(rows, columnName);
        anitable.setModel(model);
        anitable.setRowHeight(120);
        anitable.getColumnModel().getColumn(0).setPreferredWidth(150);
    }
     
     public void searchusers(){
         String seeusers= profilesearch.getText();
        
        try {
            
              //connection and statement informations 
        Connection conct = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
        Statement st = (Statement) conct.createStatement();
			//try the result set with the SQL statement and execute the statement
	  try(ResultSet rs = st.executeQuery("SELECT `userid`,`nickname`,`age`,`email` FROM `users` WHERE `userid`= '"+seeusers+"' ") ) { 
            int counter = rs.getMetaData().getColumnCount(); 	//count the column numbers from the database
            DefaultTableModel tm = new DefaultTableModel();		//create a default table model
            for(int i = 1;i<=counter;i++)
               
                tm.addColumn(rs.getMetaData().getColumnName(i));		//add columns from coming the database
            while(rs.next())				//while statement
                {
					Object[] row = new Object[counter];			//identify the rows according to counter
                    for(int i=1;i<=counter;i++)					//start the loop for the counter
                        row[i-1] = rs.getObject(i);			//put the objects to the columns
         
                    tm.addRow(row);
                }
            usertable.setModel(tm);
            
            
          
        }
        conct.close();								//close the connection
    } catch (SQLException ex) {
            Logger.getLogger(usertimeline.class.getName()).log(Level.SEVERE, null, ex);
    }
     }
     
     
     
public void populateAnisearch(){
        ArrayList<ForAnimes> list = anisearchTable();
        String[] columnName = {"animephoto","animename","studio","genre","season","type","producer","source","plannedep","currentep","country","duration"};
        
        Object[][] rows = new Object[list.size()][12];
        for(int i = 0; i < list.size(); i++){
    if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
            
            //rows[i][1] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getStudio();
            rows[i][3] = list.get(i).getGenre();
            rows[i][4] = list.get(i).getSeason();
            rows[i][5] = list.get(i).getType();
            rows[i][6] = list.get(i).getProducer();
            rows[i][7] = list.get(i).getSource();
            rows[i][8] = list.get(i).getPlannedep();
            rows[i][9] = list.get(i).getCurrentep();
            rows[i][10] = list.get(i).getCountry();
            rows[i][11] = list.get(i).getDuration();
        }
        
        AniModel model = new AniModel(rows, columnName);
        anitable.setModel(model);
        anitable.setRowHeight(120);
        anitable.getColumnModel().getColumn(0).setPreferredWidth(150);
    }
     
     public ArrayList<ForAnimes> anisearchTable(){
        
   ArrayList<ForAnimes> mylist = new ArrayList<ForAnimes>();
   Connection con = getConnection();
   Statement st;
   ResultSet rs;
   String seeanime= animesearch.getText();
  
   
   try {
   st = con.createStatement();
   rs = st.executeQuery("SELECT `animephoto`,`animeid`, `animename`, `studio`, `genre`, `season`, `type`, `producer`, `source`, `plannedep`, `currentep`, `country`, `duration` FROM `anime` WHERE `animename`='"+seeanime+"' ");
   
   ForAnimes gf;
   while(rs.next()){
   gf = new ForAnimes(
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
   mylist.add(gf);
   }
   
   } catch (SQLException ex) {
   Logger.getLogger(AniQuery.class.getName()).log(Level.SEVERE, null, ex);
   }
   return mylist;
   }
     
     
      public ArrayList<ForLists> ListTable(){
   ArrayList<ForLists> myliste = new ArrayList<ForLists>();
   Connection con=getConnection();
   Statement st;
   ResultSet rs;
   
   String usidm= gettingid.getText();
   String myli=julist.getText();
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
   Logger.getLogger(usertimeline.class.getName()).log(Level.SEVERE, null, ex);
   }
   return myliste;
   }
    
      public void populateLists(){
          try{
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
        
        anitable.setModel(model);
        anitable.setRowHeight(120);
        anitable.getColumnModel().getColumn(0).setPreferredWidth(150);
    }catch(ArrayIndexOutOfBoundsException ex) {
       
        
            }
      }
      
    public void populateAni(){
        AniQuery an = new AniQuery();
        ArrayList<ForAnimes> list = an.BindTable();
        String[] columnName = {"animephoto","animename","studio","genre","season","type","producer","source","plannedep","currentep","country","duration"};
        
        
        
        Object[][] rows = new Object[list.size()][12];
        for(int i = 0; i < list.size(); i++){
    if(list.get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            rows[i][0] = image;
            }
            else{ 
                rows[i][0] = null;
            }
          
            //rows[i][1] = list.get(i).getID();
            rows[i][1] = list.get(i).getName();
            rows[i][2] = list.get(i).getStudio();
            rows[i][3] = list.get(i).getGenre();
            rows[i][4] = list.get(i).getSeason();
            rows[i][5] = list.get(i).getType();
            rows[i][6] = list.get(i).getProducer();
            rows[i][7] = list.get(i).getSource();
            rows[i][8] = list.get(i).getPlannedep();
            rows[i][9] = list.get(i).getCurrentep();
            rows[i][10] = list.get(i).getCountry();
            rows[i][11] = list.get(i).getDuration();
           
        }
        
        AniModel model = new AniModel(rows, columnName);
        anitable.setModel(model);
        anitable.setRowHeight(120);
        anitable.getColumnModel().getColumn(0).setPreferredWidth(150);
    }
     public String seasonalmenu(){
         
        try {
              //connection and statement informations 
        Connection conct = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
        Statement st = (Statement) conct.createStatement();
			//try the result set with the SQL statement and execute the statement
                  for(int i=0; i<=4; i++){
	  try(ResultSet rs = st.executeQuery("SELECT `seasonname` FROM `season` WHERE `seasonid`= '"+i+"' ") ) { 
           while(rs.next()){
           
             
              switch (i) {
                  case 1:
                      winter.setText(rs.getString(1));
                      break;
                  case 2:
                      spring.setText(rs.getString(1));
                      break;
                  case 3:
                      summer.setText(rs.getString(1));
                      break;
                  case 4:
                      fall.setText(rs.getString(1));
                      break;
                  default:
                      break;
              }}
               
          }
        								//close the connection
    }} catch (SQLException ex) {
            Logger.getLogger(viewuser.class.getName()).log(Level.SEVERE, null, ex);
    }   return null;
}
            
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        secret = new javax.swing.JLabel();
        gettingid = new javax.swing.JLabel();
        seasonn = new javax.swing.JLabel();
        anipane = new javax.swing.JScrollPane();
        anitable = new javax.swing.JTable();
        julist = new javax.swing.JLabel();
        episodeup = new javax.swing.JButton();
        göster = new javax.swing.JLabel();
        göster2 = new javax.swing.JLabel();
        göster3 = new javax.swing.JLabel();
        epnumber = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        search = new javax.swing.JButton();
        animesearch = new javax.swing.JTextField();
        usersearch = new javax.swing.JButton();
        profilesearch = new javax.swing.JTextField();
        userpane = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        othernick = new javax.swing.JLabel();
        allanime = new javax.swing.JButton();
        myfoto = new javax.swing.JLabel();
        myage = new javax.swing.JLabel();
        mymail = new javax.swing.JLabel();
        mynick = new javax.swing.JLabel();
        ratebutton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        List = new javax.swing.JMenu();
        watching = new javax.swing.JMenuItem();
        dropped = new javax.swing.JMenuItem();
        completed = new javax.swing.JMenuItem();
        ptw = new javax.swing.JMenuItem();
        seasonalanime = new javax.swing.JMenu();
        winter = new javax.swing.JMenuItem();
        spring = new javax.swing.JMenuItem();
        summer = new javax.swing.JMenuItem();
        fall = new javax.swing.JMenuItem();
        aninews = new javax.swing.JMenu();
        animenews = new javax.swing.JMenuItem();
        platformnews = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TimeLine");

        anitable.setAutoCreateRowSorter(true);
        anitable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        anitable.setMaximumSize(new java.awt.Dimension(2312320, 22320));
        anitable.setMinimumSize(new java.awt.Dimension(1366, 768));
        anitable.setPreferredSize(new java.awt.Dimension(5000, 2500));
        anitable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anitableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                anitableMousePressed(evt);
            }
        });
        anipane.setViewportView(anitable);

        episodeup.setText("Episode");
        episodeup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                episodeupActionPerformed(evt);
            }
        });

        epnumber.setText("Entry a episode number");

        delete.setText("Delete Anime");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AniColle/search.png"))); // NOI18N
        search.setText("Search Animes");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        animesearch.setText("Find Anime");

        usersearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AniColle/profile.jpeg"))); // NOI18N
        usersearch.setText("Search Profile");
        usersearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersearchActionPerformed(evt);
            }
        });

        profilesearch.setText("Find Profile");

        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
            }
        ));
        usertable.setMaximumSize(new java.awt.Dimension(4124, 2313));
        usertable.setMinimumSize(new java.awt.Dimension(500, 500));
        usertable.setPreferredSize(new java.awt.Dimension(500, 500));
        usertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usertableMouseClicked(evt);
            }
        });
        userpane.setViewportView(usertable);

        allanime.setText("AllAnimes");
        allanime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allanimeMousePressed(evt);
            }
        });
        allanime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allanimeActionPerformed(evt);
            }
        });

        ratebutton.setText("SHOW RATE");
        ratebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratebuttonActionPerformed(evt);
            }
        });

        jMenuBar1.setAlignmentX(0.55F);
        jMenuBar1.setAlignmentY(0.5F);
        jMenuBar1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        List.setText("Lists");
        List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListActionPerformed(evt);
            }
        });

        watching.setText("watching");
        watching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                watchingMousePressed(evt);
            }
        });
        watching.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchingActionPerformed(evt);
            }
        });
        List.add(watching);

        dropped.setText("dropped");
        dropped.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                droppedMousePressed(evt);
            }
        });
        dropped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                droppedActionPerformed(evt);
            }
        });
        List.add(dropped);

        completed.setText("completed");
        completed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                completedMousePressed(evt);
            }
        });
        completed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completedActionPerformed(evt);
            }
        });
        List.add(completed);

        ptw.setText("ptw");
        ptw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ptwMousePressed(evt);
            }
        });
        ptw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptwActionPerformed(evt);
            }
        });
        List.add(ptw);

        jMenuBar1.add(List);

        seasonalanime.setText("Seasonal Anime");
        seasonalanime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seasonalanimeMouseClicked(evt);
            }
        });

        winter.setMinimumSize(new java.awt.Dimension(30, 30));
        winter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                winterMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                winterMousePressed(evt);
            }
        });
        seasonalanime.add(winter);

        spring.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                springMousePressed(evt);
            }
        });
        seasonalanime.add(spring);

        summer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                summerMousePressed(evt);
            }
        });
        seasonalanime.add(summer);

        fall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fallMousePressed(evt);
            }
        });
        seasonalanime.add(fall);

        jMenuBar1.add(seasonalanime);

        aninews.setText("News");

        animenews.setText("animenews");
        animenews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                animenewsMousePressed(evt);
            }
        });
        animenews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animenewsActionPerformed(evt);
            }
        });
        aninews.add(animenews);

        platformnews.setText("platformnews");
        platformnews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                platformnewsMousePressed(evt);
            }
        });
        aninews.add(platformnews);

        jMenuBar1.add(aninews);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(seasonn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1057, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(anipane, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(gettingid, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(mynick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(othernick))
                                    .addComponent(ratebutton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(allanime)
                                .addGap(18, 18, 18)
                                .addComponent(delete)
                                .addGap(28, 28, 28)
                                .addComponent(göster3)
                                .addGap(48, 48, 48)
                                .addComponent(episodeup)
                                .addGap(18, 18, 18)
                                .addComponent(epnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(göster2)
                                .addGap(71, 71, 71)
                                .addComponent(usersearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profilesearch)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(göster)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(julist)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(animesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(mymail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(search)
                                                .addGap(27, 27, 27))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(myage, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addComponent(myfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(172, 172, 172)
                                        .addComponent(secret)
                                        .addContainerGap())))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userpane, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(julist)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(göster3)
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(episodeup)
                                    .addComponent(epnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delete)
                                    .addComponent(usersearch)
                                    .addComponent(profilesearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(allanime))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secret))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(göster)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(göster2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(search)
                                        .addComponent(animesearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(anipane)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(othernick)
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(gettingid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(mymail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                                .addComponent(myage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(mynick, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(88, 88, 88)
                                .addComponent(ratebutton)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(userpane, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 111, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seasonn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void watchingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchingActionPerformed
       
    }//GEN-LAST:event_watchingActionPerformed

    private void droppedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_droppedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_droppedActionPerformed

    private void completedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completedActionPerformed

    private void ptwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ptwActionPerformed

    private void animenewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animenewsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_animenewsActionPerformed

    private void ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListActionPerformed

    private void seasonalanimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seasonalanimeMouseClicked
    
    }//GEN-LAST:event_seasonalanimeMouseClicked

    private void winterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winterMouseClicked
    
    }//GEN-LAST:event_winterMouseClicked

    private void winterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_winterMousePressed
          String d=winter.getLabel();
     seasonn.setText(d);
    
        populateAniTable();
         anipane.setVisible(true);
        anitable.setVisible(true);
     userpane.setVisible(false);
       usertable.setVisible(false);
     episodeup.setVisible(false);
     epnumber.setVisible(false);
     delete.setVisible(false);
     
    }//GEN-LAST:event_winterMousePressed

    private void springMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_springMousePressed
       String d=spring.getLabel();
     seasonn.setText(d);
      populateAniTable();
       anipane.setVisible(true);
        anitable.setVisible(true);
        userpane.setVisible(false);
       usertable.setVisible(false);
     episodeup.setVisible(false);
     epnumber.setVisible(false);
     delete.setVisible(false);
    }//GEN-LAST:event_springMousePressed

    private void summerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summerMousePressed
        String e=summer.getLabel();
     seasonn.setText(e);
      populateAniTable();
      anipane.setVisible(true);
        anitable.setVisible(true);
    episodeup.setVisible(false);delete.setVisible(false);
    epnumber.setVisible(false);
    userpane.setVisible(false);
       usertable.setVisible(false);
    }//GEN-LAST:event_summerMousePressed

    private void fallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fallMousePressed
       String f=fall.getLabel();
     seasonn.setText(f);
      populateAniTable();
      anipane.setVisible(true); 
        anitable.setVisible(true);
        episodeup.setVisible(false);delete.setVisible(false);
        epnumber.setVisible(false);
          userpane.setVisible(false);
       usertable.setVisible(false);
       
    }//GEN-LAST:event_fallMousePressed

    private void anitableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anitableMouseClicked
        JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

        String linkname= source.getModel().getValueAt(row,1)+"";
        String yazdir=linkname;
        String usersid= gettingid.getText();
        //new denemee(this).setVisible(false);
        new pageofanime(yazdir,usersid).setVisible(true);
    }//GEN-LAST:event_anitableMouseClicked

    private void ptwMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptwMousePressed
       String j=ptw.getLabel();
       julist.setText(j);
       populateLists();
       anipane.setVisible(true);
       anitable.setVisible(true);
       userpane.setVisible(false);
       usertable.setVisible(false);
       episodeup.setVisible(true);
       epnumber.setVisible(true);delete.setVisible(true);
    }//GEN-LAST:event_ptwMousePressed

    private void completedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_completedMousePressed
       String k=completed.getLabel();
       julist.setText(k);
       populateLists();
       anipane.setVisible(true);
       anitable.setVisible(true);
       userpane.setVisible(false);
       usertable.setVisible(false);
       episodeup.setVisible(false);
       epnumber.setVisible(false);delete.setVisible(false);
    }//GEN-LAST:event_completedMousePressed

    private void droppedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_droppedMousePressed
        String m=dropped.getLabel();
       julist.setText(m);
       populateLists();
       anipane.setVisible(true);
       anitable.setVisible(true);
       userpane.setVisible(false);
       usertable.setVisible(false);
       episodeup.setVisible(true);
       epnumber.setVisible(true); delete.setVisible(true);
    }//GEN-LAST:event_droppedMousePressed

    private void watchingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchingMousePressed
        String n=watching.getLabel();
       julist.setText(n);
       populateLists();
       userpane.setVisible(false);
       usertable.setVisible(false);
       anipane.setVisible(true);
       anitable.setVisible(true);
       episodeup.setVisible(true);
       epnumber.setVisible(true);delete.setVisible(false);
    }//GEN-LAST:event_watchingMousePressed

    private void episodeupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_episodeupActionPerformed
        
        String al=gettingid.getText();
        göster.setText(al);
        göster.setVisible(false);
        String al2=göster2.getText();
        göster2.setText(al2);
        göster2.setVisible(false);
        String al3=göster3.getText();
         göster3.setText(al3);
         göster3.setVisible(false);
         String listn=julist.getText();
         String al4=epnumber.getText();
        String sql = "UPDATE "+listn+" SET watchedep='" + al4 + "' WHERE userid='" + al + "' AND animename='" + al2 + "'";
        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            //STATEMENT
            Statement s = con.prepareStatement(sql);
            //EXECUTE
            s.execute(sql);
            JOptionPane.showMessageDialog(null,"It's updated");
        } catch (SQLException ex) {
           Logger.getLogger(usertimeline.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null,"NO");
        }
        
    }//GEN-LAST:event_episodeupActionPerformed

    private void anitableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anitableMousePressed
      JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

        String animeninismi= source.getModel().getValueAt(row,1)+"";
        göster2.setText(animeninismi);
        göster2.setVisible(false);
         
        String animewatched= source.getModel().getValueAt(row,2)+"";
         göster3.setText(animewatched);
        göster3.setVisible(false);
        
        //new denemee(this).setVisible(false);
        
        
    }//GEN-LAST:event_anitableMousePressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
         String al=gettingid.getText();
        göster.setText(al);
        göster.setVisible(false);
        String al2=göster2.getText();
        göster2.setText(al2);
        String listn=julist.getText();
         
        
        String sql="DELETE FROM "+listn+" WHERE userid ='"+al+"' AND animename ='"+al2+"' ";
        
        
        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
            
            //STATEMENT
            Statement s=con.prepareStatement(sql);
            
            //EXECUTE
            s.execute(sql);
            
            JOptionPane.showMessageDialog(null,"It's deleted");
            
        }catch(SQLException ex)
        {
            Logger.getLogger(MyQuery.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"It's not deleted");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String ara=animesearch.getText();
        animesearch.setText(ara);
        populateAnisearch();
        anipane.setVisible(true);
        anitable.setVisible(true);
        
    }//GEN-LAST:event_searchActionPerformed

    private void usersearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersearchActionPerformed
       
        
        String finduser=profilesearch.getText();
        profilesearch.setText(finduser);
        populateUserTable();
        //searchusers();
        userpane.setVisible(true);
        usertable.setVisible(true);
        anipane.setVisible(true);
        anitable.setVisible(true);
    }//GEN-LAST:event_usersearchActionPerformed

    private void usertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertableMouseClicked
        JTable source= (JTable)evt.getSource();
        int row= source.rowAtPoint(evt.getPoint());
        int column= source.columnAtPoint(evt.getPoint());

        String nicknamee= source.getModel().getValueAt(row,1)+"";
       othernick.setText(nicknamee);
        String nickname= othernick.getText();
        //new denemee(this).setVisible(false);
        new viewotherprofiles(nickname).setVisible(true);
        new viewotherprofiles(this).setVisible(false);
    }//GEN-LAST:event_usertableMouseClicked

    private void allanimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allanimeActionPerformed
        populateAni();
      anipane.setVisible(true); 
        anitable.setVisible(true);
        episodeup.setVisible(false);delete.setVisible(false);
        epnumber.setVisible(false);
        userpane.setVisible(false);
        usertable.setVisible(false);
        ratebutton.setVisible(true);
    }//GEN-LAST:event_allanimeActionPerformed

    private void allanimeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allanimeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_allanimeMousePressed

    private void animenewsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_animenewsMousePressed
    String newsname=animenews.getText();
    new Viewaninews(this).setVisible(false);
     new Viewaninews(newsname).setVisible(true);
    }//GEN-LAST:event_animenewsMousePressed

    private void platformnewsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_platformnewsMousePressed
      String newsname=platformnews.getText();
    new Viewplatformnews(this).setVisible(false);
     new Viewplatformnews(newsname).setVisible(true);
    }//GEN-LAST:event_platformnewsMousePressed

    private void ratebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratebuttonActionPerformed
         
       Connection cnn;								//identify connection
  Statement stt;									//identify statement
  ResultSet rst;									//identify result set

try
                        {
                           String aname=göster2.getText(); 
                        		//take the data 
                            cnn= DriverManager.getConnection("jdbc:mysql://localhost:3306/anicolle?useUnicode=true&characterEncoding=UTF-8", "afrodeitt", "closemyeyes");
                            stt = cnn.createStatement();
         rst = stt.executeQuery("SELECT AVG(`rating`) FROM (SELECT DISTINCT `user_id`,`animename`,`rating` FROM `rating` WHERE `animename`=  '"+aname+"' GROUP BY `user_id`)T  ");				//retrieve all data from the database on the coming data
              
           
            while(rst.next()){
                
                
           int ratee= (rst.getInt(1));	
            JOptionPane.showMessageDialog(null,+ratee);	
            
            
            }
           
           
            
             }
                          catch (SQLException ex) {
            Logger.getLogger(pageofanime.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ratebuttonActionPerformed

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
            java.util.logging.Logger.getLogger(usertimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usertimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usertimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usertimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usertimeline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu List;
    private javax.swing.JButton allanime;
    private javax.swing.JMenuItem animenews;
    private javax.swing.JTextField animesearch;
    private javax.swing.JMenu aninews;
    private javax.swing.JScrollPane anipane;
    private javax.swing.JTable anitable;
    private javax.swing.JMenuItem completed;
    private javax.swing.JButton delete;
    private javax.swing.JMenuItem dropped;
    private javax.swing.JButton episodeup;
    private javax.swing.JTextField epnumber;
    private javax.swing.JMenuItem fall;
    private javax.swing.JLabel gettingid;
    private javax.swing.JLabel göster;
    private javax.swing.JLabel göster2;
    private javax.swing.JLabel göster3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel julist;
    private javax.swing.JLabel myage;
    private javax.swing.JLabel myfoto;
    private javax.swing.JLabel mymail;
    private javax.swing.JLabel mynick;
    private javax.swing.JLabel othernick;
    private javax.swing.JMenuItem platformnews;
    private javax.swing.JTextField profilesearch;
    private javax.swing.JMenuItem ptw;
    private javax.swing.JButton ratebutton;
    private javax.swing.JButton search;
    private javax.swing.JMenu seasonalanime;
    private javax.swing.JLabel seasonn;
    private javax.swing.JLabel secret;
    private javax.swing.JMenuItem spring;
    private javax.swing.JMenuItem summer;
    private javax.swing.JScrollPane userpane;
    private javax.swing.JButton usersearch;
    private javax.swing.JTable usertable;
    private javax.swing.JMenuItem watching;
    private javax.swing.JMenuItem winter;
    // End of variables declaration//GEN-END:variables
}
