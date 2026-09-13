package org.openxmlformats.schemas.officeDocument.x2006.sharedTypes;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STPositivePercentage extends STPercentage {
    public static final SimpleTypeFactory<STPositivePercentage> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STPositivePercentage> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stpositivepercentage942dtype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
