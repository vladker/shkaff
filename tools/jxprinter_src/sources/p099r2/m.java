package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7945a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ m(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7945a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7945a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.xsetRecalcAlwaysArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 1:
                this.b.setValidIdsArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 2:
                this.b.insertValidIds(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 3:
                this.b.xsetMapOCXArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 4:
                this.b.setSecretEditArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 5:
                this.b.insertSecretEdit(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 6:
                this.b.xsetFirstButtonArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 7:
                this.b.xsetDefaultSizeArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 8:
                this.b.setFmlaMacroArray(iIntValue, (String) obj2);
                break;
            case 9:
                this.b.xsetWidthMinArray(iIntValue, (XmlInteger) obj2);
                break;
            case 10:
                this.b.insertFmlaMacro(iIntValue, (String) obj2);
                break;
            case 11:
                this.b.setTextHAlignArray(iIntValue, (String) obj2);
                break;
            case 12:
                this.b.insertTextHAlign(iIntValue, (String) obj2);
                break;
            case 13:
                this.b.setJustLastXArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 14:
                this.b.insertJustLastX(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 15:
                this.b.xsetPageArray(iIntValue, (XmlInteger) obj2);
                break;
            case 16:
                this.b.setCameraArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 17:
                this.b.insertCamera(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 18:
                this.b.xsetRowArray(iIntValue, (XmlInteger) obj2);
                break;
            case 19:
                this.b.setColumnArray(iIntValue, (BigInteger) obj2);
                break;
            case 20:
                this.b.insertColumn(iIntValue, (BigInteger) obj2);
                break;
            case 21:
                this.b.xsetColHiddenArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 22:
                this.b.xsetLCTArray(iIntValue, (XmlString) obj2);
                break;
            case 23:
                this.b.setVTEditArray(iIntValue, (BigInteger) obj2);
                break;
            case 24:
                this.b.insertVTEdit(iIntValue, (BigInteger) obj2);
                break;
            case 25:
                this.b.setFmlaLinkArray(iIntValue, (String) obj2);
                break;
            case 26:
                this.b.insertFmlaLink(iIntValue, (String) obj2);
                break;
            case 27:
                this.b.xsetUIObjArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 28:
                this.b.xsetColoredArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            default:
                this.b.setAutoScaleArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
        }
    }
}
