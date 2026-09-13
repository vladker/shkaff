package org.apache.xmlbeans;

import java.io.Writer;
import org.apache.xmlbeans.impl.repackage.Repackager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaCodePrinter {
    void printHolder(Writer writer, SchemaTypeSystem schemaTypeSystem, XmlOptions xmlOptions, Repackager repackager);

    @Deprecated
    default void printType(Writer writer, SchemaType schemaType) {
        printType(writer, schemaType, null);
    }

    @Deprecated
    default void printTypeImpl(Writer writer, SchemaType schemaType) {
        printTypeImpl(writer, schemaType, null);
    }

    default void printType(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) {
        printType(writer, schemaType);
    }

    default void printTypeImpl(Writer writer, SchemaType schemaType, XmlOptions xmlOptions) {
        printTypeImpl(writer, schemaType);
    }
}
