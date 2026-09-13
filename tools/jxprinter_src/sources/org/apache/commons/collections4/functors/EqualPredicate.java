package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EqualPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T iValue;

    public EqualPredicate(T t6) {
        this(t6, null);
    }

    public static <T> Predicate<T> equalPredicate(T t6) {
        return t6 == null ? NullPredicate.nullPredicate() : new EqualPredicate(t6);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t6) {
        Equator<T> equator = this.equator;
        return equator != null ? equator.equate(this.iValue, t6) : this.iValue.equals(t6);
    }

    public Object getValue() {
        return this.iValue;
    }

    public EqualPredicate(T t6, Equator<T> equator) {
        this.iValue = t6;
        this.equator = equator;
    }

    public static <T> Predicate<T> equalPredicate(T t6, Equator<T> equator) {
        if (t6 == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t6, equator);
    }
}
