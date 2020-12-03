package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sinosoft.speech.swing.Browser;

import info.info;
//import javafx.scene.text.Font;

public class Client {
	JTextArea showM;
	JTextField edit;
	private Socket socket;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private static info user = new info();
	private static info getInfo = new info();
	private javax.swing.JFrame frame;

	/**
	 * ���캯������ʼ��
	 */
	public Client() {
		try {
			/*
			 * initialize����
			 */
//			socket = new Socket("127.0.0.1", 8883);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//hexo
	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO exception
		}

		EventQueue.invokeLater(new Runnable() {// ���������ڵײ�ͬλ����������ε�Ӧ�ó�������¼�������С�

			public void run() {

				try {
					Client window = new Client();
					window.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * start����
	 */
	public void showFrame() {

		frame = new javax.swing.JFrame();
		frame.setResizable(true);

		frame.setTitle("ͼ�����ϵͳ��¼����");

		frame.setSize(360, 450);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(2);

		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		frame.setLayout(fl);

		javax.swing.ImageIcon icon = new javax.swing.ImageIcon("resource/1.png");
		// ��ӱ�ǩ
		javax.swing.JLabel jla = new javax.swing.JLabel(icon);
		frame.add(jla);

		javax.swing.JTextField jta_name1 = new javax.swing.JTextField("�˺�");
		jta_name1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jta_name1.getText().isEmpty()) {
					jta_name1.setText("�˺�");
				}
			}
		});

		java.awt.Dimension d1 = new java.awt.Dimension(200, 30);
		jta_name1.setPreferredSize(d1);

		frame.add(jta_name1);

		javax.swing.JTextField jta_name2 = new javax.swing.JTextField("����");
		jta_name2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jta_name2.getText().isEmpty()) {
					jta_name2.setText("�˺�");
				}
			}
		});
		java.awt.Dimension d3 = new java.awt.Dimension(200, 30);
		jta_name2.setPreferredSize(d3);
		frame.add(jta_name2);

		javax.swing.JButton bu_register = new javax.swing.JButton("��ͨ�û���¼");
		java.awt.Dimension d2 = new java.awt.Dimension(100, 30);
		bu_register.setPreferredSize(d2);
		frame.add(bu_register);

		javax.swing.JButton bu_login = new javax.swing.JButton("ת������Ա��¼");
		java.awt.Dimension d5 = new java.awt.Dimension(100, 30);
		bu_login.setPreferredSize(d5);
		frame.add(bu_login);

		frame.setVisible(true);

		ButtonListener bl = new ButtonListener();

		bu_login.addActionListener(bl);

		bl.setJt1(jta_name1);

		bl.setJt2(jta_name2);

		bl.setJt3(frame);
	}

	class ButtonListener implements ActionListener {

		private JFrame jf;
		private JTextField jt1;
		private JTextField jt2;

		public void setJt3(JFrame jframe) {
			jf = jframe;
		}

		public void setJt1(JTextField jtext) {
			jt1 = jtext;
		}

		public void setJt2(JTextField jtext) {
			jt2 = jtext;
		}

		public void actionPerformed(ActionEvent e) {
			String name1 = jt1.getText();// ������ʺ�
			String name2 = jt2.getText();// ���������
			user.name = name1;
			user.password = name2;
			try {
//				os = new ObjectOutputStream(socket.getOutputStream());
//				os.writeObject(user);
//				os.flush();
				Browser.openForm("http://127.0.0.1:8081/", "hello swing");
				jf.dispose();
				jf = null;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	class Welcome {
		public void show() {
			JFrame f = new JFrame("ChenChat");
			f.setSize(600, 900);
			f.setLocationRelativeTo(null);
			Icon send = new ImageIcon("resource/send2.png");
			JButton sendM = new JButton("", send);
			sendM.setPreferredSize(new Dimension(50, 50));
			sendM.setSize(1, 5);
			showM = new JTextArea(35, 70);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(1, 5, 20, 60);
			f.add(scrollPane);
			scrollPane.setViewportView(showM);
			showM.setEditable(false);
//			 showM.setFont(new Font("����",32));
			edit = new JTextField(48);
			JMenuBar mb = new JMenuBar();
			JMenu win = new JMenu("chatting");
			JMenu file = new JMenu("file");
			JPanel bottom = new JPanel();
			bottom.add(edit);
			bottom.add(sendM);
			f.add(bottom, BorderLayout.SOUTH);
			JPanel area = new JPanel();
			area.add(showM);
			// area.add(bottom,BorderLayout.SOUTH);
			f.add(area);
			mb.add(win);
			mb.add(file);
			f.setJMenuBar(mb);
			f.setVisible(true);
			SendListener b2 = new SendListener();
			sendM.addActionListener(b2);

		}
	}

	class SendListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String messageString = edit.getText();

			// ������Ϣ

			if (edit.getText().isEmpty() || edit.getText().equals("")) {
				JOptionPane.showConfirmDialog(null, "���ܷ��Ϳ���Ϣ", "��ʾ", JOptionPane.YES_NO_OPTION);
			} else {
				messageString.trim();
				System.out.println(messageString);
				// pw.println(messageString);// ��������
				// inputMessage.setText("");
				user.msg = messageString;
				edit.setText("");
				try {
					os = new ObjectOutputStream(socket.getOutputStream());
					os.writeObject(user);
					os.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	public void start() {

		try {

			showFrame();

		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * ����������ȡ����������Ϣ���߳�
		 *
		 */
//		GetServerMessageHandler handler = new GetServerMessageHandler(socket);// ʵ��runable�̳н��
//		Thread t = new Thread(handler);
//		t.start();

	}

	class GetServerMessageHandler implements Runnable {
		private Socket client;

		GetServerMessageHandler(Socket s) {
			this.client = s;
		}

		public void run() {
			try {
				// info user = new info();
				is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				getInfo = (info) is.readObject();
				if (getInfo.msg.equals("fail!!!")) {
					System.out.println("��¼ʧ��");
					JOptionPane.showConfirmDialog(null, "��¼ʧ�� �û������������", "��ʾ", JOptionPane.YES_NO_OPTION);
				} else {
					// ���������
					JOptionPane.showConfirmDialog(null, "��¼�ɹ���������", "��ʾ", JOptionPane.YES_NO_OPTION);
					Browser.openForm("http://127.0.0.1:8081/", "hello swing");

					// �����ȡ��Ϣѭ��
					while (getInfo.state != 404) {

						is = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
						getInfo = (info) is.readObject();
						// user�����ͻ��˷��͵���Ϣ name password msg state��Щ
						System.out.println(getInfo.msg);
						showM.append(getInfo.name + "  SAY:" + "\n" + getInfo.msg + "\n"
								+ "***********************************************************" + "\n");
						// ����Ҫ�������������ѻ�ȡ����Ϣ���������
					}
				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

}
