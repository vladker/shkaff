package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ContentTypeManager {
    public static final String CONTENT_TYPES_PART_NAME = "[Content_Types].xml";
    private static final String CONTENT_TYPE_ATTRIBUTE_NAME = "ContentType";
    private static final String DEFAULT_TAG_NAME = "Default";
    private static final String EXTENSION_ATTRIBUTE_NAME = "Extension";
    private static final String OVERRIDE_TAG_NAME = "Override";
    private static final String PART_NAME_ATTRIBUTE_NAME = "PartName";
    public static final String TYPES_NAMESPACE_URI = "http://schemas.openxmlformats.org/package/2006/content-types";
    private static final String TYPES_TAG_NAME = "Types";
    protected OPCPackage container;
    private TreeMap<String, String> defaultContentType = new TreeMap<>();
    private TreeMap<PackagePartName, String> overrideContentType;

    public ContentTypeManager(InputStream inputStream, OPCPackage oPCPackage) throws InvalidFormatException {
        this.container = oPCPackage;
        if (inputStream != null) {
            try {
                parseContentTypesFile(inputStream);
            } catch (InvalidFormatException e) {
                InvalidFormatException invalidFormatException = new InvalidFormatException("Can't read content types part !");
                invalidFormatException.initCause(e);
                throw invalidFormatException;
            }
        }
    }

    private void addDefaultContentType(String str, String str2) {
        this.defaultContentType.put(str.toLowerCase(Locale.ROOT), str2);
    }

    private void addOverrideContentType(PackagePartName packagePartName, String str) {
        if (this.overrideContentType == null) {
            this.overrideContentType = new TreeMap<>();
        }
        this.overrideContentType.put(packagePartName, str);
    }

    private void appendDefaultType(Element element, Map.Entry<String, String> entry) {
        Element elementCreateElementNS = element.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
        elementCreateElementNS.setAttribute(EXTENSION_ATTRIBUTE_NAME, entry.getKey());
        elementCreateElementNS.setAttribute(CONTENT_TYPE_ATTRIBUTE_NAME, entry.getValue());
        element.appendChild(elementCreateElementNS);
    }

    private void appendSpecificTypes(Element element, Map.Entry<PackagePartName, String> entry) {
        Element elementCreateElementNS = element.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", OVERRIDE_TAG_NAME);
        elementCreateElementNS.setAttribute(PART_NAME_ATTRIBUTE_NAME, entry.getKey().getName());
        elementCreateElementNS.setAttribute(CONTENT_TYPE_ATTRIBUTE_NAME, entry.getValue());
        element.appendChild(elementCreateElementNS);
    }

    private void parseContentTypesFile(InputStream inputStream) throws InvalidFormatException {
        try {
            Document document = DocumentHelper.readDocument(inputStream);
            NodeList elementsByTagNameNS = document.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
            int length = elementsByTagNameNS.getLength();
            for (int i5 = 0; i5 < length; i5++) {
                Element element = (Element) elementsByTagNameNS.item(i5);
                addDefaultContentType(element.getAttribute(EXTENSION_ATTRIBUTE_NAME), element.getAttribute(CONTENT_TYPE_ATTRIBUTE_NAME));
            }
            NodeList elementsByTagNameNS2 = document.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", OVERRIDE_TAG_NAME);
            int length2 = elementsByTagNameNS2.getLength();
            for (int i6 = 0; i6 < length2; i6++) {
                Element element2 = (Element) elementsByTagNameNS2.item(i6);
                addOverrideContentType(PackagingURIHelper.createPartName(new URI(element2.getAttribute(PART_NAME_ATTRIBUTE_NAME))), element2.getAttribute(CONTENT_TYPE_ATTRIBUTE_NAME));
            }
        } catch (IOException e) {
            e = e;
            throw new InvalidFormatException(e.getMessage());
        } catch (URISyntaxException e6) {
            e = e6;
            throw new InvalidFormatException(e.getMessage());
        } catch (SAXException e7) {
            e = e7;
            throw new InvalidFormatException(e.getMessage());
        }
    }

    public void addContentType(PackagePartName packagePartName, String str) {
        boolean zContainsValue = this.defaultContentType.containsValue(str);
        String lowerCase = packagePartName.getExtension().toLowerCase(Locale.ROOT);
        if (lowerCase.length() == 0 || ((this.defaultContentType.containsKey(lowerCase) && !zContainsValue) || (!this.defaultContentType.containsKey(lowerCase) && zContainsValue))) {
            addOverrideContentType(packagePartName, str);
        } else {
            if (zContainsValue) {
                return;
            }
            addDefaultContentType(lowerCase, str);
        }
    }

    public void clearAll() {
        this.defaultContentType.clear();
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null) {
            treeMap.clear();
        }
    }

    public void clearOverrideContentTypes() {
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null) {
            treeMap.clear();
        }
    }

    public String getContentType(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null && treeMap.containsKey(packagePartName)) {
            return this.overrideContentType.get(packagePartName);
        }
        String lowerCase = packagePartName.getExtension().toLowerCase(Locale.ROOT);
        if (this.defaultContentType.containsKey(lowerCase)) {
            return this.defaultContentType.get(lowerCase);
        }
        OPCPackage oPCPackage = this.container;
        if (oPCPackage == null || oPCPackage.getPart(packagePartName) == null) {
            return null;
        }
        throw new OpenXML4JRuntimeException("Rule M2.4 exception : Part '" + packagePartName + "' not found - this error should NEVER happen!\nCheck that your code is closing the open resources in the correct order prior to filing a bug report.\nIf you can provide the triggering file, then please raise a bug at https://bz.apache.org/bugzilla/enter_bug.cgi?product=POI and attach the file that triggers it, thanks!");
    }

    public boolean isContentTypeRegister(String str) {
        if (str == null) {
            throw new IllegalArgumentException("contentType");
        }
        if (this.defaultContentType.containsValue(str)) {
            return true;
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        return treeMap != null && treeMap.containsValue(str);
    }

    public void removeContentType(PackagePartName packagePartName) {
        if (packagePartName == null) {
            throw new IllegalArgumentException("partName");
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null && treeMap.get(packagePartName) != null) {
            this.overrideContentType.remove(packagePartName);
            return;
        }
        String extension = packagePartName.getExtension();
        OPCPackage oPCPackage = this.container;
        int i5 = 0;
        if (oPCPackage == null) {
            this.defaultContentType.remove(extension);
            break;
        }
        try {
            ArrayList<PackagePart> parts = oPCPackage.getParts();
            int size = parts.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    this.defaultContentType.remove(extension);
                    break;
                }
                PackagePart packagePart = parts.get(i6);
                i6++;
                PackagePart packagePart2 = packagePart;
                if (!packagePart2.getPartName().equals(packagePartName) && packagePart2.getPartName().getExtension().equalsIgnoreCase(extension)) {
                    break;
                }
            }
        } catch (InvalidFormatException e) {
            throw new InvalidOperationException(e.getMessage());
        }
        OPCPackage oPCPackage2 = this.container;
        if (oPCPackage2 != null) {
            try {
                ArrayList<PackagePart> parts2 = oPCPackage2.getParts();
                int size2 = parts2.size();
                while (i5 < size2) {
                    PackagePart packagePart3 = parts2.get(i5);
                    i5++;
                    PackagePart packagePart4 = packagePart3;
                    if (!packagePart4.getPartName().equals(packagePartName) && getContentType(packagePart4.getPartName()) == null) {
                        throw new InvalidOperationException("Rule M2.4 is not respected: Nor a default element or override element is associated with the part: " + packagePart4.getPartName().getName());
                    }
                }
            } catch (InvalidFormatException e6) {
                throw new InvalidOperationException(e6.getMessage());
            }
        }
    }

    public boolean save(OutputStream outputStream) {
        Document documentCreateDocument = DocumentHelper.createDocument();
        Element elementCreateElementNS = documentCreateDocument.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", TYPES_TAG_NAME);
        documentCreateDocument.appendChild(elementCreateElementNS);
        Iterator<Map.Entry<String, String>> it = this.defaultContentType.entrySet().iterator();
        while (it.hasNext()) {
            appendDefaultType(elementCreateElementNS, it.next());
        }
        TreeMap<PackagePartName, String> treeMap = this.overrideContentType;
        if (treeMap != null) {
            Iterator<Map.Entry<PackagePartName, String>> it2 = treeMap.entrySet().iterator();
            while (it2.hasNext()) {
                appendSpecificTypes(elementCreateElementNS, it2.next());
            }
        }
        documentCreateDocument.normalize();
        return saveImpl(documentCreateDocument, outputStream);
    }

    public abstract boolean saveImpl(Document document, OutputStream outputStream);
}
