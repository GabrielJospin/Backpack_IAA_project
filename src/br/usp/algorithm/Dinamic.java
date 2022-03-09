package br.usp.algorithm;

import br.usp.Backpack;

public class Dinamic extends Algorithm{

    @Override
    public void run(int limitValue) { //O(n²)

        this.backpack = new Backpack(limitValue);                           //1

        int[][] array = new int[objects.size() + 1][limitValue + 1];        //1
        for(int i = 1; i <= objects.size(); i++){                           //W
          for(int j = 1; j <= limitValue; j++){                             //n*W
              if(objects.get(i-1).getWeight() < backpack.getFreeSpace())    //...
                  array[i][j] = array[i-1][j];                              //...
              else {                                                        //...
                  int notUse = array[i-1][j];                               //...
                  int use = array[i-1][j] + objects.get(i-1).getValue();    //...
                  array[i][j] = Math.max(use, notUse);                      //...
              }                                                             
          }
        }

        int j = limitValue;                                                //1
        for(int i = objects.size(); i >= 1; i--){                          //n
            if(array[i][j] == array[i-1][j]) {                             //...
                getResult().add(objects.get(i-1).getPositionArray());      //...
                backpack.addObject(objects.get(i-1));                      //...
            }else                                                          //...
                j = j - objects.get(i-1).getWeight();                      //...
        }

    }

}

//T = n*w*7 + W + n + 2 => T=7n*w + W + n + 2 => T = O(n*W) 

/*
JÁ EM MEMORIA:
array =[n][W] m = n*W
objects =[n] m =n
Result = [n] m =n

M = n*W + 2n => M O(n*W)
*/