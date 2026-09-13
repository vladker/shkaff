package r5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTMapInfoImpl;

/* JADX INFO: renamed from: r5.j0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1569j0 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8056a;
    public final /* synthetic */ CTMapInfoImpl b;

    public /* synthetic */ C1569j0(CTMapInfoImpl cTMapInfoImpl, int i5) {
        this.f8056a = i5;
        this.b = cTMapInfoImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfSchemaArray;
        switch (this.f8056a) {
            case 0:
                iSizeOfSchemaArray = this.b.sizeOfSchemaArray();
                break;
            default:
                iSizeOfSchemaArray = this.b.sizeOfMapArray();
                break;
        }
        return Integer.valueOf(iSizeOfSchemaArray);
    }
}
