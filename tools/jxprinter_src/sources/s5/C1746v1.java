package s5;

import java.util.function.Function;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTRImpl;

/* JADX INFO: renamed from: s5.v1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1746v1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8487a;
    public final /* synthetic */ CTRImpl b;

    public /* synthetic */ C1746v1(CTRImpl cTRImpl, int i5) {
        this.f8487a = i5;
        this.b = cTRImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8487a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getObjectArray(iIntValue);
            case 1:
                return this.b.insertNewObject(iIntValue);
            case 2:
                return this.b.getCommentReferenceArray(iIntValue);
            case 3:
                return this.b.insertNewCommentReference(iIntValue);
            case 4:
                return this.b.getLastRenderedPageBreakArray(iIntValue);
            default:
                return this.b.insertNewLastRenderedPageBreak(iIntValue);
        }
    }
}
