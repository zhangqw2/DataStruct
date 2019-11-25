package com.base.tree;

import com.base.array.ListArray;

import com.base.array.List;


public class BuildHuffmanTree {
    /**
     * 构造Huffman树
     * @param nodes
     * @return
     */
    public static HuffmanTreeNode buildHuffmanTree(HuffmanTreeNode[] nodes){
        int n = nodes.length;
        if(n<2){
            return nodes[0];
        }
        //根结点线性表，按weight从大到小有序
        List l = new ListArray();
        //将结点逐一插入线性表
        for (int i = 0; i < n; i++) {
            insertToList(l,nodes[i]);
        }
        for (int i = 0; i < n; i++) {
            HuffmanTreeNode min1 = (HuffmanTreeNode)l.remove(l.getSize()-1);
            HuffmanTreeNode min2 = (HuffmanTreeNode)l.remove(l.getSize()-1);
            HuffmanTreeNode newRoot = new HuffmanTreeNode(min1.getWeight()+min2.getWeight());
            //合并
            newRoot.setLChild(min1);
            newRoot.setRChild(min2);
            //新树插入线性表
            insertToList(l,newRoot);
        }
        //返回Huffman树的根
        return (HuffmanTreeNode)l.get(0);
    }

    /**
     * 将结点按照weight从大到小的顺序插入线性表
     * @param l
     * @param node
     */
    public static void insertToList(List l, HuffmanTreeNode node){
        for (int i = 0; i < l.getSize(); i++) {
            if(node.getWeight()>((HuffmanTreeNode)l.get(i)).getWeight()){
                l.insert(i,node);
                return;
            }
            l.insert(l.getSize(),node);
        }
    }

    /**
     * 递归生成Huffman编码
     * @param root
     */
    public static void generateHuffmanCode(HuffmanTreeNode root){
        if(root == null){
            return;
        }
        if(root.hasParent()){
            if(root.isLChild()){
                //向左为0
                root.setCoding(root.getParent().getCoding()+"0");
            }else{
                //向右为1
                root.setCoding(root.getParent().getCoding()+"1");
            }
        }
        generateHuffmanCode(root.getlChild());
        generateHuffmanCode(root.getRChild());
    }

}
