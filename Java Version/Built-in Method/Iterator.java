for (Iterator<Apple> it = list.iterator(); it.hasNext(); ) {
  Apple apple = iter.next();
  System.out.println(apple.printOut());
}


// Remove one item from it
for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
  String str = it.next();
  it.remove();
  break;
}


List<Apple> list = new ArrayList<>();
Apple apple = list.get(0);

// Iterator gets better
for (Iterator<Apple> iter = list.iterator(); iter.hasNext(); ) {
  Apple apple = iter.next();
}

// For Each
for ( Apple apple : list ) {
  apple.printOut();
}

创建一个list，实现形式是ArrayList<>， 数据类型是Apple，
所以在构造iterator的时候，Apple apple: list
即挨个取出每一个list中的元素
