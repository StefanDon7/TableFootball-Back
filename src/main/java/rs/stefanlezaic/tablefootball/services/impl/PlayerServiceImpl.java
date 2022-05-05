package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.repository.PlayerRepository;
import rs.stefanlezaic.tablefootball.services.PlayerService;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    }

    @Override
    public Player getPlayerByUUID(String uuid) {
        return playerRepository.getPlayerByUUID(uuid);
    }

    @Override
    public Player getPlayerByUsername(String username, String password) {
        return playerRepository.getPlayerByUsername(username, password);

    }

    @Override
    public Player getPlayerByEmail(String email, String password) {
        return playerRepository.getPlayerByEmail(email, password);
    }

    @Override
    public Player add(Player player) {
        return playerRepository.add(player);
    }

    @Override
    public Player update(Player player) {
        return playerRepository.update(player);
    }

    @Override
    public Player delete(String uuid) {
        return playerRepository.delete(uuid);
    }
}
