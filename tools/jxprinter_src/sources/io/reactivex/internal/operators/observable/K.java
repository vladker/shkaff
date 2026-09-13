package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4996a;
    public final io.reactivex.G[] b;
    public final Iterable c;
    public final p027e3.o d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4997f;

    public /* synthetic */ K(io.reactivex.G[] gArr, Iterable iterable, p027e3.o oVar, int i5, boolean z6, int i6) {
        this.f4996a = i6;
        this.b = gArr;
        this.c = iterable;
        this.d = oVar;
        this.e = i5;
        this.f4997f = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        int length;
        int length2;
        switch (this.f4996a) {
            case 0:
                io.reactivex.G[] gArr = this.b;
                if (gArr == null) {
                    gArr = new io.reactivex.B[8];
                    length = 0;
                    for (io.reactivex.G g6 : this.c) {
                        if (length == gArr.length) {
                            io.reactivex.G[] gArr2 = new io.reactivex.G[(length >> 2) + length];
                            System.arraycopy(gArr, 0, gArr2, 0, length);
                            gArr = gArr2;
                        }
                        gArr[length] = g6;
                        length++;
                    }
                } else {
                    length = gArr.length;
                }
                if (length == 0) {
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onComplete();
                } else {
                    J j6 = new J(length, this.e, this.d, i5, this.f4997f);
                    I[] iArr = j6.c;
                    int length3 = iArr.length;
                    j6.f4978a.onSubscribe(j6);
                    for (int i6 = 0; i6 < length3 && !j6.f4981h && !j6.f4980g; i6++) {
                        gArr[i6].subscribe(iArr[i6]);
                    }
                }
                break;
            default:
                io.reactivex.G[] gArr3 = this.b;
                if (gArr3 == null) {
                    gArr3 = new io.reactivex.B[8];
                    length2 = 0;
                    for (io.reactivex.G g7 : this.c) {
                        if (length2 == gArr3.length) {
                            io.reactivex.G[] gArr4 = new io.reactivex.G[(length2 >> 2) + length2];
                            System.arraycopy(gArr3, 0, gArr4, 0, length2);
                            gArr3 = gArr4;
                        }
                        gArr3[length2] = g7;
                        length2++;
                    }
                } else {
                    length2 = gArr3.length;
                }
                if (length2 == 0) {
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onComplete();
                } else {
                    S3 s6 = new S3(i5, this.d, length2, this.f4997f);
                    int i7 = this.e;
                    T3[] t3Arr = s6.c;
                    int length4 = t3Arr.length;
                    for (int i8 = 0; i8 < length4; i8++) {
                        t3Arr[i8] = new T3(s6, i7);
                    }
                    s6.lazySet(0);
                    s6.f5103a.onSubscribe(s6);
                    for (int i9 = 0; i9 < length4 && !s6.f5104f; i9++) {
                        gArr3[i9].subscribe(t3Arr[i9]);
                    }
                }
                break;
        }
    }
}
