package cn.bertsir.zbar;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CameraConfiguration {
    private static final double MAX_ASPECT_DISTORTION = 0.15d;
    private static final int MIN_PREVIEW_PIXELS = 153600;
    private static final String TAG = "CameraConfiguration";
    private Point cameraResolution;
    private final Context context;
    private Point screenResolution;

    public CameraConfiguration(Context context) {
        this.context = context;
    }

    private Point findBestPreviewSizeValue(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w(TAG, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: cn.bertsir.zbar.CameraConfiguration.1
            @Override // java.util.Comparator
            public int compare(Camera.Size size, Camera.Size size2) {
                int i5 = size.height * size.width;
                int i6 = size2.height * size2.width;
                if (i6 < i5) {
                    return -1;
                }
                return i6 > i5 ? 1 : 0;
            }
        });
        if (Log.isLoggable(TAG, 4)) {
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                Camera.Size size2 = (Camera.Size) obj;
                sb.append(size2.width);
                sb.append('x');
                sb.append(size2.height);
                sb.append(Chars.SPACE);
            }
            Log.i(TAG, "Supported preview sizes: " + ((Object) sb));
        }
        double d = ((double) point.x) / ((double) point.y);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size3 = (Camera.Size) it.next();
            int i6 = size3.width;
            int i7 = size3.height;
            if (i6 * i7 < MIN_PREVIEW_PIXELS) {
                it.remove();
            } else {
                boolean z6 = i6 < i7;
                int i8 = z6 ? i7 : i6;
                int i9 = z6 ? i6 : i7;
                if (Math.abs((((double) i8) / ((double) i9)) - d) > MAX_ASPECT_DISTORTION) {
                    it.remove();
                } else if (i8 == point.x && i9 == point.y) {
                    Point point2 = new Point(i6, i7);
                    Log.i(TAG, "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
            }
        }
        if (arrayList.isEmpty()) {
            Camera.Size previewSize2 = parameters.getPreviewSize();
            Point point3 = new Point(previewSize2.width, previewSize2.height);
            Log.i(TAG, "No suitable preview sizes, using default: " + point3);
            return point3;
        }
        Camera.Size size4 = (Camera.Size) arrayList.get(0);
        Point point4 = new Point(size4.width, size4.height);
        Log.i(TAG, "Using largest suitable preview size: " + point4);
        return point4;
    }

    private Point getDisplaySize(Display display) {
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    public Point getCameraResolution() {
        return this.cameraResolution;
    }

    public Point getScreenResolution() {
        return this.screenResolution;
    }

    public void initFromCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.screenResolution = getDisplaySize(((WindowManager) this.context.getSystemService("window")).getDefaultDisplay());
        Point point = new Point();
        Point point2 = this.screenResolution;
        point.x = point2.x;
        point.y = point2.y;
        int i5 = point2.x;
        int i6 = point2.y;
        if (i5 < i6) {
            point.x = i6;
            point.y = point2.x;
        }
        this.cameraResolution = findBestPreviewSizeValue(parameters, point);
    }

    public void setDesiredCameraParameters(Camera camera, boolean z6) {
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w(TAG, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Point point = this.cameraResolution;
        parameters.setPreviewSize(point.x, point.y);
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.cameraResolution;
            int i5 = point2.x;
            int i6 = previewSize.width;
            if (i5 != i6 || point2.y != previewSize.height) {
                point2.x = i6;
                point2.y = previewSize.height;
            }
        }
        camera.setDisplayOrientation(90);
    }
}
