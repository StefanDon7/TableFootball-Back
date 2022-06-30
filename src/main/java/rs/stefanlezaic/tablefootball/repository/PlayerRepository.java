package rs.stefanlezaic.tablefootball.repository;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.entity.PlayerEntity;

@Repository
public interface PlayerRepository extends TableFootballRepository<PlayerEntity, Long> {

    PlayerEntity getByUuid(String uuid);

    PlayerEntity deleteByUuid(String uuid);
}
