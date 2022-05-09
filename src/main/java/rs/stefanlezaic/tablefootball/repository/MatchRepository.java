package rs.stefanlezaic.tablefootball.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Match;

import java.util.List;

@Repository
public interface MatchRepository{
    Match getMatch(String uuid);

    List<Match> getAllMatches();

    List<Match> getMatchesByUser(String uuid);

    List<Match> getMatchesByTeam(String uuid);
}
