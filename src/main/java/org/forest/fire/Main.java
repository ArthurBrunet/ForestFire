package org.forest.fire;

import org.forest.fire.model.BurnStatus;
import org.forest.fire.model.Forest;
import org.forest.fire.service.DisplayForestService;
import org.forest.fire.service.ForestService;
import org.forest.fire.utils.Config;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Forest forest = ForestService.createForest(Config.getInt("h",10),Config.getInt("l",10));
        forest = ForestService.initialFire(forest, Config.getInt("nbStart",5));
        while (forest.getStatus().equals(BurnStatus.ON_FIRE)){
            forest = ForestService.spreadFire(forest);
            DisplayForestService.display(forest, Config.getInt("cellSize",10));
            Thread.sleep(Config.getInt("refreshFrame",500));
        }
    }
}