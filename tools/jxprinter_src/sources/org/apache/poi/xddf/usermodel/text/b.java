package org.apache.poi.xddf.usermodel.text;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7271a;
    public final /* synthetic */ CTTextCharacterProperties b;

    public /* synthetic */ b(CTTextCharacterProperties cTTextCharacterProperties, int i5) {
        this.f7271a = i5;
        this.b = cTTextCharacterProperties;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7271a) {
            case 0:
                this.b.unsetLn();
                break;
            case 1:
                this.b.unsetExtLst();
                break;
            case 2:
                this.b.unsetCap();
                break;
            case 3:
                this.b.unsetLang();
                break;
            case 4:
                this.b.unsetU();
                break;
            case 5:
                this.b.unsetHlinkMouseOver();
                break;
            case 6:
                this.b.unsetKumimoji();
                break;
            case 7:
                this.b.unsetBaseline();
                break;
            case 8:
                this.b.unsetB();
                break;
            case 9:
                this.b.unsetHighlight();
                break;
            case 10:
                this.b.unsetKern();
                break;
            case 11:
                this.b.unsetDirty();
                break;
            case 12:
                this.b.unsetEffectLst();
                break;
            case 13:
                this.b.unsetSpc();
                break;
            case 14:
                this.b.unsetStrike();
                break;
            case 15:
                this.b.unsetAltLang();
                break;
            case 16:
                this.b.unsetEffectDag();
                break;
            case 17:
                this.b.unsetBmk();
                break;
            case 18:
                this.b.unsetSz();
                break;
            case 19:
                this.b.unsetHlinkClick();
                break;
            case 20:
                this.b.unsetSym();
                break;
            case 21:
                this.b.unsetCs();
                break;
            case 22:
                this.b.unsetEa();
                break;
            case 23:
                this.b.unsetLatin();
                break;
            case 24:
                this.b.unsetI();
                break;
            case 25:
                this.b.unsetNormalizeH();
                break;
            case 26:
                this.b.unsetNoProof();
                break;
            default:
                this.b.unsetErr();
                break;
        }
    }
}
