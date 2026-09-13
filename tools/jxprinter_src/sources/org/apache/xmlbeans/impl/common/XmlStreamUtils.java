package org.apache.xmlbeans.impl.common;

import javax.xml.stream.XMLStreamReader;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class XmlStreamUtils {
    public static String getName(int i5) {
        switch (i5) {
            case 1:
                return "START_ELEMENT";
            case 2:
                return "END_ELEMENT";
            case 3:
                return "PROCESSING_INSTRUCTION";
            case 4:
                return "CHARACTERS";
            case 5:
                return "COMMENT";
            case 6:
                return "SPACE";
            case 7:
                return "START_DOCUMENT";
            case 8:
                return "END_DOCUMENT";
            case 9:
                return "ENTITY_REFERENCE";
            case 10:
                return "ATTRIBUTE";
            case 11:
                return "DTD";
            case 12:
                return "CDATA";
            case 13:
                return "NAMESPACE";
            default:
                return "UNKNOWN_EVENT_TYPE";
        }
    }

    public static int getType(String str) {
        if (str.equals("START_ELEMENT")) {
            return 1;
        }
        if (str.equals("SPACE")) {
            return 6;
        }
        if (str.equals("END_ELEMENT")) {
            return 2;
        }
        if (str.equals("PROCESSING_INSTRUCTION")) {
            return 3;
        }
        if (str.equals("CHARACTERS")) {
            return 4;
        }
        if (str.equals("COMMENT")) {
            return 5;
        }
        if (str.equals("START_DOCUMENT")) {
            return 7;
        }
        if (str.equals("END_DOCUMENT")) {
            return 8;
        }
        if (str.equals("ATTRIBUTE")) {
            return 10;
        }
        if (str.equals("DTD")) {
            return 11;
        }
        if (str.equals("CDATA")) {
            return 12;
        }
        return str.equals("NAMESPACE") ? 13 : -1;
    }

    public static String printEvent(XMLStreamReader xMLStreamReader) {
        StringBuilder sb = new StringBuilder();
        sb.append("EVENT:[" + xMLStreamReader.getLocation().getLineNumber() + "][" + xMLStreamReader.getLocation().getColumnNumber() + "] ");
        sb.append(getName(xMLStreamReader.getEventType()));
        sb.append(" [");
        int eventType = xMLStreamReader.getEventType();
        if (eventType == 9) {
            sb.append(xMLStreamReader.getLocalName() + "=");
            if (xMLStreamReader.hasText()) {
                sb.append("[" + xMLStreamReader.getText() + "]");
            }
        } else if (eventType != 12) {
            int i5 = 0;
            switch (eventType) {
                case 1:
                    sb.append("<");
                    printName(xMLStreamReader, sb);
                    for (int i6 = 0; i6 < xMLStreamReader.getNamespaceCount(); i6++) {
                        sb.append(" ");
                        String namespacePrefix = xMLStreamReader.getNamespacePrefix(i6);
                        if (Sax2Dom.XMLNS_PREFIX.equals(namespacePrefix)) {
                            sb.append("xmlns=\"" + xMLStreamReader.getNamespaceURI(i6) + "\"");
                        } else {
                            sb.append(Sax2Dom.XMLNS_STRING + namespacePrefix);
                            sb.append("=\"");
                            sb.append(xMLStreamReader.getNamespaceURI(i6));
                            sb.append("\"");
                        }
                    }
                    while (i5 < xMLStreamReader.getAttributeCount()) {
                        sb.append(" ");
                        printName(xMLStreamReader.getAttributePrefix(i5), xMLStreamReader.getAttributeNamespace(i5), xMLStreamReader.getAttributeLocalName(i5), sb);
                        sb.append("=\"");
                        sb.append(xMLStreamReader.getAttributeValue(i5));
                        sb.append("\"");
                        i5++;
                    }
                    sb.append(">");
                    break;
                case 2:
                    sb.append("</");
                    printName(xMLStreamReader, sb);
                    while (i5 < xMLStreamReader.getNamespaceCount()) {
                        sb.append(" ");
                        String namespacePrefix2 = xMLStreamReader.getNamespacePrefix(i5);
                        if (Sax2Dom.XMLNS_PREFIX.equals(namespacePrefix2)) {
                            sb.append("xmlns=\"" + xMLStreamReader.getNamespaceURI(i5) + "\"");
                        } else {
                            sb.append(Sax2Dom.XMLNS_STRING + namespacePrefix2);
                            sb.append("=\"");
                            sb.append(xMLStreamReader.getNamespaceURI(i5));
                            sb.append("\"");
                        }
                        i5++;
                    }
                    sb.append(">");
                    break;
                case 3:
                    String pITarget = xMLStreamReader.getPITarget();
                    if (pITarget == null) {
                        pITarget = "";
                    }
                    String pIData = xMLStreamReader.getPIData();
                    String str = pIData != null ? pIData : "";
                    sb.append("<?");
                    sb.append(pITarget + " " + str);
                    sb.append("?>");
                    break;
                case 4:
                case 6:
                    sb.append(new String(xMLStreamReader.getTextCharacters(), xMLStreamReader.getTextStart(), xMLStreamReader.getTextLength()));
                    break;
                case 5:
                    sb.append("<!--");
                    if (xMLStreamReader.hasText()) {
                        sb.append(xMLStreamReader.getText());
                    }
                    sb.append("-->");
                    break;
                case 7:
                    sb.append("<?xml");
                    sb.append(" version='" + xMLStreamReader.getVersion() + "'");
                    sb.append(" encoding='" + xMLStreamReader.getCharacterEncodingScheme() + "'");
                    if (xMLStreamReader.isStandalone()) {
                        sb.append(" standalone='yes'");
                    } else {
                        sb.append(" standalone='no'");
                    }
                    sb.append("?>");
                    break;
            }
        } else {
            sb.append("<![CDATA[");
            if (xMLStreamReader.hasText()) {
                sb.append(xMLStreamReader.getText());
            }
            sb.append("]]>");
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printName(String str, String str2, String str3, StringBuilder sb) {
        if (str2 != null && !"".equals(str2)) {
            sb.append("['" + str2 + "']:");
        }
        if (str != null && !"".equals(str)) {
            sb.append(str.concat(ParameterizedMessage.ERROR_MSG_SEPARATOR));
        }
        if (str3 != null) {
            sb.append(str3);
        }
    }

    private static void printName(XMLStreamReader xMLStreamReader, StringBuilder sb) {
        if (xMLStreamReader.hasName()) {
            printName(xMLStreamReader.getPrefix(), xMLStreamReader.getNamespaceURI(), xMLStreamReader.getLocalName(), sb);
        }
    }
}
