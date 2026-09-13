package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTextTabStopList extends XmlObject {
    public static final DocumentFactory<CTTextTabStopList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTextTabStopList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttexttabstoplistf539type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTextTabStop addNewTab();

    CTTextTabStop getTabArray(int i5);

    CTTextTabStop[] getTabArray();

    List<CTTextTabStop> getTabList();

    CTTextTabStop insertNewTab(int i5);

    void removeTab(int i5);

    void setTabArray(int i5, CTTextTabStop cTTextTabStop);

    void setTabArray(CTTextTabStop[] cTTextTabStopArr);

    int sizeOfTabArray();
}
