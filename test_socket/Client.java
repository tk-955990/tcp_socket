import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 4444)) {
            System.out.println("Connected to the server!");
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}
