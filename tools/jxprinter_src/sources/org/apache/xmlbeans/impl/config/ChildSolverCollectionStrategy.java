package org.apache.xmlbeans.impl.config;

import A3.AbstractC0157z;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JarTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.utils.CollectionStrategy;
import com.github.javaparser.utils.ProjectRoot;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class ChildSolverCollectionStrategy implements CollectionStrategy {
    private static final Logger LOG = LogManager.getLogger((Class<?>) ChildSolverCollectionStrategy.class);
    private final CombinedTypeSolver combinedTypeSolver;
    private final ParserConfiguration config;
    private final PathMatcher javaMatcher = getPathMatcher("glob:**.java");
    private final PathMatcher jarMatcher = getPathMatcher("glob:**.jar");
    private final List<Path> roots = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FileVisitor extends SimpleFileVisitor<Path> {
        private FileVisitor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$visitFile$0(Path path) {
            ChildSolverCollectionStrategy.this.getSolver().add(new JavaParserTypeSolver(path, ChildSolverCollectionStrategy.this.getParserConfiguration()));
            ChildSolverCollectionStrategy.this.roots.add(path);
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
            return Files.isHidden(path) ? FileVisitResult.SKIP_SUBTREE : FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
            if (ChildSolverCollectionStrategy.this.javaMatcher.matches(path)) {
                Stream map = ChildSolverCollectionStrategy.this.roots.stream().map(new o(3));
                Path absolutePath = path.toAbsolutePath();
                absolutePath.getClass();
                if (map.noneMatch(new C1439a(absolutePath, 2))) {
                    ChildSolverCollectionStrategy.this.getRoot(path).ifPresent(new c(this, 1));
                }
            } else if (ChildSolverCollectionStrategy.this.jarMatcher.matches(path)) {
                ChildSolverCollectionStrategy.this.getSolver().add(new JarTypeSolver(path));
            }
            return FileVisitResult.CONTINUE;
        }
    }

    public ChildSolverCollectionStrategy(ParserConfiguration parserConfiguration, CombinedTypeSolver combinedTypeSolver) {
        this.config = parserConfiguration;
        this.combinedTypeSolver = combinedTypeSolver;
    }

    private static Path commonRoot(Path path, Path path2) {
        ArrayList arrayList = new ArrayList();
        int i5 = 3;
        path.toAbsolutePath().iterator().forEachRemaining(new c(arrayList, i5));
        ArrayList arrayList2 = new ArrayList();
        path2.toAbsolutePath().iterator().forEachRemaining(new c(arrayList2, i5));
        arrayList.retainAll(arrayList2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Path) androidx.collection.a.e(arrayList, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CombinedTypeSolver getSolver() {
        return this.combinedTypeSolver;
    }

    public ProjectRoot collect(Path path) {
        try {
            Files.walkFileTree(path, new FileVisitor());
        } catch (IOException e) {
            LOG.atWarn().withThrowable(e).log("Unable to walk {}", path);
        }
        if (this.roots.isEmpty()) {
            return null;
        }
        return new ProjectRoot((Path) AbstractC0157z.f(1, this.roots), this.config);
    }

    public ProjectRoot collectAll() {
        Path pathCommonRoot = null;
        for (Path path : this.roots) {
            if (pathCommonRoot != null) {
                pathCommonRoot = commonRoot(pathCommonRoot, path);
                if (pathCommonRoot == null) {
                    break;
                }
            } else {
                pathCommonRoot = path;
            }
        }
        if (pathCommonRoot == null) {
            throw new IllegalStateException("Unable to construct a common project root - giving up.");
        }
        ProjectRoot projectRoot = new ProjectRoot(pathCommonRoot, this.config);
        this.roots.forEach(new c(projectRoot, 0));
        return projectRoot;
    }

    public ParserConfiguration getParserConfiguration() {
        return this.config;
    }
}
