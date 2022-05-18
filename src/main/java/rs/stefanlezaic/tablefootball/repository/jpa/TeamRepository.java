package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team getByUuid(String uuid);

    Team deleteByUuid(String uuid);

    @Query("select t from Team t where " +
            "t.attack.uuid=:uuid or " +
            "t.defence.uuid=:uuid")
    Team findByPlayerUuid(@Param("uuid") String uuid);

    @Query("select t from Team t where " +
            "t.attack.uuid=:firstPlayerUUID and " +
            "t.defence.uuid=:secondPlayerUUID")
    Team findTeamByPlayers(@Param("firstPlayerUUID") String firstPlayerUUID, @Param("secondPlayerUUID") String secondPlayerUUID);
}
