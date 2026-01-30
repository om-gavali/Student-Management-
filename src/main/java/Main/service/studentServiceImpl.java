package Main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.Repository.StudentRepository;
import Main.entity.Student;

@Service
public class studentServiceImpl implements studentService {

	@Autowired
	private StudentRepository repository;
	@Override
	public Student addStudent(Student student) {
		return repository.save(student);
		}

	@Override
	public Student editStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
		
		
	}

	@Override
	public List<Student> ShowAllStudents() {
		return repository.findAll();
		
	}

	@Override
	public Student getStudentById(int id) {
		return repository.findById(id).get();
	}

}
