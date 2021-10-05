package ex02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//스윙 이벤트 2번째 처리방법 예제
//내부(inner) 클래스 사용

public class SwingEvent02 extends JFrame {
	
	JButton btn1, btn2, btn3;
	JLabel  lbl1;
	
	
	
	public SwingEvent02() {
		super("스윙 이벤트2");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	private void initComponent() {
		
		this.setLayout(new FlowLayout());
		
		btn1  = new JButton("단추1");
		btn2  = new JButton("단추2");
		btn3  = new JButton("단추3");
		lbl1  = new JLabel("이곳에 출력됩니다.");
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(lbl1);
		
		//이벤트 연결
		this.btn1.addActionListener(new EventB());
		this.btn2.addActionListener(new EventB());
		this.btn3.addActionListener(new EventB());
		
	}

	public static void main(String[] args) {
		new SwingEvent02(); 
	}
	
	//내부 클래스 생성
	class EventB implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn  = (JButton)e.getSource();
			String  text = btn.getText();
			String  msg  = text+"버튼이 클릭되었습니다";
			
			System.out.println(msg);
			lbl1.setText(msg);
			
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
