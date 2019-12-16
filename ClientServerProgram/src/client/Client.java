package client;
// A Java program for a Client 
import java.net.*;

import server.WebServerMain;

import java.io.*; 
  
public class Client 
{ 
    // initialize socket and input output streams 
    private Socket socket            = null; 
    private DataInputStream  input   = null;
    private DataInputStream  inputServer  = null; 

    private DataOutputStream out     = null; 
  
    // constructor to put ip address and port 
    public Client(String address, int port) 
    { 
        // establish a connection 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
            // takes input from server
            inputServer= new DataInputStream(socket.getInputStream());
            
            
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        // string to read message from input 
        String line = ""; 
        System.out.print("Enter input: ");
        // keep reading until "Over" is input 
        while (!line.equals("Over")) 
        { 
            try
            { 
                line = input.readLine();
                out.writeUTF(line); 
                System.out.println(inputServer.readUTF());
            } 
            catch(Exception e) 
            { 
                System.out.println("Could not reach server"); 
            } 
        } 
  
        // close the connection 
        try
        { 
            input.close(); 
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