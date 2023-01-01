package first_spring_form;

public class UpdateSPFForm {
	
	protected int spf;
	protected String name;
	
	public UpdateSPFForm(int spf, String name) {
		// TODO Auto-generated constructor stub
		this.spf = spf;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public int getSpf() {
		return spf;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpf(int spf) {
		this.spf = spf;
	}
	public UpdateSPFForm() {
		// TODO Auto-generated constructor stub
	}
}
