public class Sudoku extends SudokuP{

    //check row
    public static boolean rowValid(char[][] puzzle){
        char[] checker = new char[10];
		int index = 0;
		//check for any repeat in each rows
		for (int i = 0; i < puzzle.length; i++){
			for (int  j = 0; j < puzzle[i].length; j++){
				//if the value is in my checker array it's false
				if(String.valueOf(checker).contains(puzzle[i][j]+"")){
					if(puzzle[i][j] != '.'){
						return false;
					}	
				} else {
					// or it isn't in the checker, should be added, then continue with check
					checker[index++] = puzzle[i][j];
				}
			}
			//System.out.println(checker);		//works: adds . to checker but won't exit because of it
												//haven't tested with invalid
			//clear checker at end of row and set index to 0
			for (int k = 0; k < checker.length; k++){
				checker[k] = ' ';
			} 
			index = 0;
		} 
		return true;
    }
    //check column
		// if it makes it through the rows, check columns next
		public static boolean colValid(char[][] puzzle){
		char[] checker = new char[10];
		int index = 0;
		
		for (int i = 0; i < puzzle[0].length; i++){
			for (int j = 0; j < puzzle.length; j++){
				if(String.valueOf(checker).contains(puzzle[j][i]+"")){
					if (puzzle[j][i] != '.') {
						return false;
					}
				} else {
					checker[index++] = puzzle[j][i];
				}
			}
			//System.out.println(checker);		//similar to row check (because it was based on it)
			//clear checker
			for (int k = 0; k < checker.length; k++){
				checker[k] = ' ';
			}
			index = 0;
		}
		return true;
    }
	// returns True if this is a valid sudoku, no repeats in the current
	// puzzle, returns False otherwise
	public static boolean check(char[][] puzzle){
		//check rows and columns, if either are false it'll return false
		if (!rowValid(puzzle) || !colValid(puzzle)) {
			return false;
		}
		//create sub-arrays for each of the nine boxes
		for (int i = 0; i < 9; i += 3 ) {
			for (int j = 0; j < 9; j += 3){
				char[][] sub1 = {{puzzle[i][j], puzzle[i][j+1], puzzle[i][j+2]},
							 {puzzle[i+1][j], puzzle[i+1][j+1], puzzle[i+1][j+2]},
							 {puzzle[i+2][j], puzzle[i+2][j+1], puzzle[i+2][j+2]}};
			//System.out.println(toString(sub1));
				//run the row and column validations on the sub-array
				//if any of them are false then return false
            	if (!rowValid(sub1) || !colValid(sub1)) {
            		return false;
            	}
			}
		}		
		return true;
	}
	// first calls check, if invalid print "The given sudoku puzzle is invalid"
	// if valid, attempts to solve
	// if unsolvable prints "This puzzle is unsolvable" and returns false
	// if able, print solution  and return true
	public static boolean solve(char[][] puzzle){
		//insert code here
		return false;
	}
	public static String toString(char[][] puzzle) {
		// tostring function for each puzzle
		String output = "";
		//for each row
		for (int i = 0; i < puzzle.length; i++){
			//for each column
			for (int j = 0; j < puzzle[i].length; j++){
					// put [ ] arround each digit
					output += "[" + puzzle[i][j] + "] ";
			}
			//newline at end of row
			output += "\n";
		}
		return output;
	}
	public static void main(String[] args){
		char[][] invalid = {{'1', '.', '2', '3', '.', '.', '4', '.', '.'}, 
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '2', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
							{'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
		System.out.println(toString(invalid));
		System.out.println("invalid: " + check(invalid));		//should print false
		//the solvable one is from the easy nyt puzzle for 11/20/26 (these are always solvable)
		//I will solve this today to prove it
		char[][] solvable = {{'1', '7', '.', '.', '.', '2', '.', '5', '.'}, 
							{'.', '.', '2', '.', '4', '9', '.', '.', '6'},
							{'4', '.', '.', '.', '5', '.', '3', '8', '2'},
							{'5', '.', '9', '.', '2', '.', '.', '4', '1'},
							{'2', '.', '8', '4', '3', '1', '.', '.', '.'},
							{'.', '.', '1', '8', '.', '.', '.', '6', '3'},
							{'6', '2', '.', '.', '.', '8', '7', '.', '.'},
							{'.', '8', '5', '2', '.', '.', '.', '.', '4'},
							{'.', '.', '.', '5', '.', '4', '9', '.', '.'}};
		System.out.println(toString(solvable));
		System.out.println("solvable: " + check(solvable));		//should print true
	}	
						
}
