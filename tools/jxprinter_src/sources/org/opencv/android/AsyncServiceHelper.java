package org.opencv.android;

import A3.AbstractC0157z;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.a;
import java.io.File;
import java.util.StringTokenizer;
import org.opencv.core.Core;
import org.opencv.engine.OpenCVEngineInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class AsyncServiceHelper {
    protected static final int MINIMUM_ENGINE_VERSION = 2;
    protected static final String OPEN_CV_SERVICE_URL = "market://details?id=org.opencv.engine";
    protected static final String TAG = "OpenCVManager/Helper";
    protected static boolean mLibraryInstallationProgress = false;
    protected static boolean mServiceInstallationProgress = false;
    protected Context mAppContext;
    protected OpenCVEngineInterface mEngineService;
    protected String mOpenCVersion;
    protected ServiceConnection mServiceConnection = new ServiceConnection() { // from class: org.opencv.android.AsyncServiceHelper.3
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(AsyncServiceHelper.TAG, "Service connection created");
            AsyncServiceHelper.this.mEngineService = OpenCVEngineInterface.Stub.asInterface(iBinder);
            OpenCVEngineInterface openCVEngineInterface = AsyncServiceHelper.this.mEngineService;
            if (openCVEngineInterface == null) {
                Log.d(AsyncServiceHelper.TAG, "OpenCV Manager Service connection fails. May be service was not installed?");
                AsyncServiceHelper asyncServiceHelper = AsyncServiceHelper.this;
                AsyncServiceHelper.InstallService(asyncServiceHelper.mAppContext, asyncServiceHelper.mUserAppCallback);
                return;
            }
            int i5 = 0;
            AsyncServiceHelper.mServiceInstallationProgress = false;
            try {
                if (openCVEngineInterface.getEngineVersion() < 2) {
                    Log.d(AsyncServiceHelper.TAG, "Init finished with status 4");
                    Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                    AsyncServiceHelper asyncServiceHelper2 = AsyncServiceHelper.this;
                    asyncServiceHelper2.mAppContext.unbindService(asyncServiceHelper2.mServiceConnection);
                    Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                    AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(4);
                    return;
                }
                Log.d(AsyncServiceHelper.TAG, "Trying to get library path");
                AsyncServiceHelper asyncServiceHelper3 = AsyncServiceHelper.this;
                String libPathByVersion = asyncServiceHelper3.mEngineService.getLibPathByVersion(asyncServiceHelper3.mOpenCVersion);
                if (libPathByVersion != null && libPathByVersion.length() != 0) {
                    Log.d(AsyncServiceHelper.TAG, "Trying to get library list");
                    AsyncServiceHelper.mLibraryInstallationProgress = false;
                    AsyncServiceHelper asyncServiceHelper4 = AsyncServiceHelper.this;
                    String libraryList = asyncServiceHelper4.mEngineService.getLibraryList(asyncServiceHelper4.mOpenCVersion);
                    Log.d(AsyncServiceHelper.TAG, "Library list: \"" + libraryList + "\"");
                    Log.d(AsyncServiceHelper.TAG, "First attempt to load libs");
                    if (AsyncServiceHelper.this.initOpenCVLibs(libPathByVersion, libraryList)) {
                        Log.d(AsyncServiceHelper.TAG, "First attempt to load libs is OK");
                        for (String str : Core.getBuildInformation().split(System.getProperty("line.separator"))) {
                            Log.i(AsyncServiceHelper.TAG, str);
                        }
                    } else {
                        Log.d(AsyncServiceHelper.TAG, "First attempt to load libs fails");
                        i5 = 255;
                    }
                    Log.d(AsyncServiceHelper.TAG, "Init finished with status " + i5);
                    Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                    AsyncServiceHelper asyncServiceHelper5 = AsyncServiceHelper.this;
                    asyncServiceHelper5.mAppContext.unbindService(asyncServiceHelper5.mServiceConnection);
                    Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                    AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(i5);
                    return;
                }
                if (AsyncServiceHelper.mLibraryInstallationProgress) {
                    AsyncServiceHelper.this.mUserAppCallback.onPackageInstall(1, new InstallCallbackInterface() { // from class: org.opencv.android.AsyncServiceHelper.3.2
                        @Override // org.opencv.android.InstallCallbackInterface
                        public void cancel() {
                            Log.d(AsyncServiceHelper.TAG, "OpenCV library installation was canceled");
                            AsyncServiceHelper.mLibraryInstallationProgress = false;
                            Log.d(AsyncServiceHelper.TAG, "Init finished with status 3");
                            Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                            AsyncServiceHelper asyncServiceHelper6 = AsyncServiceHelper.this;
                            asyncServiceHelper6.mAppContext.unbindService(asyncServiceHelper6.mServiceConnection);
                            Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                            AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(3);
                        }

                        @Override // org.opencv.android.InstallCallbackInterface
                        public String getPackageName() {
                            return "OpenCV library";
                        }

                        @Override // org.opencv.android.InstallCallbackInterface
                        public void install() {
                            Log.e(AsyncServiceHelper.TAG, "Nothing to install we just wait current installation");
                        }

                        @Override // org.opencv.android.InstallCallbackInterface
                        public void wait_install() {
                            Log.d(AsyncServiceHelper.TAG, "Waiting for current installation");
                            try {
                                AsyncServiceHelper asyncServiceHelper6 = AsyncServiceHelper.this;
                                if (asyncServiceHelper6.mEngineService.installVersion(asyncServiceHelper6.mOpenCVersion)) {
                                    Log.d(AsyncServiceHelper.TAG, "Waiting for package installation");
                                } else {
                                    Log.d(AsyncServiceHelper.TAG, "OpenCV package was not installed!");
                                    Log.d(AsyncServiceHelper.TAG, "Init finished with status 2");
                                    Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                                    AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(2);
                                }
                                Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                                AsyncServiceHelper asyncServiceHelper7 = AsyncServiceHelper.this;
                                asyncServiceHelper7.mAppContext.unbindService(asyncServiceHelper7.mServiceConnection);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                Log.d(AsyncServiceHelper.TAG, "Init finished with status 255");
                                Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                                AsyncServiceHelper asyncServiceHelper8 = AsyncServiceHelper.this;
                                asyncServiceHelper8.mAppContext.unbindService(asyncServiceHelper8.mServiceConnection);
                                Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(255);
                            }
                        }
                    });
                } else {
                    AsyncServiceHelper.this.mUserAppCallback.onPackageInstall(0, new InstallCallbackInterface() { // from class: org.opencv.android.AsyncServiceHelper.3.1
                        @Override // org.opencv.android.InstallCallbackInterface
                        public void cancel() {
                            Log.d(AsyncServiceHelper.TAG, "OpenCV library installation was canceled");
                            Log.d(AsyncServiceHelper.TAG, "Init finished with status 3");
                            Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                            AsyncServiceHelper asyncServiceHelper6 = AsyncServiceHelper.this;
                            asyncServiceHelper6.mAppContext.unbindService(asyncServiceHelper6.mServiceConnection);
                            Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                            AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(3);
                        }

                        @Override // org.opencv.android.InstallCallbackInterface
                        public String getPackageName() {
                            return "OpenCV library";
                        }

                        @Override // org.opencv.android.InstallCallbackInterface
                        public void install() {
                            Log.d(AsyncServiceHelper.TAG, "Trying to install OpenCV lib via Google Play");
                            try {
                                AsyncServiceHelper asyncServiceHelper6 = AsyncServiceHelper.this;
                                if (asyncServiceHelper6.mEngineService.installVersion(asyncServiceHelper6.mOpenCVersion)) {
                                    AsyncServiceHelper.mLibraryInstallationProgress = true;
                                    Log.d(AsyncServiceHelper.TAG, "Package installation started");
                                    Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                                    AsyncServiceHelper asyncServiceHelper7 = AsyncServiceHelper.this;
                                    asyncServiceHelper7.mAppContext.unbindService(asyncServiceHelper7.mServiceConnection);
                                    return;
                                }
                                Log.d(AsyncServiceHelper.TAG, "OpenCV package was not installed!");
                                Log.d(AsyncServiceHelper.TAG, "Init finished with status 2");
                                Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                                AsyncServiceHelper asyncServiceHelper8 = AsyncServiceHelper.this;
                                asyncServiceHelper8.mAppContext.unbindService(asyncServiceHelper8.mServiceConnection);
                                Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(2);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                Log.d(AsyncServiceHelper.TAG, "Init finished with status 255");
                                Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                                AsyncServiceHelper asyncServiceHelper9 = AsyncServiceHelper.this;
                                asyncServiceHelper9.mAppContext.unbindService(asyncServiceHelper9.mServiceConnection);
                                Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(255);
                            }
                        }

                        @Override // org.opencv.android.InstallCallbackInterface
                        public void wait_install() {
                            Log.e(AsyncServiceHelper.TAG, "Installation was not started! Nothing to wait!");
                        }
                    });
                }
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.d(AsyncServiceHelper.TAG, "Init finished with status 255");
                Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                AsyncServiceHelper asyncServiceHelper6 = AsyncServiceHelper.this;
                asyncServiceHelper6.mAppContext.unbindService(asyncServiceHelper6.mServiceConnection);
                Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                AsyncServiceHelper.this.mUserAppCallback.onManagerConnected(255);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AsyncServiceHelper.this.mEngineService = null;
        }
    };
    protected LoaderCallbackInterface mUserAppCallback;

    public AsyncServiceHelper(String str, Context context, LoaderCallbackInterface loaderCallbackInterface) {
        this.mOpenCVersion = str;
        this.mUserAppCallback = loaderCallbackInterface;
        this.mAppContext = context;
    }

    public static void InstallService(Context context, LoaderCallbackInterface loaderCallbackInterface) {
        if (mServiceInstallationProgress) {
            Log.d(TAG, "Waiting current installation process");
            loaderCallbackInterface.onPackageInstall(1, new InstallCallbackInterface(context) { // from class: org.opencv.android.AsyncServiceHelper.2
                private LoaderCallbackInterface mUserAppCallback;
                final /* synthetic */ Context val$AppContext;

                {
                    this.val$AppContext = context;
                    this.mUserAppCallback = this.val$Callback;
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public void cancel() {
                    Log.d(AsyncServiceHelper.TAG, "Waiting for OpenCV canceled by user");
                    AsyncServiceHelper.mServiceInstallationProgress = false;
                    Log.d(AsyncServiceHelper.TAG, "Init finished with status 3");
                    Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                    this.mUserAppCallback.onManagerConnected(3);
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public String getPackageName() {
                    return "OpenCV Manager";
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public void install() {
                    Log.e(AsyncServiceHelper.TAG, "Nothing to install we just wait current installation");
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public void wait_install() {
                    AsyncServiceHelper.InstallServiceQuiet(this.val$AppContext);
                }
            });
        } else {
            Log.d(TAG, "Request new service installation");
            loaderCallbackInterface.onPackageInstall(0, new InstallCallbackInterface(context) { // from class: org.opencv.android.AsyncServiceHelper.1
                private LoaderCallbackInterface mUserAppCallback;
                final /* synthetic */ Context val$AppContext;

                {
                    this.val$AppContext = context;
                    this.mUserAppCallback = this.val$Callback;
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public void cancel() {
                    Log.d(AsyncServiceHelper.TAG, "OpenCV library installation was canceled");
                    Log.d(AsyncServiceHelper.TAG, "Init finished with status 3");
                    Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                    this.mUserAppCallback.onManagerConnected(3);
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public String getPackageName() {
                    return "OpenCV Manager";
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public void install() {
                    Log.d(AsyncServiceHelper.TAG, "Trying to install OpenCV Manager via Google Play");
                    if (AsyncServiceHelper.InstallServiceQuiet(this.val$AppContext)) {
                        AsyncServiceHelper.mServiceInstallationProgress = true;
                        Log.d(AsyncServiceHelper.TAG, "Package installation started");
                        return;
                    }
                    Log.d(AsyncServiceHelper.TAG, "OpenCV package was not installed!");
                    Log.d(AsyncServiceHelper.TAG, "Init finished with status 2");
                    Log.d(AsyncServiceHelper.TAG, "Unbind from service");
                    Log.d(AsyncServiceHelper.TAG, "Calling using callback");
                    this.mUserAppCallback.onManagerConnected(2);
                }

                @Override // org.opencv.android.InstallCallbackInterface
                public void wait_install() {
                    Log.e(AsyncServiceHelper.TAG, "Installation was not started! Nothing to wait!");
                }
            });
        }
    }

    public static boolean InstallServiceQuiet(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(OPEN_CV_SERVICE_URL));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean initOpenCV(String str, Context context, LoaderCallbackInterface loaderCallbackInterface) {
        AsyncServiceHelper asyncServiceHelper = new AsyncServiceHelper(str, context, loaderCallbackInterface);
        Intent intent = new Intent("org.opencv.engine.BIND");
        intent.setPackage("org.opencv.engine");
        if (context.bindService(intent, asyncServiceHelper.mServiceConnection, 1)) {
            return true;
        }
        context.unbindService(asyncServiceHelper.mServiceConnection);
        InstallService(context, loaderCallbackInterface);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initOpenCVLibs(String str, String str2) {
        Log.d(TAG, "Trying to init OpenCV libs");
        if (str == null || str.length() == 0) {
            Log.d(TAG, "Library path \"" + str + "\" is empty");
            return false;
        }
        if (str2 == null || str2.length() == 0) {
            return loadLibrary(AbstractC0157z.s(a.r(str), File.separator, "libopencv_java4.so"));
        }
        Log.d(TAG, "Trying to load libs by dependency list");
        StringTokenizer stringTokenizer = new StringTokenizer(str2, ";");
        boolean zLoadLibrary = true;
        while (stringTokenizer.hasMoreTokens()) {
            StringBuilder sbR = a.r(str);
            sbR.append(File.separator);
            sbR.append(stringTokenizer.nextToken());
            zLoadLibrary &= loadLibrary(sbR.toString());
        }
        return zLoadLibrary;
    }

    private boolean loadLibrary(String str) {
        Log.d(TAG, "Trying to load library " + str);
        try {
            System.load(str);
            Log.d(TAG, "OpenCV libs init was ok!");
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.d(TAG, "Cannot load library \"" + str + "\"");
            e.printStackTrace();
            return false;
        }
    }
}
