package rs.stefanlezaic.tablefootball.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rs.plusplusnt.fullcircle.common.model.AbstractAuditableEntity;
import rs.plusplusnt.fullcircle.lib.model.FullCircleEntity;
import rs.stefanlezaic.tablefootball.model.dto.ImmutableMatch;
import rs.stefanlezaic.tablefootball.model.dto.Match;

import javax.persistence.*;
import java.util.function.Function;

@Entity
@Table(name = "MATCH", indexes = {
        @Index(name = "idx_match_uuid", columnList = "UUID"),
        @Index(name = "idx_match_name", columnList = "NAME"),
})
@EntityListeners({AuditingEntityListener.class})
public class MatchEntity extends AbstractAuditableEntity implements FullCircleEntity<Match> {

    @Id
    @SequenceGenerator(name = "MatchGen", sequenceName = "MATCH_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "MatchGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "firstTeamId", referencedColumnName = "id")
    private TeamEntity firstTeamEntity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secondTeamId", referencedColumnName = "id")
    private TeamEntity secondTeamEntity;

    private int firstTeamGoal;

    private int secondTeamGoal;

    public MatchEntity() {
    }

    public MatchEntity(Match dto, TeamEntity firstTeamEntity, TeamEntity secondTeamEntity) {
        this.uuid = dto.getUuid();
        this.name = dto.getName();
        this.firstTeamGoal = dto.getFirstTeamGoal();
        this.secondTeamGoal = dto.getSecondTeamGoal();

        update(dto);
    }

    public MatchEntity(Match match) {

    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Match getDto() {
        return ImmutableMatch.builder()
                .id(id != null ? id : 0)
                .uuid(uuid)
                .name(name)
                .firstTeam(firstTeamEntity.getDto())
                .secondTeam(secondTeamEntity.getDto())
                .firstTeamGoal(firstTeamGoal)
                .secondTeamGoal(secondTeamGoal)
                .build();
    }

    @Override
    public FullCircleEntity<Match> update(Match match) {
        this.name = match.getName();
        this.firstTeamGoal = match.getFirstTeamGoal();
        this.secondTeamGoal = match.getSecondTeamGoal();
        return this;
    }


}
