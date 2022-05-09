package rs.stefanlezaic.tablefootball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Team;

import java.util.List;

@Repository
public interface TeamRepository {
    List<Team> getAllTeams();

    Team getTeamByUUID(String uuid);

    Team getTeamByPlayer(String uuid);

    Team getTeamByPlayers(String firstPlayerUUID, String secondPlayerUUID);
}
