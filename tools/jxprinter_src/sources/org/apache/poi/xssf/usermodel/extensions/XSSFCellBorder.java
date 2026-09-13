package org.apache.poi.xssf.usermodel.extensions;

import java.util.Objects;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFCellBorder {
    private final IndexedColorMap _indexedColorMap;
    private ThemesTable _theme;
    private final CTBorder border;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide;

        static {
            int[] iArr = new int[BorderSide.values().length];
            $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide = iArr;
            try {
                iArr[BorderSide.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.DIAGONAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.VERTICAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[BorderSide.HORIZONTAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum BorderSide {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT,
        DIAGONAL,
        VERTICAL,
        HORIZONTAL
    }

    public XSSFCellBorder(CTBorder cTBorder, ThemesTable themesTable, IndexedColorMap indexedColorMap) {
        this.border = cTBorder;
        this._indexedColorMap = indexedColorMap;
        this._theme = themesTable;
    }

    private CTBorderPr getBorder(BorderSide borderSide) {
        return getBorder(borderSide, false);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFCellBorder)) {
            return false;
        }
        XSSFCellBorder xSSFCellBorder = (XSSFCellBorder) obj;
        for (BorderSide borderSide : BorderSide.values()) {
            if (!Objects.equals(getBorderColor(borderSide), xSSFCellBorder.getBorderColor(borderSide)) || !Objects.equals(getBorderStyle(borderSide), xSSFCellBorder.getBorderStyle(borderSide))) {
                return false;
            }
        }
        if (this.border.isSetDiagonalUp() != xSSFCellBorder.border.isSetDiagonalUp() || this.border.isSetDiagonalDown() != xSSFCellBorder.border.isSetDiagonalDown() || this.border.isSetOutline() != xSSFCellBorder.border.isSetOutline()) {
            return false;
        }
        if (this.border.isSetDiagonalUp() && this.border.getDiagonalUp() != xSSFCellBorder.border.getDiagonalUp()) {
            return false;
        }
        if (!this.border.isSetDiagonalDown() || this.border.getDiagonalDown() == xSSFCellBorder.border.getDiagonalDown()) {
            return !this.border.isSetOutline() || this.border.getOutline() == xSSFCellBorder.border.getOutline();
        }
        return false;
    }

    public XSSFColor getBorderColor(BorderSide borderSide) {
        CTBorderPr border = getBorder(borderSide);
        if (border == null || !border.isSetColor()) {
            return null;
        }
        XSSFColor xSSFColorFrom = XSSFColor.from(border.getColor(), this._indexedColorMap);
        ThemesTable themesTable = this._theme;
        if (themesTable != null) {
            themesTable.inheritFromThemeAsRequired(xSSFColorFrom);
        }
        return xSSFColorFrom;
    }

    public BorderStyle getBorderStyle(BorderSide borderSide) {
        CTBorderPr border = getBorder(borderSide);
        return BorderStyle.values()[(border == null ? STBorderStyle.NONE : border.getStyle()).intValue() - 1];
    }

    @Internal
    public CTBorder getCTBorder() {
        return this.border;
    }

    public int hashCode() {
        return this.border.toString().hashCode();
    }

    public void setBorderColor(BorderSide borderSide, XSSFColor xSSFColor) {
        CTBorderPr border = getBorder(borderSide, true);
        if (xSSFColor == null) {
            border.unsetColor();
        } else {
            border.setColor(xSSFColor.getCTColor());
        }
    }

    public void setBorderStyle(BorderSide borderSide, BorderStyle borderStyle) {
        getBorder(borderSide, true).setStyle(STBorderStyle.Enum.forInt(borderStyle.ordinal() + 1));
    }

    public void setThemesTable(ThemesTable themesTable) {
        this._theme = themesTable;
    }

    private CTBorderPr getBorder(BorderSide borderSide, boolean z6) {
        switch (AnonymousClass1.$SwitchMap$org$apache$poi$xssf$usermodel$extensions$XSSFCellBorder$BorderSide[borderSide.ordinal()]) {
            case 1:
                CTBorderPr top = this.border.getTop();
                return (z6 && top == null) ? this.border.addNewTop() : top;
            case 2:
                CTBorderPr right = this.border.getRight();
                return (z6 && right == null) ? this.border.addNewRight() : right;
            case 3:
                CTBorderPr bottom = this.border.getBottom();
                return (z6 && bottom == null) ? this.border.addNewBottom() : bottom;
            case 4:
                CTBorderPr left = this.border.getLeft();
                return (z6 && left == null) ? this.border.addNewLeft() : left;
            case 5:
                CTBorderPr diagonal = this.border.getDiagonal();
                return (z6 && diagonal == null) ? this.border.addNewDiagonal() : diagonal;
            case 6:
                CTBorderPr vertical = this.border.getVertical();
                return (z6 && vertical == null) ? this.border.addNewVertical() : vertical;
            case 7:
                CTBorderPr horizontal = this.border.getHorizontal();
                return (z6 && horizontal == null) ? this.border.addNewHorizontal() : horizontal;
            default:
                throw new IllegalArgumentException("No suitable side specified for the border, had " + borderSide);
        }
    }

    public XSSFCellBorder(CTBorder cTBorder) {
        this(cTBorder, null, null);
    }

    public XSSFCellBorder(CTBorder cTBorder, IndexedColorMap indexedColorMap) {
        this(cTBorder, null, indexedColorMap);
    }

    public XSSFCellBorder() {
        this(CTBorder.Factory.newInstance(), null, null);
    }
}
