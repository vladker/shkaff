package p134x2;

import A3.C;
import E3.g;
import F3.i;
import G3.b;
import G3.m;
import O3.p;
import U3.B;
import java.io.IOException;
import java.io.OutputStream;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f8885a;
    public final /* synthetic */ OutputStream b;
    public final /* synthetic */ p c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(byte[] bArr, OutputStream outputStream, p pVar, g gVar) {
        super(2, gVar);
        this.f8885a = bArr;
        this.b = outputStream;
        this.c = pVar;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new W(this.f8885a, this.b, this.c, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super u> gVar) {
        return ((W) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1361constructorimpl;
        OutputStream outputStream = this.b;
        byte[] bArr = this.f8885a;
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        try {
            int length = bArr.length;
            int i5 = length / 4096;
            if (i5 >= 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 * 4096;
                    int i8 = i6 == i5 ? length : (i6 + 1) * 4096;
                    outputStream.write(C.sliceArray(bArr, B.until(i7, i8)));
                    outputStream.flush();
                    p pVar = this.c;
                    if (pVar != null) {
                        pVar.invoke(b.boxInt(length), b.boxInt(i8));
                    }
                    if (i6 == i5) {
                        break;
                    }
                    i6++;
                }
            }
            O.INSTANCE.i("PrinterConnection", "send data size: " + length);
            objM1361constructorimpl = u.m1361constructorimpl(b.boxInt(length));
        } catch (IOException e) {
            O.INSTANCE.i("PrinterConnection", "write error.", e);
            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(e));
        }
        return u.a(objM1361constructorimpl);
    }
}
