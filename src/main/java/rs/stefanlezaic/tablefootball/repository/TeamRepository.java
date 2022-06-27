package rs.stefanlezaic.tablefootball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

    TeamEntity getByUuid(String uuid);

    TeamEntity deleteByUuid(String uuid);

//    @Query("select t from TeamEntity t where " +
//            "t.attack.uuid=:uuid or " +
//            "t.defence.uuid=:uuid")
    TeamEntity findByPlayerUuid(@Param("uuid") String uuid);

//    @Query("select t from TeamEntity t where " +
//            "t.attack.uuid=:firstPlayerUUID and " +
//            "t.defence.uuid=:secondPlayerUUID")
    TeamEntity findTeamByPlayers(@Param("firstPlayerUUID") String firstPlayerUUID, @Param("secondPlayerUUID") String secondPlayerUUID);
}
