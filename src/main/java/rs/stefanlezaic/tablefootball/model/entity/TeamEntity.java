package rs.stefanlezaic.tablefootball.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rs.plusplusnt.fullcircle.common.model.AbstractAuditableEntity;
import rs.plusplusnt.fullcircle.lib.model.FullCircleEntity;
import rs.stefanlezaic.tablefootball.model.dto.Team;

import javax.persistence.*;
import java.util.function.Function;

@Entity
@Table(name = "TEAM", indexes = {
        @Index(name = "idx_team_uuid", columnList = "UUID"),
        @Index(name = "idx_team_name", columnList = "NAME"),
})
@EntityListeners({AuditingEntityListener.class})
public class TeamEntity extends AbstractAuditableEntity implements FullCircleEntity<Team> {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;

    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "attack", referencedColumnName = "id")
    private PlayerEntity attackPlayer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "defence", referencedColumnName = "id")
    private PlayerEntity defencePlayer;


    public TeamEntity(Team team) {
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Team getDto() {
        return null;
    }

    @Override
    public FullCircleEntity<Team> update(Team team) {
        return null;
    }

    @Override
    public Team getDto(Function<FullCircleEntity<Team>, Team> extender) {
        return FullCircleEntity.super.getDto(extender);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
