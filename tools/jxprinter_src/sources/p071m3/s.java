package p071m3;

import io.reactivex.internal.operators.flowable.J0;
import p027e3.a;
import p027e3.g;
import p027e3.p;
import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6153a;
    public final g b;
    public final g c;
    public final g d;
    public final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f6154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f6155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f6156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f6157i;

    public s(b bVar, g gVar, g gVar2, g gVar3, a aVar, a aVar2, g gVar4, p pVar, a aVar3) {
        this.f6153a = bVar;
        this.b = gVar;
        this.c = gVar2;
        this.d = gVar3;
        this.e = aVar;
        this.f6154f = aVar2;
        this.f6155g = gVar4;
        this.f6156h = pVar;
        this.f6157i = aVar3;
    }

    @Override // p117u3.b
    public final int a() {
        return this.f6153a.a();
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length];
            for (int i5 = 0; i5 < length; i5++) {
                cVarArr2[i5] = new J0(cVarArr[i5], this, 2);
            }
            this.f6153a.subscribe(cVarArr2);
        }
    }
}
