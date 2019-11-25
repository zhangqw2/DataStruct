package com.base.tree;

public class HuffmanTreeNode extends BinTreeNode {
    //权值
    private int weight;
    //编码
    private String coding = "";
    public HuffmanTreeNode(int weight){
        this(weight,null);
    }
    public HuffmanTreeNode(int weight,Object e){
        super(e);
        this.weight = weight;
    }
    @Override
    public HuffmanTreeNode getParent(){
        return (HuffmanTreeNode)super.getParent();
    }

   @Override
    public HuffmanTreeNode getlChild(){
        return (HuffmanTreeNode)super.getlChild();
    }
    @Override
    public HuffmanTreeNode getRChild(){
        return (HuffmanTreeNode)super.getRChild();
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }
}
