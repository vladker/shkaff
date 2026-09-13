package p111t2;

import com.microsoft.schemas.office.excel.CTClientData;
import com.microsoft.schemas.office.office.CTLock;
import com.microsoft.schemas.office.office.CTSignatureLine;
import com.microsoft.schemas.office.word.CTAnchorLock;
import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.vml.CTFill;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.CTGroup;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.CTImageData;
import com.microsoft.schemas.vml.CTLine;
import com.microsoft.schemas.vml.CTOval;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.CTRect;
import com.microsoft.schemas.vml.CTRoundRect;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.CTShape;
import com.microsoft.schemas.vml.CTShapetype;
import com.microsoft.schemas.vml.CTStroke;
import com.microsoft.schemas.vml.CTTextPath;
import com.microsoft.schemas.vml.CTTextbox;
import com.microsoft.schemas.vml.impl.CTGroupImpl;
import java.util.function.BiConsumer;

/* JADX INFO: renamed from: t2.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C1798c implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8604a;
    public final /* synthetic */ CTGroupImpl b;

    public /* synthetic */ C1798c(CTGroupImpl cTGroupImpl, int i5) {
        this.f8604a = i5;
        this.b = cTGroupImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f8604a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.setSignaturelineArray(iIntValue, (CTSignatureLine) obj2);
                break;
            case 1:
                this.b.setRectArray(iIntValue, (CTRect) obj2);
                break;
            case 2:
                this.b.setHandlesArray(iIntValue, (CTHandles) obj2);
                break;
            case 3:
                this.b.setRoundrectArray(iIntValue, (CTRoundRect) obj2);
                break;
            case 4:
                this.b.setTextpathArray(iIntValue, (CTTextPath) obj2);
                break;
            case 5:
                this.b.setTextboxArray(iIntValue, (CTTextbox) obj2);
                break;
            case 6:
                this.b.setLineArray(iIntValue, (CTLine) obj2);
                break;
            case 7:
                this.b.setShadowArray(iIntValue, (CTShadow) obj2);
                break;
            case 8:
                this.b.setPathArray(iIntValue, (CTPath) obj2);
                break;
            case 9:
                this.b.setLockArray(iIntValue, (CTLock) obj2);
                break;
            case 10:
                this.b.setGroupArray(iIntValue, (CTGroup) obj2);
                break;
            case 11:
                this.b.setWrapArray(iIntValue, (CTWrap) obj2);
                break;
            case 12:
                this.b.setFormulasArray(iIntValue, (CTFormulas) obj2);
                break;
            case 13:
                this.b.setClientDataArray(iIntValue, (CTClientData) obj2);
                break;
            case 14:
                this.b.setAnchorlockArray(iIntValue, (CTAnchorLock) obj2);
                break;
            case 15:
                this.b.setStrokeArray(iIntValue, (CTStroke) obj2);
                break;
            case 16:
                this.b.setFillArray(iIntValue, (CTFill) obj2);
                break;
            case 17:
                this.b.setOvalArray(iIntValue, (CTOval) obj2);
                break;
            case 18:
                this.b.setImagedataArray(iIntValue, (CTImageData) obj2);
                break;
            case 19:
                this.b.setShapetypeArray(iIntValue, (CTShapetype) obj2);
                break;
            default:
                this.b.setShapeArray(iIntValue, (CTShape) obj2);
                break;
        }
    }
}
