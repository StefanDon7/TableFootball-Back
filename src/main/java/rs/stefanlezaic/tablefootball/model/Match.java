package rs.stefanlezaic.tablefootball.model;

import javax.persistence.*;

@Entity
public class Match {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true, nullable = false)
    private String uuid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "firstTeamId", referencedColumnName = "id")
    private Team firstTeam;

    @ManyToOne(optional = false)
    @JoinColumn(name = "secondTeamId", referencedColumnName = "id")
    private Team secondTeam;

    private int firstTeamGoal;

    private int secondTeamGoal;

    public Match() {
    }

    public Match(long id,
                 String uuid,
                 Team firstTeam,
                 Team secondTeam,
                 int firstTeamGoal,
                 int secondTeamGoal) {
        this.id = id;
        this.uuid = uuid;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.firstTeamGoal = firstTeamGoal;
        this.secondTeamGoal = secondTeamGoal;
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

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getFirstTeamGoal() {
        return firstTeamGoal;
    }

    public void setFirstTeamGoal(int firstTeamGoal) {
        this.firstTeamGoal = firstTeamGoal;
    }

    public int getSecondTeamGoal() {
        return secondTeamGoal;
    }

    public void setSecondTeamGoal(int secondTeamGoal) {
        this.secondTeamGoal = secondTeamGoal;
    }
}
