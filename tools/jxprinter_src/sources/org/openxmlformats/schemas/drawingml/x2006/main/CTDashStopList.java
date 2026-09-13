package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTDashStopList extends XmlObject {
    public static final DocumentFactory<CTDashStopList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDashStopList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdashstoplist920dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDashStop addNewDs();

    CTDashStop getDsArray(int i5);

    CTDashStop[] getDsArray();

    List<CTDashStop> getDsList();

    CTDashStop insertNewDs(int i5);

    void removeDs(int i5);

    void setDsArray(int i5, CTDashStop cTDashStop);

    void setDsArray(CTDashStop[] cTDashStopArr);

    int sizeOfDsArray();
}
