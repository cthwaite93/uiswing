import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	public Window() {
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		setSize(1024,628);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Window();
	}
}
