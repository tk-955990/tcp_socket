import java.io.*;
import java.net.*;

public class TcpClient {

    public static void main(String[] args) {

        String serverAddress = "10.18.100.147"; // サーバーのIPアドレス
        int port = 4444;                      // サーバーのポート番号

        try (Socket socket = new Socket(serverAddress, port)) {

            // サーバーに接続
            System.out.println("Connected to the server");

            // 出力ストリームを取得してデータを送信
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello Server!!");

            // 入力ストリームを取得してサーバーからのデータを受信
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String response = reader.readLine();
            System.out.println("Received " + response + "from the server");

        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
