
package Try;


import java.awt.List;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * 1.ʹ��û��ע������û�����¼�ᱨ��                                                           ����ɣ�
 * 2.���Գɲ������ÿո���Ϊ�û���������                                                       ����ɣ�
 * 3.ע����޷��˻ص�¼����                                                                             ����ɣ�
 * 4.�޼��ر��淽����ͨ���û���������أ�                                                      
 * 5.�����з�������һ����ķ���                                                                      ����ɣ�
 * 6.ʹ�ûس������в���                                                                                    ����ɣ�
 * 7.�û�������                                                                                                   ����ɣ�
 * 8.������һ��ѡ��                                                                                            ����ɣ�
 */

public class Test {
	public static Window canvas;
	public static Scanner raf = null;
	public static HashMap<String, String> users = new HashMap<String, String>();
	public static void main(String[] args) {



		users.put("", "");
		loadDate();
		registration();
		System.exit(0);
	}


	//===============================================================�����½�============================================================
	private static void chapter1() {
		try {
			raf = new Scanner(new File("data\\1.txt"),"UTF-8");
			print(raf);
			Thread.sleep(1000);
		}catch (Exception e) {}
		canvas.A.setText("�ȴ���Ӧ");
		canvas.B.setText("����");
		String answer = canvas.message;
		while(answer==null) {
			stop();
			answer = canvas.message;
		}
		while(answer.equals("�ȴ���Ӧ")) {
			print("���Ի���û�з�Ӧ����");
			canvas.message = null;
			answer = canvas.message;			
			while(answer==null) {
				stop();
				answer = canvas.message;			
			}
		}
		if (answer.equals("����")) {
			try {
				raf = new Scanner(new File("data\\1.1.txt"),"UTF-8");
				print(raf);
				Thread.sleep(1000);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			canvas.A.setText("�𾪣����׼���ķ��˵���ŭɱ���죬���������Ե�Ť�����ǵ��µ���ɥ");
			canvas.B.setText("��������ִ����Ϯ����������");
			canvas.message = null;
			answer = canvas.message;			
			while(answer==null) {
				stop();
				answer = canvas.message;
			}
		}
		chapter2(answer);

	}

	private static void chapter2(String c) {

		try {
			if(c.equals("�𾪣����׼���ķ��˵���ŭɱ���죬���������Ե�Ť�����ǵ��µ���ɥ")) {
				raf = new Scanner(new File("data\\2.1.txt"),"UTF-8");
			}
			else if (c.equals("��������ִ����Ϯ����������")) {
				raf = new Scanner(new File("data\\2.2.txt"),"UTF-8");
			}
			
			print(raf);
			Thread.sleep(1000);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		canvas.message = null;
		try {
			raf = new Scanner(new File("data\\news.txt"),"UTF-8");
		}catch (Exception e) {
		}
		Choose s = new Choose(raf,canvas,"���Ÿ�");
		s.setVisible(true);
		try {
			raf = new Scanner(new File("data\\2.3.txt"),"UTF-8");
			print(raf);
			Thread.sleep(1000);
		}catch (Exception e) {}
		canvas.A.setText("��绰�������˽⾯�����");
		canvas.B.setText("��绰�������˽��ֳ������");
		String answer = canvas.message;
		while(answer==null) {
			stop();
			answer = canvas.message;
		}
	}
	//============================================================����/��ȡ/��¼=============================================================

	private static void registration() {
		login log = new login(canvas);
		log.setVisible(true);
		String o = log.message;
		while(o==null) {
			log = new login(canvas);
			log.setVisible(true);
			o = log.message;
		}
		if(o.equals("���û�ע��")) {
			Choose login = new Choose(canvas, o);
			login.setVisible(true);
			while(login.message==null) {
				login = new Choose(canvas, o);
				login.setVisible(true);
			}
			if(login.message.equals("����")) registration();
			else {
				PrintWriter out = null;
				Scanner in = null;
				try {
					String s = "";
					in = new Scanner(new File("data\\registration.txt"),"UTF-8");
					while(in.hasNextLine()) {
						s=s+in.nextLine()+"\n";
					}
					out = new PrintWriter(new File("data\\registration.txt"),"UTF-8");
					out.println(s);
					if(login.user.getText().contains(" ")||
							new String(login.password.getPassword()).contains(" ")) {
						JOptionPane.showMessageDialog(null, "�ף��û����������в��ܰ����ո���"); 
						out.close();in.close();
						registration();
					}
					else if(users.containsKey(login.user.getText())) {
						JOptionPane.showMessageDialog(null, "�û�������"); 
						out.close();in.close();
						registration();
					}
					else {
						users.put(login.user.getText(), new String(login.password.getPassword()));
						out.println(login.user.getText()+"\t"+new String(login.password.getPassword()));
					}
				} catch (Exception e) {

				}finally {
					try {out.close();in.close();} catch (Exception e2) {}
				}
				registration();
			}

		}
		else if (o.equals("��¼")){
			Choose login = new Choose(canvas, o);
			login.setVisible(true);
			while(login.message==null) {
				login = new Choose(canvas, o);
				login.setVisible(true);
			}
			if(login.message.equals("����")) registration();
			else {
				String user = login.user.getText();
				String password = new String(login.password.getPassword());
				if(!users.containsKey(user)) {
					JOptionPane.showMessageDialog(null, "û�д��û�"); 
					registration();
				}
				
				else {
					String p = users.get(user);
					if(!p.equals(password)) {
						JOptionPane.showMessageDialog(null, "�����������,������������Ϸ"); 
						registration();
					}
					else start();
				}
			}
		}
	}




	//===============================================================������================================================================
	private static void start() {
		canvas = new Window();
		overORstart();
		chapter1();
	}

	private static void loadDate() {
		Scanner read = null;
		try {
			read = new Scanner(new File("data\\registration.txt"),"UTF-8");
			while(read.hasNextLine()) {
				String s = read.nextLine();
				String[] part = s.split("\t");
				if(part.length==2)users.put(part[0], part[1]);
			}
		} catch (Exception e) {

		}finally {
			try {read.close();} catch (Exception e2) {}
		}

	}

	private static void overORstart() {
		String o=dialogChoose("��ʼ��Ϸ","������Ϸ");
		while(o==null) o=dialogChoose("��ʼ��Ϸ","������Ϸ");
		if(canvas.area.getText().contains("�ڴ��������´μ��棬�ݰ�~~~")) {
			canvas.area.append("��Ϸ����10����Զ��ر�");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			canvas.dispatchEvent(new WindowEvent(canvas, WindowEvent.WINDOW_CLOSING));
		}	
	}

	//	private static String restart() {
	//		String o=dialogChoose("���¿�ʼ", "������Ϸ");
	//		while(o==null) o=dialogChoose("���¿�ʼ", "������Ϸ");+++
	//		if(canvas.area.getText().contains("�ڴ��������´μ��棬�ݰ�~~~")) {
	//			canvas.area.append("ϵͳ����10����Զ��ر�");
	//			try {
	//				Thread.sleep(10000);
	//			} catch (InterruptedException e1) {
	//				e1.printStackTrace();
	//			}
	//			canvas.dispatchEvent(new WindowEvent(canvas, WindowEvent.WINDOW_CLOSING));
	//		}else if (o.equals("���¿�ʼ")) {
	//			canvas.area.setText("");
	//			chapter1();
	//		}
	//		return o;
	//	}

	private static void print(Scanner in) {
		while (in.hasNextLine()) {
			String s = in.nextLine();
			String[] parts = s.split("");
			for (String t : parts) {
				canvas.area.append(t);
				stop();
			}
			
			canvas.area.append("\n");
			for (int i = 0; i < 5; i++) {
				stop();
			}
			canvas.scrollBar.setValue(canvas.scrollBar.getMaximum());
		}
	}

	private static void print(String str) {
		String[] parts = str.split("");
		for (String t : parts) {
			canvas.area.append(t);
			stop();
		}
		
		canvas.area.append("\n");
		for (int i = 0; i < 5; i++) {
			stop();
		}
		canvas.scrollBar.setValue(canvas.scrollBar.getMaximum());

	}


	private static void stop() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	private static String dialogChoose(String a, String b) {
		Choose d = new Choose(canvas,a,b);
		d.setVisible(true);
		return d.message;
	}
}
