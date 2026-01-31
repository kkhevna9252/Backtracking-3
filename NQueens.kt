// In this problem, we need to place n queens on a n x n board following some rules. We use backtracking to solve this problem. We try to place q queen row by row and check if that position is a valid poistion. the way to check if the position is valid or not is by checking the portion above the current location.
// so we check if there is any queen in the rows above, on the top left diagnoal and top right diagonal.
// If the position is valid we place the queen and move to the next row. If we reach the end of the board, we add the current board configuration to the result.
// Time complexity is O(N!) where N is the number of queens. Space complexity is O(N^2) for the board.
class Solution {
    val result = mutableListOf<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
       val board = Array(n) { BooleanArray(n) }
        helper(board, 0, n)
        return result
    }

    fun helper(board: Array<BooleanArray>, row: Int, n: Int) {
        //base
        if (row == n) {
            val list = mutableListOf<String>()
            for(i in 0 until n) {
                var sb = StringBuilder()
                for(j in 0 until n) {
                    if(board[i][j]) {
                        sb.append('Q')
                    } else {
                        sb.append('.')
                    }
                }
                list.add(sb.toString())
            }
            result.add(list)
            return
        }
        //action

        for(j in 0 until n) {
            if(isValid(board, row, j, n)) {
                board[row][j] = true
                helper(board, row + 1, n)
                board[row][j] = false
            }
        }
    }

    fun isValid(board: Array<BooleanArray>, i: Int, j: Int, n: Int) : Boolean {
        var row = i
        var col = j

        //check straight up
        while(row>= 0) {
            if(board[row][col]) return false
            row--
        } 

        row = i
        col = j
        //check left up 
        while(row >= 0 && col >= 0) {
            if(board[row][col]) return false
            row--
            col--
        }

        row = i
        col = j
        //check right up 
        while(row >= 0 && col < n) {
            if(board[row][col]) return false
            row--
            col++
        }

        return true
    }
}