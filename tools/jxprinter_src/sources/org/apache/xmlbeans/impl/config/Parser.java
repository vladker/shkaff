package org.apache.xmlbeans.impl.config;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ClassLoaderTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import com.github.javaparser.utils.ProjectRoot;
import com.github.javaparser.utils.SourceRoot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class Parser {
    private final File[] classpath;
    private final CombinedTypeSolver combinedTypeSolver;
    private final File[] javaFiles;
    private final ParserConfiguration pc;
    private final ProjectRoot projectRoot;

    public Parser(File[] fileArr, File[] fileArr2) {
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver(new TypeSolver[0]);
        this.combinedTypeSolver = combinedTypeSolver;
        File[] fileArr3 = fileArr != null ? (File[]) fileArr.clone() : new File[0];
        this.javaFiles = fileArr3;
        File[] fileArr4 = fileArr2 != null ? (File[]) fileArr2.clone() : new File[0];
        this.classpath = fileArr4;
        ParserConfiguration parserConfiguration = new ParserConfiguration();
        this.pc = parserConfiguration;
        parserConfiguration.setLanguageLevel(ParserConfiguration.LanguageLevel.BLEEDING_EDGE);
        combinedTypeSolver.add(new ClassLoaderTypeSolver(new URLClassLoader((URL[]) Stream.of((Object[]) fileArr4).map(new o(2)).filter(new j(1)).toArray(new p(3)), getClass().getClassLoader())));
        combinedTypeSolver.add(new ReflectionTypeSolver());
        parserConfiguration.setSymbolResolver(new JavaSymbolSolver(combinedTypeSolver));
        if (fileArr3.length <= 0) {
            this.projectRoot = null;
            return;
        }
        ChildSolverCollectionStrategy childSolverCollectionStrategy = new ChildSolverCollectionStrategy(parserConfiguration, combinedTypeSolver);
        Stream.of((Object[]) fileArr3).map(new o(1)).map(new o(4)).distinct().forEach(new c(childSolverCollectionStrategy, 2));
        this.projectRoot = childSolverCollectionStrategy.collectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URL fileToURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$loadSource$3(CompilationUnit compilationUnit) {
        return compilationUnit.getTypes().stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$loadSource$4(String str, TypeDeclaration typeDeclaration) {
        return str.equals(typeDeclaration.getFullyQualifiedName().orElse(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ URL[] lambda$new$0(int i5) {
        return new URL[i5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ File lambda$new$1(File file) {
        return file.isDirectory() ? file : file.getParentFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: parseOrNull, reason: merged with bridge method [inline-methods] */
    public ParseResult<CompilationUnit> lambda$loadSource$2(SourceRoot sourceRoot, String str) {
        try {
            return sourceRoot.tryToParse("", str, this.pc);
        } catch (IOException unused) {
            return null;
        }
    }

    public ClassOrInterfaceDeclaration loadSource(final String str) {
        final String str2 = str.replace('.', '/') + ".java";
        ProjectRoot projectRoot = this.projectRoot;
        if (projectRoot == null) {
            return null;
        }
        Stream streamFlatMap = projectRoot.getSourceRoots().stream().map(new Function() { // from class: org.apache.xmlbeans.impl.config.s
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f7361a.lambda$loadSource$2(str2, (SourceRoot) obj);
            }
        }).filter(new t()).filter(new u()).map(new v()).map(new w()).flatMap(new x());
        final Class<ClassOrInterfaceDeclaration> cls = ClassOrInterfaceDeclaration.class;
        Stream streamFilter = streamFlatMap.filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.y
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((TypeDeclaration) obj);
            }
        }).filter(new Predicate() { // from class: org.apache.xmlbeans.impl.config.z
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Parser.lambda$loadSource$4(str, (TypeDeclaration) obj);
            }
        });
        final Class<ClassOrInterfaceDeclaration> cls2 = ClassOrInterfaceDeclaration.class;
        return (ClassOrInterfaceDeclaration) streamFilter.map(new Function() { // from class: org.apache.xmlbeans.impl.config.A
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (ClassOrInterfaceDeclaration) cls2.cast((TypeDeclaration) obj);
            }
        }).findFirst().orElse(null);
    }
}
