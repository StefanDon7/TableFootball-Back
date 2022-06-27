package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;
import rs.stefanlezaic.tablefootball.repository.TeamRepository;
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
    public List<TeamEntity> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public TeamEntity getByUuid(String uuid) {
        return teamRepository.getByUuid(uuid);
    }

    @Override
    public TeamEntity findByPlayerUuid(String uuid) {
        return teamRepository.findByPlayerUuid(uuid);
    }

    @Override
    public TeamEntity findTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID) {
        return teamRepository.findTeamByPlayers(firstPlayerUUID, secondPlayerUUID);
    }

    @Override
    public TeamEntity save(TeamEntity teamEntity) {
        teamEntity.setUuid(String.valueOf(UUID.randomUUID()));
        return teamRepository.save(teamEntity);
    }

    @Override
    public TeamEntity update(TeamEntity teamEntity) {
        return teamRepository.saveAndFlush(teamEntity);
    }

    @Override
    public TeamEntity deleteByUuid(String uuid) {
        return teamRepository.deleteByUuid(uuid);
    }
}
