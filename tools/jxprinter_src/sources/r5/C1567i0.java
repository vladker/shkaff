package r5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTMapInfoImpl;

/* JADX INFO: renamed from: r5.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1567i0 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8053a;
    public final /* synthetic */ CTMapInfoImpl b;

    public /* synthetic */ C1567i0(CTMapInfoImpl cTMapInfoImpl, int i5) {
        this.f8053a = i5;
        this.b = cTMapInfoImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8053a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSchema(iIntValue);
                break;
            default:
                this.b.removeMap(iIntValue);
                break;
        }
    }
}
