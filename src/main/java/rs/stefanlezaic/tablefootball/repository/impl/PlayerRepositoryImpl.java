package rs.stefanlezaic.tablefootball.repository.impl;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.repository.PlayerRepository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new LinkedList<>();
    }

    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    @Override
    public Player getPlayerByUUID(String uuid) {
        return players.stream().filter(player -> player.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public Player getPlayerByUsername(String username, String password) {
        return players.stream().filter(player -> player.getUuid().equals(username) && player.getPassword().equals(password)).findFirst().orElse(null);
    }

    @Override
    public Player getPlayerByEmail(String email, String password) {
        return players.stream().filter(player -> player.getUuid().equals(email) && player.getPassword().equals(password)).findFirst().orElse(null);
    }
}
