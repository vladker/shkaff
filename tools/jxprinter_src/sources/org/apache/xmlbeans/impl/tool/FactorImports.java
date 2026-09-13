package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class FactorImports {
    private static URI commonAncestor(URI uri, URI uri2) {
        String string = uri.toString();
        String string2 = uri2.toString();
        int length = string.length();
        if (string2.length() < length) {
            length = string2.length();
        }
        int i5 = 0;
        while (i5 < length && string.charAt(i5) == string2.charAt(i5)) {
            i5++;
        }
        int iLastIndexOf = i5 - 1;
        if (iLastIndexOf >= 0) {
            iLastIndexOf = string.lastIndexOf(47, iLastIndexOf);
        }
        if (iLastIndexOf < 0) {
            return null;
        }
        try {
            return new URI(string.substring(0, iLastIndexOf));
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    private static File commonFileFor(String str, String str2, int i5, File file) {
        if (i5 > 0) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf < 0) {
                iLastIndexOf = str.length();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, iLastIndexOf));
            sb.append(i5);
            str = androidx.exifinterface.media.a.j(str, iLastIndexOf, sb);
        }
        return new File(file, str);
    }

    private static boolean isDuplicate(String str, String str2, Set<QName> set) {
        if (str == null) {
            return false;
        }
        return set.contains(new QName(str2, str));
    }

    private static boolean isFirstDuplicate(String str, String str2, Set<QName> set, Set<QName> set2) {
        if (str == null) {
            return false;
        }
        QName qName = new QName(str2, str);
        if (!set2.contains(qName) || !set.contains(qName)) {
            return false;
        }
        set.remove(qName);
        return true;
    }

    public static void main(String[] strArr) {
        File file;
        HashMap map;
        HashMap map2;
        HashSet hashSet;
        NamedAttributeGroup[] namedAttributeGroupArr;
        NamedGroup[] namedGroupArr;
        TopLevelAttribute[] topLevelAttributeArr;
        TopLevelElement[] topLevelElementArr;
        TopLevelSimpleType[] topLevelSimpleTypeArr;
        int i5;
        HashSet hashSet2 = new HashSet();
        hashSet2.add("h");
        hashSet2.add("help");
        hashSet2.add("usage");
        hashSet2.add("license");
        hashSet2.add("version");
        String str = "out";
        CommandLine commandLine = new CommandLine(strArr, hashSet2, Arrays.asList("import", "out"));
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str2 : badOpts) {
                System.out.println("Unrecognized option: " + str2);
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
        String[] strArrArgs = commandLine.args();
        if (strArrArgs.length != 1) {
            System.exit(0);
            return;
        }
        String opt = commandLine.getOpt("import");
        if (opt == null) {
            opt = "common.xsd";
        }
        String opt2 = commandLine.getOpt("out");
        if (opt2 == null) {
            System.out.println("Using output directory 'out'");
        } else {
            str = opt2;
        }
        File file2 = new File(str);
        File file3 = new File(strArrArgs[0]);
        File[] files = commandLine.getFiles();
        HashMap map3 = new HashMap();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        HashSet hashSet6 = new HashSet();
        HashSet hashSet7 = new HashSet();
        HashSet hashSet8 = new HashSet();
        HashSet hashSet9 = new HashSet();
        HashSet hashSet10 = new HashSet();
        HashSet hashSet11 = new HashSet();
        File file4 = file3;
        HashSet hashSet12 = new HashSet();
        String str3 = opt;
        HashSet hashSet13 = new HashSet();
        int length = files.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = length;
            File file5 = files[i6];
            try {
                try {
                    SchemaDocument schemaDocument = SchemaDocument.Factory.parse(file5);
                    map3.put(schemaDocument, file5);
                    if (schemaDocument.getSchema().sizeOfImportArray() > 0 || schemaDocument.getSchema().sizeOfIncludeArray() > 0) {
                        PrintStream printStream = System.out;
                        i5 = i6;
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("warning: ");
                            sb.append(file5);
                            sb.append(" contains imports or includes that are being ignored.");
                            printStream.println(sb.toString());
                        } catch (XmlException e) {
                            e = e;
                            map3 = map3;
                            System.out.println("warning: " + file5 + " is not a schema file - " + e.getError().toString());
                            i6 = i5 + 1;
                            length = i7;
                            map3 = map3;
                        }
                    } else {
                        i5 = i6;
                    }
                    try {
                        String targetNamespace = schemaDocument.getSchema().getTargetNamespace();
                        if (targetNamespace == null) {
                            targetNamespace = "";
                        }
                        for (TopLevelComplexType topLevelComplexType : schemaDocument.getSchema().getComplexTypeArray()) {
                            noteName(topLevelComplexType.getName(), targetNamespace, hashSet5, hashSet10, hashSet13);
                        }
                        for (TopLevelSimpleType topLevelSimpleType : schemaDocument.getSchema().getSimpleTypeArray()) {
                            noteName(topLevelSimpleType.getName(), targetNamespace, hashSet5, hashSet10, hashSet13);
                        }
                        for (TopLevelElement topLevelElement : schemaDocument.getSchema().getElementArray()) {
                            noteName(topLevelElement.getName(), targetNamespace, hashSet3, hashSet8, hashSet13);
                        }
                        for (TopLevelAttribute topLevelAttribute : schemaDocument.getSchema().getAttributeArray()) {
                            noteName(topLevelAttribute.getName(), targetNamespace, hashSet4, hashSet9, hashSet13);
                        }
                        for (NamedGroup namedGroup : schemaDocument.getSchema().getGroupArray()) {
                            noteName(namedGroup.getName(), targetNamespace, hashSet6, hashSet11, hashSet13);
                        }
                        NamedAttributeGroup[] attributeGroupArray = schemaDocument.getSchema().getAttributeGroupArray();
                        int length2 = attributeGroupArray.length;
                        int i8 = 0;
                        while (i8 < length2) {
                            int i9 = i8;
                            noteName(attributeGroupArray[i8].getName(), targetNamespace, hashSet7, hashSet12, hashSet13);
                            i8 = i9 + 1;
                        }
                    } catch (XmlException e6) {
                        e = e6;
                        System.out.println("warning: " + file5 + " is not a schema file - " + e.getError().toString());
                    }
                } catch (XmlException e7) {
                    e = e7;
                    i5 = i6;
                }
                i6 = i5 + 1;
                length = i7;
                map3 = map3;
            } catch (IOException e8) {
                System.err.println("Unable to load " + file5 + " - " + e8.getMessage());
                System.exit(1);
                return;
            }
        }
        HashMap map4 = map3;
        if (map4.size() == 0) {
            System.out.println("No schema files found.");
            System.exit(0);
            return;
        }
        if (hashSet12.size() + hashSet11.size() + hashSet9.size() + hashSet8.size() + hashSet10.size() == 0) {
            System.out.println("No duplicate names found.");
            System.exit(0);
            return;
        }
        HashMap map5 = new HashMap();
        HashMap map6 = new HashMap();
        int i10 = hashSet13.size() == 1 ? 0 : 1;
        Iterator it = hashSet13.iterator();
        while (it.hasNext()) {
            String str4 = (String) it.next();
            Iterator it2 = it;
            SchemaDocument schemaDocument2 = SchemaDocument.Factory.parse("<xs:schema xmlns:xs='http://www.w3.org/2001/XMLSchema'/>");
            if (str4.length() > 0) {
                schemaDocument2.getSchema().setTargetNamespace(str4);
            }
            HashSet hashSet14 = hashSet7;
            schemaDocument2.getSchema().setElementFormDefault(FormChoice.QUALIFIED);
            map5.put(str4, schemaDocument2);
            String str5 = str3;
            map6.put(schemaDocument2, commonFileFor(str5, str4, i10, file2));
            i10++;
            it = it2;
            str3 = str5;
            hashSet7 = hashSet14;
        }
        HashSet hashSet15 = hashSet7;
        Iterator it3 = map4.keySet().iterator();
        while (it3.hasNext()) {
            SchemaDocument schemaDocument3 = (SchemaDocument) it3.next();
            String targetNamespace2 = schemaDocument3.getSchema().getTargetNamespace();
            if (targetNamespace2 == null) {
                targetNamespace2 = "";
            }
            SchemaDocument schemaDocument4 = (SchemaDocument) map5.get(targetNamespace2);
            HashMap map7 = map5;
            TopLevelComplexType[] complexTypeArray = schemaDocument3.getSchema().getComplexTypeArray();
            Iterator it4 = it3;
            int length3 = complexTypeArray.length - 1;
            boolean z6 = false;
            while (length3 >= 0) {
                TopLevelComplexType[] topLevelComplexTypeArr = complexTypeArray;
                if (isDuplicate(complexTypeArray[length3].getName(), targetNamespace2, hashSet10)) {
                    if (isFirstDuplicate(topLevelComplexTypeArr[length3].getName(), targetNamespace2, hashSet5, hashSet10)) {
                        schemaDocument4.getSchema().addNewComplexType().set(topLevelComplexTypeArr[length3]);
                    }
                    schemaDocument3.getSchema().removeComplexType(length3);
                    z6 = true;
                } else {
                    map6 = map6;
                }
                length3--;
                map6 = map6;
                complexTypeArray = topLevelComplexTypeArr;
            }
            HashMap map8 = map6;
            TopLevelSimpleType[] simpleTypeArray = schemaDocument3.getSchema().getSimpleTypeArray();
            int i11 = 0;
            while (i11 < simpleTypeArray.length) {
                if (isDuplicate(simpleTypeArray[i11].getName(), targetNamespace2, hashSet10)) {
                    if (isFirstDuplicate(simpleTypeArray[i11].getName(), targetNamespace2, hashSet5, hashSet10)) {
                        topLevelSimpleTypeArr = simpleTypeArray;
                        schemaDocument4.getSchema().addNewSimpleType().set(topLevelSimpleTypeArr[i11]);
                    } else {
                        topLevelSimpleTypeArr = simpleTypeArray;
                    }
                    schemaDocument3.getSchema().removeSimpleType(i11);
                    z6 = true;
                } else {
                    topLevelSimpleTypeArr = simpleTypeArray;
                }
                i11++;
                simpleTypeArray = topLevelSimpleTypeArr;
            }
            TopLevelElement[] elementArray = schemaDocument3.getSchema().getElementArray();
            int i12 = 0;
            while (i12 < elementArray.length) {
                if (isDuplicate(elementArray[i12].getName(), targetNamespace2, hashSet8)) {
                    if (isFirstDuplicate(elementArray[i12].getName(), targetNamespace2, hashSet3, hashSet8)) {
                        topLevelElementArr = elementArray;
                        schemaDocument4.getSchema().addNewElement().set(topLevelElementArr[i12]);
                    } else {
                        topLevelElementArr = elementArray;
                    }
                    schemaDocument3.getSchema().removeElement(i12);
                    z6 = true;
                } else {
                    topLevelElementArr = elementArray;
                }
                i12++;
                elementArray = topLevelElementArr;
            }
            TopLevelAttribute[] attributeArray = schemaDocument3.getSchema().getAttributeArray();
            int i13 = 0;
            while (i13 < attributeArray.length) {
                if (isDuplicate(attributeArray[i13].getName(), targetNamespace2, hashSet9)) {
                    if (isFirstDuplicate(attributeArray[i13].getName(), targetNamespace2, hashSet4, hashSet9)) {
                        topLevelAttributeArr = attributeArray;
                        schemaDocument4.getSchema().addNewElement().set(topLevelAttributeArr[i13]);
                    } else {
                        topLevelAttributeArr = attributeArray;
                    }
                    schemaDocument3.getSchema().removeElement(i13);
                    z6 = true;
                } else {
                    topLevelAttributeArr = attributeArray;
                }
                i13++;
                attributeArray = topLevelAttributeArr;
            }
            NamedGroup[] groupArray = schemaDocument3.getSchema().getGroupArray();
            int i14 = 0;
            while (i14 < groupArray.length) {
                if (isDuplicate(groupArray[i14].getName(), targetNamespace2, hashSet11)) {
                    if (isFirstDuplicate(groupArray[i14].getName(), targetNamespace2, hashSet6, hashSet11)) {
                        namedGroupArr = groupArray;
                        schemaDocument4.getSchema().addNewElement().set(namedGroupArr[i14]);
                    } else {
                        namedGroupArr = groupArray;
                    }
                    schemaDocument3.getSchema().removeElement(i14);
                    z6 = true;
                } else {
                    namedGroupArr = groupArray;
                }
                i14++;
                groupArray = namedGroupArr;
            }
            NamedAttributeGroup[] attributeGroupArray2 = schemaDocument3.getSchema().getAttributeGroupArray();
            int i15 = 0;
            while (i15 < attributeGroupArray2.length) {
                if (isDuplicate(attributeGroupArray2[i15].getName(), targetNamespace2, hashSet12)) {
                    hashSet = hashSet15;
                    if (isFirstDuplicate(attributeGroupArray2[i15].getName(), targetNamespace2, hashSet, hashSet12)) {
                        namedAttributeGroupArr = attributeGroupArray2;
                        schemaDocument4.getSchema().addNewElement().set(namedAttributeGroupArr[i15]);
                    } else {
                        namedAttributeGroupArr = attributeGroupArray2;
                    }
                    schemaDocument3.getSchema().removeElement(i15);
                    z6 = true;
                } else {
                    hashSet = hashSet15;
                    namedAttributeGroupArr = attributeGroupArray2;
                }
                i15++;
                attributeGroupArray2 = namedAttributeGroupArr;
                hashSet15 = hashSet;
                hashSet11 = hashSet11;
            }
            HashSet hashSet16 = hashSet11;
            HashSet hashSet17 = hashSet15;
            if (z6) {
                IncludeDocument.Include includeAddNewInclude = schemaDocument3.getSchema().addNewInclude();
                map2 = map4;
                File file6 = (File) map2.get(schemaDocument3);
                file = file4;
                map = map8;
                includeAddNewInclude.setSchemaLocation(relativeURIFor(outputFileFor(file6, file, file2), (File) map.get(schemaDocument4)));
            } else {
                file = file4;
                map = map8;
                map2 = map4;
            }
            map4 = map2;
            hashSet15 = hashSet17;
            file4 = file;
            map6 = map;
            it3 = it4;
            map5 = map7;
            hashSet11 = hashSet16;
        }
        HashMap map9 = map6;
        File file7 = file4;
        HashMap map10 = map4;
        if (!file2.isDirectory() && !file2.mkdirs()) {
            System.err.println("Unable to makedir " + file2);
            System.exit(1);
            return;
        }
        for (SchemaDocument schemaDocument5 : map10.keySet()) {
            File file8 = (File) map10.get(schemaDocument5);
            File fileOutputFileFor = outputFileFor(file8, file7, file2);
            if (fileOutputFileFor == null) {
                System.out.println("Cannot copy " + file8);
            } else {
                schemaDocument5.save(fileOutputFileFor, new XmlOptions().setSavePrettyPrint().setSaveAggressiveNamespaces());
            }
        }
        for (SchemaDocument schemaDocument6 : map9.keySet()) {
            schemaDocument6.save((File) map9.get(schemaDocument6), new XmlOptions().setSavePrettyPrint().setSaveAggressiveNamespaces());
        }
    }

    private static void noteName(String str, String str2, Set<QName> set, Set<QName> set2, Set<String> set3) {
        if (str == null) {
            return;
        }
        QName qName = new QName(str2, str);
        if (!set.contains(qName)) {
            set.add(qName);
        } else {
            set2.add(qName);
            set3.add(str2);
        }
    }

    private static File outputFileFor(File file, File file2, File file3) {
        URI uriRelativize = file2.getAbsoluteFile().toURI().relativize(file.getAbsoluteFile().toURI());
        if (!uriRelativize.isAbsolute()) {
            return new File(CodeGenUtil.resolve(file3.toURI(), uriRelativize));
        }
        System.out.println("Cannot relativize " + file);
        return null;
    }

    public static void printUsage() {
        System.out.println("Refactors a directory of XSD files to remove name conflicts.");
        System.out.println("Usage: sfactor [-import common.xsd] [-out outputdir] inputdir");
        System.out.println("    -import common.xsd - The XSD file to contain redundant ");
        System.out.println("                         definitions for importing.");
        System.out.println("    -out outputdir - The directory into which to place XSD ");
        System.out.println("                     files resulting from refactoring, ");
        System.out.println("                     plus a commonly imported common.xsd.");
        System.out.println("    inputdir - The directory containing the XSD files with");
        System.out.println("               redundant definitions.");
        System.out.println("    -license - Print license information.");
        System.out.println();
    }

    private static String relativeURIFor(File file, File file2) {
        int iIndexOf;
        URI uri = file.getAbsoluteFile().toURI();
        URI uri2 = file2.getAbsoluteFile().toURI();
        URI uriCommonAncestor = commonAncestor(uri, uri2);
        if (uriCommonAncestor == null) {
            return uri2.toString();
        }
        URI uriRelativize = uriCommonAncestor.relativize(uri);
        URI uriRelativize2 = uriCommonAncestor.relativize(uri2);
        if (uriRelativize.isAbsolute() || uriRelativize2.isAbsolute()) {
            return uri2.toString();
        }
        String string = uriRelativize.toString();
        String strN = "";
        int i5 = 0;
        while (i5 < string.length() && (iIndexOf = string.indexOf(47, i5)) >= 0) {
            strN = androidx.collection.a.n(strN, "../");
            i5 = iIndexOf + 1;
        }
        StringBuilder sbR = androidx.collection.a.r(strN);
        sbR.append(uriRelativize2.toString());
        return sbR.toString();
    }
}
