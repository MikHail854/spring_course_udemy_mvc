package ru.chigurov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }


    @RequestMapping("/askDetails")
    public String askEmployeeDetail(Model model) {

//        Employee employee = new Employee();
//        employee.setName("Mikhail");
//        employee.setSurname("Chigurov");
//        employee.setSalary(350);

        model.addAttribute("employee", new Employee());

        return "ask-emp-detail-view";
    }

    /**
     *
     * @param emp
     * @param bindingResult параметр отвечающий за валидаюцию данных
     * @return
     */
    @RequestMapping("/showDetails")
    public String showEmployeeDetail(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ask-emp-detail-view";
        } else {
            return "show-emp-detail-view";
        }
    }

}
