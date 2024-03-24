public enum Suit {
  DIAMOND(1), //
  CLUB(2), //
  HEART(3), //
  SPADE(4), //
  ;

  int normalRank;

  private Suit(int normalRank) {
    this.normalRank = normalRank;
  }

  public int getNormalRank() {
    return this.normalRank;
  }

  public int compare(Game game, Suit suit) {
    int result = switch (game) {
      case POKER -> compare(this.normalRank, suit.getNormalRank());
      case BIG2 -> compare(this.normalRank, suit.getNormalRank());
      default -> compare(this.normalRank, suit.getNormalRank());
    };
    return result;
  }

  public static int compare(int x, int y) {
    if (x > y)
      return 1;
    else if (x < y)
      return -1;
    return 0;
  }
}
