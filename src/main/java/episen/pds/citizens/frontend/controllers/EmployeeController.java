//package episen.pds.citizens.frontend.controllers;
//
//import model.Employee;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.servlet.ModelAndView;
//import service.EmployeeService;
//
//@Controller
//public class EmployeeController {
//
//    private EmployeeService service;
//
//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
//
//    @GetMapping("/deleteEmployee/{id}")
//    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
//        service.deleteEmployee(id);
//        return new ModelAndView("redirect:/");
//    }
//    @GetMapping("/h")
//    public String home(Model model) {
//        Iterable<Employee> listEmployee = service.getEmployees();
//        model.addAttribute("employees", listEmployee);
//
//        return "home";
//    }
//
//}
//
//
