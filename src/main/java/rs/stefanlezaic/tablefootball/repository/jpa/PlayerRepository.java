package rs.stefanlezaic.tablefootball.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "select * from player where uuid=?1", nativeQuery = true)
    Player findByUuid(String uuid);

    @Query(value = "select * from player where username=?1 and password=?2", nativeQuery = true)
    Player findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from player where email=?1 and password=?2", nativeQuery = true)
    Player findByEmailAndPassword(String email, String password);

    @Query(value = "delete from player where uuid=?1", nativeQuery = true)
    Player deleteByUuid(String uuid);
}
