using namespace std;
class CompTopKFrequencyWords {
public:
  std::vector<string> topK(std::vector<string> dictionary, int k){
    std::vector<int> result;
    if (k <= 0 || dictionary.size() == 0) {
      return;
    }
    std::map<string, int> count;
    int len = dictionary.size();
    for (int i = 0; i < len; i++) {
      count[dictionary[i]]++;
    }
    // Maintain a min-heap whose size is k
    priority_queue< pair<string, int>, vector<pair<string, int> >, Comparator> pq;
    for (map<string, int>::iterator it = count.begin(); it != count.end(); ++it) {
      pq.push(*it);
      if (pq.size() > k) {
        pq.pop();
      }
    }

    while (!pq.empty()) {
      result.push_back(pq.top().first);
      pq.pop();
    }
    return result;
    }

};

class Comparator{
  public operator(pair<string, int> left, pair<string,int> right){
    return left.second > right.second;
  }
}
