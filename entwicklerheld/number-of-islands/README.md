# Number of islands

### Zusammenfassung

You have a 2D map with water (marked by 0) and land (marked by 1). Connected parts of land are forming an island. Your algorithm should take such a map and return the number of islands. Many companies like Microsoft, Amazon or Visa ask this in an interview.

## STAGE 1

### Zielstellung

In a 2D map with water (marked by 0) and land (marked by 1). Connected land parts are forming an island. Your algorithm should take such a map and return the number of islands. In this Stage you should try to create a sample map to make sure you understood the task.

### Szenario 1: Create sample Map

A map is a 2D Array of chars were '0' means water and '1' means land.

Create a sample map and save it to the variable input.

Your map should have 4 rows.

Your map should have 3 columns per row.

Every row should have at least one column with land (marked with the char '1' ).

No other characters than '0' and '1' are allowed.

Your map should have exactly 3 islands.

## STAGE 2

### Zielstellung

Implement the numberOfIslands method to count and return the number of islands for a given char[][]. Keep your code readable and clean.

### Szenario 1: Map with only water

Giving following map:

![empty map](/material/img/empty_map.png)

As the map contains only water your function should return 0 islands

### Szenario 2: Map with only land

Giving following map:

![full map](/material/img/full_map.png)

As the map contains only land your function should return 1 island

### Szenario 3: Map with diagonal unconnected island

Giving following map:

![unconnected map](/material/img/unconnected_island.png)

As island are not connected by diagonal land, your function should return 3

### Szenario 4: Map with one island connected by middle row

Giving following map:

![simple map](/material/img/simple.png)

The '1' in the middle row connects the first and second row to one island, so your function should return 1

### Szenario 5: Medium sized map

Giving following map:

![medium map](/material/img/medium_map.png)

Your function should return 1 for this map in reasonable time

### Szenario 6: Big map

Giving following map:

![big map](/material/img/big_map.png)

Your function should return 1 for this map in reasonable time

## STAGE 3

### Zielstellung

A colleague of you implemented the number of island algorithm. He asked you to refactor it by using a Map class with custom iterator and convenience methods.

### Szenario 1: Convert char[][] to MapPart[][]

MapPart contains convinience methods like isLand or isWater. To work more nicely with the map we want to transform the char[][] to a MapPart[][]. Here is link to MapPart.java .

Given following map:

![gridToMap map](/material/img/gridToMap.png)

The constructor of the Map class should convert char[][] to MapPart[][]

If char[][] is empty or null an empty MapPart[][] should be constructed

The item at row 0 and column 0 should have value '1' and wasChecked should be set to false

The item at row 0 and column 1 should have value '1' and wasChecked should be set to false

The item at row 0 and column 2 should have value '0' and wasChecked should be set to false

The item at row 1 and column 0 should have value '1' and wasChecked should be set to false

The item at row 1 and column 1 should have value '1' and wasChecked should be set to false

The item at row 1 and column 2 should have value '0' and wasChecked should be set to false

The item at row 2 and column 0 should have value '0' and wasChecked should be set to false

The item at row 2 and column 1 should have value '0' and wasChecked should be set to false

The item at row 2 and column 2 should have value '1' and wasChecked should be set to false

### Szenario 2: Implement iterator for Map class

To remove the nested for loop with explicit row and column index we want to implement a custom iterator for the Map class.

Given following map containing numbers from 1-6 :

![iterator map](/material/img/iterator.png)

The iterator should return the numbers 1-6 in their natural order: 1,2,3,4,5,6

That means if we iterate through the map, we will loop 6 times

If the MapPart[][] is empty the iterator should not throw an exception

### Szenario 3: Implement getTopMapPart method

To safely access the MapPart above the current one, without catching an ArrayOutOfBoundException, we want to implement the getTopMapPart method.

Giving following map containing numbers from 1-6 :

![iterator map](/material/img/iterator.png)

If getTopMapPart is called on the MapPart containing the '1' the method should return a MapPart with value '0' as outside of the map is water

If getTopMapPart is called on the MapPart containing the '3' the method should return a MapPart with value '1' as it is above the '3'

### Szenario 4: Implement getBottomMapPart method

To safely access the MapPart underneath the current one, without catching an ArrayOutOfBoundException, we want to implement the getBottomMapPart method.

Giving following map containing numbers from 1-6 :

![iterator map](/material/img/iterator.png)

If getBottomMapPart is called on the MapPart containing the '1' the method should return a MapPart with value '3' as it is underneath the '1'

If getBottomMapPart is called on the MapPart containing the '5' the method should return a MapPart with value '0' as outside of the map is water

### Szenario 5: Implement getLeftMapPart method

To safely access the MapPart on the left side of the current one, without catching an ArrayOutOfBoundException, we want to implement the getLeftMapPart method.

Giving following map containing numbers from 1-6 :

![iterator map](/material/img/iterator.png)

If getLeftMapPart is called on the MapPart containing the '1' the method should return a MapPart with value '0' as outside of the map is water

If getLeftMapPart is called on the MapPart containing the '2' the method should return a MapPart with value '1' as it is on the left side of the '2'

### Szenario 6: Implement getRightMapPart method

To safely access the MapPart on the right side of the current one, without catching an ArrayOutOfBoundException, we want to implement the getRightMapPart method.

Giving following map containing numbers from 1-6 :

![iterator map](/material/img/iterator.png)

If getRightMapPart is called on the MapPart containing the '2' the method should return a MapPart with value '0' as outside of the map is water

If getRightMapPart is called on the MapPart containing the '3' the method should return a MapPart with value '4' as it is on the right side of the '3'

### Szenario 7: The algorithm should still work

After the refactoring the numIslands method should still work as expected

If numIslands method is called with an empty map it should still work

If numIslands method is called with diagonal unconnected map it should still work

If numIslands method is called with an simple connected map it should still work

If numIslands method is called with an medium sized map it should still work

If numIslands method is called with an big map it should still work
