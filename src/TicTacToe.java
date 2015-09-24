public class TicTacToe{
	
	private char[][] gameBoard;

	private char x = 'X';
	private char o = 'O';
	private int squares = 3;
	private int winCondition = 3;
	
	private Boolean winner = false;
	
	public TicTacToe(int squares){
		gameBoard = new char[squares][squares];
		
		for(int i=0; i<squares; i++){			
			for(int a=0; a<squares; a++){
				gameBoard[i][a] =' ';
      		}
		}
	}
	
	public void resetBoard(){
		for(int i=0; i<squares; i++){			
			for(int a=0; a<squares; a++){
				gameBoard[i][a] =' ';
      		}
		}
	}
	
	public void setTotSquares(int totSquares){
		this.squares = totSquares;
	}
	
	public void setMarker(int markerPosition, char marker){
		
		int nr = 0;
		
		for(int i=0; i<squares; i++){				
			for(int a=0; a<squares; a++){				
				if(markerPosition == nr ){
					gameBoard[i][a] = marker;
				}
				nr++;
      		}
		}
	}
	
	public void setRule(int winCondition){
		this.winCondition = winCondition;
	}
	
	public int getRule(){
		return this.winCondition;
	}
	
	public boolean checkIfBoardIsFull(){
				
		for(int i=0; i<squares; i++){				
			for(int a=0; a<squares; a++){				
					if(gameBoard[i][a] == ' '){
						return false;
				}
      		}
		}
		
		return true;
	}
	
	public boolean checkMarkerPlacement(int markerPosition, char marker){
		
		int nr = 0;
		
		for(int i=0; i<squares; i++){				
			for(int a=0; a<squares; a++){
				if(markerPosition == nr){		
					if(gameBoard[i][a] == x || gameBoard[i][a] == o){
							return true;
					}
				}
				nr++;
      		}
		}
		
		return false;
	}
	
	public boolean checkWinConditions(char marker){
		
		winner = false;
		int counter = 0;
		int saveRow = 0;
		int saveColumn = 0;
		
		//Check horizontal
		for(int i=0; i<squares; i++){
			if(saveRow != i){
				counter = 0;
			}
			for(int a=0; a<squares; a++){
				if(gameBoard[i][a] == marker){
					saveRow = i;
					counter++;
					if(counter == winCondition){
						winner = true;
						break;
					}
				}
				else{
					counter = 0;
				}
			}
			if(winner != false){
				break;
			}
		}
		
		saveRow = 0;
		saveColumn = 0;
		counter = 0;
		
		//Check vertical
		for(int i=0; i<squares; i++){
			if(saveColumn != i){
				counter = 0;
			}
			for(int a=0; a<squares; a++){
				if(gameBoard[a][i] == marker){
					saveColumn = i;
					counter++;
					if(counter == winCondition){
						winner = true;
						break;
					}
				}
				else{
					counter = 0;
				}
			}
			if(winner != false){
				break;
			}
		}	
		
		saveRow = 0;
		saveColumn = 0;
		counter = 0;	
		
		//Check Diagonal
			for(int i=0; i<squares; i++){
				for(int a=0; a<squares; a++){
					
					saveColumn = a;
					saveRow = i;
					
						while(gameBoard[saveRow][saveColumn] == marker){
							counter++;
							saveColumn--;
							saveRow++;
							
							if(counter == winCondition){
								winner = true;
								break;
							}
							else if(saveColumn < 0 ){
								break;
							}
							else if(saveRow > squares-1){
								break;
							}
						}
						
						saveColumn = a;
						saveRow = i;
						counter = 0;
						
						while(gameBoard[saveRow][saveColumn] == marker){
							counter++;
							saveColumn++;
							saveRow++;	
							
							if(counter == winCondition){
								winner = true;
								break;
							}
							else if(saveColumn > squares-1 ){
								break;
							}
							else if(saveRow > squares-1 ){
								break;
							}
						}
						counter = 0;
				}
			}	
		return winner;
	}

	public void showGameBoard(){
		System.out.println();		
		for(int i=0; i<squares; i++){
			for(int a=0; a<squares; a++){
				System.out.print("|"+gameBoard[i][a]);
				
      		}
			System.out.println("|");
		}
	}
	
	public void showRules(){
		System.out.println("\n##########################################################################################");
		  System.out.println("The rule for this game is simple, get 3 in a row with help of your marker.");
		  System.out.println("There are two kinds of markers. Player 1 uses marker| X | and player 2 uses marker| O |.");
		  System.out.println("To win you need one of these three combinations.");
		  System.out.println("\n1. Vertical");
		  
		  for(int i=0; i<3; i++){
				for(int a=0; a<3; a++){
					if(i==0 && a==1 || i==1 && a==1 || i==2 && a==1){
						System.out.print("|X");	
					}
					else
					System.out.print("| ");
					
	      		}
				System.out.println("|");
		  }
		  System.out.println("\n2. Horizontal");
		  for(int i=0; i<3; i++){
				for(int a=0; a<3; a++){
					if(i==1 && a==0 || i==1 && a==1 || i==1 && a==2){
						System.out.print("|X");	
					}
					else
					System.out.print("| ");
					
	      		}
				System.out.println("|");
		  }
		  
		  System.out.println("\n3. Diagonal");
		  for(int i=0; i<3; i++){
				for(int a=0; a<3; a++){
					if(i==0 && a==0 || i==1 && a==1 || i==2 && a==2){
						System.out.print("|X");	
					}
					else
					System.out.print("| ");
					
	      		}
				System.out.println("|");
		  }
		  System.out.println("\nIf the board fills up with markers and no one can win the game will draw.");
		  System.out.println("\nThe order of marker placement.");
		  int counter = 1;
		  for(int i = 0; i < 3; i++){
				for(int a = 0; a < 3; a++){
					System.out.print("|"+counter);
					counter++;
	      		}
				System.out.println("|");
		  }
		  System.out.println("\n##########################################################################################");
	}
}
