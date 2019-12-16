package client;
// A Java program for a Client 
import java.net.*;

import server.WebServerMain;

import java.io.*; 
  
public class Client 
{ 
    // initialize socket and input output streams 
    private Socket socket            = null; 
    //private DataInputStream  input   = null; 
    //private DataOutputStream out     = null; 
    
//    private BufferedReader br = null;
//    private BufferedInputStream bis = null;
//    private BufferedOutputStream bos = null;
 
    InputStreamReader isr = null;//new InputStreamReader(socket.getInputStream ());
    BufferedReader in = null;//new BufferedReader (isr);
    PrintWriter out = null;//new PrintWriter (socket.getOutputStream (), true);

    // constructor to put ip address and port 
    public Client(String address, int port) 
    { 
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
            
            // takes input from terminal 
            //input  = new DataInputStream(System.in); 
            isr = new InputStreamReader(socket.getInputStream ());
            in = new BufferedReader (isr);
            // sends output to the socket 
            //out    = new DataOutputStream(socket.getOutputStream());
            out = new PrintWriter (socket.getOutputStream (), true);
            
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        out.println ("Ping"); 
        try {
			String rec = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
  
        // close the connection 
        try
        { 
          //input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    }
    
	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 5000);
		client.toString();
	}
    public String toString() {
    	return "Test";
    }
} 