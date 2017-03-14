package com.francisco.jv;

import java.util.List;

@Controller
@RequestMapping(value = {"/coche", "/"})
public class CocheController {

	@Autowired
	CocheHelper cocheHelper;

	@Autowired
	CarService carService;	
		
	@Autowired
	MatriculasService maltriculasService;
	
	@Autowired
	CocheValidator cocheValidator;
	
	public static final String VIEW_COCHE = "coche";
	public static final String VIEW_ADD_CAR = "addCar";
	public static final String VIEW_EDIT_CAR = "editCar";
	public static final String REDIRECT_COCHE = "redirect:/" + VIEW_COCHE;

	@ModelAttribute("provincias")
	public List<Matriculas> getMatriculas(){
		List<Matriculas> Matriculas = MatriculasService.provinciaFindAll();
		return Matriculas;
	}
	

	@GetMapping
	public String getcar(Model model) {
		model.addAttribute("coche", carService.getCoche());
		return VIEW_COCHE;
	}

	
	@GetMapping("/{Coche}")
	public String getCoche(@PathVariable String coche, Model model) {
		coche coche = carService.getcarByUsername(coche);
		model.addAttribute("coche", coche);
		return VIEW_EDIT_CAR;
	}

	
	@GetMapping("/add")
	public String addcar(Model model) {
		model.addAttribute("Coche", new Coche());
		return VIEW_ADD_CAR;
	}

	
	@PostMapping("/add")
	public String addcar(@Valid @ModelAttribute("car") coche coche, BindingResult result, Model model) {
		CocheValidator.validate(coche, result);
		if (result.hasErrors()){
			System.out.println(result.getAllErrors());
			return VIEW_ADD_CAR;
		}

		if (carHelper.userAlreadyExists(coche, result)){
			return VIEW_ADD_CAR;
		}else {
			carService.savePerson(coche);
			return REDIRECT_COCHE;	
		}
	}
	
	@PostMapping("/{usercar}")
	public String updateUser(@Valid @ModelAttribute("car") car car, BindingResult result, @PathVariable String userncar, Model model) {
		if (result.hasErrors()){
			return VIEW_EDIT_CAR;
		}
		else {
			CocheService.savePerson(car);
		}
		return REDIRECT_COCHE;
	}

	
	@GetMapping("/{Coche}/delete")
	public String deleteCoche(@PathVariable String Coche, Model model) {		 
		CocheService.deletePersonByUsername(coche);
		return REDIRECT_COCHE;
	}

}
