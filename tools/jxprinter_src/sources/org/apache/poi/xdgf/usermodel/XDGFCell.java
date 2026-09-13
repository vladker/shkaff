package org.apache.poi.xdgf.usermodel;

import com.microsoft.schemas.office.visio.x2012.main.CellType;
import java.util.Map;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDGFCell {
    CellType _cell;

    public XDGFCell(CellType cellType) {
        this._cell = cellType;
    }

    public static Boolean maybeGetBoolean(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell == null || xDGFCell.getValue() == null) {
            return null;
        }
        if (xDGFCell.getValue().equals("0")) {
            return Boolean.FALSE;
        }
        if (xDGFCell.getValue().equals("1")) {
            return Boolean.TRUE;
        }
        throw new POIXMLException("Invalid boolean value for '" + xDGFCell.getName() + "'");
    }

    public static Double maybeGetDouble(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell != null) {
            return parseDoubleValue(xDGFCell._cell);
        }
        return null;
    }

    public static Integer maybeGetInteger(Map<String, XDGFCell> map, String str) {
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell != null) {
            return parseIntegerValue(xDGFCell._cell);
        }
        return null;
    }

    public static String maybeGetString(Map<String, XDGFCell> map, String str) {
        String v6;
        XDGFCell xDGFCell = map.get(str);
        if (xDGFCell == null || (v6 = xDGFCell._cell.getV()) == null || v6.equals("Themed")) {
            return null;
        }
        return v6;
    }

    public static Double parseDoubleValue(CellType cellType) {
        if (cellType.getV() == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(cellType.getV()));
        } catch (NumberFormatException e) {
            if (cellType.getV().equals("Themed")) {
                return null;
            }
            throw new POIXMLException("Invalid float value for '" + cellType.getN() + "': " + e);
        }
    }

    public static Integer parseIntegerValue(CellType cellType) {
        if (cellType.getV() == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(cellType.getV()));
        } catch (NumberFormatException e) {
            if (cellType.getV().equals("Themed")) {
                return null;
            }
            throw new POIXMLException("Invalid integer value for '" + cellType.getN() + "': " + e);
        }
    }

    public static Double parseVLength(CellType cellType) {
        if (cellType.getV() == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(cellType.getV()));
        } catch (NumberFormatException e) {
            if (cellType.getV().equals("Themed")) {
                return null;
            }
            throw new POIXMLException("Invalid float value for '" + cellType.getN() + "': " + e);
        }
    }

    public String getError() {
        return this._cell.getE();
    }

    public String getFormula() {
        return this._cell.getF();
    }

    public String getName() {
        return this._cell.getN();
    }

    public String getValue() {
        return this._cell.getV();
    }

    @Internal
    public CellType getXmlObject() {
        return this._cell;
    }
}
