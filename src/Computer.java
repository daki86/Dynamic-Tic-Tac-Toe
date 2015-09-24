import java.util.Random;

public class Computer {
	
	private int compNr;
	private int wins;
	private Random rng; 
	private String name;
	private char pcMarker;
	
	public Computer(){
		this.name = "Computer";
		this.compNr = 0;
		this.rng = new Random();
		this.wins = 0;
		this.pcMarker = 'O';
	}
	
	public int getRng(int totNr){
		rng = new Random();	
		this.compNr = rng.nextInt(totNr);
		
		return this.compNr;
	}
	
	public void setWins(){
		this.wins++;
	}
	
	public int getWins(){
		return this.wins;
	}
	
	public String getName(){
		return this.name;
	}
	
	public char getPcMarker(){
		return pcMarker;
	}
}
