package io.flutter.embedding.engine.plugins;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface PluginRegistry {
    void add(@NonNull FlutterPlugin flutterPlugin);

    void add(@NonNull Set<FlutterPlugin> set);

    @Nullable
    FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> cls);

    boolean has(@NonNull Class<? extends FlutterPlugin> cls);

    void remove(@NonNull Class<? extends FlutterPlugin> cls);

    void remove(@NonNull Set<Class<? extends FlutterPlugin>> set);

    void removeAll();
}
