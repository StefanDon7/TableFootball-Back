package rs.stefanlezaic.tablefootball.services.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.model.Team;
import rs.stefanlezaic.tablefootball.repository.jpa.TeamRepository;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;
import java.util.UUID;

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
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamByUUID(String uuid) {
        return teamRepository.getByUuid(uuid);
    }

    @Override
    public Team getTeamByPlayer(String uuid) {
        return teamRepository.findByPlayerUuid(uuid);
    }

    @Override
    public Team getTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID) {
        return teamRepository.findTeamByPlayers(firstPlayerUUID, secondPlayerUUID);
    }

    @Override
    public Team add(Team team) {
        team.setUuid(String.valueOf(UUID.randomUUID()));
        return teamRepository.save(team);
    }

    @Override
    public Team update(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team delete(String uuid) {
        return teamRepository.deleteByUuid(uuid);
    }
}
