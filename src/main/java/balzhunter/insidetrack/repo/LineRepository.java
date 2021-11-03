package balzhunter.insidetrack.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import balzhunter.insidetrack.model.Line;

public interface LineRepository extends MongoRepository<Line, String> {
}
