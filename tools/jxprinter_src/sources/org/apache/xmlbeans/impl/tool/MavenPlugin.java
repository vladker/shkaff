package org.apache.xmlbeans.impl.tool;

import A3.AbstractC0157z;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import com.google.firebase.crashlytics.internal.persistence.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xddf.usermodel.text.e;
import org.apache.poi.xwpf.usermodel.c;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
@Mojo(defaultPhase = LifecyclePhase.GENERATE_SOURCES, name = "compile")
public class MavenPlugin extends AbstractMojo {

    @Parameter(defaultValue = "schemaorg_apache_xmlbeans/src")
    private String baseSchemaLocation;

    @Parameter
    private File basedir;

    @Parameter(defaultValue = "true")
    private boolean buildSchemas;

    @Parameter
    private String catalogLocation;

    @Parameter
    private String classPath;

    @Parameter(defaultValue = "${project.basedir}/target/generated-resources")
    private String classTargetDir;

    @Parameter
    private String compiler;

    @Parameter(defaultValue = "false")
    private boolean copyAnn;

    @Parameter(defaultValue = "false")
    private boolean debug;

    @Parameter(defaultValue = "false")
    private boolean download;

    @Parameter
    private List<Extension> extensions;

    @Parameter(defaultValue = "${project.basedir}/target/generated-sources")
    private String javaTargetDir;

    @Parameter
    private List<String> mdefNamespaces;

    @Parameter(defaultValue = CodeGenUtil.DEFAULT_MEM_START)
    private String memoryInitialSize;

    @Parameter(defaultValue = CodeGenUtil.DEFAULT_MEM_MAX)
    private String memoryMaximumSize;

    @Parameter(defaultValue = "${project.artifactId}")
    private String name;

    @Parameter(defaultValue = "false")
    private boolean noAnn;

    @Parameter(defaultValue = "false")
    private boolean noPvr;

    @Parameter(defaultValue = "false")
    private boolean noUpa;

    @Parameter(defaultValue = "false")
    private boolean noVDoc;

    @Parameter(defaultValue = "${project.basedir}/target/${project.artifactId}-${project.version}-xmltypes.jar")
    private File outputJar;

    @Parameter
    private String partialMethods;

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Parameter(defaultValue = "true")
    private boolean quiet;

    @Parameter(defaultValue = "true")
    private boolean quite;

    @Parameter(defaultValue = "${project.groupId}.${project.artifactId}.metadata")
    private String repackage;

    @Parameter
    private List<Resource> resources;

    @Parameter(defaultValue = "${project.basedir}/src/main/schema")
    private String sourceDir;

    @Parameter(defaultValue = "true")
    private boolean sourceOnly;

    @Parameter(defaultValue = "*.xsd,*.wsdl,*.java")
    private String sourceSchemas;

    @Parameter(defaultValue = "false")
    private boolean verbose;

    @Parameter(defaultValue = "${project.basedir}/src/schema/xmlconfig.xml")
    private String xmlConfigs;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PassThroughResolver implements EntityResolver {
        private final String baseSchemaLocation;
        private final ClassLoader cl;
        private final EntityResolver delegate;
        private final URI sourceDir;

        public PassThroughResolver(ClassLoader classLoader, EntityResolver entityResolver, URI uri, String str) {
            this.cl = classLoader;
            this.delegate = entityResolver;
            this.sourceDir = uri;
            this.baseSchemaLocation = androidx.collection.a.n(str, PackagingURIHelper.FORWARD_SLASH_STRING);
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) throws IOException {
            InputSource inputSourceResolveEntity;
            EntityResolver entityResolver = this.delegate;
            if (entityResolver != null && (inputSourceResolveEntity = entityResolver.resolveEntity(str, str2)) != null) {
                return inputSourceResolveEntity;
            }
            System.out.println(androidx.collection.a.p("Could not resolve publicId: ", str, ", systemId: ", str2, " from catalog"));
            try {
                String string = this.sourceDir.relativize(new URI(str2)).toString();
                InputStream resourceAsStream = this.cl.getResourceAsStream(string);
                if (resourceAsStream != null) {
                    System.out.println("found in classpath at: " + string);
                    return new InputSource(resourceAsStream);
                }
                InputStream resourceAsStream2 = this.cl.getResourceAsStream(this.baseSchemaLocation + string);
                if (resourceAsStream2 != null) {
                    System.out.println("found in classpath at: META-INF/" + string);
                    return new InputSource(resourceAsStream2);
                }
                System.out.println("Not found in classpath, looking in current directory: " + str2);
                return new InputSource(str2);
            } catch (URISyntaxException e) {
                throw new IOException("Could not relativeize systemId", e);
            }
        }
    }

    private static File[] files(List<File> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (File[]) list.toArray(new File[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$execute$0(Pattern pattern, File file, String str) {
        return !str.endsWith(".xsdconfig") && pattern.matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$execute$1(File file, String str) {
        return Stream.of((Object[]) new File[]{new File(str), new File(file, str)}).filter(new e(22));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.maven.plugin.MojoFailureException */
    public void execute() throws MojoFailureException {
        String str = this.sourceDir;
        if (str == null || str.isEmpty() || !new File(this.sourceDir).isDirectory()) {
            throw new MojoFailureException(AbstractC0157z.s(new StringBuilder("Set configuration <sourceDir> (='"), this.sourceDir, "') to a valid directory containing *.xsd,*.wsdl files."));
        }
        String str2 = this.baseSchemaLocation;
        if (str2 == null || str2.isEmpty()) {
            throw new MojoFailureException("baseSchemaLocation is empty");
        }
        if (this.sourceSchemas == null) {
            getLog().debug("sourceSchemas is null");
        }
        if (this.classPath == null) {
            getLog().debug("classPath is null");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        File file = new File(this.sourceDir);
        Resource resource = new Resource();
        resource.setDirectory(this.sourceDir);
        resource.setTargetPath(this.baseSchemaLocation);
        File[] fileArrListFiles = file.listFiles(new b(Pattern.compile(this.sourceSchemas != null ? "(" + this.sourceSchemas.replace(",", "|").replace(Consts.DOT, "\\.").replace(ProxyConfig.MATCH_ALL_SCHEMES, ".*") + ")" : ".*"), 1 == true ? 1 : 0));
        Objects.requireNonNull(fileArrListFiles);
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            String strReplaceAll = name.replaceAll(".*\\.", "");
            strReplaceAll.getClass();
            if (strReplaceAll.equals("java")) {
                arrayList3.add(file2);
            } else if (strReplaceAll.equals("wsdl")) {
                arrayList2.add(file2);
            } else {
                arrayList.add(file2);
            }
            resource.addInclude(name);
        }
        this.resources = Collections.singletonList(resource);
        if (this.buildSchemas) {
            String str3 = this.xmlConfigs;
            List list = (str3 == null || str3.isEmpty()) ? Collections.EMPTY_LIST : (List) Stream.of((Object[]) this.xmlConfigs.split(",")).flatMap(new com.google.android.material.color.utilities.a(file, 8)).collect(Collectors.toList());
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            String str4 = this.classPath;
            if (str4 != null) {
                for (String str5 : str4.split(",")) {
                    File file3 = new File(str5);
                    arrayList4.add(file3);
                    try {
                        arrayList5.add(file3.toURI().toURL());
                    } catch (MalformedURLException e) {
                        throw new MojoFailureException(androidx.collection.a.k(file3, "invalid classpath: "), e);
                    }
                }
            }
            PassThroughResolver passThroughResolver = new PassThroughResolver(new URLClassLoader((URL[]) arrayList5.toArray(new URL[0])), MavenPluginResolver.getResolver(this.catalogLocation), new File(this.sourceDir).toURI(), this.baseSchemaLocation);
            Parameters parameters = new Parameters();
            parameters.setXsdFiles(files(arrayList));
            parameters.setWsdlFiles(files(arrayList2));
            parameters.setJavaFiles(files(arrayList3));
            parameters.setConfigFiles(files(list));
            parameters.setClasspath(files(arrayList4));
            parameters.setName(this.name);
            parameters.setSrcDir(new File(this.javaTargetDir));
            parameters.setClassesDir(new File(this.classTargetDir));
            parameters.setNojavac(this.sourceOnly);
            parameters.setVerbose(this.verbose);
            parameters.setEntityResolver(passThroughResolver);
            parameters.setQuiet(this.quiet && this.quite);
            parameters.setNoUpa(this.noUpa);
            parameters.setNoPvr(this.noPvr);
            parameters.setNoAnn(this.noAnn);
            parameters.setCopyAnn(this.copyAnn);
            parameters.setNoVDoc(this.noVDoc);
            String str6 = this.repackage;
            if (str6 != null && !str6.isEmpty()) {
                parameters.setRepackage("org.apache.xmlbeans.metadata:" + this.repackage);
            }
            List<String> list2 = this.mdefNamespaces;
            if (list2 != null && !list2.isEmpty()) {
                parameters.setMdefNamespaces(new HashSet(this.mdefNamespaces));
            }
            ArrayList arrayList6 = new ArrayList();
            parameters.setErrorListener(arrayList6);
            String str7 = this.partialMethods;
            if (str7 != null && !str7.isEmpty()) {
                parameters.setPartialMethods(SchemaCompiler.parsePartialMethods(this.partialMethods));
            }
            parameters.setDownload(this.download);
            parameters.setBaseDir(this.basedir);
            parameters.setCompiler(this.compiler);
            parameters.setMemoryInitialSize(this.memoryInitialSize);
            parameters.setMemoryMaximumSize(this.memoryMaximumSize);
            parameters.setOutputJar(this.outputJar);
            parameters.setDebug(this.debug);
            parameters.setExtensions(this.extensions);
            if (!SchemaCompiler.compile(parameters)) {
                throw new MojoFailureException("Schema compilation failed!\n" + ((String) arrayList6.stream().map(new c(9)).collect(Collectors.joining("\n"))));
            }
            Resource resource2 = new Resource();
            resource2.setDirectory(this.classTargetDir);
            this.project.addResource(resource2);
            this.project.addCompileSourceRoot(this.javaTargetDir);
        }
    }
}
