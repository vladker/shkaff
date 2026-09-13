package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTabs extends XmlObject {
    public static final DocumentFactory<CTTabs> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTabs> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttabsa2aatype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTTabStop addNewTab();

    CTTabStop getTabArray(int i5);

    CTTabStop[] getTabArray();

    List<CTTabStop> getTabList();

    CTTabStop insertNewTab(int i5);

    void removeTab(int i5);

    void setTabArray(int i5, CTTabStop cTTabStop);

    void setTabArray(CTTabStop[] cTTabStopArr);

    int sizeOfTabArray();
}
