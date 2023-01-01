package first_spring;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import first_spring_class.Lipstick;
import first_spring_dao.DAOFactory;
import first_spring_dao.IDAO;
import first_spring_dao.TypeDAO;
import first_spring_form.AddLipstickForm;
import first_spring_form.AddSunCreamForm;
import first_spring_form.DeleteLipstickForm;
import first_spring_form.DeleteSunCreamForm;
import first_spring_form.UpdateSPFForm;
import first_spring_form.searchCompanyLipForm;
import ua.nure.st.kpp.example.demo.entity.Student;
import ua.nure.st.kpp.example.demo.form.GetStudentByGroupForm;

@Controller
public class ControllerLipstick {

	//private IDAO dao = DAOFactory.getDAOInstance(TypeDAO.COLLECTION);
	private IDAO dao = DAOFactory.getDAOInstance(TypeDAO.MY_SQL);

	@RequestMapping(value = { "/lipstick" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String showAllSunCream (Model model) {
		List<Lipstick> list = dao.showLipstick();

		model.addAttribute("showLipstick", list);

		return "pageLipstick";
	}
			
	@RequestMapping(value = { "/addLipstick" }, method = RequestMethod.GET)
	public String showAddSunCream(Model model) {

	AddLipstickForm addLipstickForm = new AddLipstickForm();
	model.addAttribute("addLipstickForm", addLipstickForm);

		return "addLipstick";
	}
			
	@RequestMapping(value = { "/addLipstick" }, method = RequestMethod.POST)
	public String addSunCream(Model model, AddLipstickForm addLipstickForm) {

	dao.addLipstick(new Lipstick(addLipstickForm.getName(), addLipstickForm.getAge(), addLipstickForm.getCompany(),
			addLipstickForm.getHerbs(),addLipstickForm.getColor()));
		
	return "redirect:/lipstick";
	}
			
	@RequestMapping(value = { "/deleteLipstick" }, method = RequestMethod.GET)
	public String showDeleteLipstick(Model model) {

	DeleteLipstickForm deleteLipstickForm = new DeleteLipstickForm ();
	model.addAttribute("deleteLipstick", deleteLipstickForm);

	return "deleteLipstick";
	}
			
	@RequestMapping(value = { "/deleteLipstick" }, method = RequestMethod.POST)
	public String deleteLipstick(Model model, DeleteLipstickForm deleteLipstick) {
	dao.delLipstick(deleteLipstick.getNameL());

		return "redirect:/lipstick";
	}
			
	@RequestMapping(value = { "/searchCompanyL" }, method = RequestMethod.GET)
	public String showGetStudenBygroupNameView(Model model) {

		searchCompanyLipForm searchCompanyLForm = new searchCompanyLipForm();

		model.addAttribute("searchCompanyLForm", searchCompanyLForm);

		return "searchCompanyL";
	}

	@RequestMapping(value = { "/searchCompanyL" }, method = RequestMethod.POST)
	public String getStudentByGroup(Model model, searchCompanyLipForm searchCompanyL) {

		List<Lipstick> list = dao.searchCompanyL(searchCompanyL.getCompany());

		model.addAttribute("showLipstick", list);

		return "pageLipstick";

	}
	
}
