package ThreadUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * ���bugtwo����������
 * 
 * @author JossC
 *
 */
public class BugTwoSceeress {
	private InputStream in;
	private OutputStream out;
	private ArrayList<ProgressListener> list;
	private int total;

	public BugTwoSceeress(URL url, String outFilename) {
		try {
			in = url.openConnection().getInputStream();
			out = url.openConnection().getOutputStream();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public synchronized void addListenter(ProgressListener listener) {
		list.add(listener);
	}

	public synchronized void removeListenter(ProgressListener listener) {
		list.remove(listener);
	}

	@SuppressWarnings("unchecked")
	public synchronized void updateProgress(int n) {
		ArrayList<ProgressListener> lists;
		synchronized (this) {
			//����(ArrayList<ProgressListener>) ��������
			lists = (ArrayList<ProgressListener>) list.clone();
		}
		//�Ը��Ƴ����ĸ������б���
		for (ProgressListener lr : lists) {
			lr.onProgress(n);
		}
	}

	public void run() {
		int n = 1;
		byte[] buffer = new byte[1024];
		try {
			while ((n = in.read(buffer)) != -1) {
				out.write(buffer, 0, n);
				total += n;
				updateProgress(total);
			}
			out.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
