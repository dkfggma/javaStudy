package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingEvent05 extends JFrame {
	
	JButton btn1, btn2, btn3;
	JLabel lbl1;
	
	public SwingEvent05() {
		super("스윙 이벤트 5");
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
		
	}

	private void initComponent() {
		
		this.setLayout(new FlowLayout());
		
		btn1 = new JButton("단추1");
		btn2 = new JButton("단추2");
		btn3 = new JButton("단추3");
		lbl1 = new JLabel("레이블");
		
		lbl1.setLocation( 30, 30 );
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(lbl1);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
		
	}

	public static void main(String[] args) {
		
		new SwingEvent05();

	}
	//MouseAdapter 상속받은 class 는 필요한 메소드만 가져와서 사용가능
	class MyMouseAdapter extends MouseAdapter{

		@Override
		public void mousePressed(MouseEvent e) {
			int x =  e.getX();
			int y =  e.getY();
			System.out.println("click 위치 : x = "+x +", y = "+y);
			lbl1.setLocation(x, y);
			super.mousePressed(e);
		}
		
		
	}

}
