package com.microsoft.schemas.office.word;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTAnchorLock extends XmlObject {
    public static final DocumentFactory<CTAnchorLock> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTAnchorLock> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctanchorlocked31type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }
}
