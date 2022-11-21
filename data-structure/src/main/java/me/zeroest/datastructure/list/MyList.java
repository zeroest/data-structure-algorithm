package me.zeroest.datastructure.list;

public interface MyList<T> {
    void add(int idx, T data);
    void append(T data);
    T remove(int idx);
    boolean remove(T data);
    T get(int idx);
    void set(int idx, T data);
    int indexOf(T data);
    int size();
    boolean isEmpty();
    void clear();
}
