package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.services.MatchService;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/{uuid}")
    public Match getMatch(@PathVariable String uuid) {
        return matchService.getMatch(uuid);
    }

    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping("/by-user/{uuid}")
    List<Match> getMatchesByUser(@PathVariable String uuid) {
        return matchService.getMatchesByUser(uuid);
    }
}
