package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTConnectionSiteList extends XmlObject {
    public static final DocumentFactory<CTConnectionSiteList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTConnectionSiteList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctconnectionsitelistab9etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTConnectionSite addNewCxn();

    CTConnectionSite getCxnArray(int i5);

    CTConnectionSite[] getCxnArray();

    List<CTConnectionSite> getCxnList();

    CTConnectionSite insertNewCxn(int i5);

    void removeCxn(int i5);

    void setCxnArray(int i5, CTConnectionSite cTConnectionSite);

    void setCxnArray(CTConnectionSite[] cTConnectionSiteArr);

    int sizeOfCxnArray();
}
