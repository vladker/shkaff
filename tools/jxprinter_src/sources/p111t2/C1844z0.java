package p111t2;

import com.microsoft.schemas.vml.impl.CTRoundRectImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1844z0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8657a;
    public final /* synthetic */ CTRoundRectImpl b;

    public /* synthetic */ C1844z0(CTRoundRectImpl cTRoundRectImpl, int i5) {
        this.f8657a = i5;
        this.b = cTRoundRectImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8657a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewImagedata(iIntValue);
            case 1:
                return this.b.getSignaturelineArray(iIntValue);
            case 2:
                return this.b.insertNewSignatureline(iIntValue);
            case 3:
                return this.b.getTextpathArray(iIntValue);
            case 4:
                return this.b.insertNewTextpath(iIntValue);
            case 5:
                return this.b.getLockArray(iIntValue);
            case 6:
                return this.b.insertNewLock(iIntValue);
            case 7:
                return this.b.insertNewBorderright(iIntValue);
            case 8:
                return this.b.getExtrusionArray(iIntValue);
            case 9:
                return this.b.insertNewExtrusion(iIntValue);
            case 10:
                return this.b.getStrokeArray(iIntValue);
            case 11:
                return this.b.insertNewStroke(iIntValue);
            case 12:
                return this.b.getAnchorlockArray(iIntValue);
            case 13:
                return this.b.insertNewAnchorlock(iIntValue);
            case 14:
                return this.b.getBordertopArray(iIntValue);
            default:
                return this.b.insertNewBordertop(iIntValue);
        }
    }
}
