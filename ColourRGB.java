
public class ColourRGB {
	
	private int r;
	private int g;
	private int b;
	
	private String createExceptionMessage(int r, int g, int b) {
		String s = "";
		if (r < 0 || r > 255) {
			s += "Value R = " + r + " out of bounds. ";
		}
		
		if (g < 0 || g > 255) {
			s += "Value G = " + g + " out of bounds. ";
		}
		
		if (b < 0 || b > 255) {
			s += "Value B = " + b + " out of bounds. ";
		}
		
		return s;
	}
	
	public ColourRGB(int r, int g, int b) throws ColourRGBException {
		if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
			String s = createExceptionMessage(r, g, b);
			throw new ColourRGBException(s);
		}
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void setColour(int r, int g, int b) throws ColourRGBException {
		if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
			String s = createExceptionMessage(r, g, b);
			throw new ColourRGBException(s);
		}
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public int[] getColour() {
		return new int[] {this.r, this.g, this.b};
	}
	
	public int getB() {
		return b;
	}
	
	public int getG() {
		return g;
	}
	
	public int getR() {
		return r;
	}
	
	public void setR(int r) throws ColourRGBException {
		if (r < 0 || r > 255) {
			throw new ColourRGBException("Value R = " + r + " out of bounds");
		}
		this.r = r;
	}
	
	public void setG(int g) throws ColourRGBException {
		if (g < 0 || g > 255) {
			throw new ColourRGBException("Value G = " + g + " out of bounds");
		}
		this.g = g;
	}
	
	public void setB(int b) throws ColourRGBException {
		if (b < 0 || b > 255) {
			throw new ColourRGBException("Value B = " + b + " out of bounds");
		}
		this.b = b;
	}
	
	public String writeColour() {
		return new String("Colour: " + this.r + " " + this.g + " " + this.b);
	}
	
}
