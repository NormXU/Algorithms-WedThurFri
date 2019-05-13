Question 1 Pick a random number from an array


already shuffled || not shuffled yet


for (int index = 0; index < 52; ++index) {
  int j = random(52 - index) + index;
  swap(cards[j], card[index]);
}
================================================================================
How to do a sampling from a stream of unknow/unlimited size

Element sample = null;
int counter    = 0;

Element newElement = stream.getNext();
while (newElement != null) {
  counter++;
  if (random(counter) == 0) {
    sample = newElement;
    print(sample);
  }
  newElement = stream.getNext;

}
================================================================================
How to do K sampling from a stream of unknow/unlimited size

Element[] sample = new Element[100];
for (int i = 0; i < 100; ++i) {
  sample[i] = stream.getNext();
}

//Stream with unknown size
Element newElement = stream.getNext();
while (newElement != null) {
  counter++;
  int r = random(counter);
  if (r < 100) {
    sample[r] = newElement;
    print(sample)
  }
  newElement = stream.get
}
