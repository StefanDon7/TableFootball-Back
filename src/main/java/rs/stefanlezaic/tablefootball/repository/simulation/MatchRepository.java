package rs.stefanlezaic.tablefootball.repository.simulation;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;

@Repository
public interface MatchRepository {

    Match getMatch(String uuid);

    List<Match> getAllMatches();

    List<Match> getMatchesByUser(String uuid);

    List<Match> getMatchesByTeam(String uuid);

    Match add(Match match);

    Match update(Match match);

    Match delete(String uuid);

}
