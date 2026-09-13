package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCustSplit extends XmlObject {
    public static final DocumentFactory<CTCustSplit> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustSplit> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustsplit93bftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewSecondPiePt();

    CTUnsignedInt getSecondPiePtArray(int i5);

    CTUnsignedInt[] getSecondPiePtArray();

    List<CTUnsignedInt> getSecondPiePtList();

    CTUnsignedInt insertNewSecondPiePt(int i5);

    void removeSecondPiePt(int i5);

    void setSecondPiePtArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setSecondPiePtArray(CTUnsignedInt[] cTUnsignedIntArr);

    int sizeOfSecondPiePtArray();
}
