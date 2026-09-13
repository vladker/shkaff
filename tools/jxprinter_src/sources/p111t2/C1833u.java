package p111t2;

import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.Consumer;

/* JADX INFO: renamed from: t2.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1833u implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8646a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1833u(CTGroupImpl cTGroupImpl, int i5) {
        this.f8646a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8646a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeSkew(iIntValue);
                break;
            case 1:
                this.b.removePolyline(iIntValue);
                break;
            case 2:
                this.b.removeBordertop(iIntValue);
                break;
            case 3:
                this.b.removeShapetype(iIntValue);
                break;
            default:
                this.b.removeShape(iIntValue);
                break;
        }
    }
}
