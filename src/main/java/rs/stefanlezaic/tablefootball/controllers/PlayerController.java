package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.dto.Player;
import rs.stefanlezaic.tablefootball.model.entity.PlayerEntity;
import rs.stefanlezaic.tablefootball.services.PlayerService;


import java.util.List;
import java.util.Optional;

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
        return playerService.findAll();
    }

    @GetMapping("/{uuid}")
    public Optional<Player> getPlayerByUUID(@PathVariable String uuid) {
        return playerService.findByUuid(uuid);
    }


    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.add(player);
    }

    @PutMapping("/update")
    public Optional<Player> updatePlayer(@RequestBody Player player) {
        return playerService.update(player);
    }

    @DeleteMapping("/delete")
    public Optional<Player> deletePlayer(@RequestBody String uuid) {
        return playerService.removeByUuid(uuid);
    }
}
