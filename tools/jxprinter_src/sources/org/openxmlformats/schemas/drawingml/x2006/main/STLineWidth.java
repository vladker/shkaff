package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STLineWidth extends STCoordinate32Unqualified {
    public static final SimpleTypeFactory<STLineWidth> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STLineWidth> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stlinewidth8313type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
