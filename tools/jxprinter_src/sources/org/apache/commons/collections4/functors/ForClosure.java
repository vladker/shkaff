package org.apache.commons.collections4.functors;

import org.apache.commons.collections4.Closure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ForClosure<E> implements Closure<E> {
    private final Closure<? super E> iClosure;
    private final int iCount;

    public ForClosure(int i5, Closure<? super E> closure) {
        this.iCount = i5;
        this.iClosure = closure;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Closure<E> forClosure(int i5, Closure<? super E> closure) {
        if (i5 <= 0 || closure == 0) {
            return NOPClosure.nopClosure();
        }
        return i5 == 1 ? closure : new ForClosure(i5, closure);
    }

    @Override // org.apache.commons.collections4.Closure
    public void execute(E e) {
        for (int i5 = 0; i5 < this.iCount; i5++) {
            this.iClosure.execute(e);
        }
    }

    public Closure<? super E> getClosure() {
        return this.iClosure;
    }

    public int getCount() {
        return this.iCount;
    }
}
