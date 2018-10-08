package pkgCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck(ArrayList<Card> cardsInDeck2) {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	
	public int getRemaining(Object eNum) {
		int counter = 0;
		if (eNum instanceof eSuit) {
			 eSuit suit = (eSuit) eNum;
			 for (Card c : cardsInDeck) {
				 if (c.geteSuit() == suit) {
					 counter += 1;
				 } 
			 }
		   }
		if (eNum instanceof eRank) {
			eRank rank = (eRank) eNum;
			for (Card c : cardsInDeck) {
				if (c.geteRank() == rank) {
					counter +=1;
				}
			}
		}
		return counter;
	}
}