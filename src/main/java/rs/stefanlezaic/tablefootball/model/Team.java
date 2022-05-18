package rs.stefanlezaic.tablefootball.model;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true, nullable = false)
    private String uuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "attackId", referencedColumnName = "id")
    private Player attack;

    @ManyToOne(optional = false)
    @JoinColumn(name = "defenceId", referencedColumnName = "id")
    private Player defence;


    public Team() {
    }

    public Team(long id, String uuid, Player defence, Player attack) {
        this.id = id;
        this.uuid = uuid;
        this.defence = defence;
        this.attack = attack;
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

    public Player getDefence() {
        return defence;
    }

    public void setDefence(Player defence) {
        this.defence = defence;
    }

    public Player getAttack() {
        return attack;
    }

    public void setAttack(Player attack) {
        this.attack = attack;
    }
}
