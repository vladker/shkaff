package com.idlefish.flutterboost;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoostRouteOptions {
    private final Map<String, Object> arguments;
    private final boolean opaque;
    private final String pageName;
    private final int requestCode;
    private final String uniqueId;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Builder {
        private Map<String, Object> arguments;
        private boolean opaque = true;
        private String pageName;
        private int requestCode;
        private String uniqueId;

        public Builder arguments(Map<String, Object> map) {
            this.arguments = map;
            return this;
        }

        public FlutterBoostRouteOptions build() {
            return new FlutterBoostRouteOptions(this);
        }

        public Builder opaque(boolean z6) {
            this.opaque = z6;
            return this;
        }

        public Builder pageName(String str) {
            this.pageName = str;
            return this;
        }

        public Builder requestCode(int i5) {
            this.requestCode = i5;
            return this;
        }

        public Builder uniqueId(String str) {
            this.uniqueId = str;
            return this;
        }
    }

    public Map<String, Object> arguments() {
        return this.arguments;
    }

    public boolean opaque() {
        return this.opaque;
    }

    public String pageName() {
        return this.pageName;
    }

    public int requestCode() {
        return this.requestCode;
    }

    public String uniqueId() {
        return this.uniqueId;
    }

    private FlutterBoostRouteOptions(Builder builder) {
        this.pageName = builder.pageName;
        this.arguments = builder.arguments;
        this.requestCode = builder.requestCode;
        this.uniqueId = builder.uniqueId;
        this.opaque = builder.opaque;
    }
}
