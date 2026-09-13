package O1;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f550a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i5, String str, Object obj) {
        this.f550a = i5;
        this.b = str;
        this.c = obj;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f550a) {
            case 0:
                return ComponentMonitor.lambda$processRegistrar$0(this.b, (Component) this.c, componentContainer);
            default:
                return LibraryVersionComponent.lambda$fromContext$0(this.b, (LibraryVersionComponent.VersionExtractor) this.c, componentContainer);
        }
    }
}
