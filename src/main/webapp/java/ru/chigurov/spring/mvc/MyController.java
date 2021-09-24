package ru.chigurov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }


    @RequestMapping("/askDetails")
    public String askEmployeeDetail(Model model){

//        Employee employee = new Employee();
//        employee.setName("Mikhail");
//        employee.setSurname("Chigurov");
//        employee.setSalary(350);

        model.addAttribute("employee", new Employee());

        return "ask-emp-detail-view";
    }



    @RequestMapping("/showDetails")
    public String showEmployeeDetail(@ModelAttribute("employee") Employee emp){


//        String name = emp.getName();
//        emp.setName("Mr. " + name);
//
//        String surname = emp.getSurname();
//        emp.setSurname(surname + "!");
//
//        int salary = emp.getSalary();
//        emp.setSalary(salary * 10);

        return "show-emp-detail-view";
    }

}
