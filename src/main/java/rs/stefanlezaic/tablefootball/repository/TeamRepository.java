package rs.stefanlezaic.tablefootball.repository;

import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Match;
import rs.stefanlezaic.tablefootball.model.Team;

import java.util.List;

@Repository
public interface TeamRepository {
    List<Team> getAllTeams();

    Team getTeamByUUID(String uuid);

    Team getTeamByPlayer(String uuid);

    Team getTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID);

    Team add(Team team);

    Team update(Team team);

    Team delete(String uuid);
}
