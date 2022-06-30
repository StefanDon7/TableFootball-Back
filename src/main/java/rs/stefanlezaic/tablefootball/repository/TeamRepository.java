package rs.stefanlezaic.tablefootball.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;

@Repository
public interface TeamRepository extends TableFootballRepository<TeamEntity, Long> {

    TeamEntity getByUuid(String uuid);

    TeamEntity deleteByUuid(String uuid);

    @Query("select t from TeamEntity t where " +
            "t.attackPlayer.uuid=:uuid or " +
            "t.defencePlayer.uuid=:uuid")
    TeamEntity findByPlayerUuid(@Param("uuid") String uuid);

    @Query("select t from TeamEntity t where " +
            "t.attackPlayer.uuid=:attackPlayerUuid and " +
            "t.defencePlayer.uuid=:defencePlayerUuid")
    TeamEntity findTeamByPlayers(@Param("attackPlayerUuid") String attackPlayerUuid, @Param("defencePlayerUuid") String defencePlayerUuid);
}
