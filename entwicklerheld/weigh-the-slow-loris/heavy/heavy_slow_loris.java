package de.entwicklerheld.scalechallengehard;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

class Scale {
    static List<List<Integer>> getMasses(Integer slowLorisWeight, List<Integer> allMasses) {
        // You need to implement this method.
        // You can also add attributes to the class and add new methods or functions
        List<List<List<Integer>>> allPossible = new ArrayList<>();
        getAllPossible(allPossible, allMasses, new ArrayList<Integer>(), new ArrayList<Integer>());

        for (List<List<Integer>> curr : allPossible) {
            int left = 0;
            int right = 0;

            for (Integer i : curr.get(0)) {
                left = left + i;
            }
            for (Integer i : curr.get(1)) {
                right = right + i;
            }

            if (left + slowLorisWeight == right) {
                return curr;
            }
        }
        return allPossible.get(0);
    }

    static void getAllPossible(List<List<List<Integer>>> possible, List<Integer> masses, List<Integer> prevLeft,
            List<Integer> prevRight) {
        
        List<Integer> myMasses = new ArrayList<>(masses);

        for (int i = 0; i < myMasses.size(); i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            List<List<Integer>> tmp2 = new ArrayList<>();
            List<Integer> leftPlate = new ArrayList<>(prevLeft);
            List<Integer> rightPlate = new ArrayList<>(prevRight);

            leftPlate.add(myMasses.get(i));
            rightPlate.add(myMasses.get(i));
            myMasses.remove(i);

            tmp.add(prevLeft);
            tmp.add(rightPlate);
            tmp2.add(leftPlate);
            tmp2.add(prevRight);

            possible.add(tmp);
            possible.add(tmp2);
            
            getAllPossible(possible, myMasses, prevLeft, rightPlate);
            getAllPossible(possible, myMasses, leftPlate, prevRight);
            getAllPossible(possible, myMasses, prevLeft, prevRight);
        }
    }
}
