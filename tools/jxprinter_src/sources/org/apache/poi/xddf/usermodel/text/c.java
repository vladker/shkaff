package org.apache.poi.xddf.usermodel.text;

import java.util.function.Consumer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextFont;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextCapsType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextStrikeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextUnderlineType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7272a;
    public final /* synthetic */ CTTextCharacterProperties b;

    public /* synthetic */ c(CTTextCharacterProperties cTTextCharacterProperties, int i5) {
        this.f7272a = i5;
        this.b = cTTextCharacterProperties;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7272a) {
            case 0:
                this.b.setLn((CTLineProperties) obj);
                break;
            case 1:
                this.b.setExtLst((CTOfficeArtExtensionList) obj);
                break;
            case 2:
                this.b.setCap((STTextCapsType.Enum) obj);
                break;
            case 3:
                this.b.setLang((String) obj);
                break;
            case 4:
                this.b.setHlinkMouseOver((CTHyperlink) obj);
                break;
            case 5:
                this.b.setKumimoji(((Boolean) obj).booleanValue());
                break;
            case 6:
                this.b.setBaseline((Integer) obj);
                break;
            case 7:
                this.b.setU((STTextUnderlineType.Enum) obj);
                break;
            case 8:
                this.b.setB(((Boolean) obj).booleanValue());
                break;
            case 9:
                this.b.setHighlight((CTColor) obj);
                break;
            case 10:
                this.b.setKern(((Integer) obj).intValue());
                break;
            case 11:
                this.b.setDirty(((Boolean) obj).booleanValue());
                break;
            case 12:
                this.b.setEffectLst((CTEffectList) obj);
                break;
            case 13:
                this.b.setSpc((Integer) obj);
                break;
            case 14:
                this.b.setStrike((STTextStrikeType.Enum) obj);
                break;
            case 15:
                this.b.setEffectDag((CTEffectContainer) obj);
                break;
            case 16:
                this.b.setBmk((String) obj);
                break;
            case 17:
                this.b.setSz(((Integer) obj).intValue());
                break;
            case 18:
                this.b.setAltLang((String) obj);
                break;
            case 19:
                this.b.setHlinkClick((CTHyperlink) obj);
                break;
            case 20:
                this.b.setSym((CTTextFont) obj);
                break;
            case 21:
                this.b.setCs((CTTextFont) obj);
                break;
            case 22:
                this.b.setEa((CTTextFont) obj);
                break;
            case 23:
                this.b.setLatin((CTTextFont) obj);
                break;
            case 24:
                this.b.setI(((Boolean) obj).booleanValue());
                break;
            case 25:
                this.b.setNormalizeH(((Boolean) obj).booleanValue());
                break;
            case 26:
                this.b.setErr(((Boolean) obj).booleanValue());
                break;
            default:
                this.b.setNoProof(((Boolean) obj).booleanValue());
                break;
        }
    }
}
