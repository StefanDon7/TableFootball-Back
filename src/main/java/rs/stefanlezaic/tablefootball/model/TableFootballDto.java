package rs.stefanlezaic.tablefootball.model;

import org.immutables.value.Value;

import java.util.UUID;

public interface TableFootballDto {
    @Value.Default
    default Long getId() {
        return 0L;
    }

    @Value.Default
    default String getUuid() {
        return UUID.randomUUID().toString();
    }

}
