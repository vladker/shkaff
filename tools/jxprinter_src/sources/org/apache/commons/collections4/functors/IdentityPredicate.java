package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IdentityPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public IdentityPredicate(T t6) {
        this.iValue = t6;
    }

    public static <T> Predicate<T> identityPredicate(T t6) {
        return t6 == null ? NullPredicate.nullPredicate() : new IdentityPredicate(t6);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t6) {
        return this.iValue == t6;
    }

    public T getValue() {
        return this.iValue;
    }
}
