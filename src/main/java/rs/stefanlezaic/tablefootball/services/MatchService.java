package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;

@Service
public interface MatchService {
    Match getByUuid(String uuid);

    List<Match> findAll();

    List<Match> findByPlayerUuid(String uuid);

    List<Match> findByTeamUuid(String uuid);

    Match save(Match match);

    Match update(Match match);

    Match deleteByUuid(String uuid);
}
