
public class Pixel {
	
	private int x;
	private int y;
	private ColourRGB colour;
	
	public Pixel(int x, int y, int r, int g, int b) throws ColourRGBException {
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
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPositionX(int x) {
		this.x = x;
	}
	
	public void setPositionY(int y) {
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
