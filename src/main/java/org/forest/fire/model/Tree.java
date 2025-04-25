package org.forest.fire.model;

public class Tree {
    private BurnStatus status = BurnStatus.ALIVE;;

    public BurnStatus getStatus() {
        return status;
    }

    public void setStatus(BurnStatus status) {
        switch (this.status) {
            case ALIVE:
                if (status != BurnStatus.ON_FIRE) {
                    throw new IllegalArgumentException("L'arbre ne peut pas avoir le status "+status+" car l'arbre à un status : "+this.status);
                }
                this.status = status;
                break;
            case ON_FIRE:
                if (status != BurnStatus.BURNED) {
                    throw new IllegalArgumentException("L'arbre ne peut pas avoir le status "+status+" car l'arbre à un status : "+this.status);
                }
                this.status = status;
                break;
            default:
                throw new IllegalArgumentException("L'arbre ne peut pas avoir le status "+status+" car l'arbre à un status : "+this.status);
        }
    }
}
