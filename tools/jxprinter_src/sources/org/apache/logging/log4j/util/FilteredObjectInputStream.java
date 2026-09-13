package org.apache.logging.log4j.util;

import A3.AbstractC0157z;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FilteredObjectInputStream extends ObjectInputStream {
    private static final Set<String> REQUIRED_JAVA_CLASSES = new HashSet(Arrays.asList("java.math.BigDecimal", "java.math.BigInteger", "java.rmi.MarshalledObject", "[B"));
    private static final Set<String> REQUIRED_JAVA_PACKAGES = new HashSet(Arrays.asList("java.lang.", "java.time.", "java.util.", "org.apache.logging.log4j.", "[Lorg.apache.logging.log4j."));
    private final Collection<String> allowedExtraClasses;

    public FilteredObjectInputStream() {
        this.allowedExtraClasses = Collections.EMPTY_SET;
    }

    private static boolean isAllowedByDefault(String str) {
        return isRequiredPackage(str) || REQUIRED_JAVA_CLASSES.contains(str);
    }

    private static boolean isRequiredPackage(String str) {
        Iterator<String> it = REQUIRED_JAVA_PACKAGES.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public Collection<String> getAllowedClasses() {
        return this.allowedExtraClasses;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws InvalidObjectException {
        String name = objectStreamClass.getName();
        if (isAllowedByDefault(name) || this.allowedExtraClasses.contains(name)) {
            return super.resolveClass(objectStreamClass);
        }
        throw new InvalidObjectException(AbstractC0157z.n("Class is not allowed for deserialization: ", name));
    }

    public FilteredObjectInputStream(InputStream inputStream) {
        super(inputStream);
        this.allowedExtraClasses = Collections.EMPTY_SET;
    }

    public FilteredObjectInputStream(Collection<String> collection) {
        this.allowedExtraClasses = collection;
    }

    public FilteredObjectInputStream(InputStream inputStream, Collection<String> collection) {
        super(inputStream);
        this.allowedExtraClasses = collection;
    }
}
