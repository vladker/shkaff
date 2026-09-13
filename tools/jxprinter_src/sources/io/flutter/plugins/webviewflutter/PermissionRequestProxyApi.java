package io.flutter.plugins.webviewflutter;

import android.webkit.PermissionRequest;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PermissionRequestProxyApi extends PigeonApiPermissionRequest {
    public PermissionRequestProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiPermissionRequest
    public void deny(@NonNull PermissionRequest permissionRequest) {
        permissionRequest.deny();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiPermissionRequest
    public void grant(@NonNull PermissionRequest permissionRequest, @NonNull List<String> list) {
        permissionRequest.grant((String[]) list.toArray(new String[0]));
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiPermissionRequest
    @NonNull
    public List<String> resources(@NonNull PermissionRequest permissionRequest) {
        return Arrays.asList(permissionRequest.getResources());
    }
}
