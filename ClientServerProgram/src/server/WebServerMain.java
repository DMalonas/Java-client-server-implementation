package server;
import java.net.*;

import client.Client;

import java.io.*; 


public class WebServerMain {
    // starts server and waits for a connection
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    //private DataInputStream in = null;
    InputStreamReader isr = null; //new InputStreamReader (conn.getInputStream ());
    BufferedReader in = null; //new BufferedReader (isr);
    PrintWriter out = null; //new PrintWriter (conn.getOutputStream (), true);

    // constructor with port 
    public WebServerMain (int port) {
	    try
	    { 
	        server = new ServerSocket(port);
	        socket = server.accept(); 

	        isr = new InputStreamReader (socket.getInputStream ());
	        in = new BufferedReader (isr);
	        out = new PrintWriter (socket.getOutputStream (), true);
	        
	        System.out.println("Server started"); 
	
	        System.out.println("Waiting for a client ..."); 
	
	        
	        System.out.println("Client accepted"); 
	
	
	        String line = ""; 
	
	        // reads message from client until "Over" is sent 
	        line = in.readLine ();
	        out.println (line);

	        System.out.println("Closing connection"); 
	
	        // close connection
	        server.close();
	        socket.close();     
	        isr.close();
	        in.close();
	        out.close();
	    } 
	    catch(IOException i) 
	    { 
	        System.out.println(i); 
	    }
    }
    
    
	public static void main(String[] args) {
		WebServerMain server = new WebServerMain(5000);
		System.out.println("here");
	}
}
