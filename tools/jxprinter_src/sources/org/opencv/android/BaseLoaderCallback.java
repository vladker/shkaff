package org.opencv.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseLoaderCallback implements LoaderCallbackInterface {
    private static final String TAG = "OCV/BaseLoaderCallback";
    protected Context mAppContext;

    public BaseLoaderCallback(Context context) {
        this.mAppContext = context;
    }

    public void finish() {
        ((Activity) this.mAppContext).finish();
    }

    @Override // org.opencv.android.LoaderCallbackInterface
    public void onManagerConnected(int i5) {
        if (i5 != 0) {
            if (i5 == 2) {
                Log.e(TAG, "Package installation failed!");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mAppContext).create();
                alertDialogCreate.setTitle("OpenCV Manager");
                alertDialogCreate.setMessage("Package installation failed!");
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.setButton(-1, "OK", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i6) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                alertDialogCreate.show();
                return;
            }
            if (i5 == 3) {
                Log.d(TAG, "OpenCV library installation was canceled by user");
                finish();
                return;
            }
            if (i5 != 4) {
                Log.e(TAG, "OpenCV loading failed!");
                AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.mAppContext).create();
                alertDialogCreate2.setTitle("OpenCV error");
                alertDialogCreate2.setMessage("OpenCV was not initialised correctly. Application will be shut down");
                alertDialogCreate2.setCancelable(false);
                alertDialogCreate2.setButton(-1, "OK", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i6) {
                        BaseLoaderCallback.this.finish();
                    }
                });
                alertDialogCreate2.show();
                return;
            }
            Log.d(TAG, "OpenCV Manager Service is uncompatible with this app!");
            AlertDialog alertDialogCreate3 = new AlertDialog.Builder(this.mAppContext).create();
            alertDialogCreate3.setTitle("OpenCV Manager");
            alertDialogCreate3.setMessage("OpenCV Manager service is incompatible with this app. Try to update it via Google Play.");
            alertDialogCreate3.setCancelable(false);
            alertDialogCreate3.setButton(-1, "OK", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    BaseLoaderCallback.this.finish();
                }
            });
            alertDialogCreate3.show();
        }
    }

    @Override // org.opencv.android.LoaderCallbackInterface
    public void onPackageInstall(int i5, final InstallCallbackInterface installCallbackInterface) {
        if (i5 != 0) {
            if (i5 != 1) {
                return;
            }
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.mAppContext).create();
            alertDialogCreate.setTitle("OpenCV is not ready");
            alertDialogCreate.setMessage("Installation is in progress. Wait or exit?");
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.setButton(-1, "Wait", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    installCallbackInterface.wait_install();
                }
            });
            alertDialogCreate.setButton(-2, "Exit", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    installCallbackInterface.cancel();
                }
            });
            alertDialogCreate.show();
            return;
        }
        AlertDialog alertDialogCreate2 = new AlertDialog.Builder(this.mAppContext).create();
        alertDialogCreate2.setTitle("Package not found");
        alertDialogCreate2.setMessage(installCallbackInterface.getPackageName() + " package was not found! Try to install it?");
        alertDialogCreate2.setCancelable(false);
        alertDialogCreate2.setButton(-1, "Yes", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                installCallbackInterface.install();
            }
        });
        alertDialogCreate2.setButton(-2, "No", new DialogInterface.OnClickListener() { // from class: org.opencv.android.BaseLoaderCallback.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                installCallbackInterface.cancel();
            }
        });
        alertDialogCreate2.show();
    }
}
