package A3;

import kotlin.jvm.internal.AbstractC1096j;

/* JADX INFO: renamed from: A3.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0154w implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52a;
    public final /* synthetic */ long[] b;

    public /* synthetic */ C0154w(long[] jArr, int i5) {
        this.f52a = i5;
        this.b = jArr;
    }

    @Override // O3.a
    public final Object invoke() {
        switch (this.f52a) {
            case 0:
                return AbstractC1096j.iterator(this.b);
            default:
                return p147z3.K.m1299iteratorimpl(this.b);
        }
    }
}
