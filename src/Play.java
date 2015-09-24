import java.util.Scanner;
import java.util.Random;

public class Play{
  public static void main(String[] args){
	  
	  int totPlayers = 2;
	  
	  boolean winner = false;
	  boolean draw = false;
	  boolean input = true;
	  
	  Player [] playerName = new Player[totPlayers];
	  
	  TicTacToe board = new TicTacToe(3);
	  
	  Computer pc = new Computer();
	  
	  Scanner scanMenu = new Scanner(System.in); 
	  Scanner scanString = new Scanner(System.in); 
	  
	  String name;
	  String choice;
	  
	  int markerPos = -1;
	  int boardSquare = 3;
	  int playerTurn = 0;
	  
	  char [] markers = new char[2];
	  
	  markers[0] = 'X';
	  markers[1] = 'O';
	  
	  boolean checkMarker = false;
	  
	  for(int i=0; i<2; i++){
		  playerName[i] = new Player();
	  }
	  
	  
	  do{
		  System.out.println("\n#################");
		  System.out.println("1. Add players");
		  System.out.println("2. Show players & wins");
		  System.out.println("3. Play 1 vs 1");
		  System.out.println("4. Play 1 vs AI");
		  System.out.println("5. Rules");
		  System.out.println("6. Exit");
		  System.out.println("#################");
		  System.out.print("\nSelect: ");
		  
		  choice = scanMenu.next();
		  
		  if(choice.equals("1")){
			  
			  for(int i=0; i<2; i++){
				  playerName[i] = new Player();
			  }
			  
			  System.out.print("\nPlayer 1: ");
			  playerName[0].setPlayerName(name = scanString.nextLine());
				  
			  System.out.print("\nPlayer 2: ");
			  playerName[1].setPlayerName(name = scanString.nextLine());
		  }
		  else if(choice.equals("2")){
			  System.out.println("\n"+playerName[0].getPlayerName()+"\ngot: "+playerName[0].getWins()+" wins\n");
			  System.out.println(playerName[1].getPlayerName()+"\ngot: "+playerName[1].getWins()+" wins\n");
			  System.out.println(pc.getName()+"\ngot: "+pc.getWins()+" wins");
		  }
		  else if(choice.equals("3")){			  
			  do{
				  System.out.println("\nYou need at least 3 rows and 3 columns to play this game.");
				  System.out.println("How many rows do you want?");
				  
				  while(input){
					  if(scanMenu.hasNextInt()){
						  boardSquare = scanMenu.nextInt();
						  input = false;
					  }
					  else{
						  String clearbuf = scanMenu.next();
						  System.out.println("\n*"+clearbuf+"* is not a valid option!");
						  System.out.println("\nYou need at least 3 rows and 3 columns to play this game.");
						  System.out.println("How many rows do you want?");						  
					  }
					 
				  }
				  
				  if(boardSquare <= 2)
					  System.out.println("\nYou need more than *"+boardSquare+"* rows to play the game!");
			  }while(boardSquare <= 2);
				  
			  int totSquares = boardSquare * boardSquare;
			  
			  board = new TicTacToe(boardSquare);
			  board.setTotSquares(boardSquare);
			  
			  System.out.println("\nInput a number between 1-"+totSquares);
			  board.showGameBoard();
			  
			  winner = false;
			  draw = false;
			  playerTurn = 0;
			  
			  while(winner != true && draw != true){
				  if(playerTurn>1){
					  playerTurn = 0;
				  }
				  
				  do{
					  System.out.println("\n"+playerName[playerTurn].getPlayerName()+"'s turn ");
					  
					  input= true;
					  while(input){
						  if(scanMenu.hasNextInt()){
							  markerPos = scanMenu.nextInt();
							  input = false;
						  }
						  else{
							  String clearbuf = scanMenu.next();
							  System.out.println("\n*"+clearbuf+"* is not a valid option!");
							  System.out.println("Input a number between 1-"+totSquares);
						  }
						 
					  }
					  
					  checkMarker = false;
					  checkMarker = board.checkMarkerPlacement(markerPos-1, markers[playerTurn]);
				 
					  if(checkMarker == true){
						  System.out.println("\n##########################################");
						  System.out.println("A marker is already placed on that spot!");
						  System.out.println("##########################################");
					  }
					  else if(markerPos<=0 || markerPos>totSquares){
						  System.out.println("\n############################################");
						  System.out.println("You need to place the marker on the board!");
						  System.out.println("############################################");
					  }
					  else if(checkMarker == false){
						  board.setMarker(markerPos-1, markers[playerTurn]);
					  }
				 
					  winner = board.checkWinConditions(markers[playerTurn]);
					  
					  System.out.println("\nInput a number between 1-"+totSquares);
					  board.showGameBoard();
					  if(winner == true){
						  System.out.println("\nCongratulations on the win "+playerName[playerTurn].getPlayerName()+"!!!!");
						  playerName[playerTurn].setWins();
					  }
					  else if(board.checkIfBoardIsFull() == true){
						  System.out.println("\nIts a Draw");
						  draw = true;
					  }
					  
				  }while(markerPos<1 || markerPos>totSquares || checkMarker != false);
			  		  
				  playerTurn++;
			 }			  
			 board.resetBoard(); 
		  }
		  else if(choice.equals("4")){ 
			  
			  do{
				  System.out.println("\nYou need at least 3 rows and 3 columns to play this game.");
				  System.out.println("How many rows do you want?");

				  input = true;
				  while(input){
					  if(scanMenu.hasNextInt()){
						  boardSquare = scanMenu.nextInt();
						  input = false;
					  }
					  else{
						  String clearbuf = scanMenu.next();
						  System.out.println("\n*"+clearbuf+"* is not a valid option!");
						  System.out.println("\nYou need at least 3 rows and 3 columns to play this game.");
						  System.out.println("How many rows do you want?");						  
					  }
					 
				  }
				  
				  if(boardSquare <= 2)
					  System.out.println("\nYou need more than "+boardSquare+" markers to play the game!");
			  }while(boardSquare <= 2);
				  
			  int totSquares = boardSquare * boardSquare;
			  
			  board = new TicTacToe(boardSquare);
			  board.setTotSquares(boardSquare);
			  
			  System.out.println("\nInput a number between 1-"+totSquares);
			  board.showGameBoard();
			  
			  winner = false;
			  draw = false;
			  playerTurn = 0;
			  boolean showOnce = false;
			  
			  while(winner != true && draw != true){
				  do{
					  if(playerTurn>1){
						  playerTurn = 0;
					  }
					  
					  if(playerTurn == 0){
						  System.out.println("\n"+playerName[playerTurn].getPlayerName()+"'s turn ");
						  
						  input= true;
						  while(input){
							  if(scanMenu.hasNextInt()){
								  markerPos = scanMenu.nextInt();
								  input = false;
							  }
							  else{
								  String clearbuf = scanMenu.next();
								  System.out.println("\n*"+clearbuf+"* is not a valid option!");
								  System.out.println("Input a number between 1-"+totSquares);
							  }
							 
						  }
						  
						  checkMarker = false;
						  checkMarker = board.checkMarkerPlacement(markerPos-1, markers[playerTurn]);
						  
						  if(checkMarker == true){
							  System.out.println("\n##########################################");
							  System.out.println("A marker is already placed on that spot!");
							  System.out.println("##########################################");
						  }
						  else if(markerPos<=0 || markerPos>totSquares){
							  System.out.println("\n############################################");
							  System.out.println("You need to place the marker on the board!");
							  System.out.println("############################################");
						  }
						  else if(checkMarker == false){
							  board.setMarker(markerPos-1, markers[playerTurn]);
						  }
						  System.out.println("\nInput a number between 1-"+totSquares);
						  board.showGameBoard();
					  }
					  		
					  else{
						  if(showOnce != true){
							  System.out.println("\n"+pc.getName()+"'s turn ");
							  showOnce = true;
						  }
						  markerPos = pc.getRng(totSquares);
						  checkMarker = board.checkMarkerPlacement(markerPos, markers[playerTurn]);
						  if(checkMarker == false){
							  board.setMarker(markerPos, markers[playerTurn]);
							  
							  System.out.println("\nInput a number between 1-"+totSquares);
							  board.showGameBoard();
							 
							  showOnce = false;
						  }
					  }						  
					  
					  winner = board.checkWinConditions(markers[playerTurn]);
					  
					  if(winner == true){
						  if(playerTurn == 0){
							  System.out.println("\nCongratulations on the win "+playerName[playerTurn].getPlayerName()+"!!!!");
							  playerName[playerTurn].setWins();
						  }
						  else{
							  System.out.println("\nCongratulations on the win "+pc.getName()+"!!!!");
							  pc.setWins();
						  }
					  }
					  else if(board.checkIfBoardIsFull() == true){
						  System.out.println("\nIts a Draw");
						  draw = true;
					  }
					  
				  }while(markerPos<1 || markerPos>totSquares || checkMarker != false);
				  
				  playerTurn++;
			  }			  
			  board.resetBoard();
			  
		  }
		  else if(choice.equals("5")){
			  board.showRules();			  
		  }
		  else if(choice.equals("6")){
			  System.out.println("\nBye!!");
			  scanMenu.close();
			  scanString.close();
		  }
		  else{
			  System.out.println("\nThats not a valid option!");
		  }
		  
	  }while(!choice.equals("6"));
  }
}
