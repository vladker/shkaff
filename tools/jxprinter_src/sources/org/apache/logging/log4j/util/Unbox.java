package org.apache.logging.log4j.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@PerformanceSensitive({"allocation"})
public class Unbox {
    private static final int BITS_PER_INT = 32;
    private static final Logger LOGGER = StatusLogger.getLogger();
    private static final int MASK;
    private static final int RINGBUFFER_MIN_SIZE = 32;
    private static final int RINGBUFFER_SIZE;
    private static ThreadLocal<State> threadLocalState;
    private static WebSafeState webSafeState;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class State {
        private int current;
        private final StringBuilder[] ringBuffer = new StringBuilder[Unbox.RINGBUFFER_SIZE];

        public State() {
            int i5 = 0;
            while (true) {
                StringBuilder[] sbArr = this.ringBuffer;
                if (i5 >= sbArr.length) {
                    return;
                }
                sbArr[i5] = new StringBuilder(21);
                i5++;
            }
        }

        public StringBuilder getStringBuilder() {
            StringBuilder[] sbArr = this.ringBuffer;
            int i5 = Unbox.MASK;
            int i6 = this.current;
            this.current = i6 + 1;
            StringBuilder sb = sbArr[i5 & i6];
            sb.setLength(0);
            return sb;
        }

        public boolean isBoxedPrimitive(StringBuilder sb) {
            int i5 = 0;
            while (true) {
                StringBuilder[] sbArr = this.ringBuffer;
                if (i5 >= sbArr.length) {
                    return false;
                }
                if (sb == sbArr[i5]) {
                    return true;
                }
                i5++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class WebSafeState {
        private final ThreadLocal<int[]> current;
        private final ThreadLocal<StringBuilder[]> ringBuffer;

        private WebSafeState() {
            this.ringBuffer = new ThreadLocal<>();
            this.current = new ThreadLocal<>();
        }

        public StringBuilder getStringBuilder() {
            StringBuilder[] sbArr = this.ringBuffer.get();
            if (sbArr == null) {
                int i5 = Unbox.RINGBUFFER_SIZE;
                StringBuilder[] sbArr2 = new StringBuilder[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    sbArr2[i6] = new StringBuilder(21);
                }
                this.ringBuffer.set(sbArr2);
                this.current.set(new int[1]);
                sbArr = sbArr2;
            }
            int[] iArr = this.current.get();
            int i7 = Unbox.MASK;
            int i8 = iArr[0];
            iArr[0] = i8 + 1;
            StringBuilder sb = sbArr[i7 & i8];
            sb.setLength(0);
            return sb;
        }

        public boolean isBoxedPrimitive(StringBuilder sb) {
            StringBuilder[] sbArr = this.ringBuffer.get();
            if (sbArr == null) {
                return false;
            }
            for (StringBuilder sb2 : sbArr) {
                if (sb == sb2) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        int iCalculateRingBufferSize = calculateRingBufferSize("log4j.unbox.ringbuffer.size");
        RINGBUFFER_SIZE = iCalculateRingBufferSize;
        MASK = iCalculateRingBufferSize - 1;
        threadLocalState = new ThreadLocal<>();
        webSafeState = new WebSafeState();
    }

    private Unbox() {
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(float f6) {
        StringBuilder sb = getSB();
        sb.append(f6);
        return sb;
    }

    private static int calculateRingBufferSize(String str) {
        String stringProperty = PropertiesUtil.getProperties().getStringProperty(str, String.valueOf(32));
        try {
            int i5 = Integer.parseInt(stringProperty.trim());
            if (i5 < 32) {
                LOGGER.warn("Invalid {} {}, using minimum size {}.", (Object) str, (Object) stringProperty, (Object) 32);
                i5 = 32;
            }
            return ceilingNextPowerOfTwo(i5);
        } catch (Exception unused) {
            LOGGER.warn("Invalid {} {}, using default size {}.", (Object) str, (Object) stringProperty, (Object) 32);
            return 32;
        }
    }

    private static int ceilingNextPowerOfTwo(int i5) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i5 - 1));
    }

    public static int getRingbufferSize() {
        return RINGBUFFER_SIZE;
    }

    private static StringBuilder getSB() {
        return Constants.ENABLE_THREADLOCALS ? getState().getStringBuilder() : webSafeState.getStringBuilder();
    }

    private static State getState() {
        State state = threadLocalState.get();
        if (state != null) {
            return state;
        }
        State state2 = new State();
        threadLocalState.set(state2);
        return state2;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(double d) {
        StringBuilder sb = getSB();
        sb.append(d);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(short s6) {
        StringBuilder sb = getSB();
        sb.append((int) s6);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(int i5) {
        StringBuilder sb = getSB();
        sb.append(i5);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(char c) {
        StringBuilder sb = getSB();
        sb.append(c);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(long j6) {
        StringBuilder sb = getSB();
        sb.append(j6);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(byte b) {
        StringBuilder sb = getSB();
        sb.append((int) b);
        return sb;
    }

    @PerformanceSensitive({"allocation"})
    public static StringBuilder box(boolean z6) {
        StringBuilder sb = getSB();
        sb.append(z6);
        return sb;
    }
}
