import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.io.ObjectOutputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
 
public class arlibrary {
  public static void main(String [] args) {
    String URL = "jdbc:mysql://localhost/arlibrary?user=root&password=";
    System.out.println("Server is running...");
    try{
      ServerSocket serverSocket = new ServerSocket(1098, 500);
      Socket socket = serverSocket.accept();
      ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL);
      int isbn = (int) inputStream.readObject();
      
      socket = new Socket(InetAddress.getByName("localhost"), 1097);
      ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
      String messegeToMUlibrary =  "ISBN: " + isbn +
                                   "\nAvailable at Arlington Library";
      Statement search_ars = con.createStatement();
      String sql_statement = "select title from book where isbn = "+isbn+"";
      ResultSet rs = search_ars.executeQuery(sql_statement);
      int found = 0;
      
      while(rs.next()) {
        found = 1;
      System.out.println(rs.getString(1));
      
      outputStream.writeObject("ISBN: " + isbn + "\nTitle: " + rs.getString(1) + "\nAvailable at Arlington Library");
      outputStream.flush();
      }
    
      if (found == 0){
      String invalid = "ISBN: " + isbn + " is not available at Arlington Library.";
      outputStream.writeObject(invalid);
      outputStream.flush(); 
      }
  }
    catch(IOException e){
      e.printStackTrace();
    }
    catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch(SQLException e) {
     e.printStackTrace();
    }
    System.out.println("Server ended...");
  }
}