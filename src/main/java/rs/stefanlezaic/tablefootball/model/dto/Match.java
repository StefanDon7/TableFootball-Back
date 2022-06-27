package rs.stefanlezaic.tablefootball.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.serial.Serial;
import org.immutables.value.Value;
import rs.stefanlezaic.tablefootball.model.TableFootballDto;

@Value.Immutable
@JsonSerialize(as = ImmutableMatch.class)
@JsonDeserialize(as = ImmutableMatch.class)
@Serial.Version(20220524121855744L)
public interface Match extends TableFootballDto {
    String getName();

    Team getFirstTeam();

    Team getSecondTeam();

    int getFirstTeamGoal();

    int getSecondTeamGoal();
}
