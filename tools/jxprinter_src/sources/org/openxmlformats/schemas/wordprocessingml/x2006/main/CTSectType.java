package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSectType extends XmlObject {
    public static final DocumentFactory<CTSectType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSectType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsecttype7cebtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STSectionMark.Enum getVal();

    boolean isSetVal();

    void setVal(STSectionMark.Enum r6);

    void unsetVal();

    STSectionMark xgetVal();

    void xsetVal(STSectionMark sTSectionMark);
}
