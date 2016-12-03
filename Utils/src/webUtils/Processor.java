package webUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Processor extends Thread {
	private PrintStream out;
	private InputStream input;
	
	public static final String root="D:/CC";
	
	public Processor(Socket socket){
		try {
			input = socket.getInputStream();
			out = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 创建线程
	 */
	public void run(){
		try {
			String fileName =parse(input);
			readFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 读取文件
	 * 解析请求头
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public String parse(InputStream input) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String inputContent = in.readLine();
		if(inputContent == null||inputContent.length()==0){
			return null;
		}
		String request[]= inputContent.split(" ");
		if(request.length!=3){
			sendErro(400, "文件错误");
			return null;
		}
		String method = request[0];
		String fileName = request[1];
		String httpVersion = request[2];
		System.out.println("Method" + method +"fileName" +fileName+
		"httpVersion "+ httpVersion);
		return fileName;
	}
	/**
	 * 读取文判断文件是否存在
	 * @param fileName
	 * @throws IOException
	 */
	public void readFile(String fileName) throws IOException{
		File file = new File(Processor.root+fileName);
		if(!file.exists()){
			sendErro(404, "文件不存在");
			return;
		}
		InputStream in = new FileInputStream(file);
		byte content[] = new byte[(int)file.length()];
		in.read(content);
		out.println("HTPP/1.0 200 sendFile");
		out.print("Content-length:" + content.length);
		out.println();
		out.write(content);
		out.flush();
		out.close();
		in.close();
	}
	/**
	 * 发送错误信息
	 * @param errNum
	 * @param errMsg
	 */
	public void  sendErro(int errNum,String errMsg){
		out.println("HTTP/1.0"+ errNum +" " +errMsg);
		out.println("Content-type:text/html");
		out.println();
		out.println("<html>");
		out.println("<meta content='text/html;charset=gbk' http-equiv='Content-Type'>");
		out.println("<head><title>Erro"+errNum +"----" + errMsg+"</title></head>");
		out.println("<h1>"+errNum+""+errMsg+"</h1>");
		out.println("</html>");
		out.println();
		out.flush();
		out.close();
		System.out.println(errNum + ",,,," + errMsg);
	}
}
