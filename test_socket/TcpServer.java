import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) {
        int serverPort = 4444;

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {

            System.out.println("Server is listening...");

            while (true) {

                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getInetAddress() + " has been established.");

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String data = reader.readLine();
                System.out.println("Received from client: " + data);

                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(data.getBytes());
                outputStream.flush();

                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
