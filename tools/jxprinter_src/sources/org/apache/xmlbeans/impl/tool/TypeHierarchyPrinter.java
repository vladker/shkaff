package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TypeHierarchyPrinter {
    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("noanon");
        hashSet.add("noupr");
        hashSet.add("noupa");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printUsage();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            System.exit(0);
            return;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            System.exit(0);
            return;
        }
        if (commandLine.args().length == 0) {
            printUsage();
            return;
        }
        boolean z6 = commandLine.getOpt("noanon") != null;
        boolean z7 = commandLine.getOpt("nopvr") != null;
        boolean z8 = commandLine.getOpt("noupa") != null;
        boolean z9 = commandLine.getOpt("partial") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < fileArrFilesEndingWith.length; i5++) {
            try {
                arrayList.add(SchemaDocument.Factory.parse(fileArrFilesEndingWith[i5], new XmlOptions().setLoadLineNumbers()));
            } catch (Exception e) {
                System.err.println(fileArrFilesEndingWith[i5] + " not loadable: " + e);
            }
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[0]);
        ArrayList arrayList2 = new ArrayList();
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setErrorListener(arrayList2);
        xmlOptions.setCompileDownloadUrls();
        if (z7) {
            xmlOptions.setCompileNoPvrRule();
        }
        if (z8) {
            xmlOptions.setCompileNoUpaRule();
        }
        if (z9) {
            xmlOptions.setCompilePartialTypesystem();
        }
        try {
            SchemaTypeSystem schemaTypeSystemCompileXsd = XmlBeans.compileXsd(xmlObjectArr, (fileArrFilesEndingWith2 == null || fileArrFilesEndingWith2.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith2)), xmlOptions);
            if (z9 && !arrayList2.isEmpty()) {
                System.out.println("Schema invalid: partial schema type system recovered");
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
            HashMap map = new HashMap();
            map.put("http://www.w3.org/XML/1998/namespace", "xml");
            map.put("http://www.w3.org/2001/XMLSchema", "xs");
            System.out.println("xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"");
            HashMap map2 = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(Arrays.asList(schemaTypeSystemCompileXsd.documentTypes()));
            arrayList3.addAll(Arrays.asList(schemaTypeSystemCompileXsd.attributeTypes()));
            arrayList3.addAll(Arrays.asList(schemaTypeSystemCompileXsd.globalTypes()));
            for (int i6 = 0; i6 < arrayList3.size(); i6++) {
                SchemaType schemaType = (SchemaType) arrayList3.get(i6);
                if (!z6) {
                    arrayList3.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
                }
                if (!schemaType.isDocumentType() && !schemaType.isAttributeType() && schemaType != XmlObject.type) {
                    noteNamespace(map, schemaType);
                    Collection arrayList4 = (Collection) map2.get(schemaType.getBaseType());
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                        map2.put(schemaType.getBaseType(), arrayList4);
                        if (schemaType.getBaseType().isBuiltinType()) {
                            arrayList3.add(schemaType.getBaseType());
                        }
                    }
                    arrayList4.add(schemaType);
                }
            }
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(XmlObject.type);
            StringBuilder sb = new StringBuilder();
            while (!arrayList5.isEmpty()) {
                SchemaType schemaType2 = (SchemaType) arrayList5.remove(arrayList5.size() - 1);
                if (schemaType2 == null) {
                    sb.setLength(Math.max(0, sb.length() - 2));
                } else {
                    System.out.println(((Object) sb) + "+-" + QNameHelper.readable(schemaType2, map) + notes(schemaType2));
                    Collection collection = (Collection) map2.get(schemaType2);
                    if (collection != null && collection.size() > 0) {
                        sb.append((arrayList5.size() == 0 || androidx.collection.a.e(arrayList5, 1) == null) ? "  " : "| ");
                        arrayList5.add(null);
                        arrayList5.addAll(collection);
                    }
                }
            }
        } catch (XmlException e6) {
            System.out.println("Schema invalid:".concat(z9 ? " couldn't recover from errors" : ""));
            if (arrayList2.isEmpty()) {
                System.out.println(e6.getMessage());
                return;
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
        }
    }

    private static void noteNamespace(Map map, SchemaType schemaType) {
        String strNamespace = QNameHelper.namespace(schemaType);
        if (strNamespace.equals("") || map.containsKey(strNamespace)) {
            return;
        }
        String strSuggestPrefix = QNameHelper.suggestPrefix(strNamespace);
        int i5 = 0;
        String str = strSuggestPrefix;
        while (map.containsValue(str)) {
            str = strSuggestPrefix + i5;
            i5++;
        }
        map.put(strNamespace, str);
        System.out.println(androidx.collection.a.p(Sax2Dom.XMLNS_STRING, str, "=\"", strNamespace, "\""));
    }

    private static String notes(SchemaType schemaType) {
        if (schemaType.isBuiltinType()) {
            return " (builtin)";
        }
        if (!schemaType.isSimpleType()) {
            int contentType = schemaType.getContentType();
            if (contentType != 2) {
                return contentType != 4 ? "" : " (mixed)";
            }
            return " (complex)";
        }
        int simpleVariety = schemaType.getSimpleVariety();
        if (simpleVariety == 2) {
            return " (union)";
        }
        if (simpleVariety != 3) {
            return schemaType.getEnumerationValues() != null ? " (enumeration)" : "";
        }
        return " (list)";
    }

    public static void printUsage() {
        System.out.println("Prints the inheritance hierarchy of types defined in a schema.\n");
        System.out.println("Usage: xsdtree [-noanon] [-nopvr] [-noupa] [-partial] [-license] schemafile.xsd*");
        System.out.println("    -noanon - Don't include anonymous types in the tree.");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -partial - Print only part of the hierarchy.");
        System.out.println("    -license - prints license information");
        System.out.println("    schemafile.xsd - File containing the schema for which to print a tree.");
        System.out.println();
    }
}
