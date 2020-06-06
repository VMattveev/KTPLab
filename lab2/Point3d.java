
public class Point3d 
{
	private double xCoord;
	private double yCoord;
	private double zCoord;
	public Point3d ( double x, double y, double z) 
	{
		xCoord = x;
		yCoord = y;
		zCoord = y;
	}
	public Point3d () 
	{
		this(0, 0, 0);
	}
	public double getX() 
	{
		return xCoord;
	}
	public double getY() 
	{
		return yCoord;
	}
	public double getZ() 
	{
		return zCoord;
	}
	public void setX ( double val) 
	{
		xCoord = val;
	}
	public void setY (double val) 
	{
		yCoord = val;
	}
	public void setZ (double val) 
	{
		zCoord = val;
	}
	 public boolean equals(Point3d val)
	 {
		 if (this.xCoord!= val.getX()) return false;
		 if (this.yCoord!= val.getY()) return false;
		 if (this.zCoord!= val.getZ()) return false;
		 return true;
	 }
	 public double distanceTo(Point3d val)
	 {
		 return Math.sqrt(Math.pow(this.xCoord-val.getX(),2)+Math.pow(this.yCoord-val.getY(),2)+Math.pow(this.zCoord-val.getZ(),2));
	 }
}
