package org.forest.fire.service;

import org.forest.fire.model.BurnStatus;
import org.forest.fire.model.Forest;
import org.forest.fire.model.Tree;
import org.forest.fire.utils.Config;

import java.util.ArrayList;

public class ForestService {

    public static Forest createForest(int h, int l) {
        ArrayList<ArrayList<Tree>> trees = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            ArrayList<Tree> tree = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                tree.add(new Tree());
            }
            trees.add(tree);
        }
        return new Forest(trees);
    }

    private static Forest startFire(Forest forest, int h, int l, int percentageFire) {
        int random = (int) (Math.random() * 100);
        if (random < percentageFire) {
            forest.findTree(h,l).setStatus(BurnStatus.ON_FIRE);
        }
        return forest;
    }

    public static Forest initialFire(Forest forest, int nbStart) {
        int maxH = forest.getTreeArray().size();
        int maxL = forest.getTreeArray().getFirst().size();
        if (maxH*maxL < nbStart) {
            throw new IllegalArgumentException("Le nbStart ne doit pas être plus grand que le nombre possible de start : nbStart="+nbStart+" max="+maxH*maxL );
        }
        for (int i = 0; i < nbStart; i++) {
            randomFire(forest, maxH, maxL);
        }
        forest.setStatus(BurnStatus.ON_FIRE);
        return forest;
    }

    private static Forest randomFire(Forest forest, int maxH, int maxL) {
        int randomH = Math.toIntExact(Math.round(Math.random() * (maxH-1)));
        int randomL = Math.toIntExact(Math.round(Math.random() * (maxL-1)));
        try {
            forest = startFire(forest, randomH, randomL,100);
        }catch (Exception e){
            e.printStackTrace();
            randomFire(forest, maxH, maxL);
        }
        return forest;
    }

    public static Forest spreadFire(Forest forest) {
        ArrayList<int[]> treesOnFire = new ArrayList<>();
        boolean finished = true;
        for (int row = 0; row < forest.getTreeArray().size(); row++) {
            for (int col = 0; col < forest.getTreeArray().get(row).size(); col++) {
                Tree tree = forest.findTree(row,col);
                if (tree.getStatus().equals(BurnStatus.ON_FIRE)){
                    finished = false;
                    treesOnFire.add(new int[]{row, col});
                    tree.setStatus(BurnStatus.BURNED);
                }
            }
        }
        if (finished){
            forest.setStatus(BurnStatus.BURNED);
            return forest;
        }
        treesOnFire.forEach(tree -> {
            forest.findAdjacentTree(tree[0],tree[1]).forEach(adjacent -> {
                if (forest.findTree(adjacent[0],adjacent[1]).getStatus().equals(BurnStatus.ALIVE)){
                    startFire(forest, adjacent[0], adjacent[1], Config.getInt("percentage",50));
                }
            });
        });
        return forest;
    }
}
