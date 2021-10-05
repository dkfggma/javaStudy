package ex02;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

// 1. 이벤트 처리 방법

class EventA implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickBtn = (JButton)e.getSource();
		String msg = "";
		switch(clickBtn.getText()) {
		case "버튼 1":
			msg = "단추 1"; break;
		case "버튼 2":
			msg = "단추 2"; break;
		case "버튼 3":
			msg = "단추 3"; break;
		case "hahahahahahahahahahahahahahahahahaha":
			msg = "새로운 단추"; break;
	
		}
		msg +=" 단추가 눌러졌습니다.";
		System.out.println(msg);
		SwingEvent01.lbl1.setText(msg);
	}
	
}

public class SwingEvent01 extends JFrame{
	
	JButton btn1, btn2, btn3;
	static JLabel  lbl1;
	JButton btnnewButton;

	public SwingEvent01() {
		super("스윙 이벤트 처리1");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	private void initComponent() {
		//레이아웃
		getContentPane().setLayout(new FlowLayout());
		
		btn1 = new JButton("버튼 1");
		btn2 = new JButton("버튼 2");
		btn3 = new JButton("버튼 3");
		lbl1 = new JLabel("여기에 출력");
		
		btn1.addActionListener(new EventA());
		btn2.addActionListener(new EventA());
		btn3.addActionListener(new EventA());
		
		getContentPane().add(btn1);
		getContentPane().add(btn2);
		getContentPane().add(btn3);
		
		btnnewButton = new JButton("hahahahahahahahahahahahahahahahahaha");
		this.btnnewButton.addActionListener(new EventA());
		getContentPane().add(btnnewButton);
		
		getContentPane().add(lbl1);
	}

	public static void main(String[] args) {
		new SwingEvent01();

	}

}
