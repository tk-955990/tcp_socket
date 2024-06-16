import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(4444)) {
            System.out.println("Server started. Waiting for a client...");

            try (Socket s = ss.accept()) {
                System.out.println("client connection!");
            } catch (IOException e) {
                System.err.println("Error accepting client connection: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}
