package rs.stefanlezaic.tablefootball.model;

import javax.persistence.*;

@Entity
public class Player {
    @Id
    @Column(nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true, nullable = false)
    private String uuid;
    private String firstName;
    private String lastName;
    @Column(unique=true, nullable = false)
    private String playerName;
    @Column(unique=true, nullable = false)
    private String email;
    private String password;

    public Player() {
    }

    public Player(long id, String uuid, String firstName, String lastName, String playerName, String email, String password) {
        this.id = id;
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.playerName = playerName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
