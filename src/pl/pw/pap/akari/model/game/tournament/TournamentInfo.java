package pl.pw.pap.akari.model.game.tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TournamentInfo {
    private List<PlayerInfo> players;

    public TournamentInfo(List<String> nameList)
    {
    	players = new ArrayList<PlayerInfo> (nameList.size());
    	
    	for (String name : nameList)
    	{
    		players.add(new PlayerInfo (name));
    	}
    }
    public List<PlayerInfo> getPlayers() {

        return players;
    }
    
    public Object [][] getScores()
    {
    	this.sort();
    	
    	Object [][] scores = new Object[players.size()][];
    	
    	for (int i = 0; i< players.size(); i++)
    	{
    		String [] infoText = players.get(i).infoText();
    		scores[i] = new String []{Integer.toString(i + 1), infoText[0], infoText[1]};
    				
    	}
    	return scores;
    }
    
    
    public void setPlayerTime(int index, int time)
    {
    	players.get(index).setTime(time);
    }
    
    public void sort()
    {
    	Collections.sort(players, new Comparator<PlayerInfo>() 
    	{
            public int compare(PlayerInfo p1, PlayerInfo p2) 
            {
                return p1.getTime() - p2.getTime();
            }
    	});
   
    }
    
    
}
