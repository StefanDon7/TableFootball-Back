package rs.stefanlezaic.tablefootball.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.serial.Serial;
import org.immutables.value.Value;
import rs.stefanlezaic.tablefootball.model.TableFootballDto;

import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableTeam.class)
@JsonDeserialize(as = ImmutableTeam.class)
@Serial.Version(20220524121855744L)
public interface Team extends TableFootballDto {
    String getName();

    Optional<Player> getDefencePlayer();

    Optional<String> getDefencePlayerUuid();

    Optional<Player> getAttackPlayer();

    Optional<String> getAttackPlayerUuid();

}
