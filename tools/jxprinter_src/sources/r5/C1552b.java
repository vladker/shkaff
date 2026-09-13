package r5;

import java.util.function.BiConsumer;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTAuthorsImpl;

/* JADX INFO: renamed from: r5.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1552b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8031a;
    public final /* synthetic */ CTAuthorsImpl b;

    public /* synthetic */ C1552b(CTAuthorsImpl cTAuthorsImpl, int i5) {
        this.f8031a = i5;
        this.b = cTAuthorsImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8031a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setAuthorArray(iIntValue, (String) obj2);
                break;
            case 1:
                this.b.insertAuthor(iIntValue, (String) obj2);
                break;
            default:
                this.b.xsetAuthorArray(iIntValue, (STXstring) obj2);
                break;
        }
    }
}
