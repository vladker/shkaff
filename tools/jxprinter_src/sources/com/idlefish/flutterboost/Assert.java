package com.idlefish.flutterboost;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Assert {
    public static void assertFalse(String str, boolean z6) {
        assertTrue(str, !z6);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            assertNull("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void assertTrue(String str, boolean z6) {
        if (z6) {
            return;
        }
        fail(str);
    }

    public static void fail(String str) {
        if (str != null) {
            throw new AssertionError(str);
        }
        throw new AssertionError();
    }

    public static void assertFalse(boolean z6) {
        assertFalse(null, z6);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertTrue(boolean z6) {
        assertTrue(null, z6);
    }

    public static void fail() {
        fail(null);
    }
}
