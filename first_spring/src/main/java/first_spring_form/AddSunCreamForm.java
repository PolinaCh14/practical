package first_spring_form;

public class AddSunCreamForm {
	protected String name;
	protected int age;
	protected String company;
	protected int spf;
	
	public AddSunCreamForm(String name, int age, String company, int spf) {
		this.name = name;
		this.age = age;
		this.company = company;
		this.spf = spf;
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
	public int getSpf() {
		return spf;
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
	public void setSpf(int spf) {
		this.spf = spf;
	}
	
	public AddSunCreamForm() {
		// TODO Auto-generated constructor stub
	}
}
