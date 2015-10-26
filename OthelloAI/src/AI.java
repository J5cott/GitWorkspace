import org.json.*;

public class AI {

    public int width;

    public int height;

    public int maxIndex;

    public String[][] board;

    public String mycolor;

    public String opcolor;

    public int time;

    public int output;

    public int[] moves;

	
    public static void main(String[] args) {

        System.out.println("hello world");

        JSONObject obj = new JSONObject(args[1]);

        int width = obj.getInt("width");

        int height = obj.getInt("height");

        int maxIndex = obj.getInt("max-index");

        JSONArray board = obj.getJSONArray("squares");

        int time = Integer.parseInt(args[5]);

        String playerColor = args[3];

        AI ai = new AI(width,height,maxIndex,board,playerColor,time);

        ai.randomAI();

        System.exit(ai.getOutput());

    }

public void setOutPut(int x,int y){

        

        System.out.println(x);

        System.out.println(y);

        

        int index;

        if(y == 0){

            index = x;

        }

        else if(y== 1){

            index = x+8;

        }

        else if(y==2){

            index = x+16;

            

        }

        else if(y==3){

            index = x+24;

        }

        else if(y==4){

            index = x+32;

            

        }

        else if(y==5){

            index = x+40;

            

        }

        else if(y==6){

            index = x+48;

            

        }

        else{

            index = x+56;

            

        }


        

        System.out.println(index);


        

        output = index ;

        

        

        
    }

    public int getOutput(){

        return output;

    }

    public AI(int width,int height, int maxIndex, JSONArray board,String player,int time){

        this.width = width;

        this.height = height;

        this.maxIndex = maxIndex;

        this.board = new String[width][height];

        setBoard(board);

        if(player == "white"){

            this.mycolor = "w";

            this.opcolor = "b";

        }else{

            this.mycolor = "b";

            this.opcolor = "w";
        }

        this.time = time;

        printBoard();

    }


	
    public void setBoard(JSONArray board){

        int index=0;

        for(int n = 0;n < width;n++){

            for(int m = 0;m < height;m++){

                this.board[n][m] = board.getString(index);

                index++;

            }
        }

                
    }
	/**
	 * Checks to see if a position is on the board
	 * @param row
	 * @param column
	 * @return true if it is on the board, false if it is not
	 */
	
	public boolean onBoard(int row, int column){
		if(row >= 0 && row <= 7 && column >= 0 && column <= 7){
			return true;
		} else{
			return false;
		}
	}
	public boolean isValid(int column, int row){
		String[][] testboard = board;
		
		if(board[row][column].equals("-")){
		
		int right = 0; //0 means look right, 1 means look left, 2 means stop looking
		int up = 0; //0 means look up, 1 means look down, 2 means stop looking
		int Rdiagonal = 0;//0 means look up, 1 means look down, 2 means stop looking
		int Ldiagonal = 0;//0 means look up, 1 means look down, 2 means stop looking
		int opcolors = 0; //to store how many of the other color there are
		
		
		//check to see if the position is on the board
		if(onBoard(row, column)){
			
		for(int i = 1; i < testboard[row].length; i++){
			if(right < 2){
				//if we are checking to the right
			if(right == 0){
				if(onBoard(row, column + i)){
					if(testboard[row][column + i].equals(opcolor)){
						opcolors++;
						//check for the next column (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row][column + i].equals(mycolor)){
						return true;
					} else{
						right = 1;
						opcolors = 0;
						i = 0;
						continue;
					}
				} else{
					right = 1;
					opcolors = 0;
					i = 0;
					continue;
				}
				//if we are checking to the left
			}else if(right == 1){
				if(onBoard(row, column - i)){
					if(testboard[row][column - i].equals(opcolor)){
						opcolors++;
						//check for the next column (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row][column - i].equals(mycolor)){
						return true;
					} else{
						right = 2;
						opcolors = 0;
						i = 0;
						continue;
					}
				} else{
					right = 2;
					opcolors = 0;
					i = 0;
					continue;
				}
			}
			//next we look in the vertical directions (up and down)
			} else if(up < 2){
				if(up == 0){
					if(onBoard(row - i, column)){
						if(testboard[row - i][column].equals(opcolor)){
							opcolors++;
							//check for the next row (increments i)
							continue;
						} else if(opcolors > 0 && testboard[row - i][column].equals(mycolor)){
							return true;
						} else{
							up = 1;
							opcolors = 0;
							i = 0;
							continue;
						}
					} else{
						up = 1;
						opcolors = 0;
						i = 0;
						continue;
					}
			} else if(up == 1){
				if(onBoard(row + i, column)){
					String s = testboard[row + i][column];
					if(s.equals(opcolor)){
						opcolors++;
						//check for the next row (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row + i][column].equals(mycolor)){
						return true;
			} else{
				up = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			} else{
				up = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			}
			//next we check the right diagonal
			} else if(Rdiagonal < 2){
				if( Rdiagonal == 0){
					if(onBoard(row + i, column + i)){
						if(testboard[row + i][column + i].equals(opcolor)){
							opcolors++;
							//check for the next diagonal unit with positive slope (increments i)
							continue;
						} else if(opcolors > 0 && testboard[row + i][column + i].equals(mycolor)){
							return true;
						} else{
							Rdiagonal = 1;
							opcolors = 0;
							i = 0;
							continue;
						}
					} else{
						Rdiagonal = 1;
						opcolors = 0;
						i = 0;
					}
			} else if(Rdiagonal == 1){
				if(onBoard(row - i, column - i)){
					if(testboard[row - i][column - i].equals(opcolor)){
						opcolors++;
						//check for the next diagonal unit with negative slope (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row - i][column - i].equals(mycolor)){
						return true;
			} else{
				Rdiagonal = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			} else{
				Rdiagonal = 2;
				opcolors = 0;
				i = 0;
			}
			}
				//next we check the left diagonal
			} else{
				if( Ldiagonal == 0){
					if(onBoard(row - i, column + i)){
						if(testboard[row - i][column + i].equals(opcolor)){
							opcolors++;
							//check for the next column (increments i)
							continue;
						} else if(opcolors > 0 && testboard[row - i][column + i].equals(mycolor)){
							return true;
						} else {
							Ldiagonal = 1;
							opcolors = 0;
							i = 0;
							continue;
						}
					} else{
						Ldiagonal = 1;
						opcolors = 0;
						i = 0;
						continue;
					} 
			} else if(Ldiagonal == 1){
				if(onBoard(row + i, column - i)){
					String s = testboard[row + i][column - i];
					if(s.equals(opcolor)){
						opcolors++;
						//check for the next column (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row + i][column - i].equals(mycolor)){
						i = 0;
						return true;
			} else{
				Ldiagonal = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			} else{
				break;
			}
			}
			}
			}
			}
		}
		return false;
			}	

	public int getValue(int column, int row){
		String[][] testboard = board;
		
		if(board[row][column].equals("-")){
		
		int right = 0; //0 means look right, 1 means look left, 2 means stop looking
		int up = 0; //0 means look up, 1 means look down, 2 means stop looking
		int Rdiagonal = 0;//0 means look up, 1 means look down, 2 means stop looking
		int Ldiagonal = 0;//0 means look up, 1 means look down, 2 means stop looking
		int opcolors = 0; //to store how many of the other color there are
		
		
		//check to see if the position is on the board
		if(onBoard(row, column)){
			
		for(int i = 1; i < testboard[row].length; i++){
			if(right < 2){
				//if we are checking to the right
			if(right == 0){
				if(onBoard(row, column + i)){
					if(testboard[row][column + i].equals(opcolor)){
						opcolors++;
						//check for the next column (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row][column + i].equals(mycolor)){
						return opcolors;
					} else{
						right = 1;
						opcolors = 0;
						i = 0;
						continue;
					}
				} else{
					right = 1;
					opcolors = 0;
					i = 0;
					continue;
				}
				//if we are checking to the left
			}else if(right == 1){
				if(onBoard(row, column - i)){
					if(testboard[row][column - i].equals(opcolor)){
						opcolors++;
						//check for the next column (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row][column - i].equals(mycolor)){
						return opcolors;
					} else{
						right = 2;
						opcolors = 0;
						i = 0;
						continue;
					}
				} else{
					right = 2;
					opcolors = 0;
					i = 0;
					continue;
				}
			}
			//next we look in the vertical directions (up and down)
			} else if(up < 2){
				if(up == 0){
					if(onBoard(row - i, column)){
						if(testboard[row - i][column].equals(opcolor)){
							opcolors++;
							//check for the next row (increments i)
							continue;
						} else if(opcolors > 0 && testboard[row - i][column].equals(mycolor)){
							return opcolors;
						} else{
							up = 1;
							opcolors = 0;
							i = 0;
							continue;
						}
					} else{
						up = 1;
						opcolors = 0;
						i = 0;
						continue;
					}
			} else if(up == 1){
				if(onBoard(row + i, column)){
					String s = testboard[row + i][column];
					if(s.equals(opcolor)){
						opcolors++;
						//check for the next row (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row + i][column].equals(mycolor)){
						return opcolors;
			} else{
				up = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			} else{
				up = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			}
			//next we check the right diagonal
			} else if(Rdiagonal < 2){
				if( Rdiagonal == 0){
					if(onBoard(row + i, column + i)){
						if(testboard[row + i][column + i].equals(opcolor)){
							opcolors++;
							//check for the next diagonal unit with positive slope (increments i)
							continue;
						} else if(opcolors > 0 && testboard[row + i][column + i].equals(mycolor)){
							return opcolors;
						} else{
							Rdiagonal = 1;
							opcolors = 0;
							i = 0;
							continue;
						}
					} else{
						Rdiagonal = 1;
						opcolors = 0;
						i = 0;
					}
			} else if(Rdiagonal == 1){
				if(onBoard(row - i, column - i)){
					if(testboard[row - i][column - i].equals(opcolor)){
						opcolors++;
						//check for the next diagonal unit with negative slope (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row - i][column - i].equals(mycolor)){
						return opcolors;
			} else{
				Rdiagonal = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			} else{
				Rdiagonal = 2;
				opcolors = 0;
				i = 0;
			}
			}
				//next we check the left diagonal
			} else{
				if( Ldiagonal == 0){
					if(onBoard(row - i, column + i)){
						if(testboard[row - i][column + i].equals(opcolor)){
							opcolors++;
							//check for the next column (increments i)
							continue;
						} else if(opcolors > 0 && testboard[row - i][column + i].equals(mycolor)){
							return opcolors;
						} else {
							Ldiagonal = 1;
							opcolors = 0;
							i = 0;
							continue;
						}
					} else{
						Ldiagonal = 1;
						opcolors = 0;
						i = 0;
						continue;
					} 
			} else if(Ldiagonal == 1){
				if(onBoard(row + i, column - i)){
					String s = testboard[row + i][column - i];
					if(s.equals(opcolor)){
						opcolors++;
						//check for the next column (increments i)
						continue;
					} else if(opcolors > 0 && testboard[row + i][column - i].equals(mycolor)){
						i = 0;
						return opcolors;
			} else{
				Ldiagonal = 2;
				opcolors = 0;
				i = 0;
				continue;
			}
			} else{
				break;
			}
			}
			}
			}
			}
		}
		return 0;
			}

		
	
    public void printBoard(){

        System.out.println();

        for(int i=0;i<width;++i){

            for(int j=0;j<height;++j){

                System.out.print(board[i][j]+" ");

            }

            System.out.println();

        }

        System.out.println();
    }
    


    public int randomAI(){
    	System.out.println(board[1][2]);
    	if(isValid(0,0)){
    		setOutPut( 0, 0);
    		return 0;
    	} else if(isValid( 0, 7)){
    		setOutPut( 0, 7);
    		return 0;
    	} else if(isValid(7, 0)){
    		setOutPut(0,7);
    		return 0;
    	} else if(isValid(7, 7)){
    		setOutPut(7,7);
    		return 0;
    	}
        for(int n = 0;n < width;n++){
        	System.out.println(mycolor);
            for(int m = 0;m < height;m++){
            	System.out.println("\n" + "n: " + n + "m: " + m);
                System.out.println(isValid(n, m));
            
                if(isValid(n, m)){

                    setOutPut(n, m);

                    return 0;
                }

            }

        }
        return 0;
    }



    
	public int[] minimax(){
		int[]
		boolean winstate = true;
		if(winstate == true){
			return unimplemented;
		}else{
			
		}
	}
}