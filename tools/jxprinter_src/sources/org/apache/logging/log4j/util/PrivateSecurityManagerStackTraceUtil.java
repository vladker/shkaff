package org.apache.logging.log4j.util;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class PrivateSecurityManagerStackTraceUtil {
    private static final PrivateSecurityManager SECURITY_MANAGER;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PrivateSecurityManager extends SecurityManager {
        private PrivateSecurityManager() {
        }

        @Override // java.lang.SecurityManager
        public Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        PrivateSecurityManager privateSecurityManager = null;
        Object[] objArr = 0;
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(new RuntimePermission("createSecurityManager"));
            }
            privateSecurityManager = new PrivateSecurityManager();
        } catch (SecurityException unused) {
        }
        SECURITY_MANAGER = privateSecurityManager;
    }

    private PrivateSecurityManagerStackTraceUtil() {
    }

    public static Deque<Class<?>> getCurrentStackTrace() {
        Class<?>[] classContext = SECURITY_MANAGER.getClassContext();
        ArrayDeque arrayDeque = new ArrayDeque(classContext.length);
        Collections.addAll(arrayDeque, classContext);
        return arrayDeque;
    }

    public static boolean isEnabled() {
        return SECURITY_MANAGER != null;
    }
}
