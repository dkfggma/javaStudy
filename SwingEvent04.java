package ex02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingEvent04 extends JFrame {
	
	JButton[] btns;
	JLabel  lbl1;
	
	public SwingEvent04() {
		super("스윙 이벤트4");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.setVisible(true);
		
	}

	private void initComponent() {
		this.setLayout( new FlowLayout());
		
		btns = new JButton[3];
		
		/*btns[0] = new JButton("버튼 1");
		btns[1] = new JButton("버튼 2");
		btns[2] = new JButton("버튼 3");*/
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton("버튼 "+(i+1));
			this.add(btns[i]);
		}
		
		lbl1 = new JLabel("여기에 출력");
		this.add(lbl1);
		
		for (int i = 0; i < btns.length; i++) {
			/*방법 1 익명클래스
			 * this.btns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					String  msg = btn.getText();
					lbl1.setText(msg);
				}
			});*/
			//java 1.8이상에서 사용하는법 - 람다식
			
			btns[i].addActionListener( (e)-> {
				JButton btn  = (JButton) e.getSource();
				String  msg = btn.getText();
				lbl1.setText(msg);
			});
			
		}
		
		
		
	}

	public static void main(String[] args) {
		new SwingEvent04();

	}

}
