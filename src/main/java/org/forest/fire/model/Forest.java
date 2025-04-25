package org.forest.fire.model;

import java.util.ArrayList;

public class Forest {

    private BurnStatus status = BurnStatus.ALIVE;
    private ArrayList<ArrayList<Tree>> treeArray;


    public Forest(ArrayList<ArrayList<Tree>> treeArray) {
        this.treeArray = treeArray;
    }

    public Tree findTree(int h, int l){
        return treeArray.get(h).get(l);
    }

    public ArrayList<int[]> findAdjacentTree(int h, int l){
        int maxH = treeArray.size() - 1;
        int maxL = treeArray.getFirst().size() - 1;
        ArrayList<int[]> adjacent = new ArrayList<>();
        if (h - 1 >= 0) {
            adjacent.add(new int[]{h - 1, l});
        }
        if (h + 1 <= maxH) {
            adjacent.add(new int[]{h + 1, l});
        }
        if (l - 1 >= 0) {
            adjacent.add(new int[]{h, l - 1});
        }
        if (l + 1 <= maxL) {
            adjacent.add(new int[]{h, l + 1});
        }
        return adjacent;
    }

    public BurnStatus getStatus() {
        return status;
    }

    public void setStatus(BurnStatus status) {
        this.status = status;
    }

    public ArrayList<ArrayList<Tree>> getTreeArray() {
        return treeArray;
    }
}
