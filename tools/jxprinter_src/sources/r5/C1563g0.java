package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTMapInfoImpl;

/* JADX INFO: renamed from: r5.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1563g0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8047a;
    public final /* synthetic */ CTMapInfoImpl b;

    public /* synthetic */ C1563g0(CTMapInfoImpl cTMapInfoImpl, int i5) {
        this.f8047a = i5;
        this.b = cTMapInfoImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8047a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getSchemaArray(iIntValue);
            case 1:
                return this.b.insertNewSchema(iIntValue);
            case 2:
                return this.b.getMapArray(iIntValue);
            default:
                return this.b.insertNewMap(iIntValue);
        }
    }
}
