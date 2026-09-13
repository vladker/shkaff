package org.apache.poi.sl.extractor;

import V2.f;
import java.util.BitSet;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements IntConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7184a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f7184a = i5;
        this.b = obj;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i5) {
        switch (this.f7184a) {
            case 0:
                ((f) this.b).j(i5);
                break;
            default:
                ((BitSet) this.b).set(i5);
                break;
        }
    }
}
