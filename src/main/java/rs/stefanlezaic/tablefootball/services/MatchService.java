package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;
@Service
public interface MatchService {
    Match getMatch(String uuid);
    List<Match> getAllMatches();
    List<Match> getMatchesByUser(String uuid);
    List<Match> getMatchesByTeam(String uuid);
}
