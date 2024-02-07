import java.io.*;
import java.net.*;

public class EchoServer {

    // Constructor to initialize the server socket
    public EchoServer(int portnum) {
        try {
            server = new ServerSocket(portnum);
        } catch (Exception err) {
            // Print any exception that occurs during server socket creation
            System.out.println(err);
        }
    }

    // Method to start the echo server
    public void server() {
        try {
            while (true) {
                // Accept incoming client connections
                Socket client = server.accept();

                // Set up input and output streams for the client
                BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter w = new PrintWriter(client.getOutputStream(), true);

                // Send a welcome message to the client
                w.println("Welcome To The JAVA Echoserver. Type 'Ram Ram ' to close.");

                String line;
                do {
                    // Read lines from the client and echo them back
                    line = r.readLine();
                    if (line != null)
                        w.println("Got:" + line);
                    // Print received lines to the server console
                    System.out.println(line);
                } while (line != null && !line.trim().equals("Ram Ram"));

                // Close the connection with the client
                client.close();
            }
        } catch (Exception err) {
            // Print any exception that occurs during server operation
            System.err.println(err);
        }
    }

    // Main method to instantiate and start the echo server
    public static void main(String[] args) {
        EchoServer s = new EchoServer(6666);
        s.server();
    }

    // Private field to store the server socket
    private ServerSocket server;
}
