package common;

public class Pairs extends Node {
    public int verticalOrder;
    public int horizontalOrder;

    public Pairs(Node node, int o1, int o2) {
        super(node);
        this.verticalOrder = o1;
        this.horizontalOrder = o2;
    }
}