package ex02;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//이벤트 연결 3번째 방법
public class SwingEvent03 extends JFrame implements ActionListener{
	
	JButton btn1, btn2, btn3;
	JLabel  lbl1;
	
	public SwingEvent03() {
		super("스윙 이벤트3");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
		
	}

	private void initComponent() {
		this.setLayout(new FlowLayout());
		
		btn1  = new JButton("버튼1");
		btn2  = new JButton("버튼2");
		btn3  = new JButton("버튼3");
		lbl1  = new JLabel("이곳에 출력됩니다.");
		
		this.btn1.addActionListener( this );
		this.btn2.addActionListener( this );
		this.btn3.addActionListener( this );
		
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(lbl1);
	}

	public static void main(String[] args) {
		new SwingEvent03();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		HashMap<String, Color>colors =new HashMap<String,Color>();
		colors.put("버튼1", Color.RED);
		colors.put("버튼2", Color.GREEN);
		colors.put("버튼3", Color.BLUE);
		
		
		JButton btn  = (JButton)e.getSource();
		String  msg  = btn.getText();
		lbl1.setForeground( colors.get(msg) );
		msg         +="clicked";
		
		System.out.println(msg);
		lbl1.setText(msg);
		
	}

}
