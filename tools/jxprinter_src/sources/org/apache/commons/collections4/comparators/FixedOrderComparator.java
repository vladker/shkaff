package org.apache.commons.collections4.comparators;

import androidx.collection.a;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FixedOrderComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 82794675842863201L;
    private final Map<T, Integer> map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;

    /* JADX INFO: renamed from: org.apache.commons.collections4.comparators.FixedOrderComparator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior;

        static {
            int[] iArr = new int[UnknownObjectBehavior.values().length];
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior = iArr;
            try {
                iArr[UnknownObjectBehavior.BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public FixedOrderComparator() {
    }

    public boolean add(T t6) {
        checkLocked();
        Map<T, Integer> map = this.map;
        int i5 = this.counter;
        this.counter = i5 + 1;
        return map.put(t6, Integer.valueOf(i5)) == null;
    }

    public boolean addAsEqual(T t6, T t7) {
        checkLocked();
        Integer num = this.map.get(t6);
        if (num != null) {
            return this.map.put(t7, num) == null;
        }
        throw new IllegalArgumentException(t6 + " not known to " + this);
    }

    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    @Override // java.util.Comparator
    public int compare(T t6, T t7) {
        this.isLocked = true;
        Integer num = this.map.get(t6);
        Integer num2 = this.map.get(t7);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[this.unknownObjectBehavior.ordinal()];
        if (i5 == 1) {
            if (num == null) {
                return num2 == null ? 0 : -1;
            }
            return 1;
        }
        if (i5 == 2) {
            if (num == null) {
                return num2 == null ? 0 : 1;
            }
            return -1;
        }
        if (i5 == 3) {
            if (num != null) {
                t6 = t7;
            }
            throw new IllegalArgumentException(a.l(t6, "Attempting to compare unknown object "));
        }
        throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        UnknownObjectBehavior unknownObjectBehavior;
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
            Map<T, Integer> map = this.map;
            if (map != null ? map.equals(fixedOrderComparator.map) : fixedOrderComparator.map == null) {
                UnknownObjectBehavior unknownObjectBehavior2 = this.unknownObjectBehavior;
                if (unknownObjectBehavior2 != null ? !(unknownObjectBehavior2 != (unknownObjectBehavior = fixedOrderComparator.unknownObjectBehavior) || this.counter != fixedOrderComparator.counter || this.isLocked != fixedOrderComparator.isLocked || unknownObjectBehavior2 != unknownObjectBehavior) : fixedOrderComparator.unknownObjectBehavior == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public int hashCode() {
        int iHashCode = (this.map.hashCode() + 629) * 37;
        UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
        return ((((iHashCode + (unknownObjectBehavior == null ? 0 : unknownObjectBehavior.hashCode())) * 37) + this.counter) * 37) + (!this.isLocked ? 1 : 0);
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        if (unknownObjectBehavior == null) {
            throw new NullPointerException("Unknown object behavior must not be null");
        }
        this.unknownObjectBehavior = unknownObjectBehavior;
    }

    public FixedOrderComparator(T... tArr) {
        if (tArr != null) {
            for (T t6 : tArr) {
                add(t6);
            }
            return;
        }
        throw new NullPointerException("The list of items must not be null");
    }

    public FixedOrderComparator(List<T> list) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return;
        }
        throw new NullPointerException("The list of items must not be null");
    }
}
