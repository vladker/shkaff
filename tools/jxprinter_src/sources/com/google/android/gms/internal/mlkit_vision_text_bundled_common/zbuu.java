package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbuu implements Iterator {
    private final Iterator zba;

    public zbuu(Iterator it) {
        this.zba = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zba.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zba.next();
        return entry.getValue() instanceof zbuv ? new zbut(entry, null) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zba.remove();
    }
}
