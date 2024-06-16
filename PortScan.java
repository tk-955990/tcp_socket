import java.io.IOException;
import java.net.*;

public class PortScan {
	public static void main(String[] args) {
		// プログラムの実行開始時刻を記録
		long startTime = System.currentTimeMillis();

		try {
			// コマンドライン引数からホスト名を取得し、そのホストのInetAddressオブジェクトを取得
			InetAddress address = InetAddress.getByName(args[0]);

			// ホスト名とIPアドレスを表示
			System.out.println((args[0] + ":"));
			System.out.println("\t" + "HostName: " + address.getHostName());
			System.out.println("\t" + "HostAddress: " + address.getHostAddress());

			// スキャンするポートの範囲を指定（1から9999まで）
			int[] ports = new int[10000];
			for (int i = 0; i < ports.length; i++) {
				ports[i] = i + 1;
			}

			// 各ポートに対して接続を試みる
			for (int i = 0; i < ports.length; i++) {
				int port = ports[i];

				// Socketを利用して指定されたホストの指定されたポートに接続を試みる
				try (Socket socket = new Socket()) {
					// socket.connectでタイムアウト1000ミリ秒で接続を試みる
					socket.connect(new InetSocketAddress(address.getHostAddress(), port), 1000);
					// 接続成功した場合、ポート番号と「open」というメッセージを表示
					System.out.println(port + " :open");
				} catch (IOException e) {
					// 接続に失敗した場合の例外処理はここに記述する
				}
			}
		} catch (UnknownHostException e) {
			// 指定されたホストが見つからなかった場合の例外処理
			System.out.println("Unknown host: " + args[0]);
		}

		// プログラムの実行終了時刻を記録
		long endTime = System.currentTimeMillis();
		// 処理時間を計算して表示
		long elapsedTime = endTime - startTime;
		long minutes = (elapsedTime / 1000) / 60;
		long seconds = (elapsedTime / 1000) % 60;
		System.out.println("処理時間: " + minutes + "分" + seconds + "秒");
	}
}
