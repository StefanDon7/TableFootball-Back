package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.plusplusnt.fullcircle.lib.services.BaseEntityService;
import rs.stefanlezaic.tablefootball.model.dto.Match;

import java.util.List;

@Service
public interface MatchService extends BaseEntityService<Match> {

    List<Match> getAll();

    List<Match> findByPlayerUuid(String uuid);

    List<Match> findByTeamUuid(String uuid);

}
