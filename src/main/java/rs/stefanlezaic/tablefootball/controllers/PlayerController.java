package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

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
}
