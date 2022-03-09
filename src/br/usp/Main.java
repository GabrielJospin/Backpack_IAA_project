package br.usp;

import br.usp.algorithm.Algorithm;
import br.usp.algorithm.Dinamic;
import br.usp.algorithm.Greedy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Object> toObjectList(int[] weights, int[] values) throws Exception {

        if(weights == null || values == null)
            return null;

        if(weights.length != values.length){
            String ex = String.format("Weights and values must be the same length \nWeights = %d and Valus = %d",
                    weights.length, values.length);
            throw new Exception(ex);
        }

        List<Object> list = new ArrayList<>();
        for(int i = 0; i<weights.length; i++)
            list.add(new Object(values[i], weights[i], i));
        return list;
    }

    private static void testAlg(Algorithm algorithm, int[] weights, int[] values, int limitValue) throws Exception {
        List<Object> objects = toObjectList(weights,values);
        algorithm.setObjects(objects);
        algorithm.run(limitValue);
        List<Integer> result = algorithm.getResult();
        System.out.println(result);
        System.out.printf("The result for %s is %d\n",
                algorithm.getClass().toString() ,
                algorithm.backpack.getValue());
    }

    public static void main(String[] args) {
        Algorithm[] algs = {new Greedy(), new Dinamic()};
        int[] weights = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10};
        int[] value = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 10};
        int limitValue = 10;

        try {
            for ( Algorithm alg: algs)
                testAlg(alg, weights, value, limitValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
