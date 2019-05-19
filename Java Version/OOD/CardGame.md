# Card Game

棋牌类游戏道具

- 对游戏道具和游戏状态的描述

- 游戏规则和游戏流程的描述

  

  ```java
  public enum Suit{
      Club,
      Diamond,
      Heart,
      Spade
  }
  ```

  

```java
public enum FaceValue{
    Ace,
    Two,
    Three,
    // .....
}
```

```java
public class Card{
    private final int faceValue;
    private final Suit suit;
    
    public Card(int c, Suit s){
        faceValue = c;
        suit      = s;
    }
    
    public int value(){
        return faceValue;
    }
    
    public Suit suit(){
        return suit;
    }
    
}
```

```java
public class Deck{
    private static final Random random = new Random();
    private final List<Card> cards = new ArrayList<>();
    private int deltaIndex = 0;
    
    public Deck(){
        for(int i = 1; i <= 13; i++){
            for(Suit suit: Suit.values()){
                cards.add(new Card(i, suit));
            }
        }
    }
    
    public void shuffle(){
        for(int i = 0; i < cards.size()-1; i++){
            int j = random.nextInt(cards.size()-i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }
    
    private int remainingCards(){
        return cards.size() - deltaIndex;
    }
    
    public Card dealCard(){
        return remainingCards() == 0 ? null : cards.get(deltaIndex++);
    }
}
```

