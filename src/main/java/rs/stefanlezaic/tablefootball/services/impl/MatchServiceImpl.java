package rs.stefanlezaic.tablefootball.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.repository.MatchRepository;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.services.MatchService;

import java.util.List;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Match getMatch(String uuid) {
        return matchRepository.getMatch(uuid);
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.getAllMatches();
    }

    @Override
    public List<Match> getMatchesByUser(String uuid) {
        return matchRepository.getMatchesByUser(uuid);
    }

    @Override
    public List<Match> getMatchesByTeam(String uuid) {
        return null;
    }
}
