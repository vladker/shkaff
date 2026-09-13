package p099r2;

import com.microsoft.schemas.office.excel.impl.CTClientDataImpl;
import java.math.BigInteger;
import java.util.function.BiConsumer;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlString;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalseBlank;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7934a;
    public final /* synthetic */ CTClientDataImpl b;

    public /* synthetic */ b(CTClientDataImpl cTClientDataImpl, int i5) {
        this.f7934a = i5;
        this.b = cTClientDataImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        int i5 = this.f7934a;
        int iIntValue = ((Integer) obj).intValue();
        switch (i5) {
            case 0:
                this.b.xsetTextVAlignArray(iIntValue, (XmlString) obj2);
                break;
            case 1:
                this.b.xsetFmlaLinkArray(iIntValue, (XmlString) obj2);
                break;
            case 2:
                this.b.xsetPrintObjectArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 3:
                this.b.xsetDisabledArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 4:
                this.b.setListItemArray(iIntValue, (String) obj2);
                break;
            case 5:
                this.b.insertListItem(iIntValue, (String) obj2);
                break;
            case 6:
                this.b.xsetScriptTextArray(iIntValue, (XmlString) obj2);
                break;
            case 7:
                this.b.xsetAutoLineArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 8:
                this.b.xsetNoThreeDArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 9:
                this.b.xsetListItemArray(iIntValue, (XmlString) obj2);
                break;
            case 10:
                this.b.xsetMinArray(iIntValue, (XmlInteger) obj2);
                break;
            case 11:
                this.b.xsetAutoPictArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 12:
                this.b.setLockTextArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 13:
                this.b.insertLockText(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 14:
                this.b.xsetFmlaMacroArray(iIntValue, (XmlString) obj2);
                break;
            case 15:
                this.b.xsetMultiSelArray(iIntValue, (XmlString) obj2);
                break;
            case 16:
                this.b.setMapOCXArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 17:
                this.b.insertMapOCX(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 18:
                this.b.setAccelArray(iIntValue, (BigInteger) obj2);
                break;
            case 19:
                this.b.insertAccel(iIntValue, (BigInteger) obj2);
                break;
            case 20:
                this.b.xsetAnchorArray(iIntValue, (XmlString) obj2);
                break;
            case 21:
                this.b.xsetNoThreeD2Array(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 22:
                this.b.setSelArray(iIntValue, (BigInteger) obj2);
                break;
            case 23:
                this.b.xsetAutoScaleArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 24:
                this.b.xsetMultiLineArray(iIntValue, (STTrueFalseBlank) obj2);
                break;
            case 25:
                this.b.setAnchorArray(iIntValue, (String) obj2);
                break;
            case 26:
                this.b.insertAnchor(iIntValue, (String) obj2);
                break;
            case 27:
                this.b.setAutoFillArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            case 28:
                this.b.setAutoLineArray(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
            default:
                this.b.insertAutoLine(iIntValue, (STTrueFalseBlank.Enum) obj2);
                break;
        }
    }
}
