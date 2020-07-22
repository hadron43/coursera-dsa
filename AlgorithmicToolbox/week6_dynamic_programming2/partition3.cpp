#include <bits/stdc++.h>
using namespace std;

int partition3(vector<int> &A) {
  int target = accumulate(A.begin(), A.end(), 0);
  if(target % 3)
    return 0;
  target /= 3;
  int dp[target + 1][A.size() + 1] = {};

  for(int i=1; i<target + 1; ++i){
    for(int j=1; j<A.size() + 1; ++j){
      int temp = i - A[j-1];
      if(temp==0 || (temp > 0 && dp[temp][j-1])){
        dp[i][j] = min(dp[i][j-1] + 1, 2);
      }
      else {
        dp[i][j] = dp[i][j-1];
      }
    }
  }

  return (dp[target][A.size()]==2) ? 1 : 0;
}

int main() {
  int n;
  cin >> n;
  vector<int> A(n);
  for (size_t i = 0; i < A.size(); ++i) {
    cin >> A[i];
  }
  cout << partition3(A) << '\n';
}
