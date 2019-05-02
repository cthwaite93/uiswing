import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class PixelDrawer extends JFrame implements ActionListener {
	
	private static int width = 1024;
	private static int optionsPanelWidth = 300;
	private static int canvasWidth = width - optionsPanelWidth;
	private static int height = 576;
	private static Dimension buttonDimensions = new Dimension(100, 28);
	private static Dimension dialogDimensions = new Dimension(450, 253);
	
	private JTextField jtfx;
	private JTextField jtfy;
	private JTextField jtfr;
	private JTextField jtfb;
	private JTextField jtfg;
	private Canvas cv;
	private JDialog d;
	
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
	
	private JPanel optionsTitlePanel() {
		JPanel titleP = new JPanel();
		
		JLabel jlt = new JLabel("Pixel options");
		jlt.setFont(jlt.getFont().deriveFont(Font.BOLD));
		titleP.add(jlt);
		
		return titleP;
	}
	
	private JPanel posxPanel() {
		JPanel posxP = new JPanel();
		
		JLabel jlx = new JLabel("X position: ");
		jlx.setPreferredSize(buttonDimensions);
		this.jtfx = new JTextField();
		this.jtfx.setPreferredSize(buttonDimensions);
		posxP.add(jlx);
		posxP.add(this.jtfx);
		
		return posxP;
	}
	
	private JPanel posyPanel() {
		JPanel posyP = new JPanel();
		
		JLabel jly = new JLabel("Y position: ");
		jly.setPreferredSize(buttonDimensions);
		this.jtfy = new JTextField();
		this.jtfy.setPreferredSize(buttonDimensions);
		posyP.add(jly);
		posyP.add(this.jtfy);
		
		return posyP;
	}
	
	private JPanel colrPanel() {
		JPanel colrP = new JPanel();
		
		JLabel jlr = new JLabel("Red colour: ");
		jlr.setPreferredSize(buttonDimensions);
		this.jtfr = new JTextField();
		this.jtfr.setPreferredSize(buttonDimensions);
		colrP.add(jlr);
		colrP.add(this.jtfr);
		
		return colrP;
	}
	
	private JPanel colbPanel() {
		JPanel colbP = new JPanel();
		
		JLabel jlb = new JLabel("Blue colour: ");
		jlb.setPreferredSize(buttonDimensions);
		this.jtfb = new JTextField();
		this.jtfb.setPreferredSize(buttonDimensions);
		colbP.add(jlb);
		colbP.add(this.jtfb);
		
		return colbP;
	}
	
	private JPanel colgPanel() {
		JPanel colgP = new JPanel();
		
		JLabel jlg = new JLabel("Green colour: ");
		jlg.setPreferredSize(buttonDimensions);
		this.jtfg = new JTextField();
		this.jtfg.setPreferredSize(buttonDimensions);
		colgP.add(jlg);
		colgP.add(this.jtfg);
		
		return colgP;
	}
	
	private JPanel optionButtonsPanel() {
		JPanel buttonsP = new JPanel();
		
		JButton bd = new JButton("Draw");
		bd.setPreferredSize(buttonDimensions);
		
		JButton bc = new JButton("Clear");
		bc.setPreferredSize(buttonDimensions);
		
		bd.addActionListener(this);
		bc.addActionListener(this);
		
		buttonsP.add(bd);
		buttonsP.add(bc);
		
		return buttonsP;
	}
	
	private JPanel optionsPanel() {
		JPanel p = new JPanel();
		
		//Configure layout of Panel
		p.setPreferredSize(new Dimension(300, height));
		p.setLayout(new GridLayout(7, 1));
		p.setBorder(new EmptyBorder(25, 30, 25, 30));
		
		//Add panels to options panel
		p.add(optionsTitlePanel());
		p.add(posxPanel());
		p.add(posyPanel());
		p.add(colrPanel());
		p.add(colbPanel());
		p.add(colgPanel());
		p.add(optionButtonsPanel());
		
		return p;
	}
	
	private JPanel canvasPanel() {
		JPanel cvPanel = new JPanel();
		cvPanel.setPreferredSize(new Dimension(canvasWidth, height));
		this.cv = new Canvas();
		this.cv.setPreferredSize(new Dimension(canvasWidth, height));
		cvPanel.add(this.cv);
		//cvPanel.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK));
		cvPanel.setBackground(Color.WHITE);
		
		return cvPanel;
	}
	
	private void constructLayout() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(canvasPanel(), BorderLayout.CENTER);
		c.add(optionsPanel(), BorderLayout.WEST);
	}
	
	private void errorDialog(String s) {
		d = new JDialog(this, "Error");
		JPanel jp = new JPanel();
		JLabel jl = new JLabel(s);
		JButton bc = new JButton("Close");
		bc.setPreferredSize(buttonDimensions);
		bc.addActionListener(this);
		jl.setFont(jl.getFont().deriveFont(Font.BOLD));
		jp.add(jl);
		jp.add(bc);
		d.add(jp);
		d.setSize(dialogDimensions);
		d.setResizable(false);
		d.setLocationRelativeTo(this);
		d.setVisible(true);
	}
	
	private Pixel createPixel() {	
		Pixel p = null;
		
		try {
			int x = Integer.parseInt(jtfx.getText().toString());
			int y = Integer.parseInt(jtfy.getText().toString());
			int r = Integer.parseInt(jtfr.getText().toString());
			int b = Integer.parseInt(jtfb.getText().toString());
			int g = Integer.parseInt(jtfg.getText().toString());
			p = new Pixel(x, y, r, b, g);
		} catch(NumberFormatException e) {
			errorDialog("Textfields must have a value and value must be an integer.");
		} catch (ColourRGBException e) {
			errorDialog(e.getMessage());
		} catch (PixelPositionException e) {
			errorDialog(e.getMessage());
		}
		
		return p;
	}
	
	private void drawPixel() {
		Pixel p = createPixel();
		
		//If there's no mistake
		if (p != null) {
			
		}
	}
	
	public PixelDrawer() {
		super("Pixel Drawer");
		setLookAndFeel();
		constructLayout();
		initialize();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Draw")) {
			drawPixel();
		} else if (s.equals("Close")) {
			d.dispose();
		}
		
	}
	
	public static void main(String[] args) {
		new PixelDrawer();
	}
}
