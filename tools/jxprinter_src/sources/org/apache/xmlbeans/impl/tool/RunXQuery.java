package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class RunXQuery {
    public static void main(String[] strArr) {
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("version");
        hashSet.add("verbose");
        hashSet.add("pretty");
        CommandLine commandLine = new CommandLine(strArr, hashSet, Arrays.asList("q", "qf"));
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
            System.exit(0);
            return;
        }
        boolean z6 = commandLine.getOpt("verbose") != null;
        boolean z7 = commandLine.getOpt("pretty") != null;
        String opt = commandLine.getOpt("q");
        String opt2 = commandLine.getOpt("qf");
        if (opt == null && opt2 == null) {
            System.err.println("No query specified");
            System.exit(0);
            return;
        }
        if (opt != null && opt2 != null) {
            System.err.println("Specify -qf or -q, not both.");
            System.exit(0);
            return;
        }
        if (opt2 != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(opt2));
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.ISO_8859_1);
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i5 = inputStreamReader.read();
                    if (i5 < 0) {
                        break;
                    } else {
                        sb.append((char) i5);
                    }
                }
                inputStreamReader.close();
                fileInputStream.close();
                opt = sb.toString();
            } catch (Throwable th) {
                System.err.println("Cannot read query file: " + th.getMessage());
                System.exit(1);
                return;
            }
        }
        if (z6) {
            System.out.println("Compile Query:");
            System.out.println(opt);
            System.out.println();
        }
        try {
            String strCompileQuery = XmlBeans.compileQuery(opt);
            for (File file : commandLine.getFiles()) {
                if (z6) {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        while (true) {
                            int i6 = fileInputStream2.read();
                            if (i6 < 0) {
                                break;
                            } else {
                                System.out.write(i6);
                            }
                        }
                        fileInputStream2.close();
                        System.out.println();
                    } catch (Throwable th2) {
                        System.err.println("Error parsing instance: " + th2.getMessage());
                        System.exit(1);
                        return;
                    }
                }
                XmlObject xmlObject = XmlObject.Factory.parse(file);
                if (z6) {
                    System.out.println("Executing Query...");
                    System.err.println();
                }
                try {
                    XmlObject[] xmlObjectArrExecQuery = xmlObject.execQuery(strCompileQuery);
                    if (z6) {
                        System.out.println("Query Result:");
                    }
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setSaveOuter();
                    if (z7) {
                        xmlOptions.setSavePrettyPrint();
                    }
                    for (XmlObject xmlObject2 : xmlObjectArrExecQuery) {
                        xmlObject2.save(System.out, xmlOptions);
                        System.out.println();
                    }
                } catch (Throwable th3) {
                    System.err.println("Error executing query: " + th3.getMessage());
                    System.exit(1);
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("Error compiling query: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void printUsage() {
        System.out.println("Run an XQuery against an XML instance");
        System.out.println("Usage:");
        System.out.println("xquery [-verbose] [-pretty] [-q <query> | -qf query.xq] [file.xml]*");
        System.out.println(" -q <query> to specify a query on the command-line");
        System.out.println(" -qf <query> to specify a file containing a query");
        System.out.println(" -pretty pretty-prints the results");
        System.out.println(" -license prints license information");
        System.out.println(" the query is run on each XML file specified");
        System.out.println();
    }
}
