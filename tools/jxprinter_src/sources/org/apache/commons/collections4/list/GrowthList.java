package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public static <E> GrowthList<E> growthList(List<E> list) {
        return new GrowthList<>(list);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i5, E e) {
        int size = decorated().size();
        if (i5 > size) {
            decorated().addAll(Collections.nCopies(i5 - size, null));
        }
        decorated().add(i5, e);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        boolean z6;
        int size = decorated().size();
        if (i5 > size) {
            decorated().addAll(Collections.nCopies(i5 - size, null));
            z6 = true;
        } else {
            z6 = false;
        }
        return decorated().addAll(i5, collection) || z6;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i5, E e) {
        int size = decorated().size();
        if (i5 >= size) {
            decorated().addAll(Collections.nCopies((i5 - size) + 1, null));
        }
        return decorated().set(i5, e);
    }

    public GrowthList(int i5) {
        super(new ArrayList(i5));
    }

    public GrowthList(List<E> list) {
        super(list);
    }
}
