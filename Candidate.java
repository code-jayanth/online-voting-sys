/**
 * Candidate class: Represents a candidate in the voting system.
 */
public class Candidate {
    private final int id;
    private final String name;

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}