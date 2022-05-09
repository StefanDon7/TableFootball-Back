package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{uuid}")
    Player getPlayerByUUID(@PathVariable String uuid) {
        return playerService.getPlayerByUUID(uuid);
    }

    @PostMapping("/by-email")
    Player getPlayerByUUID(@RequestBody Player player) {
        return playerService.getPlayerByEmail(player.getEmail(), player.getPassword());
    }

    @PostMapping("/by-name")
    Player getPlayerByPlayerName(@RequestBody Player player) {
        return playerService.getPlayerByUsername(player.getPlayerName(), player.getPassword());
    }

    @PostMapping("/add")
    Player addPlayer(@RequestBody Player player) {
        return playerService.add(player);
    }

    @PutMapping("/update")
    Player updatePlayer(@RequestBody Player player) {
        return playerService.update(player);
    }

    @DeleteMapping("/delete")
    Player deletePlayer(@RequestBody String uuid) {
        return playerService.delete(uuid);
    }
}
