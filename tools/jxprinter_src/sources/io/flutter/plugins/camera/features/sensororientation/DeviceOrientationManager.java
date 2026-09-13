package io.flutter.plugins.camera.features.sensororientation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugins.camera.DartMessenger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceOrientationManager {
    private static final IntentFilter orientationIntentFilter = new IntentFilter("android.intent.action.CONFIGURATION_CHANGED");
    private final Activity activity;
    private BroadcastReceiver broadcastReceiver;
    private final boolean isFrontFacing;
    private PlatformChannel.DeviceOrientation lastOrientation;
    private final DartMessenger messenger;
    private final int sensorOrientation;

    /* JADX INFO: renamed from: io.flutter.plugins.camera.features.sensororientation.DeviceOrientationManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation;

        static {
            int[] iArr = new int[PlatformChannel.DeviceOrientation.values().length];
            $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation = iArr;
            try {
                iArr[PlatformChannel.DeviceOrientation.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private DeviceOrientationManager(@NonNull Activity activity, @NonNull DartMessenger dartMessenger, boolean z6, int i5) {
        this.activity = activity;
        this.messenger = dartMessenger;
        this.isFrontFacing = z6;
        this.sensorOrientation = i5;
    }

    @NonNull
    public static DeviceOrientationManager create(@NonNull Activity activity, @NonNull DartMessenger dartMessenger, boolean z6, int i5) {
        return new DeviceOrientationManager(activity, dartMessenger, z6, i5);
    }

    @VisibleForTesting
    public static void handleOrientationChange(PlatformChannel.DeviceOrientation deviceOrientation, PlatformChannel.DeviceOrientation deviceOrientation2, DartMessenger dartMessenger) {
        if (deviceOrientation.equals(deviceOrientation2)) {
            return;
        }
        dartMessenger.sendDeviceOrientationChangeEvent(deviceOrientation);
    }

    @VisibleForTesting
    public PlatformChannel.DeviceOrientation calculateSensorOrientation(int i5) {
        int i6 = i5 + 45;
        if (getDeviceDefaultOrientation() == 2) {
            i6 = i5 + 135;
        }
        return new PlatformChannel.DeviceOrientation[]{PlatformChannel.DeviceOrientation.PORTRAIT_UP, PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT, PlatformChannel.DeviceOrientation.PORTRAIT_DOWN, PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT}[(i6 % 360) / 90];
    }

    @VisibleForTesting
    public int getDeviceDefaultOrientation() {
        Configuration configuration = this.activity.getResources().getConfiguration();
        int rotation = getDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    @VisibleForTesting
    public Display getDisplay() {
        return ((WindowManager) this.activity.getSystemService("window")).getDefaultDisplay();
    }

    @Nullable
    public PlatformChannel.DeviceOrientation getLastUIOrientation() {
        return this.lastOrientation;
    }

    public int getPhotoOrientation() {
        return getPhotoOrientation(this.lastOrientation);
    }

    @VisibleForTesting
    public PlatformChannel.DeviceOrientation getUIOrientation() {
        int rotation = getDisplay().getRotation();
        int i5 = this.activity.getResources().getConfiguration().orientation;
        if (i5 == 1) {
            return (rotation == 0 || rotation == 1) ? PlatformChannel.DeviceOrientation.PORTRAIT_UP : PlatformChannel.DeviceOrientation.PORTRAIT_DOWN;
        }
        if (i5 != 2) {
            return PlatformChannel.DeviceOrientation.PORTRAIT_UP;
        }
        return (rotation == 0 || rotation == 1) ? PlatformChannel.DeviceOrientation.LANDSCAPE_LEFT : PlatformChannel.DeviceOrientation.LANDSCAPE_RIGHT;
    }

    public int getVideoOrientation() {
        return getVideoOrientation(this.lastOrientation);
    }

    @VisibleForTesting
    public void handleUIOrientationChange() {
        PlatformChannel.DeviceOrientation uIOrientation = getUIOrientation();
        handleOrientationChange(uIOrientation, this.lastOrientation, this.messenger);
        this.lastOrientation = uIOrientation;
    }

    public void start() {
        if (this.broadcastReceiver != null) {
            return;
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: io.flutter.plugins.camera.features.sensororientation.DeviceOrientationManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                DeviceOrientationManager.this.handleUIOrientationChange();
            }
        };
        this.broadcastReceiver = broadcastReceiver;
        this.activity.registerReceiver(broadcastReceiver, orientationIntentFilter);
        this.broadcastReceiver.onReceive(this.activity, null);
    }

    public void stop() {
        BroadcastReceiver broadcastReceiver = this.broadcastReceiver;
        if (broadcastReceiver == null) {
            return;
        }
        this.activity.unregisterReceiver(broadcastReceiver);
        this.broadcastReceiver = null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0024  */
    public int getPhotoOrientation(@Nullable PlatformChannel.DeviceOrientation deviceOrientation) {
        int i5;
        if (deviceOrientation == null) {
            deviceOrientation = getUIOrientation();
        }
        int i6 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        if (i6 == 1) {
            i5 = 90;
        } else if (i6 != 2) {
            int i7 = 180;
            i5 = 0;
            if (i6 == 3) {
                if (!this.isFrontFacing) {
                    i7 = 0;
                }
                i5 = i7;
            } else if (i6 == 4) {
                if (this.isFrontFacing) {
                    i7 = 0;
                }
                i5 = i7;
            }
        } else {
            i5 = 270;
        }
        return ((i5 + this.sensorOrientation) + 270) % 360;
    }

    public int getVideoOrientation(@Nullable PlatformChannel.DeviceOrientation deviceOrientation) {
        if (deviceOrientation == null) {
            deviceOrientation = getUIOrientation();
        }
        int i5 = AnonymousClass2.$SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$DeviceOrientation[deviceOrientation.ordinal()];
        int i6 = 0;
        if (i5 != 1) {
            if (i5 == 2) {
                i6 = 180;
            } else if (i5 == 3) {
                i6 = 270;
            } else if (i5 == 4) {
                i6 = 90;
            }
        }
        if (this.isFrontFacing) {
            i6 *= -1;
        }
        return ((i6 + this.sensorOrientation) + 360) % 360;
    }
}
