
public class ColourRGB {
	
	private static int minVal = 0;
	private static int maxVal = 255;
	
	private int r;
	private int g;
	private int b;
	
	private String createExceptionMessage(int r, int g, int b) {
		String s = "";
		if (r < minVal || r > maxVal) {
			s += "Value Red = " + r + " out of bounds. ";
		}
		
		if (g < minVal || g > maxVal) {
			s += "Value Green = " + g + " out of bounds. ";
		}
		
		if (b < minVal || b > maxVal) {
			s += "Value Blue = " + b + " out of bounds. ";
		}
		
		return s;
	}
	
	public ColourRGB(int r, int g, int b) throws ColourRGBException {
		if (r < minVal || r > maxVal || g < minVal || g > maxVal || b < minVal || b > maxVal) {
			String s = createExceptionMessage(r, g, b);
			throw new ColourRGBException(s);
		}
		
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void setColour(int r, int g, int b) throws ColourRGBException {
		if (r < minVal || r > maxVal || g < minVal || g > maxVal || b < minVal || b > maxVal) {
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
		if (r < minVal || r > maxVal) {
			throw new ColourRGBException("Value Red = " + r + " out of bounds");
		}
		this.r = r;
	}
	
	public void setG(int g) throws ColourRGBException {
		if (g < minVal || g > maxVal) {
			throw new ColourRGBException("Value Green = " + g + " out of bounds");
		}
		this.g = g;
	}
	
	public void setB(int b) throws ColourRGBException {
		if (b < minVal || b > maxVal) {
			throw new ColourRGBException("Value Blue = " + b + " out of bounds");
		}
		this.b = b;
	}
	
	public String writeColour() {
		return new String("Colour: " + this.r + " " + this.g + " " + this.b);
	}
	
}
