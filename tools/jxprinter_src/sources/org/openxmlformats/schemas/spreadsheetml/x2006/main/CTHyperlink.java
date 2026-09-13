package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTHyperlink extends XmlObject {
    public static final DocumentFactory<CTHyperlink> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHyperlink> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthyperlink0c85type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getDisplay();

    String getId();

    String getLocation();

    String getRef();

    String getTooltip();

    boolean isSetDisplay();

    boolean isSetId();

    boolean isSetLocation();

    boolean isSetTooltip();

    void setDisplay(String str);

    void setId(String str);

    void setLocation(String str);

    void setRef(String str);

    void setTooltip(String str);

    void unsetDisplay();

    void unsetId();

    void unsetLocation();

    void unsetTooltip();

    STXstring xgetDisplay();

    STRelationshipId xgetId();

    STXstring xgetLocation();

    STRef xgetRef();

    STXstring xgetTooltip();

    void xsetDisplay(STXstring sTXstring);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetLocation(STXstring sTXstring);

    void xsetRef(STRef sTRef);

    void xsetTooltip(STXstring sTXstring);
}
