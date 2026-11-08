/**
 * Voter class: Represents a voter in the voting system.
 */
public class Voter {
    private final int id;
    private final String name;
    private final String password;
    private boolean hasVoted;

    public Voter(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.hasVoted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}