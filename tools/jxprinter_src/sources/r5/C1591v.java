package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColorScaleImpl;

/* JADX INFO: renamed from: r5.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1591v implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8079a;
    public final /* synthetic */ CTColorScaleImpl b;

    public /* synthetic */ C1591v(CTColorScaleImpl cTColorScaleImpl, int i5) {
        this.f8079a = i5;
        this.b = cTColorScaleImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfCfvoArray;
        switch (this.f8079a) {
            case 0:
                iSizeOfCfvoArray = this.b.sizeOfCfvoArray();
                break;
            default:
                iSizeOfCfvoArray = this.b.sizeOfColorArray();
                break;
        }
        return Integer.valueOf(iSizeOfCfvoArray);
    }
}
