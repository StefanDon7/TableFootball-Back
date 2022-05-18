package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.model.Team;

import java.util.List;

@Service
public interface TeamService {

    List<Team> findAll();

    Team getByUuid(String uuid);

    Team findByPlayerUuid(String uuid);

    Team findTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID);

    Team save(Team team);

    Team update(Team team);

    Team deleteByUuid(String uuid);
}
