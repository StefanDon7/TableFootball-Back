package rs.stefanlezaic.tablefootball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.stefanlezaic.tablefootball.model.entity.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

    PlayerEntity getByUuid(String uuid);

//    @Query(value = "select p from PlayerEntity p where p.playerName=:playerName and p.password=:password")
    PlayerEntity findByUsernameAndPassword(@Param("playerName") String playerName, @Param("password") String password);

//    @Query(value = "select p from PlayerEntity p where p.email=:email and p.password=:password")
    PlayerEntity findByEmailAndPassword(String email, String password);

    PlayerEntity deleteByUuid(String uuid);
}
