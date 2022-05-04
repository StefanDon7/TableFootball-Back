package rs.stefanlezaic.tablefootball.model;

public class Team {
    private long id;
    private String uuid;
    private Player defence;
    private Player attack;

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
