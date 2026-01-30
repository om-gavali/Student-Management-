package Main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import Main.entity.Student;
import Main.service.studentService;

//@RestController
@Controller
public class StudentController {

	@Autowired
	private studentService service;

	@GetMapping("/students")
	public String AllStudents(Model model) {
		model.addAttribute("students", service.ShowAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "create_student";
	}

	@PostMapping("/students")
	public String SaveStudents(@ModelAttribute("student") Student student) {
		service.addStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
	    model.addAttribute("student", service.getStudentById(id));
	    return "edit_student";
	}

	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student") Student student)
	{
		Student std =service.getStudentById(id);
		std.setFirstName(student.getFirstName());
		std.setLastName(student.getLastName());
		std.setEmail(student.getEmail());
		
		
		 service.editStudent(std);
		 return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteById(id);
        return "redirect:/students";
    }

}
