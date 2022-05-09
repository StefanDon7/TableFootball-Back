package rs.stefanlezaic.tablefootball.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String uuid;

    @OneToOne
    @JoinColumn(
            name = "defence_id",
            referencedColumnName = "id"
    )
    private Player defence;
    @OneToOne
    @JoinColumn(
            name = "attack_id",
            referencedColumnName = "id"
    )
    private Player attack;

}
