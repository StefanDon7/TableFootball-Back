package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{uuid}")
    public Team getTeamByUUID(@PathVariable("uuid") String uuid) {
        return teamService.getByUuid(uuid);
    }

    @GetMapping("/by-player/{uuid}")
    public Team getTeamByPlayer(@PathVariable("uuid") String uuid) {
        return teamService.findByPlayerUuid(uuid);
    }

    @GetMapping("/attacker/{attackerUuid}/defender/{defenderUuid}")
    public Team getTeamByPlayers(@PathVariable("attackerUuid") String attackerUuid,
                                 @PathVariable("defenderUuid") String defenderUuid) {
        return teamService.findTeamByPlayers(attackerUuid, defenderUuid);
    }

    @PostMapping("/add")
    Team addPlayer(@RequestBody Team team) {
        return teamService.save(team);
    }

    @PutMapping("/update")
    Team updatePlayer(@RequestBody Team team) {
        return teamService.update(team);
    }

    @DeleteMapping("/delete")
    Team deleteTeam(@RequestBody String uuid) {
        return teamService.deleteByUuid(uuid);
    }

}
