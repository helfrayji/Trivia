import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adaptionsoft.games.uglytrivia.Game;

import static org.junit.jupiter.api.Assertions.*;

public class SomeTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void isPlayable_shouldReturnFalseWhenNoPlayers() {
        assertFalse(game.isPlayable());
    }

    @Test
    void isPlayable_shouldReturnFalseWhenOnePlayer() {
        game.addPlayer("Alice");
        assertFalse(game.isPlayable());
    }

    @Test
    void isPlayable_shouldReturnTrueWhenTwoPlayers() {
        game.addPlayer("Alice");
        game.addPlayer("Bob");
        assertTrue(game.isPlayable());
    }

    @Test
    void addPlayer_shouldIncreaseNumPlayers() {
        game.addPlayer("Alice");
        assertEquals(1, game.getNumPlayers());

        game.addPlayer("Bob");
        assertEquals(2, game.getNumPlayers());
    }

    @Test
    void addPlayer_shouldSetPlayerPositionAndScore() {
        game.addPlayer("Alice");
        assertEquals(0, game.getPlayerPositions("Alice"));
        assertEquals(0, game.getPlayerScores("Alice"));

        game.addPlayer("Bob");
        assertEquals(0, game.getPlayerPositions("Bob"));
        assertEquals(0, game.getPlayerScores("Bob"));
    }

    @Test
    void addPlayer_shouldSetPlayerInPenaltyBoxToFalse() {
        game.addPlayer("Alice");
        assertFalse(game.isPlayerInPenaltyBox("Alice"));

        game.addPlayer("Bob");
        assertFalse(game.isPlayerInPenaltyBox("Bob"));
    }

    @Test
    void roll_shouldUpdatePlayerPosition() {
        game.addPlayer("Alice");
        game.roll(3);
        assertEquals(3, game.getPlayerPosition("Alice"));

        game.roll(4);
        assertEquals(7, game.getPlayerPosition("Alice"));
    }

    @Test
    void roll_shouldWrapAroundWhenPlayerPositionExceeds11() {
        game.addPlayer("Alice");
        game.roll(10);
        assertEquals(10, game.getPlayerPosition("Alice"));

        game.roll(4);
        assertEquals(2, game.getPlayerPosition("Alice"));
    }
}
