package rs.stefanlezaic.tablefootball.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.dto.Match;
import rs.stefanlezaic.tablefootball.model.entity.MatchEntity;

import java.util.List;

@Repository
public interface MatchRepository extends TableFootballRepository<MatchEntity, Long> {

    @Query("select m from MatchEntity m where " +
            "m.firstTeamEntity.attackPlayer.uuid=:uuid or " +
            "m.firstTeamEntity.defencePlayer.uuid=:uuid or " +
            "m.secondTeamEntity.attackPlayer.uuid=:uuid or " +
            "m.secondTeamEntity.defencePlayer.uuid=:uuid")
    List<Match> findByPlayerUuid(String uuid);

    @Query("select m from MatchEntity m where m.firstTeamEntity.uuid=:uuid or m.secondTeamEntity.uuid=:uuid")
    List<Match> findByTeamUuid(@Param("uuid") String uuid);

    Match deleteByUuid(String uuid);
}
