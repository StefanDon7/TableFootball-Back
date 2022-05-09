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
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerByUUID(String uuid) {
        return playerRepository.findByUuid(uuid);
    }

    @Override
    public Player getPlayerByUsername(String username, String password) {
        return playerRepository.findByUsernameAndPassword(username, password);

    }

    @Override
    public Player getPlayerByEmail(String email, String password) {
        return playerRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Player add(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player delete(String uuid) {
        return playerRepository.deleteByUuid(uuid);
    }
}
