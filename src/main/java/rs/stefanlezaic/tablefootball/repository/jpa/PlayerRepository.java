package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player getByUuid(String uuid);

    @Query(value = "select p from Player p where p.playerName=:playerName and password=?2")
    Player findByUsernameAndPassword(@Param("playerName") String playerName, @Param("password") String password);

    @Query(value = "select * from player where email=?1 and password=?2", nativeQuery = true)
    Player findByEmailAndPassword(String email, String password);

    Player deleteByUuid(String uuid);
}
