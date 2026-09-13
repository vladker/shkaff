package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSdtContentRunImpl;

/* JADX INFO: renamed from: s5.b3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1649b3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8381a;
    public final /* synthetic */ CTSdtContentRunImpl b;

    public /* synthetic */ C1649b3(CTSdtContentRunImpl cTSdtContentRunImpl, int i5) {
        this.f8381a = i5;
        this.b = cTSdtContentRunImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfPermStartArray;
        switch (this.f8381a) {
            case 0:
                iSizeOfPermStartArray = this.b.sizeOfPermStartArray();
                break;
            case 1:
                iSizeOfPermStartArray = this.b.sizeOfBdoArray();
                break;
            case 2:
                iSizeOfPermStartArray = this.b.sizeOfMoveToRangeStartArray();
                break;
            default:
                iSizeOfPermStartArray = this.b.sizeOfBookmarkEndArray();
                break;
        }
        return Integer.valueOf(iSizeOfPermStartArray);
    }
}
