package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player getByUuid(String uuid);

    @Query(value = "select p from Player p where p.playerName=:playerName and p.password=:password")
    Player findByUsernameAndPassword(@Param("playerName") String playerName, @Param("password") String password);

    @Query(value = "select p from Player p where p.email=:email and p.password=:password")
    Player findByEmailAndPassword(String email, String password);

    Player deleteByUuid(String uuid);
}
