import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;
 
public class server {
   private ServerSocket server;
   private Socket connection;
   private DataOutputStream outputStream;
   private DataInputStream inputStream;
   private Date date;
   private String inputMessage;
  
   public server() {
String cc;

      try {
         server =  new ServerSocket(8803);
        Scanner scn=new Scanner(System.in); 
        

 System.out.println("Serverted.");
         System.out.println("Watingclient to connect…");


         while(true) {
            date = new Date();
            connection = server.accept();
            System.out.println("Connected Client " + connection.getInetAddress().getHostAddress());
            System.out.println("Client: " + connection.getInetAddress().getHostName());
            System.out.println("Date date:");
            inputStream = new DataInputStream(connection.getInputStream());
            inputMessage = inputStream.readUTF();
            System.out.println("Message Client: " + inputMessage);
cc=scn.nextLine();
            outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.writeUTF("Welcome!\n"+cc);

         }
      }
      catch(IOException ioException) {
         ioException.printStackTrace();
         System.exit(1);
      }
   }
   public static void main(String args[]) {
      new server();
   }
}
