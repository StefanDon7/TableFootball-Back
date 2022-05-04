package rs.stefanlezaic.tablefootball.services;

import org.springframework.stereotype.Service;
import rs.stefanlezaic.tablefootball.model.Player;
import rs.stefanlezaic.tablefootball.model.Team;

import java.util.List;

@Service
public interface TeamService {

    List<Team> getAllTeams();

    Team getTeamByUUID(String uuid);

    Team getTeamByPlayer(String uuid);

    Team getTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID);

}
