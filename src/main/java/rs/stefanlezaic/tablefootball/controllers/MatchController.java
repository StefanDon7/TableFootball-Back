package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.Match;
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
    public Match getMatch(@PathVariable String uuid) {
        return matchService.getMatch(uuid);
    }

    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/by-user/{uuid}")
    public List<Match> getMatchesByPlayer(@PathVariable String uuid) {
        return matchService.getMatchesByPlayer(uuid);
    }

    @GetMapping("/by-team/{uuid}")
    public List<Match> getMatchesByTeam(@PathVariable String uuid) {
        return matchService.getMatchesByTeam(uuid);
    }

    @PostMapping("/add")
    public Match addPlayer(@RequestBody Match match) {
        return matchService.add(match);
    }

    @PutMapping("/update")
    Match updatePlayer(@RequestBody Match match) {
        return matchService.update(match);
    }

    @DeleteMapping("/delete")
    Match deleteTeam(@RequestBody String uuid) {
        return matchService.delete(uuid);
    }

}
