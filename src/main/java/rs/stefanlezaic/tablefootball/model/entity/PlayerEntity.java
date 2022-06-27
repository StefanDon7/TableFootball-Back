package rs.stefanlezaic.tablefootball.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rs.plusplusnt.fullcircle.common.model.AbstractAuditableEntity;
import rs.plusplusnt.fullcircle.lib.model.FullCircleEntity;
import rs.stefanlezaic.tablefootball.model.dto.Player;

import javax.persistence.*;
import java.util.function.Function;

@Entity
@Table(name = "PLAYER", indexes = {
        @Index(name = "idx_player_uuid", columnList = "UUID"),
        @Index(name = "idx_player_name", columnList = "NAME"),
})
@EntityListeners({AuditingEntityListener.class})
public class PlayerEntity extends AbstractAuditableEntity implements FullCircleEntity<Player> {
    @Id
    @SequenceGenerator(name = "PlayerGen", sequenceName = "PLAYER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "PlayerGen", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "UUID", unique = true, nullable = false)
    private String uuid;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;

    @Column(name = "LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Player getDto() {
        return null;
    }

    @Override
    public FullCircleEntity<Player> update(Player player) {
        return null;
    }

    @Override
    public Player getDto(Function<FullCircleEntity<Player>, Player> extender) {
        return FullCircleEntity.super.getDto(extender);
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
