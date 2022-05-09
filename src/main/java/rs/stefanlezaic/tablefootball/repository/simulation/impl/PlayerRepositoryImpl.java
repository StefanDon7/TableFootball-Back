package rs.stefanlezaic.tablefootball.repository.simulation.impl;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.repository.simulation.PlayerRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new LinkedList<>();
    }

    @Override
    public List<Player> getAllPlayers() {
        System.out.println("List players:" + players);
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

    @Override
    public Player add(Player player) {
        players.add(player);
        return player;
    }

    @Override
    public Player update(Player player) {
        players.stream().filter(item -> item.getUuid().equals(player.getUuid())).findFirst().ifPresent(p -> {
            players = players.stream().filter(item -> item.getUuid().equals(player.getUuid())).collect(Collectors.toList());
            int index = players.indexOf(p);
            players.add(index, player);
        });
        return player;
    }

    @Override
    public Player delete(String uuid) {
        Player fined = players.stream().filter(item -> item.getUuid().equals(uuid)).findFirst().orElse(null);
        players = players.stream().filter(item -> !item.getUuid().equals(uuid)).collect(Collectors.toList());
        return fined;
    }
}
