package rs.stefanlezaic.tablefootball.repository.simulation.impl;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.repository.simulation.TeamRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeamRepositoryImpl implements TeamRepository {

    private List<Team> teams;

    public TeamRepositoryImpl() {
        this.teams = new LinkedList<>();
    }

    @Override
    public List<Team> getAllTeams() {
        return teams;
    }

    @Override
    public Team getTeamByUUID(String uuid) {
        return teams.stream().filter(team -> team.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public Team getTeamByPlayer(String uuid) {
        return teams.stream().filter(team ->
                team.getAttack().getUuid().equals(uuid)
                        || team.getDefence().getUuid().equals(uuid)
        ).findFirst().orElse(null);
    }

    @Override
    public Team getTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID) {
        return teams.stream().filter(team ->
                team.getAttack().getUuid().equals(firstPlayerUUID)
                        || team.getDefence().getUuid().equals(secondPlayerUUID)
        ).findFirst().orElse(null);
    }

    @Override
    public Team add(Team team) {
        teams.add(team);
        return team;
    }

    @Override
    public Team update(Team team) {
        teams.stream().filter(item -> item.getUuid().equals(team.getUuid())).findFirst().ifPresent(t -> {
            teams = teams.stream().filter(item -> item.getUuid().equals(team.getUuid())).collect(Collectors.toList());
            int index = teams.indexOf(t);
            teams.add(index, team);
        });
        return team;
    }

    @Override
    public Team delete(String uuid) {
        Team fined = teams.stream().filter(item -> item.getUuid().equals(uuid)).findFirst().orElse(null);
        teams = teams.stream().filter(item -> !item.getUuid().equals(uuid)).collect(Collectors.toList());
        return fined;
    }
}
