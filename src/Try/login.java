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

		super(frame,"��ӭ����Lifeline",true);
		/*
		 * ����1�� ���ര�ڶ���
		 * ����2�� �Ի������
		 * ����3�� �Ƿ��������ര��
		 */
		this.frame = frame;
		setLayout(new GridLayout(2,1,5,5));
		setResizable(false);//�����Ƿ���Ըı��С
		setLayout(null);
		setBounds(getScreenWidth()/2-windowWidth/2,getScreenHeight()/2-windowHeight/2, windowWidth, windowHeight);
		
		Container c = getContentPane();
		JButton A = new JButton("��¼");
		A.addActionListener(this);
		JButton B = new JButton("���û�ע��");
		B.addActionListener(this);
		JButton C = new JButton("�˳���Ϸ");
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
		if(message.equals("�˳���Ϸ")) System.exit(0);
		System.out.println(message);
		
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

	}
}
