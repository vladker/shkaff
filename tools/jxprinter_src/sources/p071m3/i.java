package p071m3;

import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.b[] f6136a;

    public i(t5.b[] bVarArr) {
        this.f6136a = bVarArr;
    }

    @Override // p117u3.b
    public final int a() {
        return this.f6136a.length;
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                this.f6136a[i5].subscribe(cVarArr[i5]);
            }
        }
    }
}
