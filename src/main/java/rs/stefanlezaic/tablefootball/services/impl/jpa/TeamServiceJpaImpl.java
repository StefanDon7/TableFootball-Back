package rs.stefanlezaic.tablefootball.services.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.repository.simulation.TeamRepository;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;

@Service
@Transactional
@Primary
public class TeamServiceJpaImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceJpaImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

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

    @Override
    public Team add(Team team) {
        return teamRepository.add(team);
    }

    @Override
    public Team update(Team team) {
        return teamRepository.update(team);
    }

    @Override
    public Team delete(String uuid) {
        return teamRepository.delete(uuid);
    }
}
