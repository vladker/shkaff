package org.apache.poi.poifs.nio;

import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.util.Objects;
import org.apache.poi.util.SuppressForbidden;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@SuppressForbidden("uses java.security features deprecated in java 17 - no other option though")
public final class CleanerUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BufferCleaner CLEANER;
    public static final String UNMAP_NOT_SUPPORTED_REASON;
    public static final boolean UNMAP_SUPPORTED;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface BufferCleaner {
        void freeBuffer(ByteBuffer byteBuffer);
    }

    static {
        Object objDoPrivileged = AccessController.doPrivileged(new C4.a(4));
        if (objDoPrivileged instanceof BufferCleaner) {
            CLEANER = (BufferCleaner) objDoPrivileged;
            UNMAP_SUPPORTED = true;
            UNMAP_NOT_SUPPORTED_REASON = null;
        } else {
            CLEANER = null;
            UNMAP_SUPPORTED = false;
            UNMAP_NOT_SUPPORTED_REASON = objDoPrivileged.toString();
        }
    }

    private CleanerUtil() {
    }

    public static BufferCleaner getCleaner() {
        return CLEANER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$newBufferCleaner$1(Class cls, MethodHandle methodHandle, ByteBuffer byteBuffer) throws IOException {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("unmapping only works with direct buffers");
        }
        if (!cls.isInstance(byteBuffer)) {
            throw new IllegalArgumentException("buffer is not an instance of ".concat(cls.getName()));
        }
        Throwable th = (Throwable) AccessController.doPrivileged(new D4.a(methodHandle, byteBuffer, 1));
        if (th != null) {
            throw new IOException("Unable to unmap the mapped buffer", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Throwable lambda$null$0(MethodHandle methodHandle, ByteBuffer byteBuffer) {
        try {
            (void) methodHandle.invokeExact(byteBuffer);
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    private static BufferCleaner newBufferCleaner(final Class<?> cls, final MethodHandle methodHandle) {
        return new BufferCleaner() { // from class: org.apache.poi.poifs.nio.a
            @Override // org.apache.poi.poifs.nio.CleanerUtil.BufferCleaner
            public final void freeBuffer(ByteBuffer byteBuffer) throws IOException {
                CleanerUtil.lambda$newBufferCleaner$1(cls, methodHandle, byteBuffer);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressForbidden("Java 9 Jigsaw allows access to sun.misc.Cleaner, so setAccessible works")
    public static Object unmapHackImpl() {
        Class cls = Void.TYPE;
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            try {
                Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                MethodHandle methodHandleFindVirtual = lookup.findVirtual(cls2, "invokeCleaner", MethodType.methodType((Class<?>) cls, (Class<?>) ByteBuffer.class));
                Field declaredField = cls2.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return newBufferCleaner(ByteBuffer.class, methodHandleFindVirtual.bindTo(declaredField.get(null)));
            } catch (ReflectiveOperationException | RuntimeException unused) {
                Class<?> cls3 = Class.forName("java.nio.DirectByteBuffer");
                Method method = cls3.getMethod("cleaner", null);
                method.setAccessible(true);
                MethodHandle methodHandleUnreflect = lookup.unreflect(method);
                Class<?> clsReturnType = methodHandleUnreflect.type().returnType();
                MethodHandle methodHandleFindVirtual2 = lookup.findVirtual(clsReturnType, "clean", MethodType.methodType(cls));
                Class cls4 = Boolean.TYPE;
                return newBufferCleaner(cls3, MethodHandles.filterReturnValue(methodHandleUnreflect, MethodHandles.guardWithTest(lookup.findStatic(Objects.class, "nonNull", MethodType.methodType((Class<?>) cls4, (Class<?>) Object.class)).asType(MethodType.methodType((Class<?>) cls4, clsReturnType)), methodHandleFindVirtual2, MethodHandles.dropArguments(MethodHandles.constant(Void.class, null).asType(MethodType.methodType(cls)), 0, (Class<?>[]) new Class[]{clsReturnType}))).asType(MethodType.methodType((Class<?>) cls, (Class<?>) ByteBuffer.class)));
            } catch (SecurityException e) {
                throw e;
            }
        } catch (ReflectiveOperationException | RuntimeException e6) {
            return "Unmapping is not supported on this platform, because internal Java APIs are not compatible with this Hadoop version: " + e6;
        } catch (SecurityException e7) {
            return "Unmapping is not supported, because not all required permissions are given to the Hadoop JAR file: " + e7 + " [Please grant at least the following permissions: RuntimePermission(\"accessClassInPackage.sun.misc\")  and ReflectPermission(\"suppressAccessChecks\")]";
        }
    }
}
