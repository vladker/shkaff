package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTLineStyleList extends XmlObject {
    public static final DocumentFactory<CTLineStyleList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLineStyleList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlinestylelist510ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTLineProperties addNewLn();

    CTLineProperties getLnArray(int i5);

    CTLineProperties[] getLnArray();

    List<CTLineProperties> getLnList();

    CTLineProperties insertNewLn(int i5);

    void removeLn(int i5);

    void setLnArray(int i5, CTLineProperties cTLineProperties);

    void setLnArray(CTLineProperties[] cTLinePropertiesArr);

    int sizeOfLnArray();
}
