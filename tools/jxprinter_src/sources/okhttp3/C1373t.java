package okhttp3;

import A4.C0169l;
import A4.InterfaceC0170m;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: okhttp3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1373t extends Q {
    public static final B c = B.a(ShareTarget.ENCODING_TYPE_URL_ENCODED);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6674a;
    public final List b;

    public C1373t(ArrayList arrayList, ArrayList arrayList2) {
        this.f6674a = p107s4.d.i(arrayList);
        this.b = p107s4.d.i(arrayList2);
    }

    private long writeOrCountBytes(InterfaceC0170m interfaceC0170m, boolean z6) throws EOFException {
        C0169l c0169l = z6 ? new C0169l() : interfaceC0170m.buffer();
        List list = this.f6674a;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                c0169l.writeByte(38);
            }
            c0169l.writeUtf8((String) list.get(i5));
            c0169l.writeByte(61);
            c0169l.writeUtf8((String) this.b.get(i5));
        }
        if (!z6) {
            return 0L;
        }
        long size2 = c0169l.size();
        c0169l.a();
        return size2;
    }

    @Override // okhttp3.Q
    public final long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.Q
    public final B contentType() {
        return c;
    }

    @Override // okhttp3.Q
    public void writeTo(InterfaceC0170m interfaceC0170m) throws EOFException {
        writeOrCountBytes(interfaceC0170m, false);
    }
}
