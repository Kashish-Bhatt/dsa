#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> add(vector<vector<int>> &mat1, 
                                vector<vector<int>> &mat2) {
    int r = mat1.size();
    int c = mat1[0].size();

    vector<vector<int>> res(r, vector<int>(c, 0));

    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            res[i][j] = mat1[i][j] + mat2[i][j];
        }
    }

    return res;
}

vector<vector<int>> multiply(vector<vector<int>> &mat1, 
                                        vector<vector<int>> &mat2) {
    int n = mat1.size();
    int m = mat1[0].size();
    int q = mat2[0].size();

    vector<vector<int>> res(n, vector<int>(q, 0));

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < q; ++j) {
            for (int k = 0; k < m; ++k) {
                res[i][j] += mat1[i][k] * mat2[k][j];
            }
        }
    }

    return res;
}

int main() {
    vector<vector<int>> mat1 = {
        {1, 2, 3},
        {4, 5, 6}
    };

    vector<vector<int>> mat2 = {
        {7, 8},
        {9, 10},
        {11, 12}
    };

    vector<vector<int>> res = multiply(mat1, mat2);

    for (auto &row : res) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }

    return 0;
}
