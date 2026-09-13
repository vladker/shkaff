package org.apache.xmlbeans.impl.tool;

import A3.AbstractC0157z;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.xmlbeans.ResourceLoader;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.SystemProperties;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.apache.xmlbeans.impl.common.JarHelper;
import org.apache.xmlbeans.impl.common.ResolverUtil;
import org.apache.xmlbeans.impl.common.XmlErrorPrinter;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.config.BindingConfigImpl;
import org.apache.xmlbeans.impl.repackage.Repackager;
import org.apache.xmlbeans.impl.schema.PathResourceLoader;
import org.apache.xmlbeans.impl.schema.SchemaTypeLoaderImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemCompiler;
import org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl;
import org.apache.xmlbeans.impl.schema.StscState;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.values.XmlListImpl;
import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaCompiler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMPATIBILITY_CONFIG_URI = "http://www.bea.com/2002/09/xbean/config";
    private static final String CONFIG_URI = "http://xml.apache.org/xmlbeans/2004/02/xbean/config";
    private static final Map<String, String> MAP_COMPATIBILITY_CONFIG_URIS = Collections.singletonMap(COMPATIBILITY_CONFIG_URI, CONFIG_URI);

    private static void addSchema(String str, SchemaDocument schemaDocument, XmlErrorWatcher xmlErrorWatcher, boolean z6, List<SchemaDocument.Schema> list) {
        StscState.addInfo(xmlErrorWatcher, "Loading schema file " + str);
        XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
        if (z6) {
            errorListener.setValidateTreatLaxAsSkip();
        }
        if (schemaDocument.validate(errorListener)) {
            list.add(schemaDocument.getSchema());
        }
    }

    private static void addWsdlSchemas(String str, DefinitionsDocument definitionsDocument, XmlErrorWatcher xmlErrorWatcher, boolean z6, List<SchemaDocument.Schema> list) {
        if (wsdlContainsEncoded(definitionsDocument)) {
            StscState.addWarning(xmlErrorWatcher, AbstractC0157z.o("The WSDL ", str, " uses SOAP encoding. SOAP encoding is not compatible with literal XML Schema."), 60, definitionsDocument);
        }
        StscState.addInfo(xmlErrorWatcher, "Loading wsdl file " + str);
        XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
        if (z6) {
            errorListener.setValidateTreatLaxAsSkip();
        }
        int i5 = 0;
        for (XmlObject xmlObject : definitionsDocument.getDefinitions().getTypesArray()) {
            XmlObject[] xmlObjectArrSelectPath = xmlObject.selectPath("declare namespace xs=\"http://www.w3.org/2001/XMLSchema\" xs:schema");
            if (xmlObjectArrSelectPath.length == 0) {
                StscState.addWarning(xmlErrorWatcher, AbstractC0157z.o("The WSDL ", str, " did not have any schema documents in namespace 'http://www.w3.org/2001/XMLSchema'"), 60, definitionsDocument);
            } else {
                for (XmlObject xmlObject2 : xmlObjectArrSelectPath) {
                    if (xmlObject2.validate(errorListener)) {
                        i5++;
                        list.add((SchemaDocument.Schema) xmlObject2);
                    }
                }
            }
        }
        StscState.addInfo(xmlErrorWatcher, "Processing " + i5 + " schema(s) in " + str);
    }

    public static boolean compile(Parameters parameters) {
        boolean z6;
        File file;
        File file2;
        File baseDir = parameters.getBaseDir();
        File[] xsdFiles = parameters.getXsdFiles();
        File[] wsdlFiles = parameters.getWsdlFiles();
        URL[] urlFiles = parameters.getUrlFiles();
        File[] javaFiles = parameters.getJavaFiles();
        File[] configFiles = parameters.getConfigFiles();
        File[] classpath = parameters.getClasspath();
        File outputJar = parameters.getOutputJar();
        String name = parameters.getName();
        File srcDir = parameters.getSrcDir();
        File classesDir = parameters.getClassesDir();
        String compiler = parameters.getCompiler();
        String memoryInitialSize = parameters.getMemoryInitialSize();
        String memoryMaximumSize = parameters.getMemoryMaximumSize();
        boolean zIsNojavac = parameters.isNojavac();
        boolean zIsDebug = parameters.isDebug();
        boolean zIsVerbose = parameters.isVerbose();
        boolean zIsQuiet = parameters.isQuiet();
        boolean zIsDownload = parameters.isDownload();
        boolean zIsNoUpa = parameters.isNoUpa();
        boolean zIsNoPvr = parameters.isNoPvr();
        boolean zIsNoAnn = parameters.isNoAnn();
        boolean zIsNoVDoc = parameters.isNoVDoc();
        boolean zIsNoExt = parameters.isNoExt();
        boolean zIsIncrementalSrcGen = parameters.isIncrementalSrcGen();
        File file3 = baseDir;
        boolean zIsCopyAnn = parameters.isCopyAnn();
        Collection<XmlError> errorListener = parameters.getErrorListener();
        Set<XmlOptions.BeanMethod> partialMethods = parameters.getPartialMethods();
        String repackage = parameters.getRepackage();
        if (repackage != null) {
            SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
            SchemaTypeSystemImpl.METADATA_PACKAGE_GEN = new Repackager(repackage).repackage(new StringBuffer(SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD)).toString();
            System.out.println("SchemaCompiler  Metadata LOAD:" + SchemaTypeLoaderImpl.METADATA_PACKAGE_LOAD + " GEN:" + SchemaTypeSystemImpl.METADATA_PACKAGE_GEN);
        }
        SchemaCodePrinter schemaCodePrinter = parameters.getSchemaCodePrinter();
        List<Extension> extensions = parameters.getExtensions();
        Set<String> mdefNamespaces = parameters.getMdefNamespaces();
        EntityResolver entityResolverResolverForCatalog = parameters.getEntityResolver() == null ? ResolverUtil.resolverForCatalog(parameters.getCatalogFile()) : parameters.getEntityResolver();
        if (srcDir == null || classesDir == null) {
            throw new IllegalArgumentException("src and class gen directories may not be null.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (file3 == null) {
            file3 = new File(SystemProperties.getProperty("user.dir"));
        }
        HashMap map = new HashMap();
        PathResourceLoader pathResourceLoader = classpath != null ? new PathResourceLoader(classpath) : null;
        StringBuilder sb = new StringBuilder();
        PathResourceLoader pathResourceLoader2 = pathResourceLoader;
        sb.append(SchemaTypeSystemImpl.METADATA_PACKAGE_GEN);
        sb.append("/src");
        File fileCreateDir = IOUtil.createDir(classesDir, sb.toString());
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(errorListener);
        SchemaTypeSystem schemaTypeSystemLoadTypeSystem = loadTypeSystem(name, xsdFiles, wsdlFiles, urlFiles, configFiles, javaFiles, pathResourceLoader2, zIsDownload, zIsNoUpa, zIsNoPvr, zIsNoAnn, zIsNoVDoc, zIsNoExt, mdefNamespaces, file3, map, xmlErrorWatcher, fileCreateDir, entityResolverResolverForCatalog, classpath);
        boolean zHasError = xmlErrorWatcher.hasError();
        boolean z7 = !zHasError;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!zIsQuiet) {
            System.out.println("Time to build schema type system: " + ((jCurrentTimeMillis2 - jCurrentTimeMillis) / 1000.0d) + " seconds");
        }
        if (zHasError || schemaTypeSystemLoadTypeSystem == null) {
            z6 = zIsQuiet;
            file = classesDir;
        } else {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            FilerImpl filerImpl = new FilerImpl(classesDir, srcDir, repackage == null ? null : new Repackager(repackage), zIsVerbose, zIsIncrementalSrcGen);
            XmlOptions xmlOptions = new XmlOptions();
            if (schemaCodePrinter != null) {
                xmlOptions.setSchemaCodePrinter(schemaCodePrinter);
            }
            xmlOptions.setCompilePartialMethod(partialMethods);
            xmlOptions.setCompileNoAnnotations(zIsNoAnn);
            xmlOptions.setCompileAnnotationAsJavadoc(zIsCopyAnn);
            schemaTypeSystemLoadTypeSystem.save(filerImpl);
            boolean zGenerateTypes = SchemaTypeSystemCompiler.generateTypes(schemaTypeSystemLoadTypeSystem, filerImpl, xmlOptions);
            if (zIsIncrementalSrcGen) {
                SchemaCodeGenerator.deleteObsoleteFiles(srcDir, srcDir, new HashSet(filerImpl.getSourceFiles()));
            }
            if (zGenerateTypes) {
                long jCurrentTimeMillis4 = System.currentTimeMillis();
                if (!zIsQuiet) {
                    System.out.println("Time to generate code: " + ((jCurrentTimeMillis4 - jCurrentTimeMillis3) / 1000.0d) + " seconds");
                }
            }
            if (!zGenerateTypes || zIsNojavac) {
                z6 = zIsQuiet;
                file = classesDir;
            } else {
                long jCurrentTimeMillis5 = System.currentTimeMillis();
                List<File> sourceFiles = filerImpl.getSourceFiles();
                if (javaFiles != null) {
                    sourceFiles.addAll(Arrays.asList(javaFiles));
                }
                z6 = zIsQuiet;
                file = classesDir;
                z7 = false;
                if (!CodeGenUtil.externalCompile(sourceFiles, file, classpath, zIsDebug, compiler, memoryInitialSize, memoryMaximumSize, z6, zIsVerbose)) {
                    zGenerateTypes = false;
                }
                long jCurrentTimeMillis6 = System.currentTimeMillis();
                if (zGenerateTypes && !parameters.isQuiet()) {
                    System.out.println("Time to compile code: " + ((jCurrentTimeMillis6 - jCurrentTimeMillis5) / 1000.0d) + " seconds");
                }
                if (zGenerateTypes && outputJar != null) {
                    try {
                        file2 = outputJar;
                        try {
                            new JarHelper().jarDir(file, file2);
                            z7 = zGenerateTypes;
                        } catch (IOException e) {
                            e = e;
                            System.err.println("IO Error " + e);
                        }
                    } catch (IOException e6) {
                        e = e6;
                        file2 = outputJar;
                    }
                    if (z7 && !parameters.isQuiet()) {
                        System.out.println("Compiled types to: " + file2);
                    }
                }
            }
            z7 = zGenerateTypes;
        }
        if (z7 || z6) {
            runExtensions(extensions, schemaTypeSystemLoadTypeSystem, file);
        } else {
            System.out.println("BUILD FAILED");
        }
        if (pathResourceLoader2 != null) {
            pathResourceLoader2.close();
        }
        return z7;
    }

    private static SchemaTypeSystem loadTypeSystem(String str, File[] fileArr, File[] fileArr2, URL[] urlArr, File[] fileArr3, File[] fileArr4, ResourceLoader resourceLoader, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, Set<String> set, File file, Map<String, String> map, Collection<XmlError> collection, File file2, EntityResolver entityResolver, File[] fileArr5) {
        int i5;
        int i6;
        int i7;
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
        try {
            StscState.start().setErrorListener(xmlErrorWatcher);
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            if (fileArr != null) {
                int length = fileArr.length;
                int i8 = 0;
                while (i8 < length) {
                    int i9 = i8;
                    File file3 = fileArr[i9];
                    try {
                        XmlOptions xmlOptions = new XmlOptions();
                        xmlOptions.setLoadLineNumbers();
                        xmlOptions.setLoadMessageDigest();
                        xmlOptions.setEntityResolver(entityResolver);
                        i7 = length;
                        try {
                            XmlObject xmlObject = schemaTypeLoaderTypeLoaderForClassLoader.parse(file3, (SchemaType) null, xmlOptions);
                            if (xmlObject instanceof SchemaDocument) {
                                addSchema(file3.toString(), (SchemaDocument) xmlObject, xmlErrorWatcher, z10, arrayList);
                            } else {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{file3, "schema"}, xmlObject);
                            }
                        } catch (XmlException e) {
                            e = e;
                            xmlErrorWatcher.add(e.getError());
                        } catch (Exception e6) {
                            e = e6;
                            StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"xsd", file3, e.getMessage()}, file3);
                        }
                    } catch (XmlException e7) {
                        e = e7;
                        i7 = length;
                    } catch (Exception e8) {
                        e = e8;
                        i7 = length;
                    }
                    i8 = i9 + 1;
                    length = i7;
                }
            }
            if (fileArr2 != null) {
                int length2 = fileArr2.length;
                int i10 = 0;
                while (i10 < length2) {
                    int i11 = i10;
                    File file4 = fileArr2[i11];
                    try {
                        XmlOptions xmlOptions2 = new XmlOptions();
                        xmlOptions2.setLoadLineNumbers();
                        i6 = length2;
                        try {
                            xmlOptions2.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                            xmlOptions2.setEntityResolver(entityResolver);
                            XmlObject xmlObject2 = schemaTypeLoaderTypeLoaderForClassLoader.parse(file4, (SchemaType) null, xmlOptions2);
                            if (xmlObject2 instanceof DefinitionsDocument) {
                                addWsdlSchemas(file4.toString(), (DefinitionsDocument) xmlObject2, xmlErrorWatcher, z10, arrayList);
                            } else {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{file4, "wsdl"}, xmlObject2);
                            }
                        } catch (XmlException e9) {
                            e = e9;
                            xmlErrorWatcher.add(e.getError());
                        } catch (Exception e10) {
                            e = e10;
                            StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"wsdl", file4, e.getMessage()}, file4);
                        }
                    } catch (XmlException e11) {
                        e = e11;
                        i6 = length2;
                    } catch (Exception e12) {
                        e = e12;
                        i6 = length2;
                    }
                    i10 = i11 + 1;
                    length2 = i6;
                }
            }
            if (urlArr != null) {
                int length3 = urlArr.length;
                int i12 = 0;
                while (i12 < length3) {
                    URL url = urlArr[i12];
                    try {
                        XmlOptions xmlOptions3 = new XmlOptions();
                        xmlOptions3.setLoadLineNumbers();
                        i5 = length3;
                        try {
                            xmlOptions3.setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
                            xmlOptions3.setEntityResolver(entityResolver);
                            XmlObject xmlObject3 = schemaTypeLoaderTypeLoaderForClassLoader.parse(url, (SchemaType) null, xmlOptions3);
                            if (xmlObject3 instanceof DefinitionsDocument) {
                                addWsdlSchemas(url.toString(), (DefinitionsDocument) xmlObject3, xmlErrorWatcher, z10, arrayList);
                            } else if (xmlObject3 instanceof SchemaDocument) {
                                addSchema(url.toString(), (SchemaDocument) xmlObject3, xmlErrorWatcher, z10, arrayList);
                            } else {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{url, "wsdl or schema"}, xmlObject3);
                            }
                        } catch (XmlException e13) {
                            e = e13;
                            xmlErrorWatcher.add(e.getError());
                        } catch (Exception e14) {
                            e = e14;
                            StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"url", url, e.getMessage()}, url);
                        }
                    } catch (XmlException e15) {
                        e = e15;
                        i5 = length3;
                    } catch (Exception e16) {
                        e = e16;
                        i5 = length3;
                    }
                    i12++;
                    length3 = i5;
                }
            }
            SchemaDocument.Schema[] schemaArr = (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[0]);
            ArrayList arrayList2 = new ArrayList();
            if (fileArr3 != null) {
                if (z11) {
                    System.out.println("Pre/Post and Interface extensions will be ignored.");
                }
                for (File file5 : fileArr3) {
                    try {
                        try {
                            XmlOptions xmlOptions4 = new XmlOptions();
                            xmlOptions4.setLoadLineNumbers();
                            xmlOptions4.setEntityResolver(entityResolver);
                            xmlOptions4.setLoadSubstituteNamespaces(MAP_COMPATIBILITY_CONFIG_URIS);
                            XmlObject xmlObject4 = schemaTypeLoaderTypeLoaderForClassLoader.parse(file5, (SchemaType) null, xmlOptions4);
                            if (xmlObject4 instanceof ConfigDocument) {
                                StscState.addInfo(xmlErrorWatcher, "Loading config file " + file5);
                                if (xmlObject4.validate(new XmlOptions().setErrorListener(xmlErrorWatcher))) {
                                    ConfigDocument.Config config = ((ConfigDocument) xmlObject4).getConfig();
                                    arrayList2.add(config);
                                    if (z11) {
                                        config.setExtensionArray(new Extensionconfig[0]);
                                    }
                                }
                            } else {
                                StscState.addError(xmlErrorWatcher, XmlErrorCodes.INVALID_DOCUMENT_TYPE, new Object[]{file5, "xsd config"}, xmlObject4);
                            }
                        } catch (XmlException e17) {
                            xmlErrorWatcher.add(e17.getError());
                        }
                    } catch (Exception e18) {
                        StscState.addError(xmlErrorWatcher, XmlErrorCodes.CANNOT_LOAD_FILE, new Object[]{"xsd config", file5, e18.getMessage()}, file5);
                    }
                }
            }
            ConfigDocument.Config[] configArr = (ConfigDocument.Config[]) arrayList2.toArray(new ConfigDocument.Config[0]);
            SchemaTypeLoader schemaTypeLoaderBuild = SchemaTypeLoaderImpl.build(null, resourceLoader, null);
            URI uri = file != null ? file.toURI() : null;
            XmlOptions xmlOptions5 = new XmlOptions();
            if (z6) {
                xmlOptions5.setCompileDownloadUrls();
            }
            if (z7) {
                xmlOptions5.setCompileNoUpaRule();
            }
            if (z8) {
                xmlOptions5.setCompileNoPvrRule();
            }
            if (z9) {
                xmlOptions5.setCompileNoAnnotations();
            }
            if (set != null) {
                xmlOptions5.setCompileMdefNamespaces(set);
            }
            xmlOptions5.setCompileNoValidation();
            xmlOptions5.setEntityResolver(entityResolver);
            SchemaTypeSystemCompiler.Parameters parameters = new SchemaTypeSystemCompiler.Parameters();
            parameters.setName(str);
            parameters.setSchemas(schemaArr);
            parameters.setConfig(BindingConfigImpl.forConfigDocuments(configArr, fileArr4, fileArr5));
            parameters.setLinkTo(schemaTypeLoaderBuild);
            parameters.setOptions(xmlOptions5);
            parameters.setErrorListener(xmlErrorWatcher);
            parameters.setJavaize(true);
            parameters.setBaseURI(uri);
            parameters.setSourcesToCopyMap(map);
            parameters.setSchemasDir(file2);
            SchemaTypeSystem schemaTypeSystemCompile = SchemaTypeSystemCompiler.compile(parameters);
            StscState.end();
            return schemaTypeSystemCompile;
        } catch (Throwable th) {
            StscState.end();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0281  */
    /* JADX WARN: Code duplicated, block: B:114:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:116:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:118:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:122:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:124:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:128:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:130:0x02f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x02fd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:143:0x032c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:146:0x0333  */
    /* JADX WARN: Code duplicated, block: B:148:0x0337  */
    /* JADX WARN: Code duplicated, block: B:149:0x033d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0340  */
    /* JADX WARN: Code duplicated, block: B:152:0x0345  */
    /* JADX WARN: Code duplicated, block: B:154:0x0349  */
    /* JADX WARN: Code duplicated, block: B:155:0x0350  */
    /* JADX WARN: Code duplicated, block: B:158:0x035a  */
    /* JADX WARN: Code duplicated, block: B:160:0x036f A[LOOP:2: B:159:0x036d->B:160:0x036f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:162:0x038c  */
    /* JADX WARN: Code duplicated, block: B:165:0x03a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:167:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:170:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:171:0x0400  */
    /* JADX WARN: Code duplicated, block: B:174:0x0408  */
    /* JADX WARN: Code duplicated, block: B:176:0x040c  */
    /* JADX WARN: Code duplicated, block: B:179:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:181:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:197:0x0305 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void main(String[] strArr) {
        SchemaCodePrinter schemaCodePrinter;
        Set<String> set;
        String str;
        boolean z6;
        boolean z7;
        String opt;
        File file;
        String opt2;
        File file2;
        File fileCreateTempDir;
        String str2;
        File file3;
        File fileCreateDir;
        File fileCreateDir2;
        String opt3;
        File[] fileArrSystemClasspath;
        File[] fileArrFilesEndingWith;
        File[] fileArrFilesEndingWith2;
        URL[] uRLs;
        File baseDir;
        URI uri;
        boolean zCompile;
        String[] strArrSplit;
        ArrayList arrayList;
        int length;
        int i5;
        Extension extension;
        StringTokenizer stringTokenizer;
        int iIndexOf;
        if (strArr.length == 0) {
            printUsage();
            System.exit(0);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add("h");
        hashSet.add("help");
        hashSet.add("usage");
        hashSet.add("license");
        hashSet.add("quiet");
        hashSet.add("verbose");
        hashSet.add("version");
        hashSet.add("dl");
        hashSet.add("noupa");
        hashSet.add("nopvr");
        hashSet.add("noann");
        hashSet.add("novdoc");
        hashSet.add("noext");
        hashSet.add("srconly");
        hashSet.add("debug");
        HashSet hashSet2 = new HashSet();
        hashSet2.add("out");
        hashSet2.add("name");
        hashSet2.add("src");
        hashSet2.add("d");
        hashSet2.add("cp");
        hashSet2.add("compiler");
        hashSet2.add(ArchiveStreamFactory.JAR);
        hashSet2.add("ms");
        hashSet2.add("mx");
        hashSet2.add("repackage");
        hashSet2.add("schemaCodePrinter");
        hashSet2.add("extension");
        hashSet2.add("extensionParms");
        hashSet2.add("allowmdef");
        hashSet2.add("catalog");
        hashSet2.add("partialMethods");
        hashSet2.add("copyann");
        CommandLine commandLine = new CommandLine(strArr, hashSet, hashSet2);
        if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
            printUsage();
            System.exit(0);
            return;
        }
        String[] badOpts = commandLine.getBadOpts();
        if (badOpts.length > 0) {
            for (String str3 : badOpts) {
                System.out.println("Unrecognized option: " + str3);
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
        boolean z8 = commandLine.getOpt("verbose") != null;
        boolean z9 = z8 ? false : commandLine.getOpt("quiet") != null;
        if (z8) {
            CommandLine.printVersion();
        }
        String opt4 = commandLine.getOpt("out");
        String opt5 = commandLine.getOpt("repackage");
        String opt6 = commandLine.getOpt("schemaCodePrinter");
        if (opt6 != null) {
            try {
                schemaCodePrinter = (SchemaCodePrinter) Class.forName(opt6).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception unused) {
                System.err.println("Failed to load SchemaCodePrinter class " + opt6 + "; proceeding with default printer");
                schemaCodePrinter = null;
            }
        } else {
            schemaCodePrinter = null;
        }
        String opt7 = commandLine.getOpt("name");
        boolean z10 = commandLine.getOpt("dl") != null;
        boolean z11 = commandLine.getOpt("noupa") != null;
        boolean z12 = commandLine.getOpt("nopvr") != null;
        boolean z13 = commandLine.getOpt("noann") != null;
        boolean z14 = commandLine.getOpt("novdoc") != null;
        boolean z15 = commandLine.getOpt("noext") != null;
        boolean z16 = commandLine.getOpt("srconly") != null;
        boolean z17 = commandLine.getOpt("debug") != null;
        boolean z18 = commandLine.getOpt("copyann") != null;
        String opt8 = commandLine.getOpt("allowmdef");
        Set<String> hashSet3 = opt8 == null ? Collections.EMPTY_SET : new HashSet(Arrays.asList(XmlListImpl.split_list(opt8)));
        ArrayList arrayList2 = new ArrayList();
        if (commandLine.getOpt("extension") != null) {
            set = hashSet3;
            try {
                Extension extension2 = new Extension();
                str = opt5;
                try {
                    z6 = z17;
                    try {
                        z7 = z15;
                        try {
                            extension2.setClassName(Class.forName(commandLine.getOpt("extension"), false, Thread.currentThread().getContextClassLoader()));
                            arrayList2.add(extension2);
                        } catch (ClassNotFoundException unused2) {
                            System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                            System.exit(1);
                        }
                    } catch (ClassNotFoundException unused3) {
                        z7 = z15;
                        System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                        System.exit(1);
                        if (arrayList2.size() > 0) {
                            extension = (Extension) arrayList2.get(0);
                            stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";");
                            while (stringTokenizer.hasMoreTokens()) {
                                String strNextToken = stringTokenizer.nextToken();
                                iIndexOf = strNextToken.indexOf(61);
                                if (iIndexOf < 0) {
                                    System.err.println("extensionParms should be name=value;name=value");
                                    System.exit(1);
                                }
                                String strSubstring = strNextToken.substring(0, iIndexOf);
                                String strSubstring2 = strNextToken.substring(iIndexOf + 1);
                                Extension.Param paramCreateParam = extension.createParam();
                                paramCreateParam.setName(strSubstring);
                                paramCreateParam.setValue(strSubstring2);
                                extension = extension;
                            }
                        }
                        opt = commandLine.getOpt("d");
                        if (opt != null) {
                            file = new File(opt);
                        } else {
                            file = null;
                        }
                        opt2 = commandLine.getOpt("src");
                        if (opt2 != null) {
                            file2 = new File(opt2);
                        } else {
                            file2 = null;
                        }
                        if (z16) {
                            file2 = file;
                        }
                        if (file2 != null) {
                            try {
                                fileCreateTempDir = SchemaCodeGenerator.createTempDir();
                                file = file;
                                file2 = file2;
                            } catch (IOException e) {
                                System.err.println("Error creating temp dir " + e);
                                System.exit(1);
                                fileCreateTempDir = null;
                            }
                        } else {
                            fileCreateTempDir = SchemaCodeGenerator.createTempDir();
                            file = file;
                            file2 = file2;
                        }
                        if (opt4 == null) {
                            str2 = opt4;
                        } else {
                            str2 = opt4;
                        }
                        if (str2 != null) {
                            file3 = new File(str2);
                        } else {
                            file3 = null;
                        }
                        if (file2 == null) {
                            fileCreateDir = IOUtil.createDir(fileCreateTempDir, "src");
                        } else {
                            fileCreateDir = file2;
                        }
                        if (file == null) {
                            fileCreateDir2 = IOUtil.createDir(fileCreateTempDir, "classes");
                        } else {
                            fileCreateDir2 = file;
                        }
                        opt3 = commandLine.getOpt("cp");
                        if (opt3 != null) {
                            strArrSplit = opt3.split(File.pathSeparator);
                            arrayList = new ArrayList();
                            i5 = 0;
                            for (length = strArrSplit.length; i5 < length; length = length) {
                                int i6 = i5;
                                arrayList.add(new File(strArrSplit[i6]));
                                i5 = i6 + 1;
                            }
                            fileArrSystemClasspath = (File[]) arrayList.toArray(new File[0]);
                        } else {
                            fileArrSystemClasspath = CodeGenUtil.systemClasspath();
                        }
                        String opt9 = commandLine.getOpt("compiler");
                        String opt10 = commandLine.getOpt(ArchiveStreamFactory.JAR);
                        if (!z8) {
                        }
                        String opt11 = commandLine.getOpt("ms");
                        String opt12 = commandLine.getOpt("mx");
                        boolean z19 = z13;
                        fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
                        boolean z20 = z12;
                        fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
                        boolean z21 = z11;
                        File[] fileArrFilesEndingWith3 = commandLine.filesEndingWith(".java");
                        boolean z22 = z10;
                        File[] fileArrFilesEndingWith4 = commandLine.filesEndingWith(".xsdconfig");
                        boolean z23 = z9;
                        uRLs = commandLine.getURLs();
                        boolean z24 = z16;
                        if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
                            System.out.println("Could not find any xsd or wsdl files to process.");
                            System.exit(0);
                        }
                        baseDir = commandLine.getBaseDir();
                        if (baseDir == null) {
                            uri = null;
                        } else {
                            uri = baseDir.toURI();
                        }
                        XmlErrorPrinter xmlErrorPrinter = new XmlErrorPrinter(z8, uri);
                        String opt13 = commandLine.getOpt("catalog");
                        String opt14 = commandLine.getOpt("partialMethods");
                        Parameters parameters = new Parameters();
                        parameters.setBaseDir(baseDir);
                        parameters.setXsdFiles(fileArrFilesEndingWith);
                        parameters.setWsdlFiles(fileArrFilesEndingWith2);
                        parameters.setJavaFiles(fileArrFilesEndingWith3);
                        parameters.setConfigFiles(fileArrFilesEndingWith4);
                        parameters.setUrlFiles(uRLs);
                        parameters.setClasspath(fileArrSystemClasspath);
                        parameters.setOutputJar(file3);
                        parameters.setName(opt7);
                        parameters.setSrcDir(fileCreateDir);
                        parameters.setClassesDir(fileCreateDir2);
                        parameters.setCompiler(opt9);
                        parameters.setMemoryInitialSize(opt11);
                        parameters.setMemoryMaximumSize(opt12);
                        parameters.setNojavac(z24);
                        parameters.setQuiet(z23);
                        parameters.setVerbose(z8);
                        parameters.setDownload(z22);
                        parameters.setNoUpa(z21);
                        parameters.setNoPvr(z20);
                        parameters.setNoAnn(z19);
                        parameters.setNoVDoc(z14);
                        parameters.setNoExt(z7);
                        parameters.setDebug(z6);
                        parameters.setErrorListener(xmlErrorPrinter);
                        parameters.setRepackage(str);
                        parameters.setExtensions(arrayList2);
                        parameters.setMdefNamespaces(set);
                        parameters.setCatalogFile(opt13);
                        parameters.setSchemaCodePrinter(schemaCodePrinter);
                        parameters.setPartialMethods(parsePartialMethods(opt14));
                        parameters.setCopyAnn(z18);
                        zCompile = compile(parameters);
                        if (fileCreateTempDir != 0) {
                            SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
                        }
                        if (!zCompile) {
                            System.exit(1);
                        }
                        System.exit(0);
                    }
                } catch (ClassNotFoundException unused4) {
                    z6 = z17;
                    z7 = z15;
                    System.err.println("Could not find extension class: " + commandLine.getOpt("extension") + "  Is it on your classpath?");
                    System.exit(1);
                    if (arrayList2.size() > 0) {
                        extension = (Extension) arrayList2.get(0);
                        stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";");
                        while (stringTokenizer.hasMoreTokens()) {
                            String strNextToken2 = stringTokenizer.nextToken();
                            iIndexOf = strNextToken2.indexOf(61);
                            if (iIndexOf < 0) {
                                System.err.println("extensionParms should be name=value;name=value");
                                System.exit(1);
                            }
                            String strSubstring3 = strNextToken2.substring(0, iIndexOf);
                            String strSubstring4 = strNextToken2.substring(iIndexOf + 1);
                            Extension.Param paramCreateParam2 = extension.createParam();
                            paramCreateParam2.setName(strSubstring3);
                            paramCreateParam2.setValue(strSubstring4);
                            extension = extension;
                        }
                    }
                    opt = commandLine.getOpt("d");
                    if (opt != null) {
                        file = new File(opt);
                    } else {
                        file = null;
                    }
                    opt2 = commandLine.getOpt("src");
                    if (opt2 != null) {
                        file2 = new File(opt2);
                    } else {
                        file2 = null;
                    }
                    if (z16) {
                        file2 = file;
                    }
                    if (file2 != null) {
                        fileCreateTempDir = SchemaCodeGenerator.createTempDir();
                        file = file;
                        file2 = file2;
                    } else {
                        fileCreateTempDir = SchemaCodeGenerator.createTempDir();
                        file = file;
                        file2 = file2;
                    }
                    if (opt4 == null) {
                        str2 = opt4;
                    } else {
                        str2 = opt4;
                    }
                    if (str2 != null) {
                        file3 = new File(str2);
                    } else {
                        file3 = null;
                    }
                    if (file2 == null) {
                        fileCreateDir = IOUtil.createDir(fileCreateTempDir, "src");
                    } else {
                        fileCreateDir = file2;
                    }
                    if (file == null) {
                        fileCreateDir2 = IOUtil.createDir(fileCreateTempDir, "classes");
                    } else {
                        fileCreateDir2 = file;
                    }
                    opt3 = commandLine.getOpt("cp");
                    if (opt3 != null) {
                        strArrSplit = opt3.split(File.pathSeparator);
                        arrayList = new ArrayList();
                        i5 = 0;
                        while (i5 < length) {
                            int i7 = i5;
                            arrayList.add(new File(strArrSplit[i7]));
                            i5 = i7 + 1;
                        }
                        fileArrSystemClasspath = (File[]) arrayList.toArray(new File[0]);
                    } else {
                        fileArrSystemClasspath = CodeGenUtil.systemClasspath();
                    }
                    String opt15 = commandLine.getOpt("compiler");
                    String opt16 = commandLine.getOpt(ArchiveStreamFactory.JAR);
                    if (!z8) {
                    }
                    String opt17 = commandLine.getOpt("ms");
                    String opt18 = commandLine.getOpt("mx");
                    boolean z110 = z13;
                    fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
                    boolean z25 = z12;
                    fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
                    boolean z26 = z11;
                    File[] fileArrFilesEndingWith5 = commandLine.filesEndingWith(".java");
                    boolean z27 = z10;
                    File[] fileArrFilesEndingWith6 = commandLine.filesEndingWith(".xsdconfig");
                    boolean z28 = z9;
                    uRLs = commandLine.getURLs();
                    boolean z29 = z16;
                    if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
                        System.out.println("Could not find any xsd or wsdl files to process.");
                        System.exit(0);
                    }
                    baseDir = commandLine.getBaseDir();
                    if (baseDir == null) {
                        uri = null;
                    } else {
                        uri = baseDir.toURI();
                    }
                    XmlErrorPrinter xmlErrorPrinter2 = new XmlErrorPrinter(z8, uri);
                    String opt19 = commandLine.getOpt("catalog");
                    String opt110 = commandLine.getOpt("partialMethods");
                    Parameters parameters2 = new Parameters();
                    parameters2.setBaseDir(baseDir);
                    parameters2.setXsdFiles(fileArrFilesEndingWith);
                    parameters2.setWsdlFiles(fileArrFilesEndingWith2);
                    parameters2.setJavaFiles(fileArrFilesEndingWith5);
                    parameters2.setConfigFiles(fileArrFilesEndingWith6);
                    parameters2.setUrlFiles(uRLs);
                    parameters2.setClasspath(fileArrSystemClasspath);
                    parameters2.setOutputJar(file3);
                    parameters2.setName(opt7);
                    parameters2.setSrcDir(fileCreateDir);
                    parameters2.setClassesDir(fileCreateDir2);
                    parameters2.setCompiler(opt15);
                    parameters2.setMemoryInitialSize(opt17);
                    parameters2.setMemoryMaximumSize(opt18);
                    parameters2.setNojavac(z29);
                    parameters2.setQuiet(z28);
                    parameters2.setVerbose(z8);
                    parameters2.setDownload(z27);
                    parameters2.setNoUpa(z26);
                    parameters2.setNoPvr(z25);
                    parameters2.setNoAnn(z110);
                    parameters2.setNoVDoc(z14);
                    parameters2.setNoExt(z7);
                    parameters2.setDebug(z6);
                    parameters2.setErrorListener(xmlErrorPrinter2);
                    parameters2.setRepackage(str);
                    parameters2.setExtensions(arrayList2);
                    parameters2.setMdefNamespaces(set);
                    parameters2.setCatalogFile(opt19);
                    parameters2.setSchemaCodePrinter(schemaCodePrinter);
                    parameters2.setPartialMethods(parsePartialMethods(opt110));
                    parameters2.setCopyAnn(z18);
                    zCompile = compile(parameters2);
                    if (fileCreateTempDir != 0) {
                        SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
                    }
                    if (!zCompile) {
                        System.exit(1);
                    }
                    System.exit(0);
                }
            } catch (ClassNotFoundException unused5) {
                str = opt5;
            }
        } else {
            set = hashSet3;
            str = opt5;
            z6 = z17;
            z7 = z15;
        }
        if (arrayList2.size() > 0 && commandLine.getOpt("extensionParms") != null) {
            extension = (Extension) arrayList2.get(0);
            stringTokenizer = new StringTokenizer(commandLine.getOpt("extensionParms"), ";");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken3 = stringTokenizer.nextToken();
                iIndexOf = strNextToken3.indexOf(61);
                if (iIndexOf < 0) {
                    System.err.println("extensionParms should be name=value;name=value");
                    System.exit(1);
                }
                String strSubstring5 = strNextToken3.substring(0, iIndexOf);
                String strSubstring6 = strNextToken3.substring(iIndexOf + 1);
                Extension.Param paramCreateParam3 = extension.createParam();
                paramCreateParam3.setName(strSubstring5);
                paramCreateParam3.setValue(strSubstring6);
                extension = extension;
            }
        }
        opt = commandLine.getOpt("d");
        if (opt != null) {
            file = new File(opt);
        } else {
            file = null;
        }
        opt2 = commandLine.getOpt("src");
        if (opt2 != null) {
            file2 = new File(opt2);
        } else {
            file2 = null;
        }
        if (z16 && opt2 == null && file != null) {
            file2 = file;
        }
        if (file2 != null || file == null) {
            fileCreateTempDir = SchemaCodeGenerator.createTempDir();
            file = file;
            file2 = file2;
            if (opt4 == null || file != null || z16) {
                str2 = opt4;
            } else {
                str2 = "xmltypes.jar";
            }
            if (str2 != null) {
                file3 = new File(str2);
            } else {
                file3 = null;
            }
            if (file2 == null) {
                fileCreateDir = IOUtil.createDir(fileCreateTempDir, "src");
            } else {
                fileCreateDir = file2;
            }
            if (file == null) {
                fileCreateDir2 = IOUtil.createDir(fileCreateTempDir, "classes");
            } else {
                fileCreateDir2 = file;
            }
            opt3 = commandLine.getOpt("cp");
            if (opt3 != null) {
                strArrSplit = opt3.split(File.pathSeparator);
                arrayList = new ArrayList();
                i5 = 0;
                while (i5 < length) {
                    int i8 = i5;
                    arrayList.add(new File(strArrSplit[i8]));
                    i5 = i8 + 1;
                }
                fileArrSystemClasspath = (File[]) arrayList.toArray(new File[0]);
            } else {
                fileArrSystemClasspath = CodeGenUtil.systemClasspath();
            }
            String opt111 = commandLine.getOpt("compiler");
            String opt112 = commandLine.getOpt(ArchiveStreamFactory.JAR);
            if (!z8 && opt112 != null) {
                System.out.println("The 'jar' option is no longer supported.");
            }
            String opt113 = commandLine.getOpt("ms");
            String opt114 = commandLine.getOpt("mx");
            boolean z111 = z13;
            fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
            boolean z210 = z12;
            fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
            boolean z211 = z11;
            File[] fileArrFilesEndingWith7 = commandLine.filesEndingWith(".java");
            boolean z212 = z10;
            File[] fileArrFilesEndingWith8 = commandLine.filesEndingWith(".xsdconfig");
            boolean z213 = z9;
            uRLs = commandLine.getURLs();
            boolean z214 = z16;
            if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
                System.out.println("Could not find any xsd or wsdl files to process.");
                System.exit(0);
            }
            baseDir = commandLine.getBaseDir();
            if (baseDir == null) {
                uri = null;
            } else {
                uri = baseDir.toURI();
            }
            XmlErrorPrinter xmlErrorPrinter3 = new XmlErrorPrinter(z8, uri);
            String opt115 = commandLine.getOpt("catalog");
            String opt116 = commandLine.getOpt("partialMethods");
            Parameters parameters3 = new Parameters();
            parameters3.setBaseDir(baseDir);
            parameters3.setXsdFiles(fileArrFilesEndingWith);
            parameters3.setWsdlFiles(fileArrFilesEndingWith2);
            parameters3.setJavaFiles(fileArrFilesEndingWith7);
            parameters3.setConfigFiles(fileArrFilesEndingWith8);
            parameters3.setUrlFiles(uRLs);
            parameters3.setClasspath(fileArrSystemClasspath);
            parameters3.setOutputJar(file3);
            parameters3.setName(opt7);
            parameters3.setSrcDir(fileCreateDir);
            parameters3.setClassesDir(fileCreateDir2);
            parameters3.setCompiler(opt111);
            parameters3.setMemoryInitialSize(opt113);
            parameters3.setMemoryMaximumSize(opt114);
            parameters3.setNojavac(z214);
            parameters3.setQuiet(z213);
            parameters3.setVerbose(z8);
            parameters3.setDownload(z212);
            parameters3.setNoUpa(z211);
            parameters3.setNoPvr(z210);
            parameters3.setNoAnn(z111);
            parameters3.setNoVDoc(z14);
            parameters3.setNoExt(z7);
            parameters3.setDebug(z6);
            parameters3.setErrorListener(xmlErrorPrinter3);
            parameters3.setRepackage(str);
            parameters3.setExtensions(arrayList2);
            parameters3.setMdefNamespaces(set);
            parameters3.setCatalogFile(opt115);
            parameters3.setSchemaCodePrinter(schemaCodePrinter);
            parameters3.setPartialMethods(parsePartialMethods(opt116));
            parameters3.setCopyAnn(z18);
            zCompile = compile(parameters3);
            if (fileCreateTempDir != 0) {
                SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
            }
            if (!zCompile) {
                System.exit(1);
            }
            System.exit(0);
        }
        fileCreateTempDir = null;
        if (opt4 == null) {
            str2 = opt4;
        } else {
            str2 = opt4;
        }
        if (str2 != null) {
            file3 = new File(str2);
        } else {
            file3 = null;
        }
        if (file2 == null) {
            fileCreateDir = IOUtil.createDir(fileCreateTempDir, "src");
        } else {
            fileCreateDir = file2;
        }
        if (file == null) {
            fileCreateDir2 = IOUtil.createDir(fileCreateTempDir, "classes");
        } else {
            fileCreateDir2 = file;
        }
        opt3 = commandLine.getOpt("cp");
        if (opt3 != null) {
            strArrSplit = opt3.split(File.pathSeparator);
            arrayList = new ArrayList();
            i5 = 0;
            while (i5 < length) {
                int i9 = i5;
                arrayList.add(new File(strArrSplit[i9]));
                i5 = i9 + 1;
            }
            fileArrSystemClasspath = (File[]) arrayList.toArray(new File[0]);
        } else {
            fileArrSystemClasspath = CodeGenUtil.systemClasspath();
        }
        String opt117 = commandLine.getOpt("compiler");
        String opt118 = commandLine.getOpt(ArchiveStreamFactory.JAR);
        if (!z8) {
        }
        String opt119 = commandLine.getOpt("ms");
        String opt1110 = commandLine.getOpt("mx");
        boolean z112 = z13;
        fileArrFilesEndingWith = commandLine.filesEndingWith(".xsd");
        boolean z215 = z12;
        fileArrFilesEndingWith2 = commandLine.filesEndingWith(".wsdl");
        boolean z216 = z11;
        File[] fileArrFilesEndingWith9 = commandLine.filesEndingWith(".java");
        boolean z217 = z10;
        File[] fileArrFilesEndingWith10 = commandLine.filesEndingWith(".xsdconfig");
        boolean z218 = z9;
        uRLs = commandLine.getURLs();
        boolean z219 = z16;
        if (fileArrFilesEndingWith.length + fileArrFilesEndingWith2.length + uRLs.length == 0) {
            System.out.println("Could not find any xsd or wsdl files to process.");
            System.exit(0);
        }
        baseDir = commandLine.getBaseDir();
        if (baseDir == null) {
            uri = null;
        } else {
            uri = baseDir.toURI();
        }
        XmlErrorPrinter xmlErrorPrinter4 = new XmlErrorPrinter(z8, uri);
        String opt1111 = commandLine.getOpt("catalog");
        String opt1112 = commandLine.getOpt("partialMethods");
        Parameters parameters4 = new Parameters();
        parameters4.setBaseDir(baseDir);
        parameters4.setXsdFiles(fileArrFilesEndingWith);
        parameters4.setWsdlFiles(fileArrFilesEndingWith2);
        parameters4.setJavaFiles(fileArrFilesEndingWith9);
        parameters4.setConfigFiles(fileArrFilesEndingWith10);
        parameters4.setUrlFiles(uRLs);
        parameters4.setClasspath(fileArrSystemClasspath);
        parameters4.setOutputJar(file3);
        parameters4.setName(opt7);
        parameters4.setSrcDir(fileCreateDir);
        parameters4.setClassesDir(fileCreateDir2);
        parameters4.setCompiler(opt117);
        parameters4.setMemoryInitialSize(opt119);
        parameters4.setMemoryMaximumSize(opt1110);
        parameters4.setNojavac(z219);
        parameters4.setQuiet(z218);
        parameters4.setVerbose(z8);
        parameters4.setDownload(z217);
        parameters4.setNoUpa(z216);
        parameters4.setNoPvr(z215);
        parameters4.setNoAnn(z112);
        parameters4.setNoVDoc(z14);
        parameters4.setNoExt(z7);
        parameters4.setDebug(z6);
        parameters4.setErrorListener(xmlErrorPrinter4);
        parameters4.setRepackage(str);
        parameters4.setExtensions(arrayList2);
        parameters4.setMdefNamespaces(set);
        parameters4.setCatalogFile(opt1111);
        parameters4.setSchemaCodePrinter(schemaCodePrinter);
        parameters4.setPartialMethods(parsePartialMethods(opt1112));
        parameters4.setCopyAnn(z18);
        zCompile = compile(parameters4);
        if (fileCreateTempDir != 0) {
            SchemaCodeGenerator.tryHardToDelete(fileCreateTempDir);
        }
        if (!zCompile) {
            System.exit(1);
        }
        System.exit(0);
    }

    public static Set<XmlOptions.BeanMethod> parsePartialMethods(String str) {
        HashSet hashSet = new HashSet();
        if (str != null) {
            for (String str2 : str.split(",")) {
                if (Rule.ALL.equals(str2)) {
                    hashSet.addAll(Arrays.asList(XmlOptions.BeanMethod.values()));
                } else {
                    boolean zStartsWith = str2.startsWith(ProcessIdUtil.DEFAULT_PROCESSID);
                    XmlOptions.BeanMethod beanMethodValueOf = XmlOptions.BeanMethod.valueOf(str2.substring(zStartsWith ? 1 : 0));
                    if (zStartsWith) {
                        hashSet.remove(beanMethodValueOf);
                    } else {
                        hashSet.add(beanMethodValueOf);
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            return null;
        }
        return hashSet;
    }

    public static void printUsage() {
        System.out.println("Compiles a schema into XML Bean classes and metadata.");
        System.out.println("Usage: scomp [opts] [dirs]* [schema.xsd]* [service.wsdl]* [config.xsdconfig]*");
        System.out.println("Options include:");
        System.out.println("    -cp [a;b;c] - classpath");
        System.out.println("    -d [dir] - target binary directory for .class and .xsb files");
        System.out.println("    -src [dir] - target directory for generated .java files");
        System.out.println("    -srconly - do not compile .java files or jar the output.");
        System.out.println("    -out [xmltypes.jar] - the name of the output jar");
        System.out.println("    -name - the name of the schema type - defaults to autogenerated name");
        System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
        System.out.println("    -noupa - do not enforce the unique particle attribution rule");
        System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
        System.out.println("    -noann - ignore annotations");
        System.out.println("    -novdoc - do not validate contents of <documentation>");
        System.out.println("    -noext - ignore all extension (Pre/Post and Interface) found in .xsdconfig files");
        System.out.println("    -compiler - path to external java compiler");
        System.out.println("    -ms - initial memory for external java compiler (default '8m')");
        System.out.println("    -mx - maximum memory for external java compiler (default '256m')");
        System.out.println("    -debug - compile with debug symbols");
        System.out.println("    -quiet - print fewer informational messages");
        System.out.println("    -verbose - print more informational messages");
        System.out.println("    -version - prints version information");
        System.out.println("    -license - prints license information");
        System.out.println("    -allowmdef \"[ns] [ns] [ns]\" - ignores multiple defs in given namespaces (use ##local for no-namespace)");
        System.out.println("    -catalog [file] -  catalog file for org.apache.xml.resolver.tools.CatalogResolver. (Note: needs resolver.jar from http://xml.apache.org/commons/components/resolver/index.html)");
        System.out.println("    -partialMethods [list] -  comma separated list of bean methods to be generated. Use \"-\" to negate and \"ALL\" for all.");
        System.out.println("                              processed left-to-right, e.g. \"ALL,-GET_LIST\" exclude java.util.List getters - see XmlOptions.BeanMethod");
        System.out.println("    -repackage - repackage specification, e.g. \"org.apache.xmlbeans.metadata:mypackage.metadata\" to change the metadata directory");
        System.out.println("    -copyann - copy schema annotations to javadoc (default false) - don't activate on untrusted schema sources!");
        System.out.println();
    }

    private static void runExtensions(List<Extension> list, SchemaTypeSystem schemaTypeSystem, File file) {
        String absolutePath;
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            absolutePath = file.getCanonicalPath();
        } catch (IOException unused) {
            System.out.println("WARNING: Unable to get the path for schema jar file");
            absolutePath = file.getAbsolutePath();
        }
        for (Extension extension : list) {
            try {
                SchemaCompilerExtension schemaCompilerExtension = (SchemaCompilerExtension) extension.getClassName().getDeclaredConstructor(null).newInstance(null);
                System.out.println("Running Extension: " + schemaCompilerExtension.getExtensionName());
                HashMap map = new HashMap();
                for (Extension.Param param : extension.getParams()) {
                    map.put(param.getName(), param.getValue());
                }
                map.put("classesDir", absolutePath);
                schemaCompilerExtension.schemaCompilerExtension(schemaTypeSystem, map);
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                System.out.println("ILLEGAL ACCESS Exception when attempting to instantiate schema compiler extension: ".concat(extension.getClassName().getName()));
                System.out.println("EXTENSION Class was not run");
                return;
            } catch (InstantiationException | NoSuchMethodException unused3) {
                System.out.println("UNABLE to instantiate schema compiler extension:".concat(extension.getClassName().getName()));
                System.out.println("EXTENSION Class was not run");
                return;
            }
        }
    }

    private static boolean wsdlContainsEncoded(XmlObject xmlObject) {
        for (XmlObject xmlObject2 : xmlObject.selectPath("declare namespace soap='http://schemas.xmlsoap.org/wsdl/soap/' .//soap:body/@use|.//soap:header/@use|.//soap:fault/@use")) {
            if ("encoded".equals(((SimpleValue) xmlObject2).getStringValue())) {
                return true;
            }
        }
        return false;
    }
}
