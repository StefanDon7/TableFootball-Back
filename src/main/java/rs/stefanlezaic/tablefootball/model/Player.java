package rs.stefanlezaic.tablefootball.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Player {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String uuid;
    private String firstName;
    private String lastName;
    private String playerName;
    private String email;
    private String password;


}
