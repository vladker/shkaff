package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ArrayStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() {
        int size = size();
        if (size > 0) {
            return get(size - 1);
        }
        throw new EmptyStackException();
    }

    public E pop() {
        int size = size();
        if (size > 0) {
            return remove(size - 1);
        }
        throw new EmptyStackException();
    }

    public E push(E e) {
        add(e);
        return e;
    }

    public int search(Object obj) {
        int i5 = 1;
        int size = size() - 1;
        while (size >= 0) {
            E e = get(size);
            if ((obj == null && e == null) || (obj != null && obj.equals(e))) {
                return i5;
            }
            size--;
            i5++;
        }
        return -1;
    }

    public ArrayStack(int i5) {
        super(i5);
    }

    public E peek(int i5) {
        int size = (size() - i5) - 1;
        if (size >= 0) {
            return get(size);
        }
        throw new EmptyStackException();
    }
}
