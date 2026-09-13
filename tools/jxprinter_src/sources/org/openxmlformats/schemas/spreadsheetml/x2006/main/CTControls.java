package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTControls extends XmlObject {
    public static final DocumentFactory<CTControls> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTControls> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcontrols75fftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTControl addNewControl();

    CTControl getControlArray(int i5);

    CTControl[] getControlArray();

    List<CTControl> getControlList();

    CTControl insertNewControl(int i5);

    void removeControl(int i5);

    void setControlArray(int i5, CTControl cTControl);

    void setControlArray(CTControl[] cTControlArr);

    int sizeOfControlArray();
}
