package r5;

import java.util.function.Function;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColorScaleImpl;

/* JADX INFO: renamed from: r5.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C1585s implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8073a;
    public final /* synthetic */ CTColorScaleImpl b;

    public /* synthetic */ C1585s(CTColorScaleImpl cTColorScaleImpl, int i5) {
        this.f8073a = i5;
        this.b = cTColorScaleImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8073a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getCfvoArray(iIntValue);
            case 1:
                return this.b.insertNewCfvo(iIntValue);
            case 2:
                return this.b.getColorArray(iIntValue);
            default:
                return this.b.insertNewColor(iIntValue);
        }
    }
}
