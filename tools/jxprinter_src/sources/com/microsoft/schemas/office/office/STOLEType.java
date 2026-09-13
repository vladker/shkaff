package com.microsoft.schemas.office.office;

import com.google.common.net.HttpHeaders;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.SimpleTypeFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface STOLEType extends XmlString {
    public static final Enum EMBED;
    public static final SimpleTypeFactory<STOLEType> Factory;
    public static final int INT_EMBED = 1;
    public static final int INT_LINK = 2;
    public static final Enum LINK;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EMBED = 1;
        static final int INT_LINK = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("Embed", 1), new Enum(HttpHeaders.LINK, 2)});

        private Enum(String str, int i5) {
            super(str, i5);
        }

        public static Enum forInt(int i5) {
            return (Enum) table.forInt(i5);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    static {
        SimpleTypeFactory<STOLEType> simpleTypeFactory = new SimpleTypeFactory<>(TypeSystemHolder.typeSystem, "stoletype716btype");
        Factory = simpleTypeFactory;
        type = simpleTypeFactory.getType();
        EMBED = Enum.forString("Embed");
        LINK = Enum.forString(HttpHeaders.LINK);
    }

    StringEnumAbstractBase getEnumValue();

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);
}
