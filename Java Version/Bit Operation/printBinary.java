public class Bit {
  public static void printBinary(int value){
    System.out.println(value + " : ");
    StringBuilder builder = new StringBuilder();
    for (int shift = 31; shift >= 0;shift-- ) {
      builder.append((value >> shift) & 1);
    }
    System.out.println(builder.toString());
    System.out.println("");
  }
}


------------------------
String word;
for (char c : word.toCharArray() ) {

}
