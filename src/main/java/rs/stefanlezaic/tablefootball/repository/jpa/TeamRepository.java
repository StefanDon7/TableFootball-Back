package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
