package androidx.core.util;

import U3.AbstractC0212i;
import U3.InterfaceC0213j;
import android.util.Range;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        return range.intersect(range2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t6) {
        return range.extend(t6);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t6, T t7) {
        return new Range<>(t6, t7);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> InterfaceC0213j toClosedRange(final Range<T> range) {
        return new InterfaceC0213j() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // U3.InterfaceC0213j, U3.z
            public boolean contains(Comparable comparable) {
                return AbstractC0212i.contains(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // U3.InterfaceC0213j
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // U3.InterfaceC0213j, U3.z
            public Comparable getStart() {
                return range.getLower();
            }

            @Override // U3.InterfaceC0213j
            public boolean isEmpty() {
                return AbstractC0212i.isEmpty(this);
            }
        };
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(InterfaceC0213j interfaceC0213j) {
        return new Range<>(interfaceC0213j.getStart(), interfaceC0213j.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        return range.extend(range2);
    }
}
