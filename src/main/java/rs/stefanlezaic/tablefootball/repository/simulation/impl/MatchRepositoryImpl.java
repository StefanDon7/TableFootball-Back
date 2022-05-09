package rs.stefanlezaic.tablefootball.repository.simulation.impl;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.repository.simulation.MatchRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MatchRepositoryImpl implements MatchRepository {

    private List<Match> matches;

    public MatchRepositoryImpl() {
        matches = new LinkedList<>();
    }

    @Override
    public Match getMatch(String uuid) {
        return matches.stream().filter(match -> match.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public List<Match> getAllMatches() {
        return matches;
    }

    @Override
    public List<Match> getMatchesByUser(String uuid) {
        return matches.stream().filter(match ->
                match.getFirstTeam().getAttack().getUuid().equals(uuid)
                        || match.getFirstTeam().getDefence().getUuid().equals(uuid)
                        || match.getSecondTeam().getAttack().getUuid().equals(uuid)
                        || match.getSecondTeam().getDefence().getUuid().equals(uuid)
        ).collect(Collectors.toList());
    }

    @Override
    public List<Match> getMatchesByTeam(String uuid) {
        return matches.stream().filter(
                match -> match.getFirstTeam().getUuid().equals(uuid)
                        || match.getSecondTeam().getUuid().equals(uuid)
        ).collect(Collectors.toList());

    }

    @Override
    public Match add(Match match) {
        matches.add(match);
        return match;
    }

    @Override
    public Match update(Match match) {
        return matches.stream().filter(item -> item.getUuid().equals(match.getUuid())).findFirst().map(exisingMatch -> {
            exisingMatch.setFirstTeamGoal(match.getFirstTeamGoal());
            exisingMatch.setSecondTeamGoal(match.getSecondTeamGoal());
            return exisingMatch;
        }).orElse(null);
    }

    @Override
    public Match delete(String uuid) {
        Match finedMatch = matches.stream().filter(item -> item.getUuid().equals(uuid)).findFirst().orElse(null);
        matches = matches.stream().filter(item -> !item.getUuid().equals(uuid)).collect(Collectors.toList());
        return finedMatch;
    }
}
