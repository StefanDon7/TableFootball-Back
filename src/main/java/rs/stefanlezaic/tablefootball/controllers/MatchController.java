package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.services.MatchService;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public Match getMatch(String uuid) {
        return this.matchService.getMatch(uuid);
    }

}
