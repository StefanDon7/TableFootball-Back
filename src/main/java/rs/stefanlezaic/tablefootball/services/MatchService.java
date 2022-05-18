package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;

@Service
public interface MatchService {
    Match getMatch(String uuid);

    List<Match> getAllMatches();

    List<Match> getMatchesByPlayer(String uuid);

    List<Match> getMatchesByTeam(String uuid);

    Match add(Match match);

    Match update(Match match);

    Match delete(String uuid);
}
