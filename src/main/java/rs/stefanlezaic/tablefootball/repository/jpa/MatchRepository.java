package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "select * from match where uuid=?1", nativeQuery = true)
    Match getByUuid(String uuid);

    @Query(value = "select * from match where teamId in select * from team where  ", nativeQuery = true)
    List<Match> findByPlayerUuid(String uuid);

    List<Match> findByTeamUuid(String uuid);

    Match deleteByUuid(String uuid);
}
