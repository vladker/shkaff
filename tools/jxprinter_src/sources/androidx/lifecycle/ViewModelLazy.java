package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements InterfaceC1934n {
    private VM cached;
    private final O3.a extrasProducer;
    private final O3.a factoryProducer;
    private final O3.a storeProducer;
    private final V3.c viewModelClass;

    /* JADX INFO: renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AnonymousClass1 extends F implements O3.a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // O3.a
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(V3.c viewModelClass, O3.a storeProducer, O3.a factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        E.f(viewModelClass, "viewModelClass");
        E.f(storeProducer, "storeProducer");
        E.f(factoryProducer, "factoryProducer");
    }

    @Override // p147z3.InterfaceC1934n
    public boolean isInitialized() {
        return this.cached != null;
    }

    public ViewModelLazy(V3.c viewModelClass, O3.a storeProducer, O3.a factoryProducer, O3.a extrasProducer) {
        E.f(viewModelClass, "viewModelClass");
        E.f(storeProducer, "storeProducer");
        E.f(factoryProducer, "factoryProducer");
        E.f(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // p147z3.InterfaceC1934n
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(N3.a.getJavaClass(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(V3.c cVar, O3.a aVar, O3.a aVar2, O3.a aVar3, int i5, AbstractC1107v abstractC1107v) {
        this(cVar, aVar, aVar2, (i5 & 8) != 0 ? AnonymousClass1.INSTANCE : aVar3);
    }
}
