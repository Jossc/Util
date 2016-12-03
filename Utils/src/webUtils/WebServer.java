package webUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {
	public static final int port =9999;
	private ServerSocket serverSocket;
	int threadPoolSize = Runtime.getRuntime().availableProcessors() * 2;
	ExecutorService ex = Executors.newFixedThreadPool(threadPoolSize);
	/**
	 * 监听8080端口
	 * @param port
	 */
	public void startServer(int port){
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("web server start");
			while(true){
				Socket socket = serverSocket.accept();
				ex.execute(new Processor(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 正常启动
	 * @param args
	 */
	public static void main(String []args){
		WebServer w = new WebServer();
		if(args.length==1){
			w.startServer(Integer.parseInt(args[0]));
		}else{
			w.startServer(WebServer.port);
		}
	}
}
