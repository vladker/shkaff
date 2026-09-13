package p111t2;

import com.microsoft.schemas.vml.impl.CTOvalImpl;
import java.util.function.Function;

/* JADX INFO: renamed from: t2.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1795a0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8599a;
    public final /* synthetic */ CTOvalImpl b;

    public /* synthetic */ C1795a0(CTOvalImpl cTOvalImpl, int i5) {
        this.f8599a = i5;
        this.b = cTOvalImpl;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i5 = this.f8599a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                return this.b.insertNewTextdata(iIntValue);
            case 1:
                return this.b.getImagedataArray(iIntValue);
            case 2:
                return this.b.insertNewImagedata(iIntValue);
            case 3:
                return this.b.getClientDataArray(iIntValue);
            case 4:
                return this.b.insertNewClientData(iIntValue);
            case 5:
                return this.b.getLockArray(iIntValue);
            case 6:
                return this.b.insertNewLock(iIntValue);
            case 7:
                return this.b.insertNewWrap(iIntValue);
            case 8:
                return this.b.getPathArray(iIntValue);
            case 9:
                return this.b.insertNewPath(iIntValue);
            case 10:
                return this.b.getHandlesArray(iIntValue);
            case 11:
                return this.b.insertNewHandles(iIntValue);
            case 12:
                return this.b.getFillArray(iIntValue);
            case 13:
                return this.b.insertNewFill(iIntValue);
            case 14:
                return this.b.getFormulasArray(iIntValue);
            default:
                return this.b.insertNewFormulas(iIntValue);
        }
    }
}
