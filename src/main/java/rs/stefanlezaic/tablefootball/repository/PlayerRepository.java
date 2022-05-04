package rs.stefanlezaic.tablefootball.repository;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;

import java.util.List;

@Repository
public interface PlayerRepository {
    List<Player> getAllPlayers();

    Player getPlayerByUUID(String uuid);

    Player getPlayerByUsername(String username, String password);

    Player getPlayerByEmail(String email, String password);

    Player add(Player player);

    Player update(Player player);

    Player delete(String uuid);
}
