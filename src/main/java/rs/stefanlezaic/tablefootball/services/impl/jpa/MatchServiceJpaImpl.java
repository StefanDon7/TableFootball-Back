package rs.stefanlezaic.tablefootball.services.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.repository.jpa.MatchRepository;
import rs.stefanlezaic.tablefootball.services.MatchService;

import java.util.List;

@Service
@Transactional
@Primary
public class MatchServiceJpaImpl implements MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceJpaImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match getMatch(String uuid) {
        return matchRepository.getByUuid(uuid);
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public List<Match> getMatchesByPlayer(String uuid) {
        return matchRepository.findByPlayerUuid(uuid);
    }

    @Override
    public List<Match> getMatchesByTeam(String uuid) {
        return matchRepository.findByTeamUuid(uuid);
    }

    @Override
    public Match add(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match update(Match match) {
        return matchRepository.saveAndFlush(match);
    }

    @Override
    public Match delete(String uuid) {
        return matchRepository.deleteByUuid(uuid);
    }
}
