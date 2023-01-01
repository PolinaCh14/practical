package first_spring_dao;

import java.util.List;
import java.util.stream.Collectors;

import first_spring_class.Lipstick;
import first_spring_class.SunCream;

import java.util.ArrayList;
import java.util.List;


public class MyCollection implements IDAO {
 
	private static List<SunCream> sunc = new ArrayList<SunCream>();
	private static List<Lipstick> lips = new ArrayList<Lipstick>();
	
	static {
		sunc.add(new SunCream("Roseliane CC Cream", 18, "Uriage ", 30));
		sunc.add(new SunCream("ThinkSport", 06, "ThinkSport", 60));
		lips.add(new Lipstick("Super Stay Matte",18,"Maybelline New York","not",60));
		}

	
	@Override
	public void addLipstick(Lipstick lip) {
		// TODO Auto-generated method stub
		lips.add(lip);
		
		
	}
	@Override
	public void addSunCream(SunCream sun) {
		// TODO Auto-generated method stub
		sunc.add(sun);
	}
	@Override
	public void delLipstick(String name) {
		// TODO Auto-generated method stub
		lips = lips.stream().filter(lip -> lip.getName().equals(name) == false).collect(Collectors.toList());
	}
	@Override
	public void delSunCream(String name) {
		// TODO Auto-generated method stub
		sunc = sunc.stream().filter(sun -> sun.getName().equals(name) == false).collect(Collectors.toList());
	}
	@Override
	public List<Lipstick> searchCompanyL(String comp) {
		// TODO Auto-generated method stub
		List<Lipstick> search = new ArrayList<Lipstick>();

		for (Lipstick lip : lips) {
			if (lip.getCompany().equals(comp)) {
				search.add(lip);
			}
		}
		if (search.size() == 0) {
			System.out.println("!!!!");
			return null;
		} else {
			return search;
		}
		
	}
	@Override
	public List<Lipstick> showLipstick() {
		// TODO Auto-generated method stub
		return lips;
	}
	@Override
	public List<SunCream> showSunCream() {
		// TODO Auto-generated method stub
		return sunc;
	}
	@Override
	public void updateSPF(int spf, String name) {
		// TODO Auto-generated method stub
		
		List<SunCream> search = new ArrayList<SunCream>();
		for (SunCream sunn : sunc) {
			if (sunn.getName().equals(name)) {
				
				sunn.setSpf(spf);
			}
		}
	}
	
}
