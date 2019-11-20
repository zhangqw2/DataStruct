package com.base.array;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.cglib.core.DefaultGeneratorStrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListArray implements List {
    /**
     * 数组的默认大小
     */

   private final int LEN = 8;
    /**
     * 数组元素个数
     */
    private int size;

    /**
     * 数据元素数组
     */
    private Object[] elements;


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
        return size==0;
    }

    /**
     * 判断线性表是否包含数据元素e
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(elements[i])){
                return true;
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

    /**
     * 删除线性表中第一个与e相同的元素
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if(i<0){
            return false;
        }
        remove(i);
        return true;
    }

    /**
     * 替换线性表中序号为i的数据元素为e，返回原数据元素
     * @param i
     * @param e
     * @return
     * @throws IndexOutOfBoundsException
     */
    public Object replace(int i,Object e)throws IndexOutOfBoundsException{
        if(i<0|i>size){
            throw new IndexOutOfBoundsException();
        }
        Object  obj = elements[i];
        elements[i] = e;
        return obj;
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

    @Override
    public Object get(int index) throws IndexOutOfBoundsException{
        if(index<0|index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        return elements[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) throws IndexOutOfBoundsException{
        if(index<0|index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        if(size >= elements.length){
            expandSpace();
        }
        for (int j = size; j > index ; j--) {
            elements[j]= elements[j-1];
        }
        elements[index]=element;
        size++;
        return;

    }
    private void expandSpace(){
        Object[] a = new Object[elements.length*2];
        for (int i = 0; i < elements.length; i++) {
            a[i]=elements[i];
        }
        elements = a;
    }

    /**
     * 将数据元素e插入到元素obj之前
     * @param obj
     * @param e
     * @return
     */
    public boolean addBefore(Object obj,Object e){
        int i = indexOf(obj);
        if(i<0){
            return false;
        }
        add(i,e);
        return true;
    }

    public boolean insertAfter(Object obj,Object e){
        int i = indexOf(obj);
        if(i<0){
            return false;
        }
        add(i+1,e);
        return true;
    }

    /**
     * 删除线性表中第一个与e相同的元素
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Object remove(int index) throws IndexOutOfBoundsException{
        if(index<0|index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Object obj = elements[index];
        for (int j = index; j < size-1; j++) {
            elements[j]=elements[j+1];
        }
        elements[--size]=null;
        return obj;
    }

    /**
     * 返回数据元素e在线性表中的序号
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(elements[i])){
                return i;
            }
        }
        return 0;
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
