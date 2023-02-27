/*
ZIELSTELLUNG
Your task is to write an algorithm which receives the weight of the animal and returns the different masses (gram) which are used in a List.

Szenario 1: Tiny Slow Loris
In this scenario you have a list of calibrated masses. For every weight (of the Slow Loris) which is given to your function you should return a List with the masses you need for weighing the Slow Lori. Note that you can use every single mass only once!

Given is a List<Integer> which includes the calibrated masses of the balance.
Your Slow Loris weighs only 145 grams.
Your function should return an List<Integer> with all needed masses to weigh the slow loris: [1, 16, 128] .
Your algorithm should work with lighter and heavier slow loris as well.
*/

package de.entwicklerheld.scalechallenge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Scale {
    static List<Integer> getMasses(Integer weight, List<Integer> allMasses) {
        // You need to implement this method.
        // You can also add attributes to the class and add new methods or functions
        List<Integer> myMasses = allMasses;
        Collections.sort(myMasses, Collections.reverseOrder());
        List<Integer> neededMasses = new ArrayList<>();
        int weightLeft = weight;

            for(int i = 0; i < myMasses.size(); i++){
                if(myMasses.get(i) <= weightLeft){
                    neededMasses.add(myMasses.get(i));
                    weightLeft = weightLeft - myMasses.get(i);
                }

                if(weightLeft == 0)
                break;
            }

        return neededMasses;
    }
}