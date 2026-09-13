package org.apache.poi.xddf.usermodel.text;

import java.io.File;
import java.util.function.Predicate;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xslf.usermodel.XSLFDiagram;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7274a;

    public /* synthetic */ e(int i5) {
        this.f7274a = i5;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.f7274a) {
            case 0:
                return ((CTTextCharacterProperties) obj).isSetKern();
            case 1:
                return ((CTTextCharacterProperties) obj).isSetHlinkClick();
            case 2:
                return ((CTTextCharacterProperties) obj).isSetBaseline();
            case 3:
                return ((CTTextCharacterProperties) obj).isSetSz();
            case 4:
                return ((CTTextCharacterProperties) obj).isSetErr();
            case 5:
                return ((CTTextCharacterProperties) obj).isSetCap();
            case 6:
                return ((CTTextCharacterProperties) obj).isSetI();
            case 7:
                return ((CTTextCharacterProperties) obj).isSetDirty();
            case 8:
                return ((CTTextCharacterProperties) obj).isSetAltLang();
            case 9:
                return ((CTTextCharacterProperties) obj).isSetSolidFill();
            case 10:
                return ((CTTextCharacterProperties) obj).isSetCs();
            case 11:
                return ((CTTextCharacterProperties) obj).isSetSym();
            case 12:
                return ((CTTextCharacterProperties) obj).isSetEa();
            case 13:
                return ((CTTextCharacterProperties) obj).isSetLatin();
            case 14:
                return ((CTTextCharacterProperties) obj).isSetSpc();
            case 15:
                return ((CTTextCharacterProperties) obj).isSetU();
            case 16:
                return ((CTTextCharacterProperties) obj).isSetLang();
            case 17:
                return ((CTTextCharacterProperties) obj).isSetB();
            case 18:
                return ((CTTextCharacterProperties) obj).isSetLn();
            case 19:
                return ((CTTextCharacterProperties) obj).isSetHlinkMouseOver();
            case 20:
                return XSLFDiagram.lambda$hasTextContent$1((CTRegularTextRun) obj);
            case 21:
                return XSLFSheet.lambda$getTheme$0((POIXMLDocumentPart) obj);
            default:
                return ((File) obj).exists();
        }
    }
}
