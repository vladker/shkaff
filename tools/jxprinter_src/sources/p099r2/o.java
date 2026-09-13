package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7947a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ o(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7947a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7947a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.insertAutoScale(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 1:
                this.b.xsetCameraArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 2:
                this.b.setFirstButtonArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 3:
                this.b.insertFirstButton(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 4:
                this.b.xsetSecretEditArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 5:
                this.b.setHorizArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 6:
                this.b.insertHoriz(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 7:
                this.b.xsetSelArray(iIntValue, (XmlInteger) obj2);
                break;
            case 8:
                this.b.xsetSelTypeArray(iIntValue, (XmlString) obj2);
                break;
            case 9:
                this.b.xsetAccelArray(iIntValue, (XmlInteger) obj2);
                break;
            case 10:
                this.b.xsetColumnArray(iIntValue, (XmlInteger) obj2);
                break;
            case 11:
                this.b.setAccel2Array(iIntValue, (BigInteger) obj2);
                break;
            case 12:
                this.b.insertAccel2(iIntValue, (BigInteger) obj2);
                break;
            case 13:
                this.b.setValArray(iIntValue, (BigInteger) obj2);
                break;
            case 14:
                this.b.insertVal(iIntValue, (BigInteger) obj2);
                break;
            case 15:
                this.b.xsetAccel2Array(iIntValue, (XmlInteger) obj2);
                break;
            case 16:
                this.b.setFmlaPictArray(iIntValue, (String) obj2);
                break;
            case 17:
                this.b.insertFmlaPict(iIntValue, (String) obj2);
                break;
            case 18:
                this.b.xsetSizeWithCellsArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 19:
                this.b.xsetScriptLanguageArray(iIntValue, (XmlNonNegativeInteger) obj2);
                break;
            case 20:
                this.b.setHelpArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 21:
                this.b.insertHelp(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 22:
                this.b.setDDEArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 23:
                this.b.insertDDE(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 24:
                this.b.xsetDismissArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 25:
                this.b.xsetValArray(iIntValue, (XmlInteger) obj2);
                break;
            case 26:
                this.b.setDefaultArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 27:
                this.b.xsetDropLinesArray(iIntValue, (XmlInteger) obj2);
                break;
            case 28:
                this.b.setDisabledArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            default:
                this.b.insertDisabled(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
        }
    }
}
