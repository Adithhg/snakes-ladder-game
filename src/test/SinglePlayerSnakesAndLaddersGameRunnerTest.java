import com.game.models.*;
import com.game.runner.SinglePlayerSnakesAndLaddersGameRunner;
import com.game.utils.DiceFactory;
import com.game.utils.ValidateInputValuesForSnakesAndLadders;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: agopal
 * Date: 5/22/2021
 * Time: 6:32 PM
 */
public class SinglePlayerSnakesAndLaddersGameRunnerTest {

    SinglePlayerSnakesAndLaddersGameRunner testObj = null;
    
    @Before
    public void setup() {

        Player player = new Player("1", "Player1");
        Snake snake1 = new Snake(14, 7);
        Snake snake2 = new Snake(30, 4);
        Snake snake3 = new Snake(99, 60);
        List<Snake> snakes = new ArrayList<Snake>(){{add(snake1); add(snake2); add(snake3);}};

        Ladder ladder1 = new Ladder(2, 30);
        Ladder ladder2 = new Ladder(4, 76);
        Ladder ladder3 = new Ladder(76, 90);
        List<Ladder> ladders = new ArrayList<Ladder>(){{add(ladder1); add(ladder2); add(ladder3);}};

        Dice dice = new CrookedDiceService();

        testObj = new SinglePlayerSnakesAndLaddersGameRunner(new SnakesLadderBoard(player, snakes, ladders, dice));

    }

    /*
        Test case for testing whether the dice gives values between 1-6
     */

    @Test
    public void validateDiceInstance() {
        //If its normal dice
        assertTrue(DiceFactory.getDice(1) instanceof DiceService);
    }

    @Test
    public void validateDiceInstanceForCrookedDice() {
        //If its normal dice
        assertTrue(DiceFactory.getDice(2) instanceof CrookedDiceService);
    }

    @Test
    public void diceThrow() {
        Dice crookedDiceService = new DiceService();
        int value = crookedDiceService.diceThrow();
        assertTrue(value > 0 && value < 7);
    }

    /*
        Test case for testing whether the dice gives even numbers in the list {2, 4, 6}
     */
    @Test
    public void diceThrowCrooked() {
        Dice crookedDiceService = new CrookedDiceService();
        int value = crookedDiceService.diceThrow();
        List<Integer> diceExpectedValues = new ArrayList<Integer>() {{add(2);add(4);add(6);}};
        assertTrue(diceExpectedValues.contains(value));
    }

    /*
        Test case for testing whether the snake functionality works
     */
    @Test
    public void addSnake() {

        testObj.setCurrentPosition(13);
        testObj.movePlayer(1);
        assertTrue(testObj.getCurrentPosition() == 7);
    }

    /*
        Test case for testing whether the snake functionality works
     */
    @Test
    public void addLadder() {

        testObj.setCurrentPosition(3);
        testObj.movePlayer(1);
        /*if the diceThrow gives 1, in the position 4, we have a ladder which should take us to 76. At 76, there is one more ladder which should take us to 90. so the new currentPosition should be pointing to 90
        */
        assertTrue(testObj.getCurrentPosition() == 90);
    }

    @Test
    public void addMultipleSnakesAndLadders() {

        testObj.setCurrentPosition(1);
        testObj.movePlayer(1);
        /*if the diceThrow gives 1, in the position 2, we have a ladder that takes us to 30. At 30, there is a snake, which moves us to 4. At 4 we have a ladder which should take us to 76. At 76, there is one more ladder which should take us to 90. so the new currentPosition should be pointing to 90
         */
        assertTrue(testObj.getCurrentPosition() == 90);
    }

    @Test
    public void validateSnakesInput() {

        //If the same snake is added again for the snakes input, it should not accept
        boolean obtainedRes = ValidateInputValuesForSnakesAndLadders.validateSnakeInput(14, 7, testObj.getSnakesLadderBoard().getSnakeList());
        assertFalse(obtainedRes);

    }

    @Test
    public void validateLaddersInput() {

        //If the same ladder is added again for the ladders input, it should not accept
        boolean obtainedRes = ValidateInputValuesForSnakesAndLadders.validateLadderInput(2, 30, testObj.getSnakesLadderBoard().getLadders(), testObj.getSnakesLadderBoard().getSnakeList());
        assertFalse(obtainedRes);

    }

    @Test
    public void validateSnakesLaddersInfiniteLoopInput() {

        //If the same ladder is added again for the ladders input, it should not accept
        boolean obtainedRes = ValidateInputValuesForSnakesAndLadders.validateLadderInput(14, 7, testObj.getSnakesLadderBoard().getLadders(), testObj.getSnakesLadderBoard().getSnakeList());
        assertFalse(obtainedRes);

    }

    @Test
    public void validateIfGameEnded() {

        testObj.setCurrentPosition(100);

        assertTrue(testObj.isGameOver());

    }

    @Test
    public void validateIfGameIsNotEnded() {

        testObj.setCurrentPosition(99);

        assertFalse(testObj.isGameOver());

    }

    @Test
    public void validateGameEndBasedOnDiceThrows() {

        testObj.setCurrentRollCounter(10);
        assertTrue(testObj.isGameOver());

    }

    @Test
    public void validateGameEndBasedOnDiceThrowsAndPosition() {

        testObj.setCurrentRollCounter(5); //eventhough number of dice throws are 5, player should be announced as winner, because he has reached goal.
        testObj.setCurrentPosition(100);
        assertTrue(testObj.isGameOver());

    }

    @Test
    public void validateGameWin() {

        //If the currrent position is 100, game should be declared as won
        testObj.setCurrentPosition(100);
        assertTrue(testObj.gameWon());

    }
    @Test
    public void validateGameWin2() {

        //If the currrent position is not equal to 100, game should be declared as Lost
        testObj.setCurrentPosition(99);
        assertFalse(testObj.gameWon());

    }

}