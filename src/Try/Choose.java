package Try;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.*;

public class Choose extends JDialog implements ActionListener{  //对话框
	Window frame;
	String message;
	JTextField user;
	JPasswordField password;
	JButton OK;
	String title;
	private int windowWidth = 400;
    private int windowHeight = 300;
    private int screenWidth;
    private int screenHeight;
    
	public Choose(Scanner raf,Window frame,String title) {
		super(frame,title,true);
        setBounds(getScreenWidth()/2-windowWidth/2,getScreenHeight()/2-windowHeight/2, windowWidth, windowHeight);
		setResizable(false);//窗口是否可以改变大小
		setLayout(null);

		Container c = getContentPane();

		JTextArea a = new JTextArea();
		while(raf.hasNextLine()) {
			String s = raf.nextLine();
			a.append(s+"\n");
			System.out.println(s);
		}
		a.setBounds(0, 0, 400, 230);
		a.setFont(new Font("等线",Font.BOLD,18));
		
		JButton OK = new JButton("确认");
		OK.setBounds(160, 230, 65, 35);
		OK.addActionListener(this);
		setLocationRelativeTo(null);
		c.add(a);
		c.add(OK);
	}

	public Choose(Window frame,String title) {//

		super(frame,title,true);
		this.frame = frame;
		setBounds(1050, 500, 400, 300);
		setResizable(false);//窗口是否可以改变大小
		setLayout(null);
		this.title = title;
		Container c = getContentPane();

		JLabel userJLabel = new JLabel("用户名");
		user = new JTextField();
		userJLabel.setBounds(20 ,30, 100, 50);
		user.setBounds(70, 30, 270, 50);
		user.addActionListener(this);


		JLabel passwordJLabel = new JLabel(" 密码   ");
		password = new JPasswordField();
		passwordJLabel.setBounds(20, 100, 100, 50);
		password.setBounds(70, 100, 270, 50);
		password.setEchoChar('*');
		password.addActionListener(this);

		JButton OK = new JButton("确认");
		OK.setBounds(100, 170, 80, 45);
		OK.addActionListener(this);

		JButton back = new JButton("返回");
		back.setBounds(220, 170, 80, 45);
		back.addActionListener(this);
		setLocationRelativeTo(null);


		c.add(user);
		c.add(password);
		c.add(userJLabel);
		c.add(passwordJLabel);
		c.add(OK);
		c.add(back);
	}


	public Choose(Window frame,String a, String b) {

		super(frame,"请选择",true);
		/*
		 * 参数1： 父类窗口对象
		 * 参数2： 对话框标题
		 * 参数3： 是否阻塞父类窗体
		 */
		this.frame = frame;
		setLayout(new GridLayout(2,1,5,5));
		setResizable(false);//窗口是否可以改变大小


		Container c = getContentPane();
		JButton A = new JButton(a);
		A.addActionListener(this);
		JButton B = new JButton(b);
		B.addActionListener(this);

		setBounds(1050, 500, 400, 300);

		setLocationRelativeTo(null);

		c.add(A);
		c.add(B);
	}


	public int getScreenWidth(){
        screenWidth = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        return screenWidth;
    }

    public int getScreenHeight(){
        screenHeight = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height; 
        return screenHeight;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		System.out.println(s);
		if(s.equals("结束游戏")) {
			frame.area.append("期待与您的下次见面，拜拜~~~\n");
		}
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		stop();
		message = s;//当敲击回车时message为密码。
	}
	private static void stop() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}