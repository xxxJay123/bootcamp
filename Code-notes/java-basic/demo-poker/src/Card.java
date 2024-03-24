public class Card { // 52

  private Rank rank;
  private Suit suit;

  private Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() {
    return this.rank;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public static Card of(Rank rank, Suit suit) { // 1-13, 4 suits
    return new Card(rank, suit);
  }

  public int compare(Game game, Card card) {
    int result = -1;
    int res = switch (game) {
      case POKER -> {
        result = this.getRank().compare(game, rank);
        if (result == 0)
          yield this.getSuit().compare(game, suit);
        yield result;
      }
      case BIG2 -> {
        result = this.getRank().compare(game, rank);
        if (result == 0)
          yield this.getSuit().compare(game, suit);
        yield result;
      }
      default -> 0;
    };
    return res;
  }

  // public static Jocker Jocker() {
  // return Jocker.JOCKER;
  // }

}
