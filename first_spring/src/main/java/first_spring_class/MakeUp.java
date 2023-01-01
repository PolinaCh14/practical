package first_spring_class;

public class MakeUp {
	protected String name;
	protected int age;
	protected String company;

	public MakeUp () {
		this.name = " ";
		this.age = 0;
		this.company = " ";
	}
	
	public MakeUp (String name,int age,String company ) {
		this.name = name;
		this.age = age;
		this.company = company;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	public String getName () {
		return name;
	}
	
	public void setAge (int age) {
		this.age = age;
	}
	public int getAge () {
		return age;
	}
	
	public void setCompany (String company) {
		this.company = company;
	}
	public String getCompany () {
		return company;
	}
	
	public String toString() {
		return "\n" + "Name = " + this.name + ", Age = " + this.age + ", Company = " + this.company;
	}
	
}
