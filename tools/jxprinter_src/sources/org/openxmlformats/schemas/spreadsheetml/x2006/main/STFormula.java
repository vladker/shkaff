package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface STFormula extends STXstring {
    public static final SimpleTypeFactory<STFormula> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STFormula> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stformula7e35type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
