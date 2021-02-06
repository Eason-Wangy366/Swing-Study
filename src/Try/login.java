package Try;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;

public class login extends JDialog implements ActionListener{

	Window frame;
	String message;
	private int windowWidth = 400;
    private int windowHeight = 300;
    private int screenWidth;
    private int screenHeight;
    
	public login(Window frame) {

		super(frame,"欢迎来到Lifeline",true);
		/*
		 * 参数1： 父类窗口对象
		 * 参数2： 对话框标题
		 * 参数3： 是否阻塞父类窗体
		 */
		this.frame = frame;
		setLayout(new GridLayout(2,1,5,5));
		setResizable(false);//窗口是否可以改变大小
		setLayout(null);
		setBounds(getScreenWidth()/2-windowWidth/2,getScreenHeight()/2-windowHeight/2, windowWidth, windowHeight);
		
		Container c = getContentPane();
		JButton A = new JButton("登录");
		A.addActionListener(this);
		JButton B = new JButton("新用户注册");
		B.addActionListener(this);
		JButton C = new JButton("退出游戏");
		C.addActionListener(this);
		
		A.setBounds(20, 100, 100, 50);
		B.setBounds(148, 100, 100, 50);
		C.setBounds(276, 100, 100, 50);



		c.add(A);
		c.add(B);
		c.add(C);
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
		message = e.getActionCommand();
		if(message.equals("退出游戏")) System.exit(0);
		System.out.println(message);
		
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

	}
}
