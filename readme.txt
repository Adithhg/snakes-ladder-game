Models:
1. Player
2. SnakesLaddersBoard
3. Snake
4. Laddder
5. DiceInterface
6. NormalDice
7. CrookedDice
8. SnakesLadderGameRunner (Interface for the action on the snakes and ladder board)

Runner:

1. GameRunner (main function to start the execution)
2. SinglePlayerSnakesAndLaddersGameRunner (For a single player, provides implementation for the actions in the SnakesAndLadderGame)

Some of default settings:
1. Number of dice throws allowed per game are 10
2. Board size is 100
3. Crooked Dice would yield one of the values in the set {2,4,6}, user can select the dice during the beginning of the game.

Steps to run the game:
1. Input the Player's details
    - Player Id (String)
    - Player Name (String)
2. Input the Snakes
    - Number of snakes
        - enter head and tail cell values
        Constraints:
        - No two snakes can have same values
        - Head cell value should be greater than Tail value. Head value cannot be less than 1 and greater than 99. cannot be equalling to 100.
        - Tail cell value should be in the range of 0-98
3. Input the ladders
    - Number of ladders
    - Enter the top and bottom of the ladder
    - top > bottom. top in range (1-100), bottom > 0
    - Ladder values should not coinside with any snake (would end up in infinite loop)

4. Starts the game, prints the messages for each dice roll and gives the result in the end.

To Run:
use the jar file at \snakes-ladders-board-game\out\artifacts\snakes_ladders_board_game_jar

sample run :

Sample 1:

C:\tutorials\snakes-ladders-board-game\out\artifacts\snakes_ladders_board_game_jar>java -jar snakes-ladders-board-game.jar
Please enter the Player's details
Player's Id :1
Player's Name :Aishu
Please select the Dice for the game
Enter 1 for Normal Dice. or 2 for Crooked Dice.1
Please enter the number of snakes in the board
1
Entered number of snakes : 1
Enter the indexes for head and tail of the snake - 1
Head : 30
Tail : 2
Please enter the number of ladders in the board
3
Entered number of ladders : 3
Enter the indexes for start and end of the ladder - 1
Start : 2
End : 45
Enter the indexes for start and end of the ladder - 2
Start : 4
End : 55
Enter the indexes for start and end of the ladder - 3
Start : 5
End : 49
Currrent Dice throw value for the turn: 0  :::  3
Position moved from : 0 to : 3
Currrent Dice throw value for the turn: 1  :::  6
Position moved from : 3 to : 9
Currrent Dice throw value for the turn: 2  :::  4
Position moved from : 9 to : 13
Currrent Dice throw value for the turn: 3  :::  3
Position moved from : 13 to : 16
Currrent Dice throw value for the turn: 4  :::  1
Position moved from : 16 to : 17
Currrent Dice throw value for the turn: 5  :::  2
Position moved from : 17 to : 19
Currrent Dice throw value for the turn: 6  :::  6
Position moved from : 19 to : 25
Currrent Dice throw value for the turn: 7  :::  5
Down :: Snake present at  : 30. New position will be : 2
Climb Up :: Ladder present at  : 2. New position will be : 45
Position moved from : 25 to : 45
Currrent Dice throw value for the turn: 8  :::  4
Position moved from : 45 to : 49
Currrent Dice throw value for the turn: 9  :::  2
Position moved from : 49 to : 51
Game lost!!!

sample 2:
C:\tutorials\snakes-ladders-board-game\out\artifacts\snakes_ladders_board_game_jar>java -jar snakes-ladders-board-game.jar
Please enter the Player's details
Player's Id :1223Adi
Player's Name :Adith
Please select the Dice for the game
Enter 1 for Normal Dice. or 2 for Crooked Dice.1
Please enter the number of snakes in the board
1
Entered number of snakes : 1
Enter the indexes for head and tail of the snake - 1
Head : 33
Tail : 30
Please enter the number of ladders in the board
5
Entered number of ladders : 5
Enter the indexes for start and end of the ladder - 1
Start : 1
End : 88
Enter the indexes for start and end of the ladder - 2
Start : 2
End : 95
Enter the indexes for start and end of the ladder - 3
Start : 3
End : 96
Enter the indexes for start and end of the ladder - 4
Start : 4
End : 90
Enter the indexes for start and end of the ladder - 5
Start : 5
End : 85
Currrent Dice throw value for the turn: 0  :::  4
Climb Up :: Ladder present at  : 4. New position will be : 90
Position moved from : 0 to : 90
Currrent Dice throw value for the turn: 1  :::  3
Position moved from : 90 to : 93
Currrent Dice throw value for the turn: 2  :::  3
Position moved from : 93 to : 96
Currrent Dice throw value for the turn: 3  :::  3
Position moved from : 96 to : 99
Currrent Dice throw value for the turn: 4  :::  6
Position moved from : 99 to : 99
Currrent Dice throw value for the turn: 5  :::  6
Position moved from : 99 to : 99
Currrent Dice throw value for the turn: 6  :::  6
Position moved from : 99 to : 99
Currrent Dice throw value for the turn: 7  :::  2
Position moved from : 99 to : 99
Currrent Dice throw value for the turn: 8  :::  5
Position moved from : 99 to : 99
Currrent Dice throw value for the turn: 9  :::  3
Position moved from : 99 to : 99
Game lost!!!

sample 3:
C:\tutorials\snakes-ladders-board-game\out\artifacts\snakes_ladders_board_game_jar>java -jar snakes-ladders-board-game.jar
Please enter the Player's details
Player's Id :123A
Player's Name :Adith
Please select the Dice for the game
Enter 1 for Normal Dice. or 2 for Crooked Dice.2
Please enter the number of snakes in the board
1
Entered number of snakes : 1
Enter the indexes for head and tail of the snake - 1
Head : 30
Tail : 29
Please enter the number of ladders in the board
5
Entered number of ladders : 5
Enter the indexes for start and end of the ladder - 1
Start : 2
End : 88
Enter the indexes for start and end of the ladder - 2
Start : 3
End : 96
Enter the indexes for start and end of the ladder - 3
Start : 4
End : 93
Enter the indexes for start and end of the ladder - 4
Start : 5
End : 97
Enter the indexes for start and end of the ladder - 5
Start : 6
End : 76
Currrent Dice throw value for the turn: 0  :::  2
Climb Up :: Ladder present at  : 2. New position will be : 88
Position moved from : 0 to : 88
Currrent Dice throw value for the turn: 1  :::  4
Position moved from : 88 to : 92
Currrent Dice throw value for the turn: 2  :::  4
Position moved from : 92 to : 96
Currrent Dice throw value for the turn: 3  :::  2
Position moved from : 96 to : 98
Currrent Dice throw value for the turn: 4  :::  2
Position moved from : 98 to : 100
Game won!!!

C:\tutorials\snakes-ladders-board-game\out\artifacts\snakes_ladders_board_game_jar>
