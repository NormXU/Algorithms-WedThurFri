s1 [ 5
s2 [ 4 3 2 1


class Q2S {
private:
  stack<int> s1;
  stack<int> s2;

public:
  Q2S (){};
  ~Q2S (){

  };

  void push(int value) {
    s1.push(value);
  }

  int poll(){
    if (s2.empty()) {
      while (!s1.empty()) {
        s2.push(s1.pop());
      }
    }
    if (s2.empty()) {
      return null;
    }
    return s2.pop();
  }
};
