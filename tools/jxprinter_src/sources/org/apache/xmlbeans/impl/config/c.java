package org.apache.xmlbeans.impl.config;

import com.github.javaparser.utils.ProjectRoot;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7353a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f7353a = i5;
        this.b = obj;
    }

    private final void a(Object obj) {
        ((ProjectRoot) this.b).addSourceRoot((Path) obj);
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7353a) {
            case 0:
                a(obj);
                break;
            case 1:
                ((ChildSolverCollectionStrategy.FileVisitor) this.b).lambda$visitFile$0((Path) obj);
                break;
            case 2:
                ((ChildSolverCollectionStrategy) this.b).collect((Path) obj);
                break;
            default:
                ((ArrayList) this.b).add((Path) obj);
                break;
        }
    }
}
