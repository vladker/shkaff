package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate32;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface STSlideSizeCoordinate extends STPositiveCoordinate32 {
    public static final SimpleTypeFactory<STSlideSizeCoordinate> Factory;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<STSlideSizeCoordinate> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stslidesizecoordinate24b5type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
    }
}
