package org.apache.xmlbeans.impl.schema;

import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlFactoryHook;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlSaxHandler;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.xpath.XPathFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class SchemaTypeLoaderBase implements SchemaTypeLoader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";

    private static String doCompilePath(String str, XmlOptions xmlOptions) {
        return XPathFactory.compilePath(str, xmlOptions);
    }

    private static String doCompileQuery(String str, XmlOptions xmlOptions) {
        return XPathFactory.compileQuery(str, xmlOptions);
    }

    public String compilePath(String str) {
        return compilePath(str, null);
    }

    public String compileQuery(String str) {
        return compileQuery(str, null);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalAttribute findAttribute(QName qName) {
        SchemaGlobalAttribute.Ref refFindAttributeRef = findAttributeRef(qName);
        if (refFindAttributeRef == null) {
            return null;
        }
        return refFindAttributeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaAttributeGroup findAttributeGroup(QName qName) {
        SchemaAttributeGroup.Ref refFindAttributeGroupRef = findAttributeGroupRef(qName);
        if (refFindAttributeGroupRef == null) {
            return null;
        }
        return refFindAttributeGroupRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findAttributeType(QName qName) {
        SchemaType.Ref refFindAttributeTypeRef = findAttributeTypeRef(qName);
        if (refFindAttributeTypeRef == null) {
            return null;
        }
        return refFindAttributeTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findDocumentType(QName qName) {
        SchemaType.Ref refFindDocumentTypeRef = findDocumentTypeRef(qName);
        if (refFindDocumentTypeRef == null) {
            return null;
        }
        return refFindDocumentTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaGlobalElement findElement(QName qName) {
        SchemaGlobalElement.Ref refFindElementRef = findElementRef(qName);
        if (refFindElementRef == null) {
            return null;
        }
        return refFindElementRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaModelGroup findModelGroup(QName qName) {
        SchemaModelGroup.Ref refFindModelGroupRef = findModelGroupRef(qName);
        if (refFindModelGroupRef == null) {
            return null;
        }
        return refFindModelGroupRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType findType(QName qName) {
        SchemaType.Ref refFindTypeRef = findTypeRef(qName);
        if (refFindTypeRef == null) {
            return null;
        }
        return refFindTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
        return Locale.newDomImplementation(this, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.newInstance(this, schemaType, xmlOptions) : Locale.newInstance(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.newXmlSaxHandler(this, schemaType, xmlOptions) : Locale.newSaxHandler(this, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        return hook != null ? hook.parse(this, str, schemaType, xmlOptions) : Locale.parseToXmlObject(this, str, schemaType, xmlOptions);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0175  */
    /* JADX WARN: Code duplicated, block: B:109:0x0184  */
    /* JADX WARN: Code duplicated, block: B:151:0x00cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x010a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:78:0x010b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x012a  */
    /* JADX WARN: Code duplicated, block: B:91:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0141  */
    /* JADX WARN: Code duplicated, block: B:95:0x0148  */
    /* JADX WARN: Code duplicated, block: B:97:0x0154  */
    /* JADX WARN: Instruction removed from duplicated block: B:95:0x0148, please report this as an issue */
    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public SchemaType typeForSignature(String str) {
        String strSubstring;
        SchemaGlobalAttribute schemaGlobalAttributeFindAttribute;
        SchemaType[] anonymousTypes;
        int i5;
        SchemaField containerField;
        SchemaGlobalElement schemaGlobalElementFindElement;
        SchemaType[] anonymousTypes2;
        int length;
        int i6;
        SchemaField containerField2;
        int iIndexOf = str.indexOf(64);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
            strSubstring = "";
        } else {
            strSubstring = str.substring(iIndexOf + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < iIndexOf) {
            int iIndexOf2 = str.indexOf(58, i7);
            int iIndexOf3 = str.indexOf(124, i7);
            if (iIndexOf2 < 0) {
                iIndexOf2 = iIndexOf3;
            } else if (iIndexOf3 >= 0) {
                iIndexOf2 = Math.min(iIndexOf2, iIndexOf3);
            }
            if (iIndexOf2 < 0 || iIndexOf2 > iIndexOf) {
                iIndexOf2 = iIndexOf;
            }
            arrayList.add(str.substring(i7, iIndexOf2));
            i7 = iIndexOf2 + 1;
        }
        SchemaType type = null;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str2 = (String) arrayList.get(size);
            if (str2.length() < 1) {
                throw new IllegalArgumentException();
            }
            int i8 = (str2.length() < 2 || str2.charAt(1) != '=') ? 1 : 2;
            char cCharAt = str2.charAt(0);
            if (cCharAt == 'I') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                if (type.getSimpleVariety() != 3) {
                    return null;
                }
                SchemaType[] anonymousTypes3 = type.getAnonymousTypes();
                if (anonymousTypes3.length != 1) {
                    return null;
                }
                type = anonymousTypes3[0];
            } else if (cCharAt == 'M') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                try {
                    int i9 = Integer.parseInt(str2.substring(i8));
                    if (type.getSimpleVariety() != 2) {
                        return null;
                    }
                    SchemaType[] anonymousTypes4 = type.getAnonymousTypes();
                    if (anonymousTypes4.length <= i9) {
                        return null;
                    }
                    type = anonymousTypes4[i9];
                } catch (Exception unused) {
                    throw new IllegalArgumentException();
                }
            } else if (cCharAt == 'Q') {
                if (type != null) {
                    if (type.isSimpleType()) {
                        return null;
                    }
                    anonymousTypes = type.getAnonymousTypes();
                    String strSubstring2 = str2.substring(i8);
                    for (SchemaType schemaType : anonymousTypes) {
                        containerField = schemaType.getContainerField();
                        if (containerField == null && containerField.isAttribute() && containerField.getName().getLocalPart().equals(strSubstring2)) {
                            type = schemaType;
                        }
                    }
                    return null;
                }
                schemaGlobalAttributeFindAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                if (schemaGlobalAttributeFindAttribute == null) {
                    return null;
                }
                type = schemaGlobalAttributeFindAttribute.getType();
            } else if (cCharAt == 'R') {
                if (type == null) {
                    throw new IllegalArgumentException();
                }
                type = findAttributeType(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                if (type == null) {
                    return null;
                }
                continue;
            } else if (cCharAt == 'T') {
                if (type != null) {
                    throw new IllegalArgumentException();
                }
                type = findType(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                if (type == null) {
                    return null;
                }
            } else if (cCharAt != 'U') {
                switch (cCharAt) {
                    case 'A':
                        if (type != null) {
                            if (type.isSimpleType()) {
                                return null;
                            }
                            anonymousTypes = type.getAnonymousTypes();
                            String strSubstring3 = str2.substring(i8);
                            while (i5 < r7) {
                                containerField = schemaType.getContainerField();
                                if (containerField == null) {
                                }
                            }
                            return null;
                        }
                        schemaGlobalAttributeFindAttribute = findAttribute(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                        if (schemaGlobalAttributeFindAttribute == null) {
                            return null;
                        }
                        type = schemaGlobalAttributeFindAttribute.getType();
                        break;
                        break;
                    case 'B':
                        if (type == null) {
                            throw new IllegalArgumentException();
                        }
                        if (type.getSimpleVariety() != 1) {
                            return null;
                        }
                        SchemaType[] anonymousTypes5 = type.getAnonymousTypes();
                        if (anonymousTypes5.length != 1) {
                            return null;
                        }
                        type = anonymousTypes5[0];
                        continue;
                        break;
                    case 'C':
                        if (type == null) {
                            throw new IllegalArgumentException();
                        }
                        type = findAttributeType(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                        if (type == null) {
                            return null;
                        }
                        continue;
                        break;
                    case 'D':
                        if (type != null) {
                            throw new IllegalArgumentException();
                        }
                        type = findDocumentType(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                        if (type == null) {
                            return null;
                        }
                        continue;
                        break;
                    case 'E':
                        if (type != null) {
                            if (type.getContentType() < 3) {
                                return null;
                            }
                            anonymousTypes2 = type.getAnonymousTypes();
                            String strSubstring4 = str2.substring(i8);
                            length = anonymousTypes2.length;
                            for (i6 = 0; i6 < length; i6++) {
                                schemaType = anonymousTypes2[i6];
                                containerField2 = schemaType.getContainerField();
                                if (containerField2 == null && !containerField2.isAttribute() && containerField2.getName().getLocalPart().equals(strSubstring4)) {
                                }
                                break;
                            }
                            return null;
                        }
                        schemaGlobalElementFindElement = findElement(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                        if (schemaGlobalElementFindElement == null) {
                            return null;
                        }
                        type = schemaGlobalElementFindElement.getType();
                        break;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                type = schemaType;
            } else {
                if (type != null) {
                    if (type.getContentType() < 3) {
                        return null;
                    }
                    anonymousTypes2 = type.getAnonymousTypes();
                    String strSubstring5 = str2.substring(i8);
                    length = anonymousTypes2.length;
                    while (i6 < length) {
                        schemaType = anonymousTypes2[i6];
                        containerField2 = schemaType.getContainerField();
                        if (containerField2 == null) {
                        }
                    }
                    return null;
                }
                schemaGlobalElementFindElement = findElement(QNameHelper.forLNS(str2.substring(i8), strSubstring));
                if (schemaGlobalElementFindElement == null) {
                    return null;
                }
                type = schemaGlobalElementFindElement.getType();
            }
        }
        return type;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compilePath(String str, XmlOptions xmlOptions) {
        return doCompilePath(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public String compileQuery(String str, XmlOptions xmlOptions) {
        return doCompileQuery(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, xMLStreamReader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, xMLStreamReader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        String string = file.toURI().normalize().toString();
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.setDocumentSourceName(string);
        } else if (xmlOptions.getDocumentSourceName() == null) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setDocumentSourceName(string);
            xmlOptions = xmlOptions2;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            XmlObject xmlObject = parse(fileInputStream, schemaType, xmlOptions);
            fileInputStream.close();
            return xmlObject;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        if (xmlOptions == null) {
            xmlOptions = new XmlOptions();
            xmlOptions.setDocumentSourceName(url.toString());
        } else if (xmlOptions.getDocumentSourceName() == null) {
            XmlOptions xmlOptions2 = new XmlOptions(xmlOptions);
            xmlOptions2.setDocumentSourceName(url.toString());
            xmlOptions = xmlOptions2;
        }
        int i5 = 0;
        boolean z6 = false;
        do {
            uRLConnectionOpenConnection = url.openConnection();
            uRLConnectionOpenConnection.addRequestProperty(HttpHeaders.USER_AGENT, USER_AGENT);
            uRLConnectionOpenConnection.addRequestProperty(HttpHeaders.ACCEPT, "application/xml, text/xml, */*");
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                int responseCode = httpURLConnection.getResponseCode();
                boolean z7 = responseCode == 301 || responseCode == 302;
                if (z7 && i5 > 5) {
                    z7 = false;
                }
                if (z7) {
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (headerField == null) {
                        z6 = false;
                    } else {
                        url = new URL(headerField);
                        i5++;
                        z6 = z7;
                    }
                } else {
                    z6 = z7;
                }
            }
        } while (z6);
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            XmlObject xmlObject = parse(inputStream, schemaType, xmlOptions);
            if (inputStream != null) {
                inputStream.close();
            }
            return xmlObject;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        DigestInputStream digestInputStream;
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (xmlOptions == null || !xmlOptions.isLoadMessageDigest()) {
            digestInputStream = null;
        } else {
            try {
                digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("SHA"));
                inputStream = digestInputStream;
            } catch (NoSuchAlgorithmException unused) {
                digestInputStream = null;
            }
        }
        if (hook != null) {
            return hook.parse(this, inputStream, schemaType, xmlOptions);
        }
        XmlObject toXmlObject = Locale.parseToXmlObject(this, inputStream, schemaType, xmlOptions);
        if (digestInputStream != null) {
            toXmlObject.documentProperties().setMessageDigest(digestInputStream.getMessageDigest().digest());
        }
        return toXmlObject;
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, reader, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, reader, schemaType, xmlOptions);
    }

    @Override // org.apache.xmlbeans.SchemaTypeLoader
    public XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlFactoryHook hook = XmlFactoryHook.ThreadContext.getHook();
        if (hook != null) {
            return hook.parse(this, node, schemaType, xmlOptions);
        }
        return Locale.parseToXmlObject(this, node, schemaType, xmlOptions);
    }
}
