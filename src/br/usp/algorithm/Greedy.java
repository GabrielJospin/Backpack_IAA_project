package br.usp.algorithm;


import br.usp.Backpack;
import br.usp.Object;

import java.util.ArrayList;
import java.util.List;

public class Greedy extends Algorithm{


    @Override
    public void run(int limitValue) {
        List<Object> orderArray = sortObjects(super.objects);
        this.backpack = new Backpack(limitValue);
        for(Object o: orderArray){
            try{

                if (!backpack.addObject(o))
                    break;
                else
                    getResult().add(o.getPositionArray());

            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }


    }

    private List<Object> sortObjects(List<Object> objects) {
        if(objects.size() == 1)
            return objects;

        List<Object> aux1 = new ArrayList<>();
        List<Object> aux2 = new ArrayList<>();

        for(int i =0; i < (int) objects.size()/2; i++)
            aux1.add(objects.get(i));

        for(int i = (int) objects.size()/2; i < objects.size(); i++)
            aux2.add(objects.get(i));

        sortObjects(aux1);
        sortObjects(aux2);

        return merge(aux1, aux2);
    }

    private List<Object> merge(List<Object> list1, List<Object> list2) {

        List<Object> answer = new ArrayList<>();
        while(list1.size() > 0 && list2.size() > 0) {
            if(list1.get(0).getValue() > list2.get(0).getValue() ) {
                answer.add(list1.get(0));
                list1.remove(list1.get(0));
            }else{
                answer.add(list2.get(0));
                list2.remove(list2.get(0));
            }
        }

        while (list1.size() > 0){
            answer.add(list1.get(0));
            list1.remove(list1.get(0));
        }

        while (list2.size() > 0){
            answer.add(list2.get(0));
            list2.remove(list2.get(0));
        }

        return answer;
    }


}
