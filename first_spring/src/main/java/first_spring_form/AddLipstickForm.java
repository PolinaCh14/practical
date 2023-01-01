package first_spring_form;

public class AddLipstickForm {

	protected String name;
	protected int age;
	protected String company;
	protected String herbs;
	protected int color;
	
	public AddLipstickForm(String name, int age, String company, String herbs, int color) {
		this.name = name;
		this.age = age;
		this.company = company;
		this.herbs = herbs;
		this.color = color;
	}
	public AddLipstickForm() {
		// TODO Auto-generated constructor stub
	}
	
	public int getAge() {
		return age;
	}
	public String getCompany() {
		return company;
	}
	public String getName() {
		return name;
	} 
	public String getHerbs() {
		return herbs;
	}
	public int getColor() {
		return color;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHerbs(String herbs) {
		this.herbs = herbs;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
}
