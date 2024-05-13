package br.com.univillecalendar.repository;

import br.com.univillecalendar.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, UUID> {
}
