class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if(q.size() == 0) return;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] != Integer.MAX_VALUE)
                    continue;

                q.add(new int[]{nr, nc});

                grid[nr][nc] = grid[row][col] + 1;
            }
            
        }
    }
}
