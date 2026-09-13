package p072m4;

import P3.a;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements Iterable, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6174a;
    public final /* synthetic */ r b;

    public /* synthetic */ u(r rVar, int i5) {
        this.f6174a = i5;
        this.b = rVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f6174a) {
            case 0:
                return new t(this.b, 0);
            default:
                return new t(this.b, 1);
        }
    }
}
