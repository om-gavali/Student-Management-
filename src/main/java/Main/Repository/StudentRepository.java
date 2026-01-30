package Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Main.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
