package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbko {
    private final zbkm zba;

    private zbko(zbkm zbkmVar) {
        int i5 = zbkc.zbb;
        this.zba = zbkmVar;
    }

    public static zbko zba(String str) {
        return new zbko(new zbkm("#vk "));
    }

    public final List zbb(CharSequence charSequence) {
        charSequence.getClass();
        zbkl zbklVar = new zbkl(this.zba, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zbklVar.hasNext()) {
            arrayList.add((String) zbklVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
