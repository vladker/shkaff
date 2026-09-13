package org.apache.poi.xssf.model;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class ParagraphPropertyFetcher<T> {
    private int _level;
    private T _value;

    public ParagraphPropertyFetcher(int i5) {
        this._level = i5;
    }

    public abstract boolean fetch(CTTextParagraphProperties cTTextParagraphProperties);

    public boolean fetch(CTShape cTShape) {
        XmlObject[] xmlObjectArrSelectPath = cTShape.selectPath("declare namespace xdr='http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//xdr:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (xmlObjectArrSelectPath.length == 1) {
            return fetch((CTTextParagraphProperties) xmlObjectArrSelectPath[0]);
        }
        return false;
    }

    public T getValue() {
        return this._value;
    }

    public void setValue(T t6) {
        this._value = t6;
    }
}
