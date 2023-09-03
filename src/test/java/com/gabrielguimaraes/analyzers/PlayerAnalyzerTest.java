package com.gabrielguimaraes.analyzers;

import static org.junit.jupiter.api.Assertions.*;

import com.gabrielguimaraes.entities.Player;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PlayerAnalyzerTest {

  private PlayerAnalyzer playerAnalyzer;

  @BeforeEach
  void setUp() {
    playerAnalyzer = new PlayerAnalyzer();
  }

  @Nested
  class PositiveTests {

    @Test
    void testCalculateScore_NormalPlayer() {
      // Given
      Player player = new Player();
      player.setAge(25);
      player.setExperience(5);
      player.setSkills(Arrays.asList(2, 2, 2));

      // When
      double result = playerAnalyzer.calculateScore(Collections.singletonList(player));

      // Then
      assertEquals(250, result);
    }

    @Test
    void testCalculateScore_JuniorPlayer() {
      // Given
      Player player = new Player();
      player.setAge(15);
      player.setExperience(3);
      player.setSkills(Arrays.asList(3, 3, 3));

      // When
      double result = playerAnalyzer.calculateScore(Collections.singletonList(player));

      // Then
      assertEquals(67.5, result);
    }

    @Test
    void testCalculateScore_SeniorPlayer() {
      // Given
      Player player = new Player();
      player.setAge(35);
      player.setExperience(15);
      player.setSkills(Arrays.asList(4, 4, 4));

      // When
      double result = playerAnalyzer.calculateScore(Collections.singletonList(player));

      // Then
      assertEquals(2520, result);
    }

    @Test
    void testCalculateScore_MultiplePlayers() {
      // Given
      Player player1 = new Player();
      player1.setAge(25);
      player1.setExperience(5);
      player1.setSkills(Arrays.asList(2, 2, 2));

      Player player2 = new Player();
      player2.setAge(15);
      player2.setExperience(3);
      player2.setSkills(Arrays.asList(3, 3, 3));

      List<Player> players = Arrays.asList(player1, player2);

      // When
      double result = playerAnalyzer.calculateScore(players);

      // Then
      assertEquals(250 + 67.5, result);
    }
  }

  @Nested
  class NegativeTests {

    @Test
    void testCalculateScore_SkillsIsNull() {
      // Given
      Player player = new Player();
      player.setAge(25);
      player.setExperience(5);
      player.setSkills(null);
      List<Player> players = Collections.singletonList(player);

      // When & Then
      assertThrows(NullPointerException.class, () -> playerAnalyzer.calculateScore(players));
    }

    @Test
    void testCalculateScore_EmptyArray() {
      // Given
      List<Player> players = Collections.emptyList();

      // When
      double result = playerAnalyzer.calculateScore(players);

      // Then
      assertEquals(0, result);
    }
  }

  @Nested
  class CornerCases {

    @Test
    void testCalculateScore_SkillsIsEmpty() {
      // Given
      Player player = new Player();
      player.setAge(25);
      player.setExperience(5);
      player.setSkills(Collections.emptyList());

      // When
      double result = playerAnalyzer.calculateScore(Collections.singletonList(player));

      // Then
      assertTrue(Double.isNaN(result));
    }

    @Test
    void testCalculateScore_PlayerFieldsNotAffected() {
      // Given
      Player player = new Player();
      player.setName("John");
      player.setAge(25);
      player.setExperience(5);
      player.setSkills(Arrays.asList(2, 2, 2));

      // When
      playerAnalyzer.calculateScore(Collections.singletonList(player));

      // Then
      assertEquals("John", player.getName());
      assertEquals(25, player.getAge());
      assertEquals(5, player.getExperience());
      assertEquals(Arrays.asList(2, 2, 2), player.getSkills());
    }
  }
}
