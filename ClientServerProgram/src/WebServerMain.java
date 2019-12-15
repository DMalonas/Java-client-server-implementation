import java.net.*; 
import java.io.*; 


public class WebServerMain {
    // starts server and waits for a connection
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in = null;
    // constructor with port 
    public WebServerMain (int port) {
	    try
	    { 
	        server = new ServerSocket(port); 
	        System.out.println("Server started"); 
	
	        System.out.println("Waiting for a client ..."); 
	
	        socket = server.accept(); 
	        System.out.println("Client accepted"); 
	
	        // takes input from the client socket 
	        in = new DataInputStream( 
	            new BufferedInputStream(socket.getInputStream())); 
	
	        String line = ""; 
	
	        // reads message from client until "Over" is sent 
	        while (!line.equals("Over")) 
	        { 
	            try
	            { 
	                line = in.readUTF(); 
	                System.out.println(line); 
	
	            } 
	            catch(IOException i) 
	            { 
	                System.out.println(i); 
	            } 
	        } 
	        System.out.println("Closing connection"); 
	
	        // close connection 
	        socket.close(); 
	        in.close(); 
	    } 
	    catch(IOException i) 
	    { 
	        System.out.println(i); 
	    }
    }
    
    
	public static void main(String[] args) {
		WebServerMain server = new WebServerMain(5000);
		Client client = new Client("127.0.0.1", 5000);
		client.toString();
	}
}
