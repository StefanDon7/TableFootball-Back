package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Player;

import java.util.List;

@Service
public interface PlayerService {
    List<Player> findAll();

    Player getByUuid(String uuid);

    Player findByUsernameAndPassword(String playerName, String password);

    Player findByEmailAndPassword(String email, String password);

    Player save(Player player);

    Player update(Player player);

    Player deleteByUuid(String uuid);
}
