public class ReadPlanets {	

	public static void main(String[] args) {

		In in = new In("./Data/planets.txt");
		
		int num = in.readInt();
		double radius = in.readDouble();

		//for the format
		System.out.println(" ");


		for(int i = 0; i < 5; i++) {
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
			String name = in.readString();


			if (name.equals(args[0])) {		
				System.out.println("The imformation of " + name + " are listed below : ");
				System.out.println("xxPos = " + xxPos + ", " + "yyPos = " + yyPos + ",");
				System.out.println("xxVel = " + xxVel + ", " + "yyVel = " + yyVel + ",");
				System.out.println("mass = " + mass + ", " + "imgFileName = " + imgFileName + ".");
			}
		}
		
		//for the format
		System.out.println(" ");

	}
} 