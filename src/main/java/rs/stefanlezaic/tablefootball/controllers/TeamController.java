package rs.stefanlezaic.tablefootball.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.stefanlezaic.tablefootball.model.dto.Team;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;
import java.util.Optional;

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
    public Optional<Team> getTeamByUUID(@PathVariable("uuid") String uuid) {
        return teamService.findByUuid(uuid);
    }

    @GetMapping("/by-player/{uuid}")
    public Team getTeamByPlayer(@PathVariable("uuid") String uuid) {
        return teamService.findByPlayerUuid(uuid);
    }

    @GetMapping("/attack/{attackPlayerUuid}/defence/{defencePlayerUuid}")
    public Team getTeamByPlayers(@PathVariable("attackPlayerUuid") String attackPlayerUuid,
                                       @PathVariable("defencePlayerUuid") String defencePlayerUuid) {
        return teamService.findByPlayers(attackPlayerUuid, defencePlayerUuid);
    }

    @PostMapping("/add")
    public Team addPlayer(@RequestBody Team team) {
        return teamService.add(team);
    }

    @PutMapping("/update")
    public Optional<Team> updatePlayer(@RequestBody Team team) {
        return teamService.update(team);
    }

    @DeleteMapping("/delete")
    public Optional<Team> deleteTeam(@RequestBody String uuid) {
        return teamService.removeByUuid(uuid);
    }

}
