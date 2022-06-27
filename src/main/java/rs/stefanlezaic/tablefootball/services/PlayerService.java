package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.entity.PlayerEntity;

import java.util.List;

@Service
public interface PlayerService {
    List<PlayerEntity> findAll();

    PlayerEntity getByUuid(String uuid);

    PlayerEntity save(PlayerEntity playerEntity);

    PlayerEntity update(PlayerEntity playerEntity);

    PlayerEntity deleteByUuid(String uuid);
}
