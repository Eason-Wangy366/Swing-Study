
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
 * 1.使用没有注册过的用户名登录会报错                                                           （完成）
 * 2.调试成不允许用空格作为用户名和密码                                                       （完成）
 * 3.注册后无法退回登录界面                                                                             （完成）
 * 4.无加载保存方法（通过用户名保存加载）                                                      
 * 5.尽量研发返回上一界面的方法                                                                      （完成）
 * 6.使用回车键进行操作                                                                                    （完成）
 * 7.用户名查重                                                                                                   （完成）
 * 8.返回上一个选项                                                                                            （完成）
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


	//===============================================================故事章节============================================================
	private static void chapter1() {
		try {
			raf = new Scanner(new File("data\\1.txt"),"UTF-8");
			print(raf);
			Thread.sleep(1000);
		}catch (Exception e) {}
		canvas.A.setText("等待响应");
		canvas.B.setText("重启");
		String answer = canvas.message;
		while(answer==null) {
			stop();
			answer = canvas.message;
		}
		while(answer.equals("等待响应")) {
			print("电脑还是没有反应……");
			canvas.message = null;
			answer = canvas.message;			
			while(answer==null) {
				stop();
				answer = canvas.message;			
			}
		}
		if (answer.equals("重启")) {
			try {
				raf = new Scanner(new File("data\\1.1.txt"),"UTF-8");
				print(raf);
				Thread.sleep(1000);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			canvas.A.setText("震惊！穷凶极恶的犯人当街怒杀警察，到底是人性的扭曲还是道德的沦丧");
			canvas.B.setText("两名警官执法遇袭，凶手在逃");
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
			if(c.equals("震惊！穷凶极恶的犯人当街怒杀警察，到底是人性的扭曲还是道德的沦丧")) {
				raf = new Scanner(new File("data\\2.1.txt"),"UTF-8");
			}
			else if (c.equals("两名警官执法遇袭，凶手在逃")) {
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
		Choose s = new Choose(raf,canvas,"新闻稿");
		s.setVisible(true);
		try {
			raf = new Scanner(new File("data\\2.3.txt"),"UTF-8");
			print(raf);
			Thread.sleep(1000);
		}catch (Exception e) {}
		canvas.A.setText("打电话给阿珍了解警察情况");
		canvas.B.setText("打电话给狗蛋了解现场的情况");
		String answer = canvas.message;
		while(answer==null) {
			stop();
			answer = canvas.message;
		}
	}
	//============================================================保存/读取/登录=============================================================

	private static void registration() {
		login log = new login(canvas);
		log.setVisible(true);
		String o = log.message;
		while(o==null) {
			log = new login(canvas);
			log.setVisible(true);
			o = log.message;
		}
		if(o.equals("新用户注册")) {
			Choose login = new Choose(canvas, o);
			login.setVisible(true);
			while(login.message==null) {
				login = new Choose(canvas, o);
				login.setVisible(true);
			}
			if(login.message.equals("返回")) registration();
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
						JOptionPane.showMessageDialog(null, "亲，用户名和密码中不能包括空格呦"); 
						out.close();in.close();
						registration();
					}
					else if(users.containsKey(login.user.getText())) {
						JOptionPane.showMessageDialog(null, "用户名存在"); 
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
		else if (o.equals("登录")){
			Choose login = new Choose(canvas, o);
			login.setVisible(true);
			while(login.message==null) {
				login = new Choose(canvas, o);
				login.setVisible(true);
			}
			if(login.message.equals("返回")) registration();
			else {
				String user = login.user.getText();
				String password = new String(login.password.getPassword());
				if(!users.containsKey(user)) {
					JOptionPane.showMessageDialog(null, "没有此用户"); 
					registration();
				}
				
				else {
					String p = users.get(user);
					if(!p.equals(password)) {
						JOptionPane.showMessageDialog(null, "密码输入错误,请重新载入游戏"); 
						registration();
					}
					else start();
				}
			}
		}
	}




	//===============================================================工具栏================================================================
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
		String o=dialogChoose("开始游戏","结束游戏");
		while(o==null) o=dialogChoose("开始游戏","结束游戏");
		if(canvas.area.getText().contains("期待与您的下次见面，拜拜~~~")) {
			canvas.area.append("游戏将在10秒后自动关闭");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			canvas.dispatchEvent(new WindowEvent(canvas, WindowEvent.WINDOW_CLOSING));
		}	
	}

	//	private static String restart() {
	//		String o=dialogChoose("重新开始", "结束游戏");
	//		while(o==null) o=dialogChoose("重新开始", "结束游戏");+++
	//		if(canvas.area.getText().contains("期待与您的下次见面，拜拜~~~")) {
	//			canvas.area.append("系统将在10秒后自动关闭");
	//			try {
	//				Thread.sleep(10000);
	//			} catch (InterruptedException e1) {
	//				e1.printStackTrace();
	//			}
	//			canvas.dispatchEvent(new WindowEvent(canvas, WindowEvent.WINDOW_CLOSING));
	//		}else if (o.equals("重新开始")) {
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
