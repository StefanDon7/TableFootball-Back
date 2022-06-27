package rs.stefanlezaic.tablefootball.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.serial.Serial;
import org.immutables.value.Value;
import rs.stefanlezaic.tablefootball.model.TableFootballDto;


@Value.Immutable
@JsonSerialize(as = ImmutablePlayer.class)
@JsonDeserialize(as = ImmutablePlayer.class)
@Serial.Version(20220524121855744L)
public interface Player extends TableFootballDto {

    String getFirstName();

    String getLastName();

    String getName();

    String getEmail();

}
