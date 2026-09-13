package com.microsoft.schemas.office.x2006.digsig;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STSignatureComments extends XmlString {
    public static final SimpleTypeFactory<STSignatureComments> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STSignatureComments> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stsignaturecomments47batype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
