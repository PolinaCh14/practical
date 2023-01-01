package first_spring;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;*/

import first_spring_class.SunCream;
import first_spring_dao.DAOFactory;
import first_spring_dao.IDAO;
import first_spring_dao.TypeDAO;
//import first_spring_form.AddSunCream;
import first_spring_form.AddSunCreamForm;
import first_spring_form.DeleteSunCreamForm;
import first_spring_form.UpdateSPFForm;

@Controller
public class ControllerSunCream {
	
	   //private IDAO dao = DAOFactory.getDAOInstance(TypeDAO.COLLECTION);
		private IDAO dao = DAOFactory.getDAOInstance(TypeDAO.MY_SQL);

		@RequestMapping(value = { "/", "/suncream" }, method = { RequestMethod.GET, RequestMethod.POST })
		public String showAllSunCream (Model model) {
			List<SunCream> list = dao.showSunCream();

			model.addAttribute("showSunCream", list);

			return "pageSunCream";
		}
		
		@RequestMapping(value = { "/addSunCream" }, method = RequestMethod.GET)
		public String showAddSunCream(Model model) {

			AddSunCreamForm addSunCreamForm = new AddSunCreamForm();
			model.addAttribute("addSunCreamForm", addSunCreamForm);

			return "addSunCream";
		}
		
		@RequestMapping(value = { "/addSunCream" }, method = RequestMethod.POST)
		public String addSunCream(Model model, AddSunCreamForm addSunCreamForm) {

			dao.addSunCream(new SunCream(addSunCreamForm.getName(), addSunCreamForm.getAge(), addSunCreamForm.getCompany(),
					addSunCreamForm.getSpf()));
			
			return "redirect:/suncream";
		}
		
		@RequestMapping(value = { "/deleteSunCream" }, method = RequestMethod.GET)
		public String showDeleteSunCream(Model model) {

			DeleteSunCreamForm deleteSunCreamForm = new DeleteSunCreamForm ();
			model.addAttribute("deleteSunCream", deleteSunCreamForm);

			return "deleteSunCream";
		}
		
		@RequestMapping(value = { "/deleteSunCream" }, method = RequestMethod.POST)
		public String deleteSunCream(Model model, DeleteSunCreamForm deleteSunCream) {

			dao.delSunCream(deleteSunCream.getNameS());

			return "redirect:/suncream";
		}
		
		@RequestMapping(value = { "/updatespf" }, method = RequestMethod.GET)
		public String showUpdateSPFSunCream(Model model) {

			UpdateSPFForm updateSPF = new UpdateSPFForm();
			model.addAttribute("updatespf", updateSPF);

			return "updatespf";
		}
		
		@RequestMapping(value = { "/updatespf" }, method = RequestMethod.POST)
		public String UpdateSPF(Model model,UpdateSPFForm updatespf) {

			 dao.updateSPF(updatespf.getSpf(),updatespf.getName());
			return "redirect:/suncream";
		}
}
