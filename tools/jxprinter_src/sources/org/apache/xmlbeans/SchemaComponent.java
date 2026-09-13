package org.apache.xmlbeans;

import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaComponent {
    public static final int ANNOTATION = 8;
    public static final int ATTRIBUTE = 3;
    public static final int ATTRIBUTE_GROUP = 4;
    public static final int ELEMENT = 1;
    public static final int IDENTITY_CONSTRAINT = 5;
    public static final int MODEL_GROUP = 6;
    public static final int NOTATION = 7;
    public static final int TYPE = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Ref {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public String _handle;
        private volatile SchemaComponent _schemaComponent;
        private SchemaTypeSystem _schemaTypeSystem;

        public Ref(SchemaComponent schemaComponent) {
            this._schemaComponent = schemaComponent;
        }

        public final SchemaComponent getComponent() {
            String str;
            if (this._schemaComponent == null && this._handle != null) {
                synchronized (this) {
                    try {
                        if (this._schemaComponent == null && (str = this._handle) != null) {
                            this._schemaComponent = this._schemaTypeSystem.resolveHandle(str);
                            this._schemaTypeSystem = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this._schemaComponent;
        }

        public abstract int getComponentType();

        public final SchemaTypeSystem getTypeSystem() {
            return this._schemaTypeSystem;
        }

        public Ref(SchemaTypeSystem schemaTypeSystem, String str) {
            this._schemaTypeSystem = schemaTypeSystem;
            this._handle = str;
        }
    }

    Ref getComponentRef();

    int getComponentType();

    QName getName();

    String getSourceName();

    SchemaTypeSystem getTypeSystem();
}
