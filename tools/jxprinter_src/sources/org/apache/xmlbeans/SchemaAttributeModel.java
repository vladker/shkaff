package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaAttributeModel {
    public static final int LAX = 2;
    public static final int NONE = 0;
    public static final int SKIP = 3;
    public static final int STRICT = 1;

    SchemaLocalAttribute getAttribute(QName qName);

    SchemaLocalAttribute[] getAttributes();

    int getWildcardProcess();

    QNameSet getWildcardSet();
}
