package com.tw.unoProject.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void shouldBeAbleToAddACardInCardsList() {
        Player player = new Player("somePlayer");
        player.addCard(new Card(CardPoints.EIGHT, CardColor.GREEN));

        List<Card> allCards = player.getMyCards();
        assertEquals(allCards.get(0), new Card(CardPoints.EIGHT, CardColor.GREEN));
    }

    @Test
    public void shouldBeAbleToGetAllTheCardsPresentInList() {
        Player player = new Player("someone");
        player.addCard(new Card(CardPoints.EIGHT, CardColor.YELLOW));
        player.addCard(new Card(CardPoints.FIVE, CardColor.RED));

        List<Card> allCards = player.getMyCards();
        assertEquals(2, allCards.size());
    }

    @Test
    public void shouldBeAbleToPlayACard() {
        Player player = new Player("someone");
        Card card = new Card(CardPoints.FIVE, CardColor.BLUE);
        player.addCard(card);
        player.playACard(card);
        assertEquals(0, player.getMyCards().size());
    }
    @Test
    public void shouldBeAbleToPlayCard() {
        Player player = new Player("me");
        Card card1 = new Card(CardPoints.EIGHT, CardColor.GREEN);
        Card card2 = new Card(CardPoints.FIVE, CardColor.BLUE);
        player.addCard(card1);
        player.addCard(card2);
        player.play(card1);
        List<Card> allCards = player.getMyCards();
        assertEquals(allCards.get(0), new Card(CardPoints.FIVE, CardColor.BLUE));
    }
    @Test
    public void shouldBeAbleToCalculatePoints() {
        Player player = new Player("me");
        Card card1 = new Card(CardPoints.EIGHT, CardColor.GREEN);
        Card card2 = new Card(CardPoints.FIVE, CardColor.BLUE);
        player.addCard(card1);
        player.addCard(card2);
        assertEquals(13,player.calculatePoints());
    }
}
