package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.dto.Match;
import rs.stefanlezaic.tablefootball.model.entity.MatchEntity;
import rs.stefanlezaic.tablefootball.repository.MatchRepository;
import rs.stefanlezaic.tablefootball.services.MatchService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Primary
public class MatchServiceImpl implements MatchService {

    private final MatchRepository repository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.repository = matchRepository;
    }

    @Override
    public Optional<Match> findByUuid(String uuid) {
        return repository.findByUuid(uuid).map(MatchEntity::getDto);
    }

    @Override
    public List<Match> getAll() {
        return repository.findAll().stream().map(MatchEntity::getDto).collect(Collectors.toList());
    }


    @Override
    public List<Match> findByPlayerUuid(String uuid) {
        return null;
    }

    @Override
    public List<Match> findByTeamUuid(String uuid) {
        return null;
    }


    @Override
    public Match add(Match match) {
        MatchEntity entity = new MatchEntity(match);
        return repository.save(entity).getDto();
    }

    @Override
    public Optional<Match> update(Match match) {
        return repository.findByUuid(match.getUuid()).map(entity -> {
            entity.update(match);
            return repository.save(entity).getDto();
        });
    }

    @Override
    public Optional<Match> removeByUuid(String uuid) {
        return repository.findByUuid(uuid).map(matchEntity -> {
            repository.delete(matchEntity);
            return matchEntity.getDto();
        });
    }
}


