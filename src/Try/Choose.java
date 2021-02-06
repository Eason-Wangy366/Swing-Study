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

public class Choose extends JDialog implements ActionListener{  //�Ի���
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
		setResizable(false);//�����Ƿ���Ըı��С
		setLayout(null);

		Container c = getContentPane();

		JTextArea a = new JTextArea();
		while(raf.hasNextLine()) {
			String s = raf.nextLine();
			a.append(s+"\n");
			System.out.println(s);
		}
		a.setBounds(0, 0, 400, 230);
		a.setFont(new Font("����",Font.BOLD,18));
		
		JButton OK = new JButton("ȷ��");
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
		setResizable(false);//�����Ƿ���Ըı��С
		setLayout(null);
		this.title = title;
		Container c = getContentPane();

		JLabel userJLabel = new JLabel("�û���");
		user = new JTextField();
		userJLabel.setBounds(20 ,30, 100, 50);
		user.setBounds(70, 30, 270, 50);
		user.addActionListener(this);


		JLabel passwordJLabel = new JLabel(" ����   ");
		password = new JPasswordField();
		passwordJLabel.setBounds(20, 100, 100, 50);
		password.setBounds(70, 100, 270, 50);
		password.setEchoChar('*');
		password.addActionListener(this);

		JButton OK = new JButton("ȷ��");
		OK.setBounds(100, 170, 80, 45);
		OK.addActionListener(this);

		JButton back = new JButton("����");
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

		super(frame,"��ѡ��",true);
		/*
		 * ����1�� ���ര�ڶ���
		 * ����2�� �Ի������
		 * ����3�� �Ƿ��������ര��
		 */
		this.frame = frame;
		setLayout(new GridLayout(2,1,5,5));
		setResizable(false);//�����Ƿ���Ըı��С


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
		if(s.equals("������Ϸ")) {
			frame.area.append("�ڴ��������´μ��棬�ݰ�~~~\n");
		}
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		stop();
		message = s;//���û��س�ʱmessageΪ���롣
	}
	private static void stop() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}