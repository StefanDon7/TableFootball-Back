package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.entity.PlayerEntity;
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
    List<PlayerEntity> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping("/{uuid}")
    public PlayerEntity getPlayerByUUID(@PathVariable String uuid) {
        return playerService.getByUuid(uuid);
    }

//    @PostMapping("/by-email")
//    public PlayerEntity getPlayerByUUID(@RequestBody PlayerEntity playerEntity) {
//        return playerService.findByEmailAndPassword(playerEntity.getEmail(), playerEntity.getPassword());
//    }
//
//    @PostMapping("/by-name")
//    public PlayerEntity getPlayerByPlayerName(@RequestBody PlayerEntity playerEntity) {
//        return playerService.findByUsernameAndPassword(playerEntity.getName(), playerEntity.getPassword());
//    }

    @PostMapping("/add")
    public PlayerEntity addPlayer(@RequestBody PlayerEntity playerEntity) {
        return playerService.save(playerEntity);
    }

    @PutMapping("/update")
    public PlayerEntity updatePlayer(@RequestBody PlayerEntity playerEntity) {
        return playerService.update(playerEntity);
    }

    @DeleteMapping("/delete")
    public PlayerEntity deletePlayer(@RequestBody String uuid) {
        return playerService.deleteByUuid(uuid);
    }
}
