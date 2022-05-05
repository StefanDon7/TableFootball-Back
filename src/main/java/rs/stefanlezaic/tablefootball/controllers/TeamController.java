package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{uuid}")
    public Team getTeamByUUID(@PathVariable("uuid") String uuid) {
        return teamService.getTeamByUUID(uuid);
    }

    @GetMapping("/by-player/{uuid}")
    public Team getTeamByPlayer(@PathVariable("uuid") String uuid) {
        return teamService.getTeamByPlayer(uuid);
    }

    @GetMapping("/attacker/{attackerUuid}/defender/{defenderUuid}")
    public Team getTeamByPlayers(@PathVariable("attackerUuid") String attackerUuid,
                                 @PathVariable("defenderUuid") String defenderUuid) {
        return teamService.getTeamByPlayers(attackerUuid, defenderUuid);
    }

    @PostMapping("/add")
    Team addPlayer(@RequestBody Team team) {
        return teamService.add(team);
    }

    @PutMapping("/update")
    Team updatePlayer(@RequestBody Team team) {
        return teamService.update(team);
    }

    @DeleteMapping("/delete")
    Team deleteTeam(@RequestBody String uuid) {
        return teamService.delete(uuid);
    }

}
