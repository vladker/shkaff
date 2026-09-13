package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSheet extends XmlObject {
    public static final DocumentFactory<CTSheet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheet4dbetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getId();

    String getName();

    long getSheetId();

    STSheetState.Enum getState();

    boolean isSetState();

    void setId(String str);

    void setName(String str);

    void setSheetId(long j6);

    void setState(STSheetState.Enum r6);

    void unsetState();

    STRelationshipId xgetId();

    STXstring xgetName();

    XmlUnsignedInt xgetSheetId();

    STSheetState xgetState();

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetName(STXstring sTXstring);

    void xsetSheetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetState(STSheetState sTSheetState);
}
