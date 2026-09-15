#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <numeric>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int> answer;
    int denom = denom1 * denom2;
    numer1 *= denom2;
    numer2 *= denom1;
    int numer = numer1 +  numer2;
    // cout << numer;
    int g = gcd(denom, numer);
    // cout << g;
    answer.push_back(numer/g);
    answer.push_back(denom/g);
    return answer;
}