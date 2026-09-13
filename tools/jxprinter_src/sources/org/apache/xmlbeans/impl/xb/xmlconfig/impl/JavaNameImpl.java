package org.apache.xmlbeans.impl.xb.xmlconfig.impl;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.xb.xmlconfig.JavaName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class JavaNameImpl extends JavaStringHolderEx implements JavaName {
    private static final long serialVersionUID = 1;

    public JavaNameImpl(SchemaType schemaType) {
        super(schemaType, false);
    }

    public JavaNameImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
