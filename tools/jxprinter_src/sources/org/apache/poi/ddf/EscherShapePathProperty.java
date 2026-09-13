package org.apache.poi.ddf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EscherShapePathProperty extends EscherSimpleProperty {
    public static final int CLOSED_CURVES = 3;
    public static final int CLOSED_POLYGON = 1;
    public static final int COMPLEX = 4;
    public static final int CURVES = 2;
    public static final int LINE_OF_STRAIGHT_SEGMENTS = 0;

    public EscherShapePathProperty(short s6, int i5) {
        super(s6, false, false, i5);
    }

    public EscherShapePathProperty(EscherPropertyTypes escherPropertyTypes, int i5) {
        super(escherPropertyTypes, false, false, i5);
    }
}
