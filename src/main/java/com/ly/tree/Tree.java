package com.ly.tree;

public interface Tree<T extends Comparable<? super T>> {

    /**
     * 插入
     * @param val
     */
    void insert(T val);

    /**
     * 查找
     * @param val
     * @return
     */
    Boolean find(T val);

    /**
     * 查询最大的
     * @return
     */
    Node<T> findMax();

    /**
     * 查询最小的
     * @return
     */
    Node<T> findMin();

    /**
     * 删除
     * @param val
     * @return
     */
    Node<T> remove(T val);

}
