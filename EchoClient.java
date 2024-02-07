import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) {
        try {
            // Establish a socket connection to the echo server on localhost (127.0.0.1) at port 6666
            Socket s = new Socket("127.0.0.1", 6666);

            // Set up input and output streams for communication with the server
            BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter w = new PrintWriter(s.getOutputStream(), true);

            // Set up a buffered reader to read input from the console
            BufferedReader con = new BufferedReader(new InputStreamReader(System.in));

            String line;

            do {
                // Read lines from the server and print them to the console
                line = r.readLine();
                if (line != null)
                    System.out.println(line);

                // Read a line of input from the console and send it to the server
                line = con.readLine();
                w.println(line);

            } while (!line.trim().equals("Ram Ram"));

            // Close the socket connection when the loop exits
            s.close();
        } catch (Exception err) {
            // Print any exception that occurs during client operation
            System.out.println(err);
        }
    }
}
