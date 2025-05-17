package scoreboardDesign;

import lombok.Data;

import java.util.List;

@Data
public class Match {
    private List<Team> teams;
    private int noOfOvers;
    private List<Player> battingOrderFirstTeam;
    private List<Player> battingOrderSecondTeam;
    private List<Over> overs;
}
