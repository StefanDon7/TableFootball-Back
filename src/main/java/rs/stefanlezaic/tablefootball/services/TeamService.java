package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.plusplusnt.fullcircle.lib.services.BaseEntityService;
import rs.stefanlezaic.tablefootball.model.dto.Team;
import rs.stefanlezaic.tablefootball.model.entity.TeamEntity;

import java.util.List;

@Service
public interface TeamService extends BaseEntityService<Team> {

    List<Team> findAll();

    Team findByPlayerUuid(String uuid);

    Team findByPlayers(String attackPlayerUuid, String defencePlayerUuid);

}
