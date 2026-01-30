package Main.service;

import java.util.List;
import Main.entity.Student;
public interface studentService {

	public Student addStudent(Student student);
	public Student editStudent(Student student);
	public void deleteById(int id);
	public List<Student> ShowAllStudents();
	public Student getStudentById(int id) ;
	
}
