package elevengame;

/**
 * Represents the table with cards to play and a deck
 * @author janvit
 */
public class Board implements BoardInterface{
    private Card[] cards;
    private Deck deck;
    
    public Board(){
        deck = new Deck(DataStore.loadSymbols(), DataStore.loadValues(), DataStore.loadNPoints());
        cards = new Card[nCards()];
        for (int i = 0; i < nCards(); i++) {
            this.cards[i] = this.deck.deal();
        }
    }
    
    @Override
    public String gameName() {
        return "Hra jedenactka";
    }
    
    @Override
    public int nCards() {
        return DataStore.getNCards();
    }

    @Override
    public int getDeckSize() {
        return this.deck.getDeckSize();
    }
    
    @Override
    public String getCardDescriptionAt(int index){
        if(cards[index] == null){
            return " ";
        }
        return cards[index].getSymbol() + "-" + cards[index].getValue();
    }

    @Override
    public boolean anotherPlayIsPossible() {
        for (int i = 0; i < nCards(); i++) {
            for (int j = i + 1; j < nCards(); j++) {
                if (isPlayPossible(new int[] {i, j})) {
                    return true;
                }
                for (int k = j + 1; k < nCards(); k++) {
                    if (isPlayPossible(new int[] {i, j, k})) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean playAndReplace(int[] iSelectedCards) {
        boolean passedValidation = isPlayPossible(iSelectedCards);
        if(passedValidation){
            for (int i : iSelectedCards) {
                this.cards[i] = this.deck.deal();
            }
        }
        return passedValidation;
    }
    
    private boolean isPlayPossible(int[] iSelectedCards){
        switch (iSelectedCards.length) {
            case 2:
            {
                Card a = this.cards[iSelectedCards[0]];
                Card b = this.cards[iSelectedCards[1]];
                return a.getnPoints() + b.getnPoints() == 11;
            }
            case 3:
            {
                Card a = this.cards[iSelectedCards[0]];
                Card b = this.cards[iSelectedCards[1]];
                Card c = this.cards[iSelectedCards[2]];
                return a.getnPoints() + b.getnPoints() + c.getnPoints() == 0;
            }
            default:
                return false;
        }
    }

    @Override
    public boolean isWon() {
        return cards.length == 0 && this.deck.getDeckSize() == 0;
    }
}
