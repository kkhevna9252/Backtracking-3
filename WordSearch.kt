// In this problem, we need to find if a give word exists in the board by moving in all 4 directions. We use backtracking to solve this problem. We start from each cell and try to find
// the word by moving in all 4 directions. We mark the cell as visited by changing the character to a special character and backtrack after exploring all possibilities from that cell.
// Time complexity is O(M * N * 3^L) where M is number of rows, N is number of columns and L is length of the word. Space complexity is O(L) for the recursion stack.

class Solution {
             val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )
    var m = 0
    var n = 0
    fun exist(board: Array<CharArray>, word: String): Boolean {
        m = board.size
        n = board[0].size

        for(i in 0 until m) {
            for(j in 0 until n) {
                if(dfs(board, word, i, j, 0)) return true
            }

        }
        return false

    }

    fun dfs(board: Array<CharArray>, word: String, i: Int, j : Int, idx: Int) : Boolean {
        //base
        if(idx == word.length) return true
        if(i < 0 || j <0 || i == m || j == n || board[i][j] == '#') return false
        if(board[i][j] != word[idx]) return false
        //logic
        board[i][j] = '#'
        for(dir in dirs) {
            val r = dir[0] + i
            val c = dir[1] + j

            if(dfs(board, word, r, c, idx + 1)) return true
        }

        board[i][j] = word[idx]
        return false
    }
}