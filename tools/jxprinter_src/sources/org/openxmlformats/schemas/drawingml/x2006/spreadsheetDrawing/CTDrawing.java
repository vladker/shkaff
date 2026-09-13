package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTDrawing extends XmlObject {
    public static final DocumentFactory<CTDrawing> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDrawing> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdrawing2748type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAbsoluteAnchor addNewAbsoluteAnchor();

    CTOneCellAnchor addNewOneCellAnchor();

    CTTwoCellAnchor addNewTwoCellAnchor();

    CTAbsoluteAnchor getAbsoluteAnchorArray(int i5);

    CTAbsoluteAnchor[] getAbsoluteAnchorArray();

    List<CTAbsoluteAnchor> getAbsoluteAnchorList();

    CTOneCellAnchor getOneCellAnchorArray(int i5);

    CTOneCellAnchor[] getOneCellAnchorArray();

    List<CTOneCellAnchor> getOneCellAnchorList();

    CTTwoCellAnchor getTwoCellAnchorArray(int i5);

    CTTwoCellAnchor[] getTwoCellAnchorArray();

    List<CTTwoCellAnchor> getTwoCellAnchorList();

    CTAbsoluteAnchor insertNewAbsoluteAnchor(int i5);

    CTOneCellAnchor insertNewOneCellAnchor(int i5);

    CTTwoCellAnchor insertNewTwoCellAnchor(int i5);

    void removeAbsoluteAnchor(int i5);

    void removeOneCellAnchor(int i5);

    void removeTwoCellAnchor(int i5);

    void setAbsoluteAnchorArray(int i5, CTAbsoluteAnchor cTAbsoluteAnchor);

    void setAbsoluteAnchorArray(CTAbsoluteAnchor[] cTAbsoluteAnchorArr);

    void setOneCellAnchorArray(int i5, CTOneCellAnchor cTOneCellAnchor);

    void setOneCellAnchorArray(CTOneCellAnchor[] cTOneCellAnchorArr);

    void setTwoCellAnchorArray(int i5, CTTwoCellAnchor cTTwoCellAnchor);

    void setTwoCellAnchorArray(CTTwoCellAnchor[] cTTwoCellAnchorArr);

    int sizeOfAbsoluteAnchorArray();

    int sizeOfOneCellAnchorArray();

    int sizeOfTwoCellAnchorArray();
}
