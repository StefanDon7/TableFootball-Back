package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.repository.MatchRepository;

import java.util.List;

public class MatchServiceImpl implements rs.stefanlezaic.tablefootball.services.MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Match getMatch(String uuid) {
        return null;
    }

    @Override
    public List<Match> getAll() {
        return null;
    }

    @Override
    public List<Match> getMatchByUser(String uuid) {
        return null;
    }

    @Override
    public List<Match> getMatchByTeam(String uuid) {
        return null;
    }
}
