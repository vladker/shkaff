package A3;

import kotlin.jvm.internal.AbstractC1096j;

/* JADX INFO: renamed from: A3.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C0155x implements O3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ C0155x(byte[] bArr, int i5) {
        this.f53a = i5;
        this.b = bArr;
    }

    @Override // O3.a
    public final Object invoke() {
        switch (this.f53a) {
            case 0:
                return AbstractC1096j.iterator(this.b);
            default:
                return p147z3.E.m1181iteratorimpl(this.b);
        }
    }
}
