package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTopPageBorder extends CTPageBorder {
    public static final DocumentFactory<CTTopPageBorder> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTopPageBorder> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttoppageborder3c02type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    String getTopLeft();

    String getTopRight();

    boolean isSetTopLeft();

    boolean isSetTopRight();

    void setTopLeft(String str);

    void setTopRight(String str);

    void unsetTopLeft();

    void unsetTopRight();

    STRelationshipId xgetTopLeft();

    STRelationshipId xgetTopRight();

    void xsetTopLeft(STRelationshipId sTRelationshipId);

    void xsetTopRight(STRelationshipId sTRelationshipId);
}
