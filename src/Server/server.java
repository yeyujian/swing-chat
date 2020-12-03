package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class server {


	public static void main(String[] args) throws IOException {

		server cs=new server();

		cs.start(8883);
	}
 
	private void start(int port) throws IOException {

		ServerSocket server=new ServerSocket(port);

		System.out.println("服务器创建成功！！！！！！ 端口号:"+port);
		chatPool exec = new chatPool(50,10000);
		Socket socket=null;
		while(true) {

			socket=server.accept();
			System.out.println("有客户端连接："+socket.getRemoteSocketAddress().toString());
			exec.execute(new serverThread(socket));
		}
		
		
	}

}
