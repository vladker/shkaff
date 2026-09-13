package org.apache.xmlbeans.xml.stream;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface StartElement extends XMLEvent {
    Attribute getAttributeByName(XMLName xMLName);

    AttributeIterator getAttributes();

    AttributeIterator getAttributesAndNamespaces();

    Map<String, String> getNamespaceMap();

    String getNamespaceUri(String str);

    AttributeIterator getNamespaces();
}
