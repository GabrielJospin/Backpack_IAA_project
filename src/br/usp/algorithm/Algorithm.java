package br.usp.algorithm;

import br.usp.Backpack;
import br.usp.Object;

import java.util.ArrayList;
import java.util.List;

public abstract class Algorithm {

    private List<Integer> result = new ArrayList<>();
    public Backpack backpack;
    protected List<Object> objects = null;

    public abstract void run(int limitValue);
    public void setObjects(List<Object> list){
        this.objects = list;
    }
    public List<Integer> getResult(){
        return result;
    }


}
