package rs.stefanlezaic.tablefootball.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.immutables.serial.Serial;

import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableTableFootballFilter.class)
@JsonDeserialize(as = ImmutableTableFootballFilter.class)
@Serial.Version(20220524160038857L)
public interface TableFootballFilter {
    Optional<String> getName();
}
