package p111t2;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.impl.CTRectImpl;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: t2.f0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1805f0 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8614a;
    public final /* synthetic */ CTRectImpl b;

    public /* synthetic */ C1805f0(CTRectImpl cTRectImpl, int i5) {
        this.f8614a = i5;
        this.b = cTRectImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8614a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setTextboxArray(iIntValue, (CTTextbox) obj2);
                break;
            case 1:
                this.b.setAnchorlockArray(iIntValue, (CTAnchorLock) obj2);
                break;
            case 2:
                this.b.setWrapArray(iIntValue, (CTWrap) obj2);
                break;
            case 3:
                this.b.setShadowArray(iIntValue, (CTShadow) obj2);
                break;
            case 4:
                this.b.setImagedataArray(iIntValue, (CTImageData) obj2);
                break;
            case 5:
                this.b.setLockArray(iIntValue, (CTLock) obj2);
                break;
            case 6:
                this.b.setTextpathArray(iIntValue, (CTTextPath) obj2);
                break;
            case 7:
                this.b.setSignaturelineArray(iIntValue, (CTSignatureLine) obj2);
                break;
            case 8:
                this.b.setClientDataArray(iIntValue, (CTClientData) obj2);
                break;
            case 9:
                this.b.setPathArray(iIntValue, (CTPath) obj2);
                break;
            case 10:
                this.b.setStrokeArray(iIntValue, (CTStroke) obj2);
                break;
            case 11:
                this.b.setFormulasArray(iIntValue, (CTFormulas) obj2);
                break;
            case 12:
                this.b.setHandlesArray(iIntValue, (CTHandles) obj2);
                break;
            default:
                this.b.setFillArray(iIntValue, (CTFill) obj2);
                break;
        }
    }
}
