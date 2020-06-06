
public class Lab1 {
	public static void main(String[] args) {
		double perem1 = Double.parseDouble(args[0]);
		double perem2 = Double.parseDouble(args[1]);
		double perem3 = Double.parseDouble(args[2]);
		double perem4 = Double.parseDouble(args[3]);
		double perem5 = Double.parseDouble(args[4]);
		double perem6 = Double.parseDouble(args[5]);
		double perem7 = Double.parseDouble(args[6]);
		double perem8 = Double.parseDouble(args[7]);
		double perem9 = Double.parseDouble(args[8]);
		Point3d perem10 = new Point3d(perem1,perem2,perem3);
		Point3d perem11 = new Point3d(perem4,perem5,perem6);
		Point3d perem12 = new Point3d(perem7,perem8,perem9);
		if (method2(perem10,perem11,perem12)) System.out.println("S " + method1(perem10,perem11,perem12));
		else System.out.println("Error");
	}
	public static double method1(Point3d perem10,Point3d perem11,Point3d perem12)
	{
		double a = perem10.distanceTo(perem11);
		double b = perem10.distanceTo(perem12);
		double c = perem11.distanceTo(perem12);
		double p = (a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
		
	}
	public static boolean method2(Point3d perem10, Point3d perem11, Point3d perem12)
	{
		if (perem10.equals(perem11)) return false;
		if (perem10.equals(perem12)) return false;
		if (perem11.equals(perem12)) return false;
		return true;
	}

}
