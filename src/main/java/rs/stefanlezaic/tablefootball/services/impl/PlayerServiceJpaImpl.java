package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.entity.PlayerEntity;
import rs.stefanlezaic.tablefootball.repository.PlayerRepository;
import rs.stefanlezaic.tablefootball.services.PlayerService;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Primary
public class PlayerServiceJpaImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceJpaImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerEntity> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public PlayerEntity getByUuid(String uuid) {
        return playerRepository.getByUuid(uuid);
    }

//    @Override
//    public PlayerEntity findByUsernameAndPassword(String playerName, String password) {
//        return playerRepository.findByUsernameAndPassword(playerName, password);
//    }
//
//    @Override
//    public PlayerEntity findByEmailAndPassword(String email, String password) {
//        return playerRepository.findByEmailAndPassword(email, password);
//    }

    @Override
    public PlayerEntity save(PlayerEntity playerEntity) {
        playerEntity.setUuid(String.valueOf(UUID.randomUUID()));
        return playerRepository.save(playerEntity);
    }

    @Override
    public PlayerEntity update(PlayerEntity playerEntity) {
        return playerRepository.saveAndFlush(playerEntity);
    }

    @Override
    public PlayerEntity deleteByUuid(String uuid) {
        return playerRepository.deleteByUuid(uuid);
    }
}
