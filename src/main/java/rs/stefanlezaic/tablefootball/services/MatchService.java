package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.entity.MatchEntity;

import java.util.List;

@Service
public interface MatchService {
    MatchEntity getByUuid(String uuid);

    List<MatchEntity> findAll();

    List<MatchEntity> findByPlayerUuid(String uuid);

    List<MatchEntity> findByTeamUuid(String uuid);

    MatchEntity save(MatchEntity matchEntity);

    MatchEntity update(MatchEntity matchEntity);

    MatchEntity deleteByUuid(String uuid);
}
