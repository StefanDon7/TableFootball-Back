package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.entity.MatchEntity;
import rs.stefanlezaic.tablefootball.services.MatchService;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{uuid}")
    public MatchEntity getByUuid(@PathVariable String uuid) {
        return matchService.getByUuid(uuid);
    }

    @GetMapping("/all")
    public List<MatchEntity> findAll() {
        return matchService.findAll();
    }

    @GetMapping("/by-player/{uuid}")
    public List<MatchEntity> findByPlayerUuid(@PathVariable String uuid) {
        return matchService.findByPlayerUuid(uuid);
    }

    @GetMapping("/by-team/{uuid}")
    public List<MatchEntity> findByTeamUuid(@PathVariable String uuid) {
        return matchService.findByTeamUuid(uuid);
    }

    @PostMapping("/add")
    public MatchEntity save(@RequestBody MatchEntity matchEntity) {
        return matchService.save(matchEntity);
    }

    @PutMapping("/update")
    MatchEntity update(@RequestBody MatchEntity matchEntity) {
        return matchService.update(matchEntity);
    }

    @DeleteMapping("/deleteByUuid")
    MatchEntity deleteByUuid(@RequestBody String uuid) {
        return matchService.deleteByUuid(uuid);
    }

}
