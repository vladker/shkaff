package org.apache.xmlbeans.impl.tool;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.xmlbeans.SchemaCodePrinter;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.xml.sax.EntityResolver;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Parameters {
    private File baseDir;
    private String catalogFile;
    private File classesDir;
    private File[] classpath;
    private String compiler;
    private File[] configFiles;
    private boolean copyAnn;
    private boolean debug;
    private boolean download;
    private EntityResolver entityResolver;
    private Collection<XmlError> errorListener;
    private List<Extension> extensions = Collections.EMPTY_LIST;
    private boolean incrementalSrcGen;
    private File[] javaFiles;
    private Set<String> mdefNamespaces;
    private String memoryInitialSize;
    private String memoryMaximumSize;
    private String name;
    private boolean noAnn;
    private boolean noExt;
    private boolean noPvr;
    private boolean noUpa;
    private boolean noVDoc;
    private boolean nojavac;
    private File outputJar;
    private Set<XmlOptions.BeanMethod> partialMethods;
    private boolean quiet;
    private String repackage;
    private SchemaCodePrinter schemaCodePrinter;
    private File srcDir;
    private URL[] urlFiles;
    private boolean verbose;
    private File[] wsdlFiles;
    private File[] xsdFiles;

    public Parameters() {
        Set set = Collections.EMPTY_SET;
        this.mdefNamespaces = set;
        this.partialMethods = set;
    }

    public File getBaseDir() {
        return this.baseDir;
    }

    public String getCatalogFile() {
        return this.catalogFile;
    }

    public File getClassesDir() {
        return this.classesDir;
    }

    public File[] getClasspath() {
        return this.classpath;
    }

    public String getCompiler() {
        return this.compiler;
    }

    public File[] getConfigFiles() {
        return this.configFiles;
    }

    public EntityResolver getEntityResolver() {
        return this.entityResolver;
    }

    public Collection<XmlError> getErrorListener() {
        return this.errorListener;
    }

    public List<Extension> getExtensions() {
        return this.extensions;
    }

    public File[] getJavaFiles() {
        return this.javaFiles;
    }

    public Set<String> getMdefNamespaces() {
        return this.mdefNamespaces;
    }

    public String getMemoryInitialSize() {
        return this.memoryInitialSize;
    }

    public String getMemoryMaximumSize() {
        return this.memoryMaximumSize;
    }

    public String getName() {
        return this.name;
    }

    public File getOutputJar() {
        return this.outputJar;
    }

    public Set<XmlOptions.BeanMethod> getPartialMethods() {
        return this.partialMethods;
    }

    public String getRepackage() {
        return this.repackage;
    }

    public SchemaCodePrinter getSchemaCodePrinter() {
        return this.schemaCodePrinter;
    }

    public File getSrcDir() {
        return this.srcDir;
    }

    public URL[] getUrlFiles() {
        return this.urlFiles;
    }

    public File[] getWsdlFiles() {
        return this.wsdlFiles;
    }

    public File[] getXsdFiles() {
        return this.xsdFiles;
    }

    public boolean isCopyAnn() {
        return this.copyAnn;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isDownload() {
        return this.download;
    }

    public boolean isIncrementalSrcGen() {
        return this.incrementalSrcGen;
    }

    public boolean isNoAnn() {
        return this.noAnn;
    }

    public boolean isNoExt() {
        return this.noExt;
    }

    public boolean isNoPvr() {
        return this.noPvr;
    }

    public boolean isNoUpa() {
        return this.noUpa;
    }

    public boolean isNoVDoc() {
        return this.noVDoc;
    }

    public boolean isNojavac() {
        return this.nojavac;
    }

    public boolean isQuiet() {
        return this.quiet;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public void setBaseDir(File file) {
        this.baseDir = file;
    }

    public void setCatalogFile(String str) {
        this.catalogFile = str;
    }

    public void setClassesDir(File file) {
        this.classesDir = file;
    }

    public void setClasspath(File... fileArr) {
        this.classpath = fileArr == null ? null : (File[]) fileArr.clone();
    }

    public void setCompiler(String str) {
        this.compiler = str;
    }

    public void setConfigFiles(File... fileArr) {
        this.configFiles = fileArr == null ? null : (File[]) fileArr.clone();
    }

    public void setCopyAnn(boolean z6) {
        this.copyAnn = z6;
    }

    public void setDebug(boolean z6) {
        this.debug = z6;
    }

    public void setDownload(boolean z6) {
        this.download = z6;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    public void setErrorListener(Collection<XmlError> collection) {
        this.errorListener = collection;
    }

    public void setExtensions(List<Extension> list) {
        this.extensions = list;
    }

    public void setIncrementalSrcGen(boolean z6) {
        this.incrementalSrcGen = z6;
    }

    public void setJavaFiles(File... fileArr) {
        this.javaFiles = fileArr == null ? null : (File[]) fileArr.clone();
    }

    public void setMdefNamespaces(Set<String> set) {
        this.mdefNamespaces = set;
    }

    public void setMemoryInitialSize(String str) {
        this.memoryInitialSize = str;
    }

    public void setMemoryMaximumSize(String str) {
        this.memoryMaximumSize = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNoAnn(boolean z6) {
        this.noAnn = z6;
    }

    public void setNoExt(boolean z6) {
        this.noExt = z6;
    }

    public void setNoPvr(boolean z6) {
        this.noPvr = z6;
    }

    public void setNoUpa(boolean z6) {
        this.noUpa = z6;
    }

    public void setNoVDoc(boolean z6) {
        this.noVDoc = z6;
    }

    public void setNojavac(boolean z6) {
        this.nojavac = z6;
    }

    public void setOutputJar(File file) {
        this.outputJar = file;
    }

    public void setPartialMethods(Set<XmlOptions.BeanMethod> set) {
        this.partialMethods = set;
    }

    public void setQuiet(boolean z6) {
        this.quiet = z6;
    }

    public void setRepackage(String str) {
        this.repackage = str;
    }

    public void setSchemaCodePrinter(SchemaCodePrinter schemaCodePrinter) {
        this.schemaCodePrinter = schemaCodePrinter;
    }

    public void setSrcDir(File file) {
        this.srcDir = file;
    }

    public void setUrlFiles(URL... urlArr) {
        this.urlFiles = urlArr == null ? null : (URL[]) urlArr.clone();
    }

    public void setVerbose(boolean z6) {
        this.verbose = z6;
    }

    public void setWsdlFiles(File... fileArr) {
        this.wsdlFiles = fileArr == null ? null : (File[]) fileArr.clone();
    }

    public void setXsdFiles(File... fileArr) {
        this.xsdFiles = fileArr == null ? null : (File[]) fileArr.clone();
    }
}
