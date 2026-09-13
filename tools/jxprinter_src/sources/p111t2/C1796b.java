package p111t2;

import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1796b implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8601a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1796b(CTGroupImpl cTGroupImpl, int i5) {
        this.f8601a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8601a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.getExtrusionArray(iIntValue);
            case 1:
                return this.b.getSignaturelineArray(iIntValue);
            case 2:
                return this.b.insertNewSignatureline(iIntValue);
            case 3:
                return this.b.getRectArray(iIntValue);
            case 4:
                return this.b.insertNewRect(iIntValue);
            case 5:
                return this.b.getHandlesArray(iIntValue);
            case 6:
                return this.b.getCalloutArray(iIntValue);
            case 7:
                return this.b.insertNewCallout(iIntValue);
            case 8:
                return this.b.getArcArray(iIntValue);
            case 9:
                return this.b.insertNewArc(iIntValue);
            case 10:
                return this.b.getClippathArray(iIntValue);
            case 11:
                return this.b.insertNewClippath(iIntValue);
            case 12:
                return this.b.getTextdataArray(iIntValue);
            case 13:
                return this.b.insertNewTextdata(iIntValue);
            case 14:
                return this.b.insertNewHandles(iIntValue);
            case 15:
                return this.b.getRoundrectArray(iIntValue);
            case 16:
                return this.b.insertNewRoundrect(iIntValue);
            case 17:
                return this.b.getTextpathArray(iIntValue);
            case 18:
                return this.b.insertNewTextpath(iIntValue);
            case 19:
                return this.b.getTextboxArray(iIntValue);
            case 20:
                return this.b.insertNewTextbox(iIntValue);
            case 21:
                return this.b.getLineArray(iIntValue);
            case 22:
                return this.b.insertNewLine(iIntValue);
            case 23:
                return this.b.getCurveArray(iIntValue);
            case 24:
                return this.b.insertNewCurve(iIntValue);
            case 25:
                return this.b.getShadowArray(iIntValue);
            case 26:
                return this.b.insertNewShadow(iIntValue);
            case 27:
                return this.b.getBorderbottomArray(iIntValue);
            case 28:
                return this.b.getPathArray(iIntValue);
            default:
                return this.b.insertNewPath(iIntValue);
        }
    }
}
