package first_spring_class;

import java.util.Comparator;

public class LipBalm extends MakeUp {
	
	protected String herbs;
	
	public LipBalm () {
		this.herbs = " ";
	}
	
	public LipBalm (String name,int age,String company,String herbs) {
		super(name,age,company);
		this.herbs = herbs;
	}
	
	public void setHerbs (String herbs) {
		this.herbs = herbs;
	}
	public String getHerbs () {
		return this.herbs;
	}
	
	public String toString() {
		return "\n" + "Name = " + this.name + ", Age = " + this.age + ", Company = " + this.company + ", Herbs = " + this.herbs ;
	}
	
	public static Comparator<LipBalm> herbComparator = new Comparator<LipBalm>(){
		@Override
		public int compare(LipBalm lipb1, LipBalm lipb2) {
			return (lipb1.getHerbs().compareTo(lipb2.getHerbs()));
		}
    };
	
}

