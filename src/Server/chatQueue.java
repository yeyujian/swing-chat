package Server;

import java.io.IOException;
import java.util.ArrayList;

import info.info;

import java.io.IOException;

public class chatQueue {

	private static ArrayList<serverThread> stList = new ArrayList<serverThread>();

	private chatQueue() {
	}

	public static void addClient(serverThread st) throws IOException, Exception {
		stList.add(st);
		//castMsg(st.getInfo());
	}

	// ������Ϣ�������û�
	public static void castMsg(info user) throws IOException, Exception {
		//System.out.println("�����Ϣ��"+user.msg);
		for (int i = 0; i < stList.size(); i++) {
			serverThread st = stList.get(i);
			if(st==null) {
				stList.remove(i);
			}
			else {
				st.sendMsg(user);// ����Ϣ��ÿһ���ͻ���
			}
			
		}
	}

}
