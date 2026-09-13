package org.apache.xmlbeans.impl.common;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class XmlReaderToWriter {
    private XmlReaderToWriter() {
    }

    public static void write(XMLStreamReader xMLStreamReader, XMLStreamWriter xMLStreamWriter) {
        switch (xMLStreamReader.getEventType()) {
            case 1:
                String localName = xMLStreamReader.getLocalName();
                String namespaceURI = xMLStreamReader.getNamespaceURI();
                if (namespaceURI == null || namespaceURI.length() <= 0) {
                    xMLStreamWriter.writeStartElement(localName);
                } else {
                    String prefix = xMLStreamReader.getPrefix();
                    if (prefix != null) {
                        xMLStreamWriter.writeStartElement(prefix, localName, namespaceURI);
                    } else {
                        xMLStreamWriter.writeStartElement(namespaceURI, localName);
                    }
                }
                int namespaceCount = xMLStreamReader.getNamespaceCount();
                for (int i5 = 0; i5 < namespaceCount; i5++) {
                    xMLStreamWriter.writeNamespace(xMLStreamReader.getNamespacePrefix(i5), xMLStreamReader.getNamespaceURI(i5));
                }
                int attributeCount = xMLStreamReader.getAttributeCount();
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    String attributeNamespace = xMLStreamReader.getAttributeNamespace(i6);
                    if (attributeNamespace != null) {
                        xMLStreamWriter.writeAttribute(attributeNamespace, xMLStreamReader.getAttributeLocalName(i6), xMLStreamReader.getAttributeValue(i6));
                    } else {
                        xMLStreamWriter.writeAttribute(xMLStreamReader.getAttributeLocalName(i6), xMLStreamReader.getAttributeValue(i6));
                    }
                }
                break;
            case 2:
                xMLStreamWriter.writeEndElement();
                break;
            case 3:
                xMLStreamWriter.writeProcessingInstruction(xMLStreamReader.getPITarget(), xMLStreamReader.getPIData());
                break;
            case 4:
            case 6:
                xMLStreamWriter.writeCharacters(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength());
                break;
            case 5:
                xMLStreamWriter.writeComment(xMLStreamReader.getText());
                break;
            case 7:
                String characterEncodingScheme = xMLStreamReader.getCharacterEncodingScheme();
                String version = xMLStreamReader.getVersion();
                if (characterEncodingScheme != null && version != null) {
                    xMLStreamWriter.writeStartDocument(characterEncodingScheme, version);
                } else if (version != null) {
                    xMLStreamWriter.writeStartDocument(xMLStreamReader.getVersion());
                }
                break;
            case 8:
                xMLStreamWriter.writeEndDocument();
                break;
            case 9:
                xMLStreamWriter.writeEntityRef(xMLStreamReader.getLocalName());
                break;
            case 11:
                xMLStreamWriter.writeDTD(xMLStreamReader.getText());
                break;
            case 12:
                xMLStreamWriter.writeCData(xMLStreamReader.getText());
                break;
        }
    }

    public static void writeAll(XMLStreamReader xMLStreamReader, XMLStreamWriter xMLStreamWriter) {
        while (xMLStreamReader.hasNext()) {
            write(xMLStreamReader, xMLStreamWriter);
            xMLStreamReader.next();
        }
        write(xMLStreamReader, xMLStreamWriter);
        xMLStreamWriter.flush();
    }
}
