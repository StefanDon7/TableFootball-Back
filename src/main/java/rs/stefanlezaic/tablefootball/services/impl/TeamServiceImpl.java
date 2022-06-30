package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.dto.Team;
import rs.stefanlezaic.tablefootball.repository.TeamRepository;
import rs.stefanlezaic.tablefootball.services.TeamService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Primary
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public List<Team> findAll() {
        return null;
    }

    @Override
    public Team findByPlayerUuid(String uuid) {
        return null;
    }

    @Override
    public Team findByPlayers(String attackPlayerUuid, String defencePlayerUuid) {
        return null;
    }

    @Override
    public Optional<Team> findByUuid(String s) {
        return Optional.empty();
    }

    @Override
    public Team add(Team team) {
        return null;
    }

    @Override
    public Optional<Team> update(Team team) {
        return Optional.empty();
    }

    @Override
    public Optional<Team> removeByUuid(String s) {
        return Optional.empty();
    }
}
