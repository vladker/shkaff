package org.apache.xmlbeans.impl.xb.xsdschema.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.impl.values.JavaIntegerHolderEx;
import org.apache.xmlbeans.impl.values.XmlUnionImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AllImpl extends ExplicitGroupImpl implements All {
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MaxOccursImpl extends XmlUnionImpl implements All.MaxOccurs, XmlNonNegativeInteger, AllNNI.Member {
        private static final long serialVersionUID = 1;

        public MaxOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MaxOccursImpl(SchemaType schemaType, boolean z6) {
            super(schemaType, z6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MinOccursImpl extends JavaIntegerHolderEx implements All.MinOccurs {
        private static final long serialVersionUID = 1;

        public MinOccursImpl(SchemaType schemaType) {
            super(schemaType, false);
        }

        public MinOccursImpl(SchemaType schemaType, boolean z6) {
            super(schemaType, z6);
        }
    }

    public AllImpl(SchemaType schemaType) {
        super(schemaType);
    }
}
