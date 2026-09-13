package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STCalendarType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCalendarType extends XmlObject {
    public static final DocumentFactory<CTCalendarType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCalendarType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcalendartyped1d0type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STCalendarType.Enum getVal();

    boolean isSetVal();

    void setVal(STCalendarType.Enum r6);

    void unsetVal();

    STCalendarType xgetVal();

    void xsetVal(STCalendarType sTCalendarType);
}
