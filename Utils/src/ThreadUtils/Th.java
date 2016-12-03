package ThreadUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Th {
	public static void main(String[] args) {
		int threadPoolSize = Runtime.getRuntime().availableProcessors() * 2;
		class ConnectionHandler implements Runnable {
			InputStream in;
			OutputStream out;

			public ConnectionHandler(Socket socket) {
				try {
					in = socket.getInputStream();
					out = socket.getOutputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void run() {
				try {
					int n = 0;
					byte[] buffer = new byte[1024];
					while ((n = in.read(buffer)) != -1) {
						out.write(buffer, 0, n);
						out.flush();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		try {
			System.out.println(threadPoolSize);
			ServerSocket server = new ServerSocket(8080);
			ExecutorService ex = Executors.newFixedThreadPool(threadPoolSize);
			while (true) {
				Socket socket = server.accept();
				ex.execute(new ConnectionHandler(socket));
			}
//			while (true) {
//				Socket socket = server.accept();
//				Thread h = new Thread(new ConnectionHandler(socket));
//				h.start();
//			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
