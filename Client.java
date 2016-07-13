import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Client {
   private Socket connection;
   private DataInputStream inputStream;
   private DataOutputStream outputStream;
   private String inputMessage;
   


   public Client() {
String a;   
while(true){
   try {
Scanner scn=new Scanner(System.in);
   a=scn.nextLine();
      connection = new Socket(InetAddress.getByName("192.168.128.80"), 8803);
        
         outputStream = new DataOutputStream(connection.getOutputStream());
         outputStream.writeUTF("Hello!"+a);
         inputStream = new DataInputStream(connection.getInputStream());
         inputMessage = inputStream.readUTF();
         System.out.println("Message Server: " + inputMessage);
         connection.close();
      }
      catch(IOException ioException) {
         ioException.printStackTrace();
      }
   }

}
   public static void main(String args[]) {
      new Client();
   }
}
