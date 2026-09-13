package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0530z {

    @VisibleForTesting
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    public static final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f3127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final File f3128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile C0530z f3129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile int f3130i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3131a;
    public final int b;
    public final int c;

    @GuardedBy("this")
    private int decodesSinceLastFdCheck;

    @GuardedBy("this")
    private boolean isFdSizeBelowHardwareLimit = true;
    public final AtomicBoolean d = new AtomicBoolean(false);

    static {
        e = Build.VERSION.SDK_INT < 29;
        f3127f = true;
        f3128g = new File("/proc/self/fd");
        f3130i = -1;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0060  */
    /* JADX WARN: Code duplicated, block: B:14:0x0062  */
    @VisibleForTesting
    public C0530z() {
        boolean zContains;
        boolean z6;
        if (Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT != 27) {
                zContains = false;
            } else {
                zContains = Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
            }
            z6 = zContains ? false : true;
        } else {
            Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Build.MODEL.startsWith((String) it.next())) {
                    }
                } else {
                    if (Build.VERSION.SDK_INT != 27) {
                        zContains = false;
                    } else {
                        zContains = Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
                    }
                    if (zContains) {
                    }
                }
            }
        }
        this.f3131a = z6;
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
            this.c = 0;
        } else {
            this.b = 700;
            this.c = 128;
        }
    }

    public static C0530z a() {
        if (f3129h == null) {
            synchronized (C0530z.class) {
                try {
                    if (f3129h == null) {
                        f3129h = new C0530z();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3129h;
    }

    public final boolean b(int i5, int i6, boolean z6, boolean z7) {
        boolean z8;
        if (z6) {
            if (this.f3131a) {
                if (f3127f) {
                    if (!e || this.d.get()) {
                        if (!z7) {
                            int i7 = this.c;
                            if (i5 < i7) {
                                if (Log.isLoggable("HardwareConfig", 2)) {
                                    Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
                                    return false;
                                }
                            } else if (i6 >= i7) {
                                synchronized (this) {
                                    try {
                                        int i8 = this.decodesSinceLastFdCheck + 1;
                                        this.decodesSinceLastFdCheck = i8;
                                        if (i8 >= 50) {
                                            this.decodesSinceLastFdCheck = 0;
                                            int length = f3128g.list().length;
                                            long j6 = f3130i != -1 ? f3130i : this.b;
                                            boolean z9 = ((long) length) < j6;
                                            this.isFdSizeBelowHardwareLimit = z9;
                                            if (!z9 && Log.isLoggable("Downsampler", 5)) {
                                                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j6);
                                            }
                                        }
                                        z8 = this.isFdSizeBelowHardwareLimit;
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                                if (z8) {
                                    return true;
                                }
                                if (Log.isLoggable("HardwareConfig", 2)) {
                                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                                }
                            } else if (Log.isLoggable("HardwareConfig", 2)) {
                                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
                                return false;
                            }
                        } else if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (Log.isLoggable("HardwareConfig", 2)) {
                        Log.v("HardwareConfig", "Hardware config disallowed by app state");
                        return false;
                    }
                } else if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed by sdk");
                    return false;
                }
            } else if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
                return false;
            }
        } else if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed by caller");
            return false;
        }
        return false;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i5, int i6, BitmapFactory.Options options, boolean z6, boolean z7) {
        boolean zB = b(i5, i6, z6, z7);
        if (zB) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zB;
    }
}
