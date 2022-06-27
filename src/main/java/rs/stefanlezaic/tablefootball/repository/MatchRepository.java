package rs.stefanlezaic.tablefootball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.entity.MatchEntity;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {

    MatchEntity getByUuid(String uuid);

//    @Query("select m from MatchEntity m where " +
//            "m.firstTeam.attack.uuid=:uuid or " +
//            "m.firstTeam.defence.uuid=:uuid or " +
//            "m.secondTeam.attack.uuid=:uuid or " +
//            "m.secondTeam.defence.uuid=:uuid")
    List<MatchEntity> findByPlayerUuid(String uuid);

//    @Query("select m from MatchEntity m where m.firstTeam.uuid=:uuid or m.secondTeam.uuid=:uuid")
    List<MatchEntity> findByTeamUuid(@Param("uuid") String uuid);

    MatchEntity deleteByUuid(String uuid);
}
