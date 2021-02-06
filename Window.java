package Try;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
public class Window extends JFrame implements ActionListener{
	String message;
	Container c;
	JTextArea area = new JTextArea();
	JButton A;
	JButton B;
	JScrollBar scrollBar;
	
    private JFrame frame;
    private int screenWidth;
    private int screenHeight;
    private int windowWidth = 1600;
    private int windowHeight = 900;
    private int Jpanewidth = 0;
    private int Jpaneheight = 0;
    private int titlewidth = 0;
    private int titleheight = 0;
    private int AButtonwidth = 0;
    private int AButtonheight = 0;
    private int BButtonwidth = 0;
    private int BButtonheight = 0;
    private int SJButtonwidth = 0;
    private int SJButtonheight = 0;
    private int LJButtonwidth = 0;
    private int LJButtonheight = 0;
    private JLabel title = new JLabel("       Lifeline");


    public Window() {
    	
        frame = new JFrame();
        frame.setLayout(null);

        //自动将窗口放到屏幕正中间
        frame.setBounds(getScreenWidth()/2-windowWidth/2,getScreenHeight()/2-windowHeight/2, windowWidth, windowHeight);
        
        frame.setTitle("Lifeline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        frame.setLayout(null);
		c = frame.getContentPane();

		
		
		JLabel title = title();
		

	    JScrollPane pane = Jpane();
		scrollBar= pane.getVerticalScrollBar();
		
		A = AButton();
		B = BButton();
		A.addActionListener(this);
		B.addActionListener(this);
		
		JButton save = SJButton("Save/保存");
		JButton load = LJButton("Lode/加载");
		save.addActionListener(this);
		load.addActionListener(this);
		
		c.add(title);
		c.add(pane);
		c.add(A);
		c.add(B);
		c.add(save);
		c.add(load);
		frame.setVisible(true);

		
        
        //监听窗口尺寸改变事件
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            System.out.println("尺寸改变了！");
            titlewidth = frame.getWidth()/16*6;
    	    titleheight = frame.getHeight()/9*1;
    		title.setFont(new Font("Comic Sans MS",Font.BOLD,frame.getWidth()/30));//改变字体
    		title.setBounds(frame.getWidth()/2-titlewidth/2, 0, titlewidth, titleheight);
            
    		Jpanewidth = frame.getWidth()/16*15;
    	    Jpaneheight = frame.getHeight()/9*5;
    		pane.setBounds(frame.getWidth()/2-Jpanewidth/2, frame.getHeight()/9*2, Jpanewidth, Jpaneheight);
    		area.setFont(new Font("等线",Font.BOLD,windowWidth/40));//改变字体

    		AButtonwidth = frame.getWidth()/32*11;
        	AButtonheight = frame.getHeight()/9;
        	A.setBounds(frame.getWidth()/16*2, frame.getHeight()/18*15, AButtonwidth, AButtonheight);
        	
        	BButtonwidth = frame.getWidth()/32*11;
        	BButtonheight = frame.getHeight()/9;
        	B.setBounds(frame.getWidth()/32*17, frame.getHeight()/18*15, BButtonwidth, BButtonheight);
        	
        	SJButtonwidth = frame.getWidth()/16;
    		SJButtonheight = frame.getHeight()/18;
    		save.setBounds(frame.getWidth()/16, frame.getHeight()/9, SJButtonwidth, SJButtonheight);
    		
    		LJButtonwidth = frame.getWidth()/16;
        	LJButtonheight = frame.getHeight()/18;
    		load.setBounds(frame.getWidth()/16*14, frame.getHeight()/9, LJButtonwidth, LJButtonheight);
    		
    		frame.setVisible(true);

        }
        });

    }

    private JButton LJButton(String string) {
    	LJButtonwidth = frame.getWidth()/16;
    	LJButtonheight = frame.getHeight()/18;
		JButton load = new JButton(string);
		load.setBounds(frame.getWidth()/16*14, frame.getHeight()/9, LJButtonwidth, LJButtonheight);
		return load;
	}

	private JButton SJButton(String string) {
		SJButtonwidth = frame.getWidth()/16;
		SJButtonheight = frame.getHeight()/18;
		JButton save = new JButton(string);
		save.setBounds(frame.getWidth()/16, frame.getHeight()/9, LJButtonwidth, LJButtonheight);
		return save;
	}

	private JButton BButton() {
    	BButtonwidth = frame.getWidth()/32*11;
    	BButtonheight = frame.getHeight()/9;
    	JButton x = new JButton();
    	x.setBounds(frame.getWidth()/32*17, frame.getHeight()/18*15, BButtonwidth, BButtonheight);
		
		return x;
	}

	private JButton AButton() {
		AButtonwidth = frame.getWidth()/32*11;
    	AButtonheight = frame.getHeight()/9;
		JButton x = new JButton();
    	x.setBounds(frame.getWidth()/16*2, frame.getHeight()/18*15, AButtonwidth, AButtonheight);
		
		return x;
	}

	private JScrollPane Jpane() {
		Jpanewidth = frame.getWidth()/16*15;
	    Jpaneheight = frame.getHeight()/9*5;
    	
		JScrollPane pane = new JScrollPane();
		pane.setBounds(frame.getWidth()/2-Jpanewidth/2, frame.getHeight()/9*2, Jpanewidth, Jpaneheight);
		pane.setViewportView(area);
		area.setEnabled(false);
		area.setFont(new Font("等线",Font.BOLD,frame.getWidth()/40));//改变字体
		return pane;
	}

	private JLabel title() {
		titlewidth = frame.getWidth()/16*6;
	    titleheight = frame.getHeight()/9*1;
		title.setBounds(frame.getWidth()/2-titlewidth/2, 0, titlewidth, titleheight);
		title.setFont(new Font("Comic Sans MS",Font.BOLD,frame.getWidth()/30));//改变字体
		return title;
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
		System.out.println(message);
	}
}
