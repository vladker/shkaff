package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zbjz implements Iterator {
    private Object zba;
    private int zbb = 2;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5 = this.zbb;
        if (i5 == 4) {
            throw new IllegalStateException();
        }
        int i6 = i5 - 1;
        if (i5 == 0) {
            throw null;
        }
        if (i6 == 0) {
            return true;
        }
        if (i6 != 2) {
            this.zbb = 4;
            this.zba = zba();
            if (this.zbb != 3) {
                this.zbb = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.zbb = 2;
        Object obj = this.zba;
        this.zba = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public abstract Object zba();

    public final Object zbb() {
        this.zbb = 3;
        return null;
    }
}
