package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTMarker extends XmlObject {
    public static final DocumentFactory<CTMarker> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTMarker> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctmarkeree8etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    int getCol();

    Object getColOff();

    int getRow();

    Object getRowOff();

    void setCol(int i5);

    void setColOff(Object obj);

    void setRow(int i5);

    void setRowOff(Object obj);

    STColID xgetCol();

    STCoordinate xgetColOff();

    STRowID xgetRow();

    STCoordinate xgetRowOff();

    void xsetCol(STColID sTColID);

    void xsetColOff(STCoordinate sTCoordinate);

    void xsetRow(STRowID sTRowID);

    void xsetRowOff(STCoordinate sTCoordinate);
}
