package s5;

import java.util.function.Supplier;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSimpleFieldImpl;

/* JADX INFO: renamed from: s5.v3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1748v3 implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8489a;
    public final /* synthetic */ CTSimpleFieldImpl b;

    public /* synthetic */ C1748v3(CTSimpleFieldImpl cTSimpleFieldImpl, int i5) {
        this.f8489a = i5;
        this.b = cTSimpleFieldImpl;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int iSizeOfBookmarkEndArray;
        switch (this.f8489a) {
            case 0:
                iSizeOfBookmarkEndArray = this.b.sizeOfBookmarkEndArray();
                break;
            case 1:
                iSizeOfBookmarkEndArray = this.b.sizeOfMoveFromArray();
                break;
            case 2:
                iSizeOfBookmarkEndArray = this.b.sizeOfBookmarkStartArray();
                break;
            default:
                iSizeOfBookmarkEndArray = this.b.sizeOfInsArray();
                break;
        }
        return Integer.valueOf(iSizeOfBookmarkEndArray);
    }
}
