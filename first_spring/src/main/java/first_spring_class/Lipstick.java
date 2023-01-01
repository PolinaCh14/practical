package first_spring_class;

import java.util.Comparator;
import java.util.Scanner;


public class Lipstick extends LipBalm {

	protected int color;
	protected long idLip;
	
	public Lipstick() {
		this.color = 0;
	}
	
	public Lipstick(String name,int age,String company,String herbs, int color) {
		
		super(name,age,company,herbs);
		this.color = color;
	}
	
	
	
	public long getIdLip() {
		return idLip;
	}
	
	public void setIdLip(long idLip) {
		this.idLip = idLip;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
	this.color = color;
	}
	
	public void getAgeVerified() {
		Scanner inn = new Scanner(System.in);
		System.out.print("Enter the age for which you choose lipstick ");
		int choose = inn.nextInt();
		if(choose < this.age) {
			System.out.println("Unfortunately, lipstick with a color number " + this.color + " not suitable for the age that you entered");
		}else if(choose<=0) {
			System.out.println("You have entered an invalid age");
		}else {
			System.out.println("This lipstick is suitable for the entered age");
		}
	}
	
	public String toString() {
		return "\n" + "Id = " + this.idLip +" Name = " + this.name + ", Age = "  + this.age + ", Company = " + this.company + ", Herbs = " + this.herbs+ ", Number of colors = " + this.color;
	}
	
	public static Comparator<Object> color_ageComparator = new Comparator<Object>(){
		@Override
		public int compare(Object obj1,Object obj2) {
			int cl1 = (((Lipstick)obj1).getColor());
			int cl2 = (((Lipstick)obj2).getColor());
			int age1 = (((Lipstick)obj1).getAge());
			int age2 = (((Lipstick)obj2).getAge());
			if(cl1 == cl2 && age1 == age2){
				return 0;
			}else if (cl1 == cl2){
				return ( age1 > age2 )? 1 :-1;
			}else {
				return ( cl1 > cl2 )? 1 :-1;
			}
		}
	};
}

