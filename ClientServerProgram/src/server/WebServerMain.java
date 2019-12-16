package server;
import java.net.*;

import client.Client;

import java.io.*; 


public class WebServerMain {
    // starts server and waits for a connection
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in = null;
    private DataOutputStream out = null;
    // constructor with port 
    public WebServerMain (int port) {
	    try
	    {
		    while(true) {
	    		server = new ServerSocket(port); 
		        System.out.println("Server started"); 
		
		        
		        System.out.println("Waiting for a client ..."); 
		        try {
			        socket = server.accept(); 
			        System.out.println("Client accepted"); 
			
			        // takes input from the client socket
			        in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
			
			        out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			        
			        String line = ""; 
			        // reads message from client until "Over" is sent 
			        while (!line.equals("Over")) 
			        { 
			            try
			            { 
			                if ((line = in.readUTF()) == null) {
				                System.out.println("Client disconnected");
				                break;
			                	
			                } else {
		
			                	System.out.println(line);
			                	//Respond to client
			                	out.writeUTF(line + " SERVER");
			                	out.flush();
			                } 
			        	} catch (SocketTimeoutException e) {
			        		e.printStackTrace();
			        	}
			        }
		        } catch (IOException i) {
		        	System.out.println("Exception");
		        }
		        System.out.println("Closing connection"); 
		    	
		        // close connection 
		        server.close();
		        out.close();
		        socket.close(); 
		        in.close(); 
	    	}
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