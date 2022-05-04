package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.repository.TeamRepository;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.getAllTeams();
    }

    @Override
    public Team getTeamByUUID(String uuid) {
        return teamRepository.getTeamByUUID(uuid);
    }

    @Override
    public Team getTeamByPlayer(String uuid) {
        return teamRepository.getTeamByPlayer(uuid);
    }

    @Override
    public Team getTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID) {
        return teamRepository.getTeamByPlayers(firstPlayerUUID, secondPlayerUUID);
    }

    public Team add(Team team) {
        return teamRepository.add(team);
    }

    public Team update(Team team) {
        return teamRepository.update(team);
    }

    public Team delete(String uuid) {
        return teamRepository.delete(uuid);
    }
}
