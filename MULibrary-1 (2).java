import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.io.ObjectInputStream;


public class MULibrary extends JFrame implements ActionListener {
  
  private JLabel isbnLabel, titleLabel;
  private JTextField isbnTextField, titleTextField;
  private JPanel northPanel,northPanel2, southPanel, southPanel2;
  private JButton addnewbookButton, searchisbn_mulibraryButton, searchisbn_arlingtonlibraryButton;
  
  public MULibrary() {
    super("MU Library");
    isbnLabel = new JLabel("ISBN:");
    isbnTextField = new JTextField(15);
    titleLabel = new JLabel("Title:");
    titleTextField = new JTextField(15);
    northPanel = new JPanel();
    northPanel.setLayout(new GridLayout(2,2));
    northPanel.add(isbnLabel);
    northPanel.add(isbnTextField);
    northPanel.add(titleLabel);
    northPanel.add(titleTextField);
    northPanel2 = new JPanel();
    northPanel2.add(northPanel);
    add(northPanel2, BorderLayout.NORTH);
    
    addnewbookButton = new JButton("Add New Book");
    addnewbookButton.addActionListener(this);
    searchisbn_mulibraryButton = new JButton("Search ISBN - MU Library");
    searchisbn_mulibraryButton.addActionListener(this);
    searchisbn_arlingtonlibraryButton = new JButton("Search ISBN - Arlington Library");
    searchisbn_arlingtonlibraryButton.addActionListener(this);
    southPanel = new JPanel();
    southPanel.add(addnewbookButton);
    southPanel.add(searchisbn_mulibraryButton);
    southPanel.add(searchisbn_arlingtonlibraryButton);
    southPanel2 = new JPanel();
    southPanel2.add(southPanel);
    add(southPanel2, BorderLayout.SOUTH);
    
  setVisible(true);
  setSize(600,200);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public void actionPerformed(ActionEvent event){
    String URL = "jdbc:mysql://localhost/mulibrary?user=root&password=";
    if(event.getSource () == addnewbookButton){
      try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL);
      String isbnn = isbnTextField.getText();
      int isbn = Integer.parseInt(isbnn);
      String title = titleTextField.getText();
      
      String output = "The following book is succesfully added to MU Library." +
                      "\nISBN: " + isbn +
                      "\nTitle: " + title;
      String insert_add = "insert into desc_book (isbn, title) values ('"+isbn+"', '"+title+"')";
      Statement add = con.createStatement();
      add.execute(insert_add);
      System.out.println("Insert successfull");
    
      JOptionPane.showMessageDialog(null, output);
    }
    catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
     catch(SQLException e) {
     e.printStackTrace();
    }
  }
    else if(event.getSource () == searchisbn_mulibraryButton) {
    
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL);
        String isbnn = isbnTextField.getText();
        int isbn = Integer.parseInt(isbnn);
        String title = titleTextField.getText();
        
       Statement search_mu = con.createStatement();
       String sql_statement = "select title from desc_book where isbn = "+isbn+"";
       ResultSet rs = search_mu.executeQuery(sql_statement);
      
       int found = 0;
         while(rs.next()) {
         found = 1;
         System.out.println(rs.getString(1));
         
         JOptionPane.showMessageDialog(null, "ISBN: " + isbn + "\nTitle: " + rs.getString(1) + "\nAvailable at MU Library");
      }
       
       if(found == 0){
       String invalid = "ISBN: " + isbn + " is not available at MU Library.";
       JOptionPane.showMessageDialog(null, invalid);
      }
        }
        
      catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
      catch(SQLException e) {
     e.printStackTrace();
    }
    
   }
    else if(event.getSource () == searchisbn_arlingtonlibraryButton) {
      try{
       Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL);
        String isbnn = isbnTextField.getText();
        int isbn = Integer.parseInt(isbnn);
        String title = titleTextField.getText();
        
        String ar_result = "\nISBN: " + isbn;
                      // "\nTitle: " +null+
       
      Socket socket = new Socket(InetAddress.getByName("localhost"), 1098);
      ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
      outputStream.writeObject(isbn);
      outputStream.flush();
      System.out.println("Message sent successfully");
      
      ServerSocket serverSocket = new ServerSocket(1097, 500);
 // something is wrong! it only works if i reset the code otherwise it says server already used
      socket = serverSocket.accept();
      ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
      String ar_resultFromarlibrary = (String) inputStream.readObject();
      JOptionPane.showMessageDialog(null, ar_resultFromarlibrary);
      
      }
      catch (IOException e) {
        e.printStackTrace();
      }
       catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
      catch(SQLException e) {
     e.printStackTrace();
    }
      
   }
 }
  
  public static void main(String [] args) {
  MULibrary m = new MULibrary ();
   
  }
}