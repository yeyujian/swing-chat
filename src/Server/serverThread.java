package Server;

import java.io.*;

import java.net.Socket;

import Dao.user;
import info.info;





public class serverThread implements Runnable {

	
	
	private Socket client;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private static user userDao=new user();
	private info someone;
	public serverThread(Socket client) {
		this.client=client;
	}
	@Override
	public void run() {
		
		try {
			process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public info getInfo() {
		return this.someone;
	}
	
	private boolean login() throws IOException,Exception{
		
		if(userDao.query(someone.name, someone.password)) {
			return true;
		}
		else	return false;
	}
	
	private boolean changePass(String msg) throws IOException,Exception{
		
		if(userDao.query(someone.name, someone.password)) {
			return true;
		}
		else	return false;
	}
	
	private void getMsg()throws IOException, Exception{
		is = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
		this.someone=(info)is.readObject();
		//ins.close();
	}
	
	private void process() throws IOException, Exception{
		
		//in=new ObjectInputStream(client.getInputStream());
		//out=new ObjectOutputStream(client.getOutputStream());
		
		
		getMsg();
		System.out.println("����Ϣ�������˰���������");
		if(!login()) {
			this.someone.msg="fail!!!";
			System.out.println("��¼ʧ�ܣ���");
			this.sendMsg(this.someone);
			this.close();
			return;
		}
		this.someone.msg="success!";
		this.someone.state=200;
		//this.sendMsg(this.someone);
		chatQueue.addClient(this);//��֤�ɹ������û����Ӽ������
		while(this.someone.state!=404) {
			//chatQueue.castMsg(this.someone);
			this.sendMsg(this.someone);
			//this.someone=(info)in.readObject();

			getMsg();//���������ݿ��ѯ����
		}
		this.close();

	}
	
	//�رյ�ǰ�ͻ���������������ӡ�
	public void close() throws IOException {
		client.close();
	}
	
	public  void  sendMsg(info one) throws IOException {
		os = new ObjectOutputStream(client.getOutputStream());
		//out.write(msg.getBytes());
		//System.out.println("all of  it !!");
		//System.out.printf("from%s  msg:%s\n",one.name,one.msg);
		os.writeObject(one);
		os.flush();
		//objectOutput.close();
	}

}
