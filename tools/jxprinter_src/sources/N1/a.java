package N1;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ComponentFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f497a;

    public /* synthetic */ a(int i5) {
        this.f497a = i5;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(ComponentContainer componentContainer) {
        switch (this.f497a) {
            case 0:
                return TransportRegistrar.lambda$getComponents$0(componentContainer);
            case 1:
                return TransportRegistrar.lambda$getComponents$1(componentContainer);
            case 2:
                return TransportRegistrar.lambda$getComponents$2(componentContainer);
            case 3:
                return ExecutorsRegistrar.lambda$getComponents$4(componentContainer);
            case 4:
                return ExecutorsRegistrar.lambda$getComponents$5(componentContainer);
            case 5:
                return ExecutorsRegistrar.lambda$getComponents$6(componentContainer);
            case 6:
                return ExecutorsRegistrar.lambda$getComponents$7(componentContainer);
            case 7:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(componentContainer);
            case 8:
                return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
            case 9:
                return FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
            default:
                return FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
        }
    }
}
