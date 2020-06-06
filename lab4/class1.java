
public class class1
{

	private double perem1;

	private double perem2;

	class1()
	{
		this.perem1 = 0;
		this.perem2 = 0;
	}
	class1(double perem1, double y)
	{
		this.perem1 = perem1;
		this.perem2 = y;
	}
	public double met1()
	{
		return this.perem1;
	}
	public double met2()
	{
		return this.perem2;
	}
	public void met3()
	{
		double newperem1 = this.perem1*this.perem1-this.perem2*this.perem2;
		this.perem2 = 2*this.perem1*this.perem2;
		this.perem1 = newperem1;
	}
	public double met4()
	{
		return this.perem1*this.perem1 +this.perem2*this.perem2;
	}
	public void met5(class1 add)
	{
		this.perem1 += add.met1();
		this.perem2 += add.met2();
	}
}