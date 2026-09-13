package p111t2;

import com.microsoft.schemas.vml.impl.CTLineImpl;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class J implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8565a;
    public final /* synthetic */ CTLineImpl b;

    public /* synthetic */ J(CTLineImpl cTLineImpl, int i5) {
        this.f8565a = i5;
        this.b = cTLineImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8565a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewClientData(iIntValue);
            case 1:
                return this.b.getBorderbottomArray(iIntValue);
            case 2:
                return this.b.insertNewBorderbottom(iIntValue);
            case 3:
                return this.b.getFillArray(iIntValue);
            case 4:
                return this.b.insertNewFill(iIntValue);
            case 5:
                return this.b.getTextpathArray(iIntValue);
            case 6:
                return this.b.insertNewTextpath(iIntValue);
            case 7:
                return this.b.insertNewBorderright(iIntValue);
            case 8:
                return this.b.getPathArray(iIntValue);
            case 9:
                return this.b.insertNewPath(iIntValue);
            case 10:
                return this.b.getTextboxArray(iIntValue);
            case 11:
                return this.b.insertNewTextbox(iIntValue);
            case 12:
                return this.b.getLockArray(iIntValue);
            case 13:
                return this.b.insertNewLock(iIntValue);
            case 14:
                return this.b.getAnchorlockArray(iIntValue);
            default:
                return this.b.insertNewAnchorlock(iIntValue);
        }
    }
}
