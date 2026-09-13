package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xmlbeans.BindingConfig;
import org.apache.xmlbeans.Filer;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
import org.apache.xmlbeans.impl.util.FilerImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaTypeSystemCompiler {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parameters {
        private URI baseURI;
        private BindingConfig config;
        private Collection<XmlError> errorListener;
        private SchemaTypeSystem existingSystem;
        private boolean javaize;
        private SchemaTypeLoader linkTo;
        private String name;
        private XmlOptions options;
        private SchemaDocument.Schema[] schemas;
        private File schemasDir;
        private Map<String, String> sourcesToCopyMap;

        public URI getBaseURI() {
            return this.baseURI;
        }

        public BindingConfig getConfig() {
            return this.config;
        }

        public Collection<XmlError> getErrorListener() {
            return this.errorListener;
        }

        public SchemaTypeSystem getExistingTypeSystem() {
            return this.existingSystem;
        }

        public SchemaTypeLoader getLinkTo() {
            return this.linkTo;
        }

        public String getName() {
            return this.name;
        }

        public XmlOptions getOptions() {
            return this.options;
        }

        public SchemaDocument.Schema[] getSchemas() {
            return this.schemas;
        }

        public File getSchemasDir() {
            return this.schemasDir;
        }

        public Map<String, String> getSourcesToCopyMap() {
            return this.sourcesToCopyMap;
        }

        public boolean isJavaize() {
            return this.javaize;
        }

        public void setBaseURI(URI uri) {
            this.baseURI = uri;
        }

        public void setConfig(BindingConfig bindingConfig) {
            this.config = bindingConfig;
        }

        public void setErrorListener(Collection<XmlError> collection) {
            this.errorListener = collection;
        }

        public void setExistingTypeSystem(SchemaTypeSystem schemaTypeSystem) {
            this.existingSystem = schemaTypeSystem;
        }

        public void setJavaize(boolean z6) {
            this.javaize = z6;
        }

        public void setLinkTo(SchemaTypeLoader schemaTypeLoader) {
            this.linkTo = schemaTypeLoader;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setOptions(XmlOptions xmlOptions) {
            this.options = xmlOptions;
        }

        public void setSchemas(SchemaDocument.Schema[] schemaArr) {
            this.schemas = schemaArr == null ? null : (SchemaDocument.Schema[]) schemaArr.clone();
        }

        public void setSchemasDir(File file) {
            this.schemasDir = file;
        }

        public void setSourcesToCopyMap(Map<String, String> map) {
            this.sourcesToCopyMap = map;
        }
    }

    public static SchemaTypeSystem compile(Parameters parameters) {
        return compileImpl(parameters.getExistingTypeSystem(), parameters.getName(), parameters.getSchemas(), parameters.getConfig(), parameters.getLinkTo(), parameters.getOptions(), parameters.getErrorListener(), parameters.isJavaize(), parameters.getBaseURI(), parameters.getSourcesToCopyMap(), parameters.getSchemasDir());
    }

    public static SchemaTypeSystemImpl compileImpl(SchemaTypeSystem schemaTypeSystem, String str, SchemaDocument.Schema[] schemaArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection<XmlError> collection, boolean z6, URI uri, Map<String, String> map, File file) {
        if (schemaTypeLoader == null) {
            throw new IllegalArgumentException("Must supply linkTo");
        }
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
        boolean z7 = schemaTypeSystem != null;
        StscState stscStateStart = StscState.start();
        boolean z8 = xmlOptions == null || !xmlOptions.isCompileNoValidation();
        try {
            stscStateStart.setErrorListener(xmlErrorWatcher);
            stscStateStart.setBindingConfig(bindingConfig);
            stscStateStart.setOptions(xmlOptions);
            stscStateStart.setGivenTypeSystemName(str);
            stscStateStart.setSchemasDir(file);
            if (uri != null) {
                stscStateStart.setBaseUri(uri);
            }
            stscStateStart.setImportingTypeLoader(SchemaTypeLoaderImpl.build(new SchemaTypeLoader[]{BuiltinSchemaTypeSystem.get(), schemaTypeLoader}, null, null));
            ArrayList arrayList = new ArrayList(schemaArr.length);
            if (z8) {
                XmlOptions errorListener = new XmlOptions().setErrorListener(xmlErrorWatcher);
                if (xmlOptions != null && xmlOptions.isValidateTreatLaxAsSkip()) {
                    errorListener.setValidateTreatLaxAsSkip();
                }
                for (SchemaDocument.Schema schema : schemaArr) {
                    if (schema.validate(errorListener)) {
                        arrayList.add(schema);
                    }
                }
            } else {
                arrayList.addAll(Arrays.asList(schemaArr));
            }
            SchemaDocument.Schema[] schemasToRecompile = (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[0]);
            if (z7) {
                HashSet hashSet = new HashSet();
                schemasToRecompile = getSchemasToRecompile((SchemaTypeSystemImpl) schemaTypeSystem, schemasToRecompile, hashSet);
                stscStateStart.initFromTypeSystem((SchemaTypeSystemImpl) schemaTypeSystem, hashSet);
            } else {
                stscStateStart.setDependencies(new SchemaDependencies());
            }
            StscTranslator.addAllDefinitions(StscImporter.resolveImportsAndIncludes(schemasToRecompile, z7));
            StscResolver.resolveAll();
            StscChecker.checkAll();
            StscJavaizer.javaizeAllTypes(z6);
            StscState.get().sts().loadFromStscState(stscStateStart);
            if (map != null) {
                map.putAll(stscStateStart.sourceCopyMap());
            }
            if (xmlErrorWatcher.hasError()) {
                if (!stscStateStart.allowPartial() || stscStateStart.getRecovered() != xmlErrorWatcher.size()) {
                    return null;
                }
                StscState.get().sts().setIncomplete(true);
            }
            if (schemaTypeSystem != null) {
                ((SchemaTypeSystemImpl) schemaTypeSystem).setIncomplete(true);
            }
            return StscState.get().sts();
        } finally {
            StscState.end();
        }
    }

    public static boolean generateTypes(SchemaTypeSystem schemaTypeSystem, Filer filer, XmlOptions xmlOptions) {
        boolean z6;
        if ((schemaTypeSystem instanceof SchemaTypeSystemImpl) && ((SchemaTypeSystemImpl) schemaTypeSystem).isIncomplete()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(schemaTypeSystem.globalTypes()));
        arrayList.addAll(Arrays.asList(schemaTypeSystem.documentTypes()));
        arrayList.addAll(Arrays.asList(schemaTypeSystem.attributeTypes()));
        SchemaCodePrinter schemaCodePrinter = xmlOptions == null ? null : xmlOptions.getSchemaCodePrinter();
        if (schemaCodePrinter == null) {
            schemaCodePrinter = new SchemaTypeCodePrinter();
        }
        try {
            Writer writerCreateSourceFile = filer.createSourceFile(SchemaTypeCodePrinter.indexClassForSystem(schemaTypeSystem));
            try {
                schemaCodePrinter.printHolder(writerCreateSourceFile, schemaTypeSystem, xmlOptions, filer instanceof FilerImpl ? ((FilerImpl) filer).getRepackager() : null);
                if (writerCreateSourceFile != null) {
                    writerCreateSourceFile.close();
                }
                z6 = true;
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    SchemaType schemaType = (SchemaType) obj;
                    if (!schemaType.isBuiltinType() && schemaType.getFullJavaName() != null) {
                        try {
                            Writer writerCreateSourceFile2 = filer.createSourceFile(schemaType.getFullJavaName());
                            try {
                                schemaCodePrinter.printType(writerCreateSourceFile2, schemaType, xmlOptions);
                                if (writerCreateSourceFile2 != null) {
                                    writerCreateSourceFile2.close();
                                }
                                try {
                                    Writer writerCreateSourceFile3 = filer.createSourceFile(schemaType.getFullJavaImplName());
                                    try {
                                        schemaCodePrinter.printTypeImpl(writerCreateSourceFile3, schemaType, xmlOptions);
                                        if (writerCreateSourceFile3 != null) {
                                            writerCreateSourceFile3.close();
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            if (writerCreateSourceFile3 != null) {
                                                try {
                                                    writerCreateSourceFile3.close();
                                                } catch (Throwable th3) {
                                                    th.addSuppressed(th3);
                                                }
                                            }
                                            throw th2;
                                        }
                                    }
                                } catch (IOException e) {
                                    System.err.println("IO Error " + e);
                                    z6 = false;
                                }
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    if (writerCreateSourceFile2 != null) {
                                        try {
                                            writerCreateSourceFile2.close();
                                        } catch (Throwable th6) {
                                            th4.addSuppressed(th6);
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        } catch (IOException e6) {
                            System.err.println("IO Error " + e6);
                            z6 = false;
                        }
                    }
                }
                return z6;
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    if (writerCreateSourceFile != null) {
                        try {
                            writerCreateSourceFile.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                    }
                    throw th8;
                }
            }
        } catch (IOException e7) {
            System.err.println("IO Error " + e7);
            z6 = false;
        }
    }

    private static SchemaDocument.Schema[] getSchemasToRecompile(SchemaTypeSystemImpl schemaTypeSystemImpl, SchemaDocument.Schema[] schemaArr, Set<String> set) {
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (SchemaDocument.Schema schema : schemaArr) {
            String sourceName = schema.documentProperties().getSourceName();
            if (sourceName == null) {
                throw new IllegalArgumentException("One of the Schema files passed in doesn't have the source set, which prevents it to be incrementally compiled");
            }
            hashSet.add(sourceName);
            map.put(sourceName, schema);
            arrayList.add(schema);
        }
        SchemaDependencies dependencies = schemaTypeSystemImpl.getDependencies();
        set.addAll(dependencies.computeTransitiveClosure(dependencies.getNamespacesTouched(hashSet)));
        List<String> filesTouched = dependencies.getFilesTouched(set);
        StscState.get().setDependencies(new SchemaDependencies(dependencies, set));
        for (String str : filesTouched) {
            if (((SchemaDocument.Schema) map.get(str)) == null) {
                try {
                    XmlObject xmlObjectDownloadDocument = StscImporter.DownloadTable.downloadDocument(StscState.get().getS4SLoader(), null, str);
                    XmlOptions xmlOptions = new XmlOptions();
                    xmlOptions.setErrorListener(StscState.get().getErrorListener());
                    if ((xmlObjectDownloadDocument instanceof SchemaDocument) && xmlObjectDownloadDocument.validate(xmlOptions)) {
                        arrayList.add(((SchemaDocument) xmlObjectDownloadDocument).getSchema());
                    } else {
                        StscState.get().error("Referenced document is not a valid schema, URL = " + str, 56, (XmlObject) null);
                    }
                } catch (MalformedURLException e) {
                    StscState.get().error(XmlErrorCodes.EXCEPTION_LOADING_URL, new Object[]{"MalformedURLException", str, e.getMessage()}, (XmlObject) null);
                } catch (IOException e6) {
                    StscState.get().error(XmlErrorCodes.EXCEPTION_LOADING_URL, new Object[]{"IOException", str, e6.getMessage()}, (XmlObject) null);
                } catch (XmlException e7) {
                    StscState.get().error(XmlErrorCodes.EXCEPTION_LOADING_URL, new Object[]{"XmlException", str, e7.getMessage()}, (XmlObject) null);
                }
            }
        }
        return (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[0]);
    }

    public static SchemaTypeSystemImpl compile(String str, SchemaTypeSystem schemaTypeSystem, XmlObject[] xmlObjectArr, BindingConfig bindingConfig, SchemaTypeLoader schemaTypeLoader, Filer filer, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        ArrayList arrayList = new ArrayList();
        if (xmlObjectArr != null) {
            for (int i5 = 0; i5 < xmlObjectArr.length; i5++) {
                XmlObject xmlObject = xmlObjectArr[i5];
                if (xmlObject instanceof SchemaDocument.Schema) {
                    arrayList.add((SchemaDocument.Schema) xmlObject);
                } else if ((xmlObject instanceof SchemaDocument) && ((SchemaDocument) xmlObject).getSchema() != null) {
                    arrayList.add(((SchemaDocument) xmlObjectArr[i5]).getSchema());
                } else {
                    throw new XmlException("Thread " + Thread.currentThread().getName() + ": The " + i5 + "th supplied input is not a schema document: its type is " + xmlObjectArr[i5].schemaType());
                }
            }
        }
        XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(xmlOptionsMaskNull.getErrorListener());
        SchemaTypeSystemImpl schemaTypeSystemImplCompileImpl = compileImpl(schemaTypeSystem, str, (SchemaDocument.Schema[]) arrayList.toArray(new SchemaDocument.Schema[0]), bindingConfig, schemaTypeLoader, xmlOptionsMaskNull, xmlErrorWatcher, filer != null, xmlOptionsMaskNull.getBaseURI(), null, null);
        if (xmlErrorWatcher.hasError() && schemaTypeSystemImplCompileImpl == null) {
            throw new XmlException(xmlErrorWatcher.firstError());
        }
        if (schemaTypeSystemImplCompileImpl != null && !schemaTypeSystemImplCompileImpl.isIncomplete() && filer != null) {
            schemaTypeSystemImplCompileImpl.save(filer);
            generateTypes(schemaTypeSystemImplCompileImpl, filer, xmlOptionsMaskNull);
        }
        return schemaTypeSystemImplCompileImpl;
    }
}
