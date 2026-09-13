package org.apache.xmlbeans;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SchemaTypeSystem extends SchemaTypeLoader {
    SchemaAnnotation[] annotations();

    SchemaAttributeGroup[] attributeGroups();

    SchemaType[] attributeTypes();

    SchemaType[] documentTypes();

    ClassLoader getClassLoader();

    String getName();

    SchemaGlobalAttribute[] globalAttributes();

    SchemaGlobalElement[] globalElements();

    SchemaType[] globalTypes();

    SchemaModelGroup[] modelGroups();

    void resolve();

    SchemaComponent resolveHandle(String str);

    void save(Filer filer);

    void saveToDirectory(File file);

    SchemaType typeForHandle(String str);
}
