package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTEffectStyleList extends XmlObject {
    public static final DocumentFactory<CTEffectStyleList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTEffectStyleList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cteffectstylelistc50ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTEffectStyleItem addNewEffectStyle();

    CTEffectStyleItem getEffectStyleArray(int i5);

    CTEffectStyleItem[] getEffectStyleArray();

    List<CTEffectStyleItem> getEffectStyleList();

    CTEffectStyleItem insertNewEffectStyle(int i5);

    void removeEffectStyle(int i5);

    void setEffectStyleArray(int i5, CTEffectStyleItem cTEffectStyleItem);

    void setEffectStyleArray(CTEffectStyleItem[] cTEffectStyleItemArr);

    int sizeOfEffectStyleArray();
}
