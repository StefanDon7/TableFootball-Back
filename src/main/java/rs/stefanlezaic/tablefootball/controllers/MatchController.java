package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.dto.Match;
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

//    @GetMapping("/{uuid}")
//    public Match getByUuid(@PathVariable String uuid) {
//        return matchService.getByUuid(uuid);
//    }
//
//    @GetMapping("/all")
//    public List<Match> findAll() {
//        return matchService.findAll();
//    }
//
//    @GetMapping("/by-player/{uuid}")
//    public List<Match> findByPlayerUuid(@PathVariable String uuid) {
//        return matchService.findByPlayerUuid(uuid);
//    }
//
//    @GetMapping("/by-team/{uuid}")
//    public List<Match> findByTeamUuid(@PathVariable String uuid) {
//        return matchService.findByTeamUuid(uuid);
//    }
//
//    @PostMapping("/add")
//    public Match save(@RequestBody Match match) {
//        return matchService.save(match);
//    }
//
//    @PutMapping("/update")
//    Match update(@RequestBody MatchEntity match) {
//        return matchService.update(match);
//    }
//
//    @DeleteMapping("/deleteByUuid")
//    Match deleteByUuid(@RequestBody String uuid) {
//        return matchService.deleteByUuid(uuid);
//    }

}
