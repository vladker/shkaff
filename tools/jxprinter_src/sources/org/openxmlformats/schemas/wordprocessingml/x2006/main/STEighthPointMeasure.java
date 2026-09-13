package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STUnsignedDecimalNumber;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STEighthPointMeasure extends STUnsignedDecimalNumber {
    public static final SimpleTypeFactory<STEighthPointMeasure> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STEighthPointMeasure> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "steighthpointmeasure3371type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
