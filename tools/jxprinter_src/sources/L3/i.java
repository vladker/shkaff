package L3;

import W3.InterfaceC0233q;
import java.io.File;
import java.util.Iterator;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements InterfaceC0233q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f447a;
    private final n direction;
    private final O3.l onEnter;
    private final O3.p onFail;
    private final O3.l onLeave;
    private final File start;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class a extends b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File rootDir) {
            super(rootDir);
            E.f(rootDir, "rootDir");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class b {
        private final File root;

        public b(File root) {
            E.f(root, "root");
            this.root = root;
        }

        public final File getRoot() {
            return this.root;
        }

        public abstract File step();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(File start, n direction) {
        this(start, direction, null, null, null, Integer.MAX_VALUE);
        E.f(start, "start");
        E.f(direction, "direction");
    }

    @Override // W3.InterfaceC0233q
    public Iterator<File> iterator() {
        return new m(this);
    }

    public final i maxDepth(int i5) {
        if (i5 > 0) {
            return new i(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, i5);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i5 + '.');
    }

    public final i onEnter(O3.l function) {
        E.f(function, "function");
        return new i(this.start, this.direction, function, this.onLeave, this.onFail, this.f447a);
    }

    public final i onFail(O3.p function) {
        E.f(function, "function");
        return new i(this.start, this.direction, this.onEnter, this.onLeave, function, this.f447a);
    }

    public final i onLeave(O3.l function) {
        E.f(function, "function");
        return new i(this.start, this.direction, this.onEnter, function, this.onFail, this.f447a);
    }

    public i(File file, n nVar, O3.l lVar, O3.l lVar2, O3.p pVar, int i5) {
        this.start = file;
        this.direction = nVar;
        this.onEnter = lVar;
        this.onLeave = lVar2;
        this.onFail = pVar;
        this.f447a = i5;
    }
}
