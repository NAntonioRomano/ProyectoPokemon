package model.dto;

import java.io.Serializable;

public class ArenaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private String level;
    private int creditsForWinner;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLevel() {
        return level;
    }

    public int getCreditsForWinner() {
        return creditsForWinner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCreditsForWinner(int creditsForWinner) {
        this.creditsForWinner = creditsForWinner;
    }
}
