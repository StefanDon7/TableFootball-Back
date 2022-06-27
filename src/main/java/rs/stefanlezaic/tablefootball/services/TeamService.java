package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;

import java.util.List;

@Service
public interface TeamService {

    List<TeamEntity> findAll();

    TeamEntity getByUuid(String uuid);

    TeamEntity findByPlayerUuid(String uuid);

    TeamEntity findTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID);

    TeamEntity save(TeamEntity teamEntity);

    TeamEntity update(TeamEntity teamEntity);

    TeamEntity deleteByUuid(String uuid);
}
