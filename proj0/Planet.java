public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	//定义一个Planet p
	public Planet (double xP, double yP, double xV,double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	//创建一个Planet p 的副本 构造行星
	public Planet (Planet p) {
		//this 表示此处的实例对象
		this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);

		// xxPos = p.xxPos;
  //       yyPos = p.yyPos;
  //       xxVel = p.xxVel;
  //       yyVel = p.yyVel;
  //       mass = p.mass;
  //       imgFileName = p.imgFileName;
		
	}

	//计算行星距离
	public double calcDistance(Planet p) {
		double dx = p.xxPos - this.xxPos ;
		double dy = p.yyPos - this.yyPos ;
		double r = Math.sqrt(dx * dx + dy * dy);
		return r;
	}

	//计算两星之间引力大小
	public double calcForceExertedBy(Planet p) {
		double grav = 6.67e-11; //grav 为重力常数
		double force = grav * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return force;
	}

	//x轴距离
	public double calcForceExertedByX(Planet p) {
		double xForce = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p) ;
		return xForce;
	}

	//y轴距离
	public double calcForceExertedByY(Planet p) {
		double yForce = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p) ;
		return yForce;
	}

	//x轴净力
	public double calcNetForceExertedByX(Planet[] p) {
		Planet[] allPlanets = p;

		double xNetForce = 0;
		for (int i = 0; i < allPlanets.length; i++) {
			if (allPlanets[i] != this){
			xNetForce += this.calcForceExertedByX(allPlanets[i]);
			}
		}
		// xNetForce = xNetForce;
		return xNetForce;
	}

	//y轴净力
	public double calcNetForceExertedByY(Planet[] p) {
		Planet[] allPlanets = p;

		double yNetForce = 0;
		for (int i = 0; i < allPlanets.length; i++) {
			if (allPlanets[i] != this){
			yNetForce += this.calcForceExertedByY(allPlanets[i]);

			}
		}
		// yNetForce = yNetForce;
		return yNetForce;
	}

	//	加速度和移动
	public void update(double dt, double xNetForce, double yNetForce) {
		xxVel = this.xxVel + dt * (xNetForce / this.mass);
		yyVel = this.yyVel + dt * (yNetForce / this.mass);
		xxPos = this.xxPos + dt * xxVel;
		yyPos = this.yyPos + dt * yyVel;
	}

	//绘制行星
	public void draw() {


		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		// StdDraw.show();
		// StdDraw.pause(2000);		
	}	

}



















