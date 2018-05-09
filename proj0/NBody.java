public class NBody {

	public static Planet[] readPlanets(String path) {

		String planetsTxtPath = path;

		In in = new In(planetsTxtPath);
		
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] p = new Planet[num];

		for(int i = 0; i < num; i++) {
		//while(!in.isEmpty()) {
			/* Each line has the rank of a country, then its
			 * name, then its production in metric tons, and
			 * finally the fraction of world salt output it produces. */
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();

			p[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
	
				// System.out.println("xxPos = " + xxPos + ", " + "yyPos = " + yyPos + ",");
				// System.out.println("xxVel = " + xxVel + ", " + "yyVel = " + yyVel + ",");
				// System.out.println("mass = " + mass + ", " + "imgFileName = " + imgFileName + ".");
			// }
		}
		
				return (p);

	}

	public static double readRadius(String path) {
	
		String radiusTxtPath = path;
		
		In in = new In(radiusTxtPath);
		
		/* Keep looking until the file is empty. */
		int num = in.readInt();
		double radius = in.readDouble();

		return radius;

	}
	
	public static String imageToDraw = "images/starfield.jpg";

	public static void drawBackground(double rad) {
		/** Sets up the universe so it goes from 
		  * -100, -100 up to 100, 100 */
		double radius = rad;
		StdDraw.setScale(-rad, rad);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
		// StdDraw.picture(0, 75, imageToDraw);
		// StdDraw.picture(-75, -75, imageToDraw);
		// StdDraw.picture(75, -75, imageToDraw);
		StdDraw.picture(0, 0, imageToDraw);

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		// StdDraw.show();
		// StdDraw.pause(2000);		
	}	

	public static void main(String[] args) {
		/* collecting all needed input */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		StdDraw.enableDoubleBuffering();//启动双缓冲
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);

		//运行动画
		for(double time = 0; time < T; time += dt){
			/* drawing the background */ 
			drawBackground(radius);

			/* draw the planets */
			for(int i = 0; i < planets.length; i++) {
				planets[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);

			double[] xForce = new double[planets.length];
			double[] yForce = new double[planets.length];
 
			for(int j = 0; j < planets.length; j++) {
				xForce[j] = planets[j].calcNetForceExertedByX(planets);
				yForce[j] = planets[j].calcNetForceExertedByY(planets);
			}

			for(int k = 0; k < planets.length; k++) {
				planets[k].update(dt, xForce[k], yForce[k]);
			}

		}
	
	}

} 




















