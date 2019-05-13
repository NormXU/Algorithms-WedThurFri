Given a random generator random5(), the return value of random5()
is 0 - 4 with equal probability. Use random5() to implement random7().

public class RandomSeven {
  public int random7(){
    while (true) {
      // To generator 0 - 24 number
      int random = 5 * RandomFive.random5() + RandomFive.random5();
      // We only care about the first 21 numbers and ignore
      // Numbers >= 21
      if (random < 21) {
        return random % 7;
      }
    }
  }
}
