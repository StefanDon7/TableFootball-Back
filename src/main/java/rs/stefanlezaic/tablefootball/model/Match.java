package rs.stefanlezaic.tablefootball.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "uuid_unique",
                columnNames = "uuid"
        )
)
public class Match {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String uuid;
    private int firstTeamGoal;
    private int secondTeamGoal;

    @OneToOne
    @JoinColumn(
            name = "first_team_id",
            referencedColumnName = "id"
    )
    private Team firstTeam;

    @OneToOne
    @JoinColumn(
            name = "second_team_id",
            referencedColumnName = "id"
    )
    private Team secondTeam;

}
