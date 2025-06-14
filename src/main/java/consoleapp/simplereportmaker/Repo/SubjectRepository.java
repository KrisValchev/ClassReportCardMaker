package consoleapp.simplereportmaker.Repo;

import consoleapp.simplereportmaker.Models.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
