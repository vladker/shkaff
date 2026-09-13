package com.library.base.frame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.hjq.permissions.V;
import com.orhanobut.hawk.Hawk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int BLUETOOTH_REQUEST_CODE = 21845;
    public static final int REQUEST_BLUETOOTH_PERMISSIONS = 3;
    public static final int REQUEST_CAMERA_PERMISSIONS = 2;
    public static final int REQUEST_STORAGE_PERMISSIONS = 1;
    protected Fragment currentFragment;
    public b openBluetoothCallback;
    protected final String TAG = getClass().getSimpleName();
    protected HashMap<Integer, p026e2.a> requestPermissionMap = null;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ V f3560a;
        public final /* synthetic */ int b;

        public a(V v6, int i5) {
            this.f3560a = v6;
            this.b = i5;
        }

        @Override // com.library.base.frame.d
        public final void onCancel() {
            BaseActivity.this.doRequestPermissionFail(this.b);
        }

        @Override // com.library.base.frame.d
        public final void onConfirm() {
            this.f3560a.request(new com.library.base.frame.a(this));
        }
    }

    private static String getSystemProperty(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                    return line;
                } catch (IOException e) {
                    e.printStackTrace();
                    return line;
                }
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isMIUI() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("Xiaomi")) {
            return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
        }
        return true;
    }

    private void setAppLanguage(String str) {
        p051j0.a.k(this.TAG, "class: " + getClass().getName() + " setAppLanguage: " + str);
        Locale locale = str.split("_").length > 1 ? new Locale(str.split("_")[0], str.split("_")[1]) : new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = getResources().getConfiguration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    public abstract void activityConfigure();

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        Locale locale = str.split("_").length > 1 ? new Locale(str.split("_")[0], str.split("_")[1]) : new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        super.attachBaseContext(context.createConfigurationContext(configuration));
    }

    public void checkAndRequestPermissions(String[] strArr, c cVar, p026e2.a aVar) {
        int iNextInt;
        if (aVar != null) {
            do {
                iNextInt = new Random().nextInt(Integer.MAX_VALUE);
            } while (this.requestPermissionMap.containsKey(Integer.valueOf(iNextInt)));
            this.requestPermissionMap.put(Integer.valueOf(iNextInt), aVar);
        } else {
            iNextInt = 0;
        }
        V vWith = V.with(this);
        for (String str : strArr) {
            vWith.permission(str);
        }
        if (hasPermission(strArr)) {
            doRequestPermissionSuccess(iNextInt);
            return;
        }
        PermissionTipDialog permissionTipDialog = (PermissionTipDialog) cVar;
        permissionTipDialog.f2624a = new a(vWith, iNextInt);
        permissionTipDialog.show();
    }

    public int dip2px(float f6) {
        try {
            return (int) ((f6 * getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != null && motionEvent.getAction() == 0) {
            Rect rect = new Rect();
            currentFocus.getGlobalVisibleRect(rect);
            if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                currentFocus.clearFocus();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void doRequestPermissionFail(int i5) {
        p026e2.a aVar = this.requestPermissionMap.get(Integer.valueOf(i5));
        if (aVar != null) {
            aVar.onRequestPermissionFail();
            this.requestPermissionMap.remove(Integer.valueOf(i5));
        }
        for (Method method : getClass().getMethods()) {
            p005a2.a aVar2 = (p005a2.a) method.getAnnotation(p005a2.a.class);
            if (aVar2 != null && aVar2.requestCode() == i5) {
                try {
                    method.invoke(this, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void doRequestPermissionSuccess(int i5) {
        p026e2.a aVar = this.requestPermissionMap.get(Integer.valueOf(i5));
        if (aVar != null) {
            aVar.onRequestPermissionSuccess();
            this.requestPermissionMap.remove(Integer.valueOf(i5));
        }
        for (Method method : getClass().getMethods()) {
            p005a2.b bVar = (p005a2.b) method.getAnnotation(p005a2.b.class);
            if (bVar != null && bVar.requestCode() == i5) {
                try {
                    method.invoke(this, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void finishActivity() {
        V1.b.h().getClass();
        V1.b.b.remove(this);
        finish();
    }

    public String getCurrentLanguage() {
        return (String) Hawk.get("current_language", FrameApplication.defaultLang);
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void gotoActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    public void gotoActivityForResult(int i5, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, i5);
    }

    public void gotoActivityNotClose(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public boolean hasPermission(String... strArr) {
        return V.isGranted(this, strArr);
    }

    public boolean hasStoragePermission() {
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        return V.isGranted(this, strArr);
    }

    public abstract void initComponent();

    public abstract void initData();

    public abstract void initListener();

    public abstract int layoutId();

    public void needBlueToothPermission(c cVar, p026e2.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.BLUETOOTH_SCAN");
        arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
        arrayList.add("android.permission.BLUETOOTH_CONNECT");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        checkAndRequestPermissions((String[]) arrayList.toArray(new String[0]), cVar, aVar);
    }

    public void needCameraPermission(c cVar, p026e2.a aVar) {
        checkAndRequestPermissions(new String[]{"android.permission.CAMERA"}, cVar, aVar);
    }

    public void needStoragePermission(c cVar, p026e2.a aVar) {
        checkAndRequestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO"}, cVar, aVar);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        b bVar;
        if (i5 == 21845 && i6 == -1 && (bVar = this.openBluetoothCallback) != null) {
            bVar.openBluetoothSuccess();
            this.openBluetoothCallback = null;
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setAppLanguage(getCurrentLanguage());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        getWindow().getDecorView().setSystemUiVisibility(256);
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFFFF"));
        getWindow().getDecorView().setSystemUiVisibility(8448);
        this.requestPermissionMap = new HashMap<>();
        setAppLanguage((String) Hawk.get("current_language", FrameApplication.defaultLang));
        ARouter.getInstance().inject(this);
        activityConfigure();
        V1.b.h().getClass();
        if (V1.b.b.empty() || V1.b.b.lastElement() != this) {
            V1.b.b.add(this);
        }
        setContentView(layoutId());
        ButterKnife.bind(this);
        if (getIntent().getExtras() != null) {
            receiveDataFromPreActivity(getIntent().getExtras());
        }
        initComponent();
        initData();
        initListener();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        V1.b.h().getClass();
        V1.b.b.remove(this);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i5, @NonNull String[] strArr, @NonNull int[] iArr) {
        int length = iArr.length;
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                z6 = true;
                break;
            } else if (iArr[i6] != 0) {
                break;
            } else {
                i6++;
            }
        }
        p042h2.c.requestPermissionResult(strArr, iArr);
        if (z6) {
            doRequestPermissionSuccess(i5);
        } else {
            doRequestPermissionFail(i5);
        }
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        setAppLanguage(getCurrentLanguage());
    }

    @SuppressLint({"MissingPermission"})
    public void openBluetooth(b bVar) {
        this.openBluetoothCallback = bVar;
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), BLUETOOTH_REQUEST_CODE);
    }

    public abstract void receiveDataFromPreActivity(Bundle bundle);

    public void replaceFragment(int i5, Fragment fragment, String str) {
        boolean z6;
        this.currentFragment = fragment;
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            z6 = false;
        } else {
            z6 = true;
            fragment = fragmentFindFragmentByTag;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(i5, fragment, str);
        if (!z6) {
            fragmentTransactionBeginTransaction.addToBackStack(str);
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    public void runOnNewThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
