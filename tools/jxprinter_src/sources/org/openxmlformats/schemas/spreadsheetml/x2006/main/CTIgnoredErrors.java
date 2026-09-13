package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTIgnoredErrors extends XmlObject {
    public static final DocumentFactory<CTIgnoredErrors> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTIgnoredErrors> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctignorederrorsbebctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTIgnoredError addNewIgnoredError();

    CTExtensionList getExtLst();

    CTIgnoredError getIgnoredErrorArray(int i5);

    CTIgnoredError[] getIgnoredErrorArray();

    List<CTIgnoredError> getIgnoredErrorList();

    CTIgnoredError insertNewIgnoredError(int i5);

    boolean isSetExtLst();

    void removeIgnoredError(int i5);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIgnoredErrorArray(int i5, CTIgnoredError cTIgnoredError);

    void setIgnoredErrorArray(CTIgnoredError[] cTIgnoredErrorArr);

    int sizeOfIgnoredErrorArray();

    void unsetExtLst();
}
