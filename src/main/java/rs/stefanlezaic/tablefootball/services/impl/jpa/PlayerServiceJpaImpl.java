package rs.stefanlezaic.tablefootball.services.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.repository.jpa.MatchRepository;
import rs.stefanlezaic.tablefootball.repository.jpa.PlayerRepository;
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
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player getByUuid(String uuid) {
        return playerRepository.getByUuid(uuid);
    }

    @Override
    public Player findByUsernameAndPassword(String playerName, String password) {
        return playerRepository.findByUsernameAndPassword(playerName, password);
    }

    @Override
    public Player findByEmailAndPassword(String email, String password) {
        return playerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Player save(Player player) {
        player.setUuid(String.valueOf(UUID.randomUUID()));
        return playerRepository.save(player);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.saveAndFlush(player);
    }

    @Override
    public Player deleteByUuid(String uuid) {
        return playerRepository.deleteByUuid(uuid);
    }
}
