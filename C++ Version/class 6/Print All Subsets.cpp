using namespace std;
void printAllSubsets(string s, int idx, string& out){
  if (idx == s.size()) {
    cout << out << " ";
    return;
  }
  for (int i = 0; i < s.size(); i++) {
    out.push_back(s[i]);
    printAllSubsets(s, i+1, out);
    out = out.substr(0, out.length()-1);

    printAllSubsets(s, i+1, out);

  }
}
