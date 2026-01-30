package Main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Main.entity.users;

public interface UserRepository extends JpaRepository<users, Integer>  {

	

	

	users findByUsername(String username);

	
	
}
