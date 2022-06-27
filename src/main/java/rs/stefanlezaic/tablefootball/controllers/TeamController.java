package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;
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
    public List<TeamEntity> getAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{uuid}")
    public TeamEntity getTeamByUUID(@PathVariable("uuid") String uuid) {
        return teamService.getByUuid(uuid);
    }

    @GetMapping("/by-player/{uuid}")
    public TeamEntity getTeamByPlayer(@PathVariable("uuid") String uuid) {
        return teamService.findByPlayerUuid(uuid);
    }

    @GetMapping("/attacker/{attackerUuid}/defender/{defenderUuid}")
    public TeamEntity getTeamByPlayers(@PathVariable("attackerUuid") String attackerUuid,
                                       @PathVariable("defenderUuid") String defenderUuid) {
        return teamService.findTeamByPlayers(attackerUuid, defenderUuid);
    }

    @PostMapping("/add")
    TeamEntity addPlayer(@RequestBody TeamEntity teamEntity) {
        return teamService.save(teamEntity);
    }

    @PutMapping("/update")
    TeamEntity updatePlayer(@RequestBody TeamEntity teamEntity) {
        return teamService.update(teamEntity);
    }

    @DeleteMapping("/delete")
    TeamEntity deleteTeam(@RequestBody String uuid) {
        return teamService.deleteByUuid(uuid);
    }

}
