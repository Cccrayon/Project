public class ReadRadius {	

	public static void main(String[] args) {
		// if (args.length == 0) {
		// 	System.out.println("Please supply a planet as a command line argument.");
		// }	

		/* Start reading in national_salt_production.txt */
		In in = new In("./Data/planets.txt");
		
		/* Keep looking until the file is empty. */
		int num = in.readInt();
		double radius = in.readDouble();

		//for the format
		System.out.println("The radius of the universe is " + radius);


	}
} 