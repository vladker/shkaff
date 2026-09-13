package org.apache.xmlbeans.impl.inst2xsd;

import A3.AbstractC0157z;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
import org.apache.xmlbeans.impl.tool.CommandLine;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Inst2Xsd {
    private Inst2Xsd() {
    }

    public static SchemaDocument[] inst2xsd(Reader[] readerArr, Inst2XsdOptions inst2XsdOptions) {
        XmlObject[] xmlObjectArr = new XmlObject[readerArr.length];
        for (int i5 = 0; i5 < readerArr.length; i5++) {
            xmlObjectArr[i5] = XmlObject.Factory.parse(readerArr[i5]);
        }
        return inst2xsd(xmlObjectArr, inst2XsdOptions);
    }

    public static void main(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            printHelp();
            System.exit(0);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("verbose");
        hashSet.add("validate");
        HashSet hashSet2 = new HashSet();
        hashSet2.add("design");
        hashSet2.add("simple-content-types");
        hashSet2.add("enumerations");
        hashSet2.add("outDir");
        hashSet2.add("outPrefix");
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        Inst2XsdOptions inst2XsdOptions = new Inst2XsdOptions();
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
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printHelp();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str : badOpts) {
                System.out.println("Unrecognized option: " + str);
            }
            printHelp();
            System.exit(0);
            return;
        }
        String opt = commandLine.getOpt("design");
        if (opt != null) {
            if (opt.equals("vb")) {
                inst2XsdOptions.setDesign(3);
            } else if (opt.equals("rd")) {
                inst2XsdOptions.setDesign(1);
            } else {
                if (!opt.equals("ss")) {
                    printHelp();
                    System.exit(0);
                    return;
                }
                inst2XsdOptions.setDesign(2);
            }
        }
        String opt2 = commandLine.getOpt("simple-content-types");
        if (opt2 != null) {
            if (opt2.equals("smart")) {
                inst2XsdOptions.setSimpleContentTypes(1);
            } else {
                if (!opt2.equals(TypedValues.Custom.S_STRING)) {
                    printHelp();
                    System.exit(0);
                    return;
                }
                inst2XsdOptions.setSimpleContentTypes(2);
            }
        }
        String opt3 = commandLine.getOpt("enumerations");
        if (opt3 != null) {
            if (opt3.equals("never")) {
                inst2XsdOptions.setUseEnumerations(1);
            } else {
                try {
                    inst2XsdOptions.setUseEnumerations(Integer.parseInt(opt3));
                } catch (NumberFormatException unused) {
                    printHelp();
                    System.exit(0);
                    return;
                }
            }
        }
        File file = new File(commandLine.getOpt("outDir") == null ? Consts.DOT : commandLine.getOpt("outDir"));
        String opt4 = commandLine.getOpt("outPrefix");
        if (opt4 == null) {
            opt4 = "schema";
        }
        inst2XsdOptions.setVerbose(commandLine.getOpt("verbose") != null);
        boolean z6 = commandLine.getOpt("validate") != null;
        File[] fileArrFilesEndingWith = commandLine.filesEndingWith(".xml");
        int length = fileArrFilesEndingWith.length;
        XmlObject[] xmlObjectArr = new XmlObject[length];
        if (length == 0) {
            printHelp();
            System.exit(0);
            return;
        }
        for (int i5 = 0; i5 < fileArrFilesEndingWith.length; i5++) {
            try {
                xmlObjectArr[i5] = XmlObject.Factory.parse(fileArrFilesEndingWith[i5]);
            } catch (IOException e) {
                System.err.println("Could not read file: '" + fileArrFilesEndingWith[i5].getName() + "'. " + e.getMessage());
                return;
            } catch (XmlException e6) {
                System.err.println("Invalid xml file: '" + fileArrFilesEndingWith[i5].getName() + "'. " + e6.getMessage());
                return;
            }
        }
        SchemaDocument[] schemaDocumentArrInst2xsd = inst2xsd(xmlObjectArr, inst2XsdOptions);
        for (int i6 = 0; i6 < schemaDocumentArrInst2xsd.length; i6++) {
            try {
                SchemaDocument schemaDocument = schemaDocumentArrInst2xsd[i6];
                if (inst2XsdOptions.isVerbose()) {
                    System.out.println("----------------------\n\n" + schemaDocument);
                }
                schemaDocument.save(new File(file, opt4 + i6 + ".xsd"), new XmlOptions().setSavePrettyPrint());
            } catch (IOException e7) {
                System.err.println("Could not write file: '" + file + File.pathSeparator + opt4 + i6 + ".xsd'. " + e7.getMessage());
                return;
            }
        }
        if (z6) {
            validateInstances(schemaDocumentArrInst2xsd, xmlObjectArr);
        }
    }

    private static void printHelp() {
        System.out.println("Generates XMLSchema from instance xml documents.");
        System.out.println("Usage: inst2xsd [opts] [instance.xml]*");
        System.out.println("Options include:");
        System.out.println("    -design [rd|ss|vb] - XMLSchema design type");
        System.out.println("             rd  - Russian Doll Design - local elements and local types");
        System.out.println("             ss  - Salami Slice Design - global elements and local types");
        System.out.println("             vb  - Venetian Blind Design (default) - local elements and global complex types");
        System.out.println("    -simple-content-types [smart|string] - Simple content types detection (leaf text). Smart is the default");
        System.out.println("    -enumerations [never|NUMBER] - Use enumerations. Default value is 10.");
        System.out.println("    -outDir [dir] - Directory for output files. Default is '.'");
        System.out.println("    -outPrefix [file_name_prefix] - Prefix for output file names. Default is 'schema'");
        System.out.println("    -validate - Validates input instances agaist generated schemas.");
        System.out.println("    -verbose - print more informational messages");
        System.out.println("    -license - print license information");
        System.out.println("    -help - help imformation");
    }

    private static boolean validateInstances(SchemaDocument[] schemaDocumentArr, XmlObject[] xmlObjectArr) {
        ArrayList arrayList = new ArrayList();
        XmlOptions xmlOptions = new XmlOptions();
        xmlOptions.setErrorListener(arrayList);
        try {
            SchemaTypeLoader schemaTypeLoaderLoadXsd = XmlBeans.loadXsd(schemaDocumentArr, xmlOptions);
            System.out.println("\n-------------------");
            boolean z6 = true;
            for (int i5 = 0; i5 < xmlObjectArr.length; i5++) {
                try {
                    XmlObject xmlObject = schemaTypeLoaderLoadXsd.parse(xmlObjectArr[i5].newXMLStreamReader(), (SchemaType) null, new XmlOptions().setLoadLineNumbers());
                    ArrayList arrayList2 = new ArrayList();
                    if (xmlObject.schemaType() == XmlObject.type) {
                        System.out.println(xmlObjectArr[i5].documentProperties().getSourceName() + " NOT valid.  ");
                        System.out.println("  Document type not found.");
                    } else {
                        if (xmlObject.validate(new XmlOptions().setErrorListener(arrayList2))) {
                            PrintStream printStream = System.out;
                            StringBuilder sbT = AbstractC0157z.t(i5, "Instance[", "] valid - ");
                            sbT.append(xmlObjectArr[i5].documentProperties().getSourceName());
                            printStream.println(sbT.toString());
                        } else {
                            PrintStream printStream2 = System.out;
                            StringBuilder sbT2 = AbstractC0157z.t(i5, "Instance[", "] NOT valid - ");
                            sbT2.append(xmlObjectArr[i5].documentProperties().getSourceName());
                            printStream2.println(sbT2.toString());
                            int size = arrayList2.size();
                            int i6 = 0;
                            while (i6 < size) {
                                Object obj = arrayList2.get(i6);
                                i6++;
                                XmlError xmlError = (XmlError) obj;
                                System.out.println(xmlError.getLine() + ParameterizedMessage.ERROR_MSG_SEPARATOR + xmlError.getColumn() + " " + xmlError.getMessage());
                            }
                        }
                    }
                } catch (XmlException e) {
                    System.out.println("Error:\n" + xmlObjectArr[i5].documentProperties().getSourceName() + " not loadable: " + e);
                    e.printStackTrace(System.out);
                }
                z6 = false;
            }
            return z6;
        } catch (Exception e6) {
            if (arrayList.isEmpty() || !(e6 instanceof XmlException)) {
                e6.printStackTrace(System.out);
            }
            System.out.println("\n-------------------\n\nInvalid schemas.");
            int size2 = arrayList.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj2 = arrayList.get(i7);
                i7++;
                XmlError xmlError2 = (XmlError) obj2;
                System.out.println(xmlError2.getLine() + ParameterizedMessage.ERROR_MSG_SEPARATOR + xmlError2.getColumn() + " " + xmlError2.getMessage());
            }
            return false;
        }
    }

    public static SchemaDocument[] inst2xsd(XmlObject[] xmlObjectArr, Inst2XsdOptions inst2XsdOptions) {
        XsdGenStrategy russianDollStrategy;
        if (inst2XsdOptions == null) {
            inst2XsdOptions = new Inst2XsdOptions();
        }
        TypeSystemHolder typeSystemHolder = new TypeSystemHolder();
        int design = inst2XsdOptions.getDesign();
        if (design == 1) {
            russianDollStrategy = new RussianDollStrategy();
        } else if (design == 2) {
            russianDollStrategy = new SalamiSliceStrategy();
        } else if (design == 3) {
            russianDollStrategy = new VenetianBlindStrategy();
        } else {
            throw new IllegalArgumentException("Unknown design.");
        }
        russianDollStrategy.processDoc(xmlObjectArr, inst2XsdOptions, typeSystemHolder);
        if (inst2XsdOptions.isVerbose()) {
            System.out.println("typeSystemHolder.toString(): " + typeSystemHolder);
        }
        return typeSystemHolder.getSchemaDocuments();
    }
}
