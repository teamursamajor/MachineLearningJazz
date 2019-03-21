package graphs;

public class ConicCircle {	
	public interface Circle {
		/**
		 * 
		 * @param h - y-value of origin
		 * @param k - x-value of origin
		 * @param r - radius of circle
		 * @param x - x coord to calculate
		 * @param y - y coord to calculate
		 * @return
		 */
		double equation (double h, double k, double r, double x, double y);
	}
	
	private Circle c;
	private double xCoord, yCoord, radius;
	
	public ConicCircle(double xCoord, double yCoord, double radius) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.radius = radius;
		c = (double h, double k, double r, double x, double y) -> (Math.pow(x-h, 2)/2) + (Math.pow(y-k, 2)/2);// = Math.pow(r, 2);
	}
	
	public double calcPoints(double x, double y) {
		return c.equation(xCoord, yCoord, radius, x, y);
	}
	
	public static void main (String[] args) {
		ConicCircle circ = new ConicCircle(0,0,5);
		System.out.println(circ.calcPoints(5, 5));
		System.out.println(circ.calcPoints(2, 5));
		
		for (double x = 0.0; x < 5.1; x+=.1) {
			for (double y = 0.0; y < 5.1; y+=.1) {
				if (circ.calcPoints(x,y) > 24.5 && circ.calcPoints(x,y) < 25.5) {
					System.out.println(x+","+y);
				} else {
//					System.out.println("no");
				}
			}
		}
	}
	
}
