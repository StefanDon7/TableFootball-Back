package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Player;

import java.util.List;

@Service
public interface PlayerService {
    List<Player> getAllPlayers();

    Player getPlayerByUUID(String uuid);

    Player getPlayerByUsername(String username, String password);

    Player getPlayerByEmail(String email, String password);

    Player add(Player player);

    Player update(Player player);

    Player delete(String uuid);
}
