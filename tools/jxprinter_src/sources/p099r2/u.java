package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class u implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7953a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ u(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7953a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7953a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.xsetValidIdsArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 1:
                this.b.xsetCancelArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 2:
                this.b.xsetScriptLocationArray(iIntValue, (XmlNonNegativeInteger) obj2);
                break;
            case 3:
                this.b.setRowArray(iIntValue, (BigInteger) obj2);
                break;
            case 4:
                this.b.insertRow(iIntValue, (BigInteger) obj2);
                break;
            case 5:
                this.b.xsetVisibleArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 6:
                this.b.setSelTypeArray(iIntValue, (String) obj2);
                break;
            case 7:
                this.b.insertSelType(iIntValue, (String) obj2);
                break;
            case 8:
                this.b.setAutoPictArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 9:
                this.b.insertAutoPict(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 10:
                this.b.xsetFmlaTxbxArray(iIntValue, (XmlString) obj2);
                break;
            case 11:
                this.b.xsetLockedArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 12:
                this.b.xsetDefaultArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 13:
                this.b.xsetVScrollArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 14:
                this.b.setRecalcAlwaysArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 15:
                this.b.insertRecalcAlways(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 16:
                this.b.setScriptLocationArray(iIntValue, (BigInteger) obj2);
                break;
            case 17:
                this.b.insertScriptLocation(iIntValue, (BigInteger) obj2);
                break;
            case 18:
                this.b.setCancelArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 19:
                this.b.insertCancel(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            default:
                this.b.xsetDDEArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
        }
    }
}
