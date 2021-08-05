class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n_row = len(grid)
        n_col = len(grid[0])
        
        visited = [[0 for _ in range(n_col)] for _ in range(n_row)]
        areas = []
        
        for i in range(n_row):
            for j in range(n_col):
                if visited[i][j] == 1:
                    continue
                else:
                    if grid[i][j] == 1:
                        area = get_area(grid, visited, i, j)
                        areas.append(area)
                        
                    else:
                        visited[i][j] = 1
                        
        return max(areas) if len(areas) > 0 else 0
    
def get_area(grid, visited, i, j):
    n_row = len(grid)
    n_col = len(grid[0])
    visited[i][j] = 1
    
    area = grid[i][j]
    if i-1 >= 0 and visited[i-1][j]==0 and grid[i-1][j]==1:
        # upper area
        area += get_area(grid, visited, i-1, j)
    
    if i+1 < n_row and visited[i+1][j]==0 and grid[i+1][j]==1:
        # lower area
        area += get_area(grid, visited, i+1, j)
        
    if j-1 >= 0 and visited[i][j-1]==0 and grid[i][j-1]==1:
        # left area
        area += get_area(grid, visited, i, j-1)
        
    if j+1 < n_col and visited[i][j+1]==0 and grid[i][j+1]==1:
        # right area
        area += get_area(grid, visited, i, j+1)
        
    return area
    
    
    
                    