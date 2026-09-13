package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TypeDerivationControl extends DerivationControl {
    public static final DerivationControl.Enum EXTENSION;
    public static final SimpleTypeFactory<TypeDerivationControl> Factory;
    public static final int INT_EXTENSION = 2;
    public static final int INT_LIST = 4;
    public static final int INT_RESTRICTION = 3;
    public static final int INT_UNION = 5;
    public static final DerivationControl.Enum LIST;
    public static final DerivationControl.Enum RESTRICTION;
    public static final DerivationControl.Enum UNION;
    public static final SchemaType type;

    static {
        SimpleTypeFactory<TypeDerivationControl> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "typederivationcontrol3239type");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        EXTENSION = DerivationControl.EXTENSION;
        RESTRICTION = DerivationControl.RESTRICTION;
        LIST = DerivationControl.LIST;
        UNION = DerivationControl.UNION;
    }
}
