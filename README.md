# Battleship_Game
A digitized version of the classic board game battleship. Two Player game played in the terminal.

On the game board, '@' is a ship that has not been hit, '-' is a space that has not been fired upon yet, 'O' is a space where the user has shot but missed, and 'X' is a spot where the user has hit. The game terminates after the program detects that one of the users has no ships left and prints to the terminal that the game is over and which specific player has won the game!

**2022-05-15:**
**Topic:**  Battelship Application Completed
**Purpose:** To recreate the classic game battleship where users place their ships on a grid board and then fire at their opponents to sink all their battleships.
**What did you do?** 
I completed the battleship application which can be viewed in a separate repositiory. This involved the use of switch statements for input validation, along with plenty of data type conversions such as str->int, a nested do-while loop to count the remaining number of ships represented by the '@' character in a multi-dimensional char[][] array, use of the split function to split a string into an array that will be used as the location board for ships as well as the target tracking board to keep track of user hits and misses on the 5 x 5 playing grid. The highest dimenisional array used here was a 3 dimensional char array used to store both players' game boards.
