public class Player {
	
	private String name;
	private int wins;
	
	public Player(){
		this.name = "uknown";
		this.wins = 0;
	}
	
	public Player(String name){
		this.name = name;
	}
	
	public void setPlayerName(String name){
		    this.name = name;
	}
	 
	public String getPlayerName(){
		    return this.name;
	}
	
	public void setWins(){
		this.wins++;
	}
	
	public int getWins(){
		return wins;
	}
	
}
