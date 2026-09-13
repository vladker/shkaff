package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class InstanceValidator {
    public static int extraMain(String[] strArr) {
        int i5;
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("strict");
        hashSet.add("partial");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Collections.EMPTY_SET);
        int i6 = 0;
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || strArr.length < 1) {
            printUsage();
            return 0;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printUsage();
            return 0;
        }
        if (commandLine.getOpt("license") != null) {
            CommandLine.printLicense();
            return 0;
        }
        if (commandLine.getOpt("version") != null) {
            CommandLine.printVersion();
            return 0;
        }
        if (commandLine.args().length == 0) {
            return 0;
        }
        boolean z6 = commandLine.getOpt("dl") != null;
        boolean z7 = commandLine.getOpt("nopvr") != null;
        boolean z8 = commandLine.getOpt("noupa") != null;
        boolean z9 = commandLine.getOpt("strict") != null;
        boolean z10 = commandLine.getOpt("partial") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        File[] fileArrFilesEndingWith2 = commandLine.filesEndingWith(".xml");
        File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".jar");
        ArrayList arrayList = new ArrayList();
        int length = fileArrFilesEndingWith.length;
        int i7 = 0;
        while (i7 < length) {
            File file = fileArrFilesEndingWith[i7];
            try {
                arrayList.add(XmlObject.Factory.parse(file, new XmlOptions().setLoadLineNumbers().setLoadMessageDigest()));
            } catch (Exception e) {
                System.err.println(file + " not loadable: " + e);
            }
            i7++;
            i6 = 0;
        }
        XmlObject[] xmlObjectArr = (XmlObject[]) arrayList.toArray(new XmlObject[i6]);
        ArrayList arrayList2 = new ArrayList();
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setErrorListener(arrayList2);
        if (z6) {
            xmlOptions.setCompileDownloadUrls();
        }
        if (z7) {
            xmlOptions.setCompileNoPvrRule();
        }
        if (z8) {
            xmlOptions.setCompileNoUpaRule();
        }
        if (z10) {
            xmlOptions.setCompilePartialTypesystem();
        }
        SchemaTypeLoader schemaTypeLoaderTypeLoaderForResource = (fileArrFilesEndingWith3 == null || fileArrFilesEndingWith3.length <= 0) ? null : XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(fileArrFilesEndingWith3));
        if (xmlObjectArr != null) {
            try {
                if (xmlObjectArr.length > 0) {
                    schemaTypeLoaderTypeLoaderForResource = XmlBeans.compileXsd(xmlObjectArr, schemaTypeLoaderTypeLoaderForResource, xmlOptions);
                }
            } catch (Exception e6) {
                if (arrayList2.isEmpty() || !(e6 instanceof XmlException)) {
                    e6.printStackTrace(System.err);
                }
                System.out.println("Schema invalid:".concat(z10 ? " couldn't recover from errors" : ""));
                int size = arrayList2.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj = arrayList2.get(i8);
                    i8++;
                    System.out.println((XmlError) obj);
                }
                return 10;
            }
        }
        if (!z10 || arrayList2.isEmpty()) {
            i5 = 0;
        } else {
            System.out.println("Schema invalid: partial schema type system recovered");
            int size2 = arrayList2.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj2 = arrayList2.get(i9);
                i9++;
                System.out.println((XmlError) obj2);
            }
            i5 = 11;
        }
        if (schemaTypeLoaderTypeLoaderForResource == null) {
            schemaTypeLoaderTypeLoaderForResource = XmlBeans.getContextTypeLoader();
        }
        int i10 = i5;
        for (File file2 : fileArrFilesEndingWith2) {
            try {
                XmlOptions xmlOptions2 = new XmlOptions();
                xmlOptions2.setLoadLineNumbersEndElement();
                XmlObject xmlObject = schemaTypeLoaderTypeLoaderForResource.parse(file2, (SchemaType) null, xmlOptions2);
                ArrayList arrayList3 = new ArrayList();
                if (xmlObject.schemaType() == XmlObject.type) {
                    System.out.println(file2 + " NOT valid.  ");
                    System.out.println("  Document type not found.");
                } else if (xmlObject.validate(z9 ? new XmlOptions().setErrorListener(arrayList3).setValidateStrict() : new XmlOptions().setErrorListener(arrayList3))) {
                    System.out.println(file2 + " valid.");
                } else {
                    System.out.println(file2 + " NOT valid.");
                    int size3 = arrayList3.size();
                    int i11 = 0;
                    while (i11 < size3) {
                        Object obj3 = arrayList3.get(i11);
                        i11++;
                        System.out.println((XmlError) obj3);
                    }
                    i10 = 1;
                }
            } catch (Exception e7) {
                System.err.println(file2 + " not loadable: " + e7);
                e7.printStackTrace(System.err);
            }
        }
        return i10;
    }

    public static void main(String[] strArr) {
        System.exit(extraMain(strArr));
    }

    public static void printUsage() {
        System.out.println("Validates the specified instance against the specified schema.");
        System.out.println("Contrast with the svalidate tool, which validates using a stream.");
        System.out.println("Usage: validate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
        System.out.println("Options:");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -strict - performs strict(er) validation");
        System.out.println("    -partial - allow partial schema type system");
        System.out.println("    -license - prints license information");
    }
}
