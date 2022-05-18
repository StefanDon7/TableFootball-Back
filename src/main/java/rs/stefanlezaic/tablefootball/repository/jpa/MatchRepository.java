package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    Match getByUuid(String uuid);

    @Query("select m from Match m where " +
            "m.firstTeam.attack.uuid=:uuid or " +
            "m.firstTeam.defence.uuid=:uuid or " +
            "m.secondTeam.attack.uuid=:uuid or " +
            "m.secondTeam.defence.uuid=:uuid")
    List<Match> findByPlayerUuid(String uuid);

    @Query("select m from Match m where m.firstTeam.uuid=:uuid or m.secondTeam.uuid=:uuid")
    List<Match> findByTeamUuid(@Param("uuid") String uuid);

    Match deleteByUuid(String uuid);
}
