package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbut implements Map.Entry {
    private final Map.Entry zba;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zba.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zbuv) this.zba.getValue()) == null) {
            return null;
        }
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zbvm) {
            return ((zbuv) this.zba.getValue()).zbc((zbvm) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zbuv zba() {
        return (zbuv) this.zba.getValue();
    }
}
