package s5;

import java.util.function.Consumer;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSimpleFieldImpl;

/* JADX INFO: renamed from: s5.u3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1743u3 implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8484a;
    public final /* synthetic */ CTSimpleFieldImpl b;

    public /* synthetic */ C1743u3(CTSimpleFieldImpl cTSimpleFieldImpl, int i5) {
        this.f8484a = i5;
        this.b = cTSimpleFieldImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i5 = this.f8484a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.removeBookmarkEnd(iIntValue);
                break;
            case 1:
                this.b.removeIns(iIntValue);
                break;
            case 2:
                this.b.removeMoveFrom(iIntValue);
                break;
            default:
                this.b.removeBookmarkStart(iIntValue);
                break;
        }
    }
}
