
public class Pixel {
	
	private static int maxX = 724;
	private static int maxY = 576;
	private static int min = 0;
	
	private int x;
	private int y;
	private ColourRGB colour;
	
	private String createExceptionMessage(int x, int y) {
		String s = "";
		if (x < min || x > maxX) {
			s += "Value of position X = " + x + " out of bounds. ";
		}
		
		if (y < min || y > maxY) {
			s += "Value of position Y = " + y + " out of bounds. ";
		}
		
		return s;
	}
	
	public Pixel(int x, int y, int r, int g, int b) throws ColourRGBException, PixelPositionException {
		if (x < min || x > maxX || y < min || y > maxY) {
			throw new PixelPositionException(createExceptionMessage(x, y));
		}
		
		this.x = x;
		this.y = y;
		this.colour = new ColourRGB(r, g, b);
	}
	
	public int[] getPosition() {
		return new int[] {this.x, this.y};
	}
	
	public int getPositionX() {
		return this.x;
	}
	
	public int getPositionY() {
		return this.y;
	}
	
	public int[] getColour() {
		return this.colour.getColour();
	}
	
	public int getColourR() {
		return this.colour.getR();
	}
	
	public int getColourG() {
		return this.colour.getG();
	}
	
	public int getColourB() {
		return this.colour.getB();
	}
	
	public void setPosition(int x, int y) throws PixelPositionException {
		if (x < min || x > maxX || y < min || y > maxY) {
			throw new PixelPositionException(createExceptionMessage(x, y));
		}
		
		this.x = x;
		this.y = y;
	}
	
	public void setPositionX(int x) throws PixelPositionException {
		if (x < min || x > maxX) {
			throw new PixelPositionException("Value of position X = " + x + " out of bounds.");
		}
		
		this.x = x;
	}
	
	public void setPositionY(int y) throws PixelPositionException {
		if (y < min || y > maxY) {
			throw new PixelPositionException("Value of position Y = " + y + " out of bounds.");
		}
		this.y = y;
	}
	
	public void setColour(int r, int g, int b) throws ColourRGBException {
		this.colour.setColour(r, g, b);
	}
	
	public void setColourR(int r) throws ColourRGBException {
		this.colour.setR(r);
	}
	
	public void setColourG(int g) throws ColourRGBException {
		this.colour.setG(g);
	}
	
	public void setColourB(int b) throws ColourRGBException {
		this.colour.setR(b);
	}
	
	public String writePixel() {
		return new String("Position: " + this.x + " " + this.y + ", " + this.colour.writeColour());
	}
	
}
