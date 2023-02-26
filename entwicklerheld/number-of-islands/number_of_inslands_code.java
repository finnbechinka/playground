//STAGE 1

package io.polylith.numberofislands;


import static org.junit.Assert.assertEquals;

public class Stage1 {
    public void testSimpleIsland(ISolution solution) {
        // Initialize input variable to a sample map
        char[][] input = {
                         {'1', '1', '0'},
                         {'1', '0', '0'},
                         {'0', '0', '1'},
                         {'1', '0', '0'}
        };

        int result = solution.numIslands(input);
    }

}

//STAGE 2

package io.polylith.numberofislands;

class Solution implements ISolution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        char[][] myGrid = grid;

        int islands = 0;

        int i;
        for(i = 0; i < rows; i++){
            int j;
            for(j = 0; j < colums; j++){
               if(myGrid[i][j] == '1'){
                   myGrid[i][j] = 'X';
                   islands++;
                   checkNeighbors(myGrid, rows, colums, i, j);
               }
            }
        }

        return islands;
    }

    public void checkNeighbors(char[][] grid, int rows, int colums, int row, int colum){
        if(colum + 1 < colums && grid[row][colum + 1] == '1'){
            grid[row][colum + 1] = 'X';
            checkNeighbors(grid, rows, colums, row, colum + 1);
        }
        if(row + 1 < rows && grid[row + 1][colum] == '1'){
            grid[row + 1][colum] = 'X';
            checkNeighbors(grid, rows, colums, row + 1, colum);
        }
        if(colum - 1 >= 0 && grid[row][colum - 1] == '1'){
            grid[row][colum - 1] = 'X';
            checkNeighbors(grid, rows, colums, row, colum - 1);
        }
        if(row - 1 >= 0 && grid[row - 1][colum] == '1'){
            grid[row - 1][colum] = 'X';
            checkNeighbors(grid, rows, colums, row - 1, colum);
        }
    }
}

//STAGE 3

package io.polylith.numberofislands;

import java.util.Iterator;

class SolutionRefactored implements ISolution {
    public class Map implements Iterable<MapPart> {
        private final MapPart[][] mapParts;

        public Map(char[][] grid) {
            // Implement transformation from char[][] to MapPart[][]
            if(grid == null || grid.length == 0){
                this.mapParts = new MapPart[0][0];
            }else{
                int rows = grid.length;
                int colums = grid[0].length;
                this.mapParts = new MapPart[rows][colums];
                int i;
                for(i = 0; i < rows; i++){
                    int j;
                    for(j = 0; j < colums; j++){
                        this.mapParts[i][j] = new MapPart(i,j,grid[i][j]);
                    }
                }
            }
        }

        public MapPart getTopMapPart(MapPart referenceMapPart) {
            // Implement this
            if(referenceMapPart.row > 0){
                return mapParts[referenceMapPart.row - 1][referenceMapPart.column];
            }else{
                MapPart tmp = new MapPart(-1, -1, '0');
                return tmp;
            }
        }

        public MapPart getBottomMapPart(MapPart referenceMapPart) {
            // Implement this
            if(referenceMapPart.row < mapParts.length - 1){
                return mapParts[referenceMapPart.row + 1][referenceMapPart.column];
            }else{
                MapPart tmp = new MapPart(-1, -1, '0');
                return tmp;
            }
        }

        public MapPart getLeftMapPart(MapPart referenceMapPart) {
            // Implement this
            if(referenceMapPart.column > 0){
                return mapParts[referenceMapPart.row][referenceMapPart.column - 1];
            }else{
                MapPart tmp = new MapPart(-1, -1, '0');
                return tmp;
            }
        }

        public MapPart getRightMapPart(MapPart referenceMapPart) {
            // Implement this
            if(referenceMapPart.column < mapParts[0].length - 1){
                return mapParts[referenceMapPart.row][referenceMapPart.column + 1];
            }else{
                MapPart tmp = new MapPart(-1, -1, '0');
                return tmp;
            }
        }

        public Iterator<MapPart> iterator() {
            return new Iterator<MapPart>() {

                private int currentRow = 0;
                private int currentColumn = 0;

                public boolean hasNext() {
                    // Implement this
                    return currentRow < mapParts.length && currentColumn < mapParts[0].length;
                }

                public MapPart next() {
                    // Implement this
                    if(hasNext()){
                        MapPart tmp = mapParts[currentRow][currentColumn];
                        if(currentColumn == mapParts[currentRow].length - 1){
                            currentRow++;
                            currentColumn = 0;
                        }else{
                            currentColumn++;
                        }
                        return tmp;
                    }
                    return null;
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public MapPart[][] getMapParts() {
            return mapParts;
        }
    }


    public int numIslands(char[][] grid) {
        Map map = new Map(grid);
        int islandCount = 0;

        for (MapPart mapPart : map) {
            if (mapPart.isWater() || mapPart.wasChecked) {
                continue;
            }

            islandCount += 1;
            mapPart.wasChecked = true;

            this.checkSurroundings(map, mapPart);
        }
        return islandCount;
    }

    private void checkSurroundings(Map map, MapPart part) {
        MapPart topMapPart = map.getTopMapPart(part);
        if (topMapPart.isLand() && !topMapPart.wasChecked) {
            topMapPart.wasChecked = true;
            checkSurroundings(map, topMapPart);
        }

        MapPart bottomPart = map.getBottomMapPart(part);
        if (bottomPart.isLand() && !bottomPart.wasChecked) {
            bottomPart.wasChecked = true;
            checkSurroundings(map, bottomPart);
        }

        MapPart rightPart = map.getRightMapPart(part);
        if (rightPart.isLand() && !rightPart.wasChecked) {
            rightPart.wasChecked = true;
            checkSurroundings(map, rightPart);
        }

        MapPart leftPart = map.getLeftMapPart(part);
        if (leftPart.isLand() && !leftPart.wasChecked) {
            leftPart.wasChecked = true;
            checkSurroundings(map, leftPart);
        }
    }
}
