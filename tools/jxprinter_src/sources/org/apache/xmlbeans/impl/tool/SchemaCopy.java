package org.apache.xmlbeans.impl.tool;

import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.substwsdl.TImport;
import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaCopy {
    private static final XmlOptions loadOptions = new XmlOptions().setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));

    private static void copyAll(Map<URI, URI> map, boolean z6) {
        for (URI uri : map.keySet()) {
            URI uri2 = map.get(uri);
            try {
                IOUtil.copyCompletely(uri, uri2);
                if (z6) {
                    System.out.println("Copied " + uri + " -> " + uri2);
                }
            } catch (Exception unused) {
                if (z6) {
                    System.out.println("Could not copy " + uri + " -> " + uri2);
                }
            }
        }
    }

    public static Map<URI, URI> findAllRelative(URI uri, URI uri2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(uri, uri2);
        LinkedList linkedList = new LinkedList();
        linkedList.add(uri);
        while (!linkedList.isEmpty()) {
            URI uri3 = (URI) linkedList.removeFirst();
            Map<URI, URI> mapFindRelativeInOne = findRelativeInOne(uri3, (URI) linkedHashMap.get(uri3));
            for (URI uri4 : mapFindRelativeInOne.keySet()) {
                if (!linkedHashMap.containsKey(uri4)) {
                    linkedHashMap.put(uri4, mapFindRelativeInOne.get(uri4));
                    linkedList.add(uri4);
                }
            }
        }
        return linkedHashMap;
    }

    private static Map<URI, URI> findRelativeInOne(URI uri, URI uri2) {
        try {
            XmlObject xmlObject = XmlObject.Factory.parse(uri.toURL(), loadOptions);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (xmlObject instanceof SchemaDocument) {
                putMappingsFromSchema(linkedHashMap, uri, uri2, ((SchemaDocument) xmlObject).getSchema());
                return linkedHashMap;
            }
            if (xmlObject instanceof DefinitionsDocument) {
                putMappingsFromWsdl(linkedHashMap, uri, uri2, ((DefinitionsDocument) xmlObject).getDefinitions());
            }
            return linkedHashMap;
        } catch (Exception unused) {
            return Collections.EMPTY_MAP;
        }
    }

    public static void main(String[] strArr) {
        URI uri;
        if (strArr.length < 1 || strArr.length > 2) {
            printUsage();
            return;
        }
        URI uri2 = null;
        try {
            if (strArr[0].compareToIgnoreCase("-usage") == 0) {
                printUsage();
                return;
            }
            URI uri3 = new URI(strArr[0]);
            try {
                uri3.toURL();
                if (strArr.length < 2) {
                    try {
                        URI uri4 = new File(Consts.DOT).getCanonicalFile().toURI();
                        String path = uri3.getPath();
                        uri = CodeGenUtil.resolve(uri4, URI.create(path.substring(path.lastIndexOf(47) + 1)));
                    } catch (Exception unused) {
                        System.err.println("Cannot canonicalize current directory");
                        return;
                    }
                } else {
                    try {
                        URI uri5 = new URI(strArr[1]);
                        if (uri5.isAbsolute() && uri5.getScheme().equals(Constants.FILE)) {
                            uri2 = uri5;
                        }
                    } catch (Exception unused2) {
                    }
                    if (uri2 == null) {
                        try {
                            uri = Paths.get("", new String[0]).toAbsolutePath().toUri();
                        } catch (Exception unused3) {
                            System.err.println("Cannot canonicalize current directory");
                            return;
                        }
                    } else {
                        uri = uri2;
                    }
                }
                copyAll(findAllRelative(uri3, uri), true);
            } catch (Exception unused4) {
                uri2 = uri3;
                System.err.println("Badly formed URL " + uri2);
            }
        } catch (Exception unused5) {
        }
    }

    public static void printUsage() {
        System.out.println("Copies the XML schema at the specified URL to the specified file.");
        System.out.println("Usage: scopy sourceurl [targetfile]");
        System.out.println("    sourceurl - The URL at which the schema is located.");
        System.out.println("    targetfile - The file to which the schema should be copied.");
        System.out.println();
    }

    private static void putMappingsFromSchema(Map<URI, URI> map, URI uri, URI uri2, SchemaDocument.Schema schema) {
        for (ImportDocument.Import r6 : schema.getImportArray()) {
            putNewMapping(map, uri, uri2, r6.getSchemaLocation());
        }
        for (IncludeDocument.Include include : schema.getIncludeArray()) {
            putNewMapping(map, uri, uri2, include.getSchemaLocation());
        }
    }

    private static void putMappingsFromWsdl(Map<URI, URI> map, URI uri, URI uri2, DefinitionsDocument.Definitions definitions) {
        for (XmlObject xmlObject : definitions.getTypesArray()) {
            for (SchemaDocument.Schema schema : (SchemaDocument.Schema[]) xmlObject.selectPath("declare namespace xs='http://www.w3.org/2001/XMLSchema' xs:schema")) {
                putMappingsFromSchema(map, uri, uri2, schema);
            }
        }
        for (TImport tImport : definitions.getImportArray()) {
            putNewMapping(map, uri, uri2, tImport.getLocation());
        }
    }

    private static void putNewMapping(Map<URI, URI> map, URI uri, URI uri2, String str) {
        if (str == null) {
            return;
        }
        try {
            URI uri3 = new URI(str);
            if (uri3.isAbsolute()) {
                return;
            }
            map.put(CodeGenUtil.resolve(uri, uri3), CodeGenUtil.resolve(uri2, uri3));
        } catch (URISyntaxException unused) {
        }
    }
}
