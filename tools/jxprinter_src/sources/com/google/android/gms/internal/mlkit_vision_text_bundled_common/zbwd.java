package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbwd implements Iterator {
    final /* synthetic */ zbwh zba;
    private int zbb = -1;
    private boolean zbc;
    private Iterator zbd;

    public /* synthetic */ zbwd(zbwh zbwhVar, zbwc zbwcVar) {
        this.zba = zbwhVar;
    }

    private final Iterator zba() {
        if (this.zbd == null) {
            this.zbd = this.zba.zbc.entrySet().iterator();
        }
        return this.zbd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i5 = this.zbb + 1;
        zbwh zbwhVar = this.zba;
        if (i5 >= zbwhVar.zbb) {
            return !zbwhVar.zbc.isEmpty() && zba().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zbc = true;
        int i5 = this.zbb + 1;
        this.zbb = i5;
        zbwh zbwhVar = this.zba;
        return i5 < zbwhVar.zbb ? (zbwb) zbwhVar.zba[i5] : (Map.Entry) zba().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zbc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zbc = false;
        this.zba.zbo();
        int i5 = this.zbb;
        zbwh zbwhVar = this.zba;
        if (i5 >= zbwhVar.zbb) {
            zba().remove();
        } else {
            this.zbb = i5 - 1;
            zbwhVar.zbm(i5);
        }
    }
}
