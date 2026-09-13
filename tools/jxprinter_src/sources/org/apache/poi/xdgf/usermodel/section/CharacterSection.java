package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFSheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CharacterSection extends XDGFSection {
    Map<String, XDGFCell> _characterCells;
    Color _fontColor;
    Double _fontSize;

    public CharacterSection(SectionType sectionType, XDGFSheet xDGFSheet) {
        super(sectionType, xDGFSheet);
        this._characterCells = new HashMap();
        for (CellType cellType : sectionType.getRowArray(0).getCellArray()) {
            this._characterCells.put(cellType.getN(), new XDGFCell(cellType));
        }
        this._fontSize = XDGFCell.maybeGetDouble(this._characterCells, "Size");
        String strMaybeGetString = XDGFCell.maybeGetString(this._characterCells, "Color");
        if (strMaybeGetString != null) {
            this._fontColor = Color.decode(strMaybeGetString);
        }
    }

    public Color getFontColor() {
        return this._fontColor;
    }

    public Double getFontSize() {
        return this._fontSize;
    }

    @Override // org.apache.poi.xdgf.usermodel.section.XDGFSection
    public void setupMaster(XDGFSection xDGFSection) {
    }
}
