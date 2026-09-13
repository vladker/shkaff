package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbsu extends zbsv {
    final /* synthetic */ zbtc zba;
    private int zbb = 0;
    private final int zbc;

    public zbsu(zbtc zbtcVar) {
        this.zba = zbtcVar;
        this.zbc = zbtcVar.zbd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zbb < this.zbc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbsx
    public final byte zba() {
        int i5 = this.zbb;
        if (i5 >= this.zbc) {
            throw new NoSuchElementException();
        }
        this.zbb = i5 + 1;
        return this.zba.zbb(i5);
    }
}
