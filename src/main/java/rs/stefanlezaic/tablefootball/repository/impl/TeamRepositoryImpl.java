package rs.stefanlezaic.tablefootball.repository.impl;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.repository.TeamRepository;

import java.util.LinkedList;
import java.util.List;

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
}
