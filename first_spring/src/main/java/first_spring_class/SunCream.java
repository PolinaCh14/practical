package first_spring_class;

import java.util.Scanner;

public class SunCream extends MakeUp implements Comparable<SunCream>{

	protected int spf;
	protected long idSun;
	
	@Override
	public int compareTo(SunCream sun) {
		if(this.spf == sun.spf) {
			return 0;
		}
		else {
			return (this.spf > sun.spf)?1:-1;
		}
	}
	
	public SunCream () {
		this.spf = 0;
	}
	
	public SunCream (String name,int age,String company,int spf ) {
		super(name,age,company);
		this.spf = spf;
		//idSun = (long)(Math.random()*100);
	}
	
	public long getIdSun() {
		return idSun;
	}
	
	public void setIdSun(long idSun) {
		this.idSun = idSun;
	}
	
	public void setSpf (int spf) {
		this.spf = spf;
	}
	public int getSpf () {
		return spf;
	}
	
	public void getReccommendation() {
		Scanner inn = new Scanner(System.in);
		System.out.print("Enter the number corresponding to the month you need " + "\n" + "1 - Winter" + "\n" + "2 - Spring" + "\n" + "3 - Summer" + "\n" + "4 - Autumn");
		int choose = inn.nextInt();
		switch(choose) {
		case 1: //winter
			if(this.spf >= 20) {
				System.out.println("It is suitable for winter");
			}else {
				System.out.println("Unfortunately, this cream is not suitable for this season");
			}
			break;
		case 2: //spring
			if(this.spf >= 45) {
				System.out.println("It is suitable for spring");
			}else {
				System.out.println("Unfortunately, this cream is not suitable for this season");
			}
			break;
		
	case 3: //summer
		if(this.spf >= 50) {
			System.out.println("It is suitable for summer");
		}else {
			System.out.println("Unfortunately, this cream is not suitable for this season");
		}
		break;
	case 4: //autumn
		if(this.spf >= 40) {
			System.out.println("It is suitable for autumn");
		}else {
			System.out.println("Unfortunately this cream is not suitable for this season");
		}
		break;
	default:
		System.out.println("Sorry, no such month exists");
		break;
	  }
	}
	
	public String toString() {
		return "\n"+ "id = " + this.idSun + ", Name = " + this.name + ", Age = " + this.age + ", Company = " + this.company + ", SPF = " + this.spf;
	}
}

