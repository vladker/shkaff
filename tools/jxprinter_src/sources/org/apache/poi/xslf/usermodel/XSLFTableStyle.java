package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFTableStyle {
    private CTTableStyle _tblStyle;

    /* JADX INFO: renamed from: org.apache.poi.xslf.usermodel.XSLFTableStyle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle;

        static {
            int[] iArr = new int[TablePartStyle.values().length];
            $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle = iArr;
            try {
                iArr[TablePartStyle.wholeTbl.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.band1H.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.band2H.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.band1V.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.band2V.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.firstCol.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.lastCol.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.firstRow.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.lastRow.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.seCell.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.swCell.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.neCell.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[TablePartStyle.nwCell.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TablePartStyle {
        wholeTbl,
        band1H,
        band2H,
        band1V,
        band2V,
        firstCol,
        lastCol,
        firstRow,
        lastRow,
        seCell,
        swCell,
        neCell,
        nwCell
    }

    public XSLFTableStyle(CTTableStyle cTTableStyle) {
        this._tblStyle = cTTableStyle;
    }

    public String getStyleId() {
        return this._tblStyle.getStyleId();
    }

    public String getStyleName() {
        return this._tblStyle.getStyleName();
    }

    public CTTablePartStyle getTablePartStyle(TablePartStyle tablePartStyle) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xslf$usermodel$XSLFTableStyle$TablePartStyle[tablePartStyle.ordinal()]) {
            case 2:
                return this._tblStyle.getBand1H();
            case 3:
                return this._tblStyle.getBand2H();
            case 4:
                return this._tblStyle.getBand1V();
            case 5:
                return this._tblStyle.getBand2V();
            case 6:
                return this._tblStyle.getFirstCol();
            case 7:
                return this._tblStyle.getLastCol();
            case 8:
                return this._tblStyle.getFirstRow();
            case 9:
                return this._tblStyle.getLastRow();
            case 10:
                return this._tblStyle.getSeCell();
            case 11:
                return this._tblStyle.getSwCell();
            case 12:
                return this._tblStyle.getNeCell();
            case 13:
                return this._tblStyle.getNwCell();
            default:
                return this._tblStyle.getWholeTbl();
        }
    }

    public CTTableStyle getXmlObject() {
        return this._tblStyle;
    }
}
