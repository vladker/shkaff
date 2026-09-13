package org.apache.poi.xddf.usermodel.text;

import java.util.function.Supplier;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7270a;
    public final /* synthetic */ CTTextCharacterProperties b;

    public /* synthetic */ a(CTTextCharacterProperties cTTextCharacterProperties, int i5) {
        this.f7270a = i5;
        this.b = cTTextCharacterProperties;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        boolean zIsSetU;
        switch (this.f7270a) {
            case 0:
                zIsSetU = this.b.isSetU();
                break;
            case 1:
                zIsSetU = this.b.isSetExtLst();
                break;
            case 2:
                zIsSetU = this.b.isSetCap();
                break;
            case 3:
                zIsSetU = this.b.isSetLang();
                break;
            case 4:
                zIsSetU = this.b.isSetHlinkMouseOver();
                break;
            case 5:
                zIsSetU = this.b.isSetKumimoji();
                break;
            case 6:
                zIsSetU = this.b.isSetBaseline();
                break;
            case 7:
                zIsSetU = this.b.isSetB();
                break;
            case 8:
                zIsSetU = this.b.isSetHighlight();
                break;
            case 9:
                zIsSetU = this.b.isSetKern();
                break;
            case 10:
                zIsSetU = this.b.isSetDirty();
                break;
            case 11:
                zIsSetU = this.b.isSetAltLang();
                break;
            case 12:
                zIsSetU = this.b.isSetEffectLst();
                break;
            case 13:
                zIsSetU = this.b.isSetSpc();
                break;
            case 14:
                zIsSetU = this.b.isSetStrike();
                break;
            case 15:
                zIsSetU = this.b.isSetEffectDag();
                break;
            case 16:
                zIsSetU = this.b.isSetBmk();
                break;
            case 17:
                zIsSetU = this.b.isSetSz();
                break;
            case 18:
                zIsSetU = this.b.isSetHlinkClick();
                break;
            case 19:
                zIsSetU = this.b.isSetCs();
                break;
            case 20:
                zIsSetU = this.b.isSetEa();
                break;
            case 21:
                zIsSetU = this.b.isSetNoProof();
                break;
            case 22:
                zIsSetU = this.b.isSetLatin();
                break;
            case 23:
                zIsSetU = this.b.isSetSym();
                break;
            case 24:
                zIsSetU = this.b.isSetI();
                break;
            case 25:
                zIsSetU = this.b.isSetNormalizeH();
                break;
            case 26:
                zIsSetU = this.b.isSetErr();
                break;
            default:
                zIsSetU = this.b.isSetLn();
                break;
        }
        return Boolean.valueOf(zIsSetU);
    }
}
