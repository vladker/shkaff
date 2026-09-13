package com.idlefish.flutterboost;

import io.flutter.embedding.android.FlutterEngineProvider;
import java.util.List;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoostSetupOptions {
    private final String dartEntrypoint;
    private final List<String> dartEntrypointArgs;
    private FlutterEngineProvider flutterEngineProvider;
    private final String initialRoute;
    private final boolean isDebugLoggingEnabled;
    private final String[] shellArgs;
    private final boolean shouldOverrideBackForegroundEvent;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Builder {
        private List<String> dartEntrypointArgs;
        private FlutterEngineProvider flutterEngineProvider;
        private String[] shellArgs;
        private String initialRoute = PackagingURIHelper.FORWARD_SLASH_STRING;
        private String dartEntrypoint = "main";
        private boolean isDebugLoggingEnabled = false;
        private boolean shouldOverrideBackForegroundEvent = false;

        public FlutterBoostSetupOptions build() {
            return new FlutterBoostSetupOptions(this);
        }

        public Builder dartEntrypoint(String str) {
            this.dartEntrypoint = str;
            return this;
        }

        public Builder dartEntrypointArgs(List<String> list) {
            this.dartEntrypointArgs = list;
            return this;
        }

        public Builder flutterEngineProvider(FlutterEngineProvider flutterEngineProvider) {
            this.flutterEngineProvider = flutterEngineProvider;
            return this;
        }

        public Builder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public Builder isDebugLoggingEnabled(boolean z6) {
            this.isDebugLoggingEnabled = z6;
            return this;
        }

        public Builder shellArgs(String[] strArr) {
            this.shellArgs = strArr;
            return this;
        }

        public Builder shouldOverrideBackForegroundEvent(boolean z6) {
            this.shouldOverrideBackForegroundEvent = z6;
            return this;
        }
    }

    public static FlutterBoostSetupOptions createDefault() {
        return new Builder().build();
    }

    public String dartEntrypoint() {
        return this.dartEntrypoint;
    }

    public List<String> dartEntrypointArgs() {
        return this.dartEntrypointArgs;
    }

    public FlutterEngineProvider flutterEngineProvider() {
        return this.flutterEngineProvider;
    }

    public String initialRoute() {
        return this.initialRoute;
    }

    public boolean isDebugLoggingEnabled() {
        return this.isDebugLoggingEnabled;
    }

    public String[] shellArgs() {
        return this.shellArgs;
    }

    public boolean shouldOverrideBackForegroundEvent() {
        return this.shouldOverrideBackForegroundEvent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String[] strArr = this.shellArgs;
        if (strArr == null || strArr.length == 0) {
            sb.append(']');
        } else {
            int i5 = 0;
            while (true) {
                sb.append(String.valueOf(this.shellArgs[i5]));
                if (i5 == this.shellArgs.length - 1) {
                    break;
                }
                sb.append(", ");
                i5++;
            }
            sb.append(']');
        }
        return "initialRoute:" + this.initialRoute + ", dartEntrypoint:" + this.dartEntrypoint + ", isDebugLoggingEnabled: " + this.isDebugLoggingEnabled + ", shouldOverrideBackForegroundEvent:" + this.shouldOverrideBackForegroundEvent + ", shellArgs:" + sb.toString();
    }

    private FlutterBoostSetupOptions(Builder builder) {
        this.initialRoute = builder.initialRoute;
        this.dartEntrypoint = builder.dartEntrypoint;
        this.dartEntrypointArgs = builder.dartEntrypointArgs;
        this.shellArgs = builder.shellArgs;
        this.isDebugLoggingEnabled = builder.isDebugLoggingEnabled;
        this.shouldOverrideBackForegroundEvent = builder.shouldOverrideBackForegroundEvent;
        this.flutterEngineProvider = builder.flutterEngineProvider;
    }
}
