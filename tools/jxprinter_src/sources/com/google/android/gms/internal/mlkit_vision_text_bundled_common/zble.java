package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zble implements Iterator {
    final Iterator zbb;

    public zble(Iterator it) {
        it.getClass();
        this.zbb = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zbb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zba(this.zbb.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zbb.remove();
    }

    public abstract Object zba(Object obj);
}
