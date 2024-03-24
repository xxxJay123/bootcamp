public enum Rank {
  ONE(1, 12), //
  TWO(2, 13), //
  THREE(3, 1), //
  FOUR(4, 2), //
  FIVE(5, 3), //
  SIX(6, 4), //
  SEVEN(7, 5), //
  EIGHT(8, 6), //
  NINE(9, 7), //
  TEN(10, 8), //
  JACK(11, 9), //
  QUEEN(12, 10), //
  KING(13, 11), //
  // JOKER(14), //
  ;

  int pokerRank;
  int big2Rank;

  private Rank(int pokerRank, int big2Rank) {
    this.pokerRank = pokerRank;
    this.big2Rank = big2Rank;
  }

  public int getPokerRank() {
    return this.pokerRank;
  }

  public int getBig2Rank() {
    return this.big2Rank;
  }

  public int compare(Game game, Rank rank) { // -1, 0, 1
    int result = switch (game) {
      case POKER -> compare(this.pokerRank, rank.getPokerRank());
      case BIG2 -> compare(this.big2Rank, rank.getBig2Rank());
      default -> 0;
    };
    return result;
  }

  private static int compare(int x, int y) {
    if (x > y)
      return 1;
    else if (x < y)
      return -1;
    return 0;
  }
}
