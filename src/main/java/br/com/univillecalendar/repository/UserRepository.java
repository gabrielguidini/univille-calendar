package br.com.univillecalendar.repository;

import br.com.univillecalendar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Student, UUID> {
}
