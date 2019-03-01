"""
Given the following definition of “Tesla”,
and an integer n (n > 0).
Make an array of n Tesla cars whose number of wheels is 4
and who “VIN” numbers are from 0 to n-1.

"""
class Tesla{
  int numofWheels;
  int vin;

  public Tesla(int n, int v){
    numofWheels = n;
    vin  = v;
  }
}

class Accumulator{
  public Tesla[] make(int n){
    Tesla[] s = new Tesla[n];
    for(int i=0; i < n; i++){
      s[i] = new Tesla(4,i);
    }
  }

  return s;
}
