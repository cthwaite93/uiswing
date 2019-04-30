import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class PixelDrawer extends JFrame {
	
	private static int width = 1024;
	private static int height = 576;
	private static Dimension buttonDimensions = new Dimension(100, 28);
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(width, height);
		setVisible(true);
	}
	
	private JPanel optionsPanel() {
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		
		p.setLayout(new GridLayout(6, 1));
		p.setBorder(new EmptyBorder(25, 30, 25, 30));
		
		JButton bd = new JButton("Draw");
		bd.setPreferredSize(buttonDimensions);
		JButton bc = new JButton("Clear");
		bc.setPreferredSize(buttonDimensions);
		p1.add(bd);
		p1.add(bc);
		
		p.add(p1);
		return p;
	}
	
	private Canvas canvasPanel() {
		return new Canvas();
	}
	
	private void constructLayout() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		Canvas cv = new Canvas();
		c.add(cv, BorderLayout.CENTER);
		
		c.add(optionsPanel(), BorderLayout.WEST);
	}
	
	public PixelDrawer() {
		super("Pixel Drawer");
		setLookAndFeel();
		constructLayout();
		initialize();
	}
	
	public static void main(String[] args) {
		new PixelDrawer();
	}
}
