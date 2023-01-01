package first_spring_dao;

import java.util.List;
import first_spring_class.Lipstick;
import first_spring_class.SunCream;

public interface IDAO {
	void addSunCream(SunCream sun);
	void addLipstick(Lipstick lip);
    List<SunCream> showSunCream();
	List<Lipstick>showLipstick();
	void delSunCream(String name);
	void delLipstick(String name);
	void updateSPF (int spf, String name);
    List<Lipstick> searchCompanyL(String comp);
}