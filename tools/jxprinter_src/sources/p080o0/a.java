package p080o0;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.internal.operators.observable.C0953x2;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6433a;
    public final d b;

    public a(Context context, C0953x2 c0953x2, d dVar, C0953x2 c0953x3) {
        this.f6433a = context;
        this.b = dVar;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x01dd  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        ?? IsLocationEnabled;
        String str = methodCall.method;
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    b = 0;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    b = 1;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    b = 2;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    b = 3;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    b = 4;
                }
                break;
        }
        Context context = this.f6433a;
        d dVar = this.b;
        switch (b) {
            case 0:
                int i5 = Integer.parseInt(methodCall.arguments.toString());
                Objects.requireNonNull(result);
                if (context == null) {
                    Log.d("permissions_handler", "Context cannot be null.");
                    result.error("PermissionHandler.ServiceManager", "Android context cannot be null.", null);
                } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
                        if (locationManager == null) {
                            IsLocationEnabled = 0;
                        } else {
                            IsLocationEnabled = locationManager.isLocationEnabled();
                        }
                    } else {
                        try {
                            if (Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0) {
                                IsLocationEnabled = 1;
                            } else {
                                IsLocationEnabled = 0;
                            }
                        } catch (Settings.SettingNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    result.success(Integer.valueOf((int) IsLocationEnabled));
                } else if (i5 == 21) {
                    result.success(Integer.valueOf(((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled() ? 1 : 0));
                } else if (i5 == 8) {
                    PackageManager packageManager = context.getPackageManager();
                    if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
                        result.success(2);
                    } else {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null || telephonyManager.getPhoneType() == 0) {
                            result.success(2);
                        } else {
                            Intent intent = new Intent("android.intent.action.CALL");
                            intent.setData(Uri.parse("tel:123123"));
                            if ((Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(intent, 0)).isEmpty()) {
                                result.success(2);
                            } else if (telephonyManager.getSimState() == 5) {
                                result.success(1);
                            } else {
                                result.success(0);
                            }
                        }
                    }
                } else if (i5 != 16) {
                    result.success(2);
                } else {
                    result.success(1);
                }
                break;
            case 1:
                int i6 = Integer.parseInt(methodCall.arguments.toString());
                Objects.requireNonNull(result);
                dVar.e(i6, new P1.a(result, 6), new P1.a(result, 7));
                break;
            case 2:
                int i7 = Integer.parseInt(methodCall.arguments.toString());
                Objects.requireNonNull(result);
                result.success(Integer.valueOf(dVar.a(i7)));
                break;
            case 3:
                Objects.requireNonNull(result);
                if (context == null) {
                    Log.d("permissions_handler", "Context cannot be null.");
                    result.error("PermissionHandler.AppSettingsManager", "Android context cannot be null.", null);
                } else {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent2.addCategory("android.intent.category.DEFAULT");
                        intent2.setData(Uri.parse("package:" + context.getPackageName()));
                        intent2.addFlags(268435456);
                        intent2.addFlags(1073741824);
                        intent2.addFlags(8388608);
                        context.startActivity(intent2);
                        result.success(Boolean.TRUE);
                    } catch (Exception unused) {
                        result.success(Boolean.FALSE);
                        return;
                    }
                }
                break;
            case 4:
                List list = (List) methodCall.arguments();
                Objects.requireNonNull(result);
                dVar.d(list, new P1.a(result, 4), new P1.a(result, 5));
                break;
            default:
                result.notImplemented();
                break;
        }
    }
}
