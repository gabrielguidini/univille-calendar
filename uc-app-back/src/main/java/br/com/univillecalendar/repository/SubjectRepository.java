package br.com.univillecalendar.repository;

import br.com.univillecalendar.model.Subject;
import br.com.univillecalendar.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    @Query(value = """
                    select t from Teacher t where t.teacherFirstName=:firstName and t.teacherLastName=:lastName
                    """)
    Teacher findTeacherByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
