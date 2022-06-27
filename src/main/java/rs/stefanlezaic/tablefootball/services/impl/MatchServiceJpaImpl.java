package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.entity.MatchEntity;
import rs.stefanlezaic.tablefootball.repository.MatchRepository;
import rs.stefanlezaic.tablefootball.services.MatchService;

import java.util.List;

@Service
@Transactional
@Primary
public class MatchServiceJpaImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceJpaImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public MatchEntity getByUuid(String uuid) {
        return matchRepository.getByUuid(uuid);
    }

    @Override
    public List<MatchEntity> findAll() {
        return matchRepository.findAll();
    }

    @Override
    public List<MatchEntity> findByPlayerUuid(String uuid) {
        return matchRepository.findByPlayerUuid(uuid);
    }

    @Override
    public List<MatchEntity> findByTeamUuid(String uuid) {
        return matchRepository.findByTeamUuid(uuid);
    }

    @Override
    public MatchEntity save(MatchEntity matchEntity) {
//        matchEntity.setUuid(String.valueOf(UUID.randomUUID()));
        return matchRepository.save(matchEntity);
    }

    @Override
    public MatchEntity update(MatchEntity matchEntity) {
        return matchRepository.saveAndFlush(matchEntity);
    }

    @Override
    public MatchEntity deleteByUuid(String uuid) {
        return matchRepository.deleteByUuid(uuid);
    }
}
