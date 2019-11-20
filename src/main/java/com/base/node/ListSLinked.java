package com.base.node;

import com.base.array.ListArray;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListSLinked implements List {
    /**
     * 单链表首结点引用
     */
    private SLNode head;
    /**
     * 线性表中数据元素的个数
     */
    private int size;

    public ListSLinked(){
        head = new SLNode();
        size = 0;
    }

    /**
     * 获取数据元素e所在的前驱结点
     * @param e
     * @return
     */
    private SLNode getPreNode(Object e){
        SLNode p = head;
        while(p.getNext() != null){
            if(e.equals(p.getNext().getData())){
                return p;
            }else{
                p = p.getNext();
            }
        }
        return null;
    }

    /**
     * 获取序号为0<=index<size的元素所在结点的前驱结点
     * @param index
     * @return
     */
    private SLNode getPreNode(int index){
        SLNode p = head;
        for (; index > 0 ; index--) {
            p = p.getNext();
        }
        return p;
    }

    /**
     * 获取序号为0<=i<size的元素所在结点
     * @param index
     * @return
     */
    public SLNode getNode(int index){
        SLNode p = head.getNext();
        for (; index > 0 ; index --) {
            p = p.getNext();
        }
        return p;
    }

    /**
     * 返回线性表的大小，即数据元素的个数
     * @return
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * 如果线性表为空返回true，否则返回false
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断线性表是否包含数据元素o
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        SLNode p = head.getNext();
        while(p!=null){
            if(o.equals(p.getData())){
                return true;
            }else{
                p = p.getNext();
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        SLNode p = getPreNode(o);
        if(p!=null) {
            p.setNext(p.getNext().getNext());
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * 返回线性表中序号为i的数据元素
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Object get(int index) throws IndexOutOfBoundsException{
        if(index<0|index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        SLNode p = getNode(index);
        return p.getData();
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }


    /**
     * 删除线性表中序号为index的元素，并返回
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException{
        if(index<0|index>=size){
            throw new IndexOutOfBoundsException();
        }
        SLNode p = getPreNode(index);
        Object obj = p.getNext().getData();
        p.setNext(p.getNext().getNext());
        size--;
        return obj;
    }

    /**
     * 返回数据元素o在线性表中的序号
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        SLNode p = head.getNext();
        int index = 0;
        while(p!=null){
            if(o.equals(p.getData())){
                return index;
            }else{
                index++;
                p=p.getNext();
            }
        }
        return -1;
    }

    /**
     * 将数据元素o插入到线性表index位置
     * @param index
     * @param o
     * @throws IndexOutOfBoundsException
     */
    public void insert(int index ,Object o)throws IndexOutOfBoundsException{
        if(index<0|index>size){
            throw new IndexOutOfBoundsException();
        }
        SLNode p = getPreNode(index);
        SLNode q = new SLNode(o,p.getNext());
        p.setNext(q);
        size++;
    }

    /**
     * 将数据元素o插入元素obj之前
     * @param obj
     * @param o
     * @return
     */
    public boolean insertBefore(Object obj,Object o){
        SLNode p = getPreNode(obj);
        if(p!=null){
            SLNode q = new SLNode(o,p.getNext());
            p.setNext(q);
            size++;
            return true;
        }
        return false;
    }

    /**
     * 将数据元素o插入元素obj之后
     * @param obj
     * @param o
     * @return
     */
    public boolean insertAfter(Object obj,Object o){
        SLNode p = head.getNext();
        while(p!=null){
            if(p.getData().equals(obj)){
                SLNode q = new SLNode(o,p.getNext());
                p.setNext(q);
                size++;
                return true;
            }else{
                p = p.getNext();
            }
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
