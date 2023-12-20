import com.example.tictactoelab.Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testIllegalMove() {
        Model model = new Model();

        // Make a legal move
        model.cellClicked(1);
        assertEquals("X", model.getCell1());
        String initialCurrentPlayer = model.getCurrentPlayer();

        // Try making the same move again to make sure it doesnt allow it
        model.cellClicked(1);

        // Verify that the state of the game remains unchanged
        assertEquals(initialCurrentPlayer, model.getCurrentPlayer());
        assertEquals("X", model.getCell1());
    }
    @Test
    public void testGameOver() {
        Model model = new Model();

        model.cellClicked(1);
        model.cellClicked(2);
        model.cellClicked(3);
        model.cellClicked(4);
        model.cellClicked(5);
        model.cellClicked(6);
        model.cellClicked(7);
        model.cellClicked(8);
        model.cellClicked(9);

        assertTrue(model.isGameOver());
    }
    @Test
    public void testNoMovesAfterGameOver() {
        Model model = new Model();

        model.cellClicked(1);
        model.cellClicked(2);
        model.cellClicked(3);

        if (model.isGameOver()) {
            // Attempt to make moves after the game is over
            for (int i = 4; i <= 9; i++) {
                model.cellClicked(i);

                // Check that no moves can be made after the game is over
                assertTrue(model.isGameOver());
            }
        } else {
            // Make additional moves since the game is not over yet
            model.cellClicked(4);
            model.cellClicked(5);
            model.cellClicked(6);
        }
    }
}
