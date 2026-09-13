package androidx.core.graphics;

import O3.l;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l lVar) {
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            matrix = new Matrix();
        }
        int iSave = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withRotation(Canvas canvas, float f6, float f7, float f8, l lVar) {
        int iSave = canvas.save();
        canvas.rotate(f6, f7, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f6, float f7, float f8, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f7 = 0.0f;
        }
        if ((i5 & 4) != 0) {
            f8 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.rotate(f6, f7, f8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSave(Canvas canvas, l lVar) {
        int iSave = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withScale(Canvas canvas, float f6, float f7, float f8, float f9, l lVar) {
        int iSave = canvas.save();
        canvas.scale(f6, f7, f8, f9);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f6, float f7, float f8, float f9, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f6 = 1.0f;
        }
        if ((i5 & 2) != 0) {
            f7 = 1.0f;
        }
        if ((i5 & 4) != 0) {
            f8 = 0.0f;
        }
        if ((i5 & 8) != 0) {
            f9 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.scale(f6, f7, f8, f9);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withSkew(Canvas canvas, float f6, float f7, l lVar) {
        int iSave = canvas.save();
        canvas.skew(f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f6, float f7, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f7 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.skew(f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withTranslation(Canvas canvas, float f6, float f7, l lVar) {
        int iSave = canvas.save();
        canvas.translate(f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f6, float f7, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f6 = 0.0f;
        }
        if ((i5 & 2) != 0) {
            f7 = 0.0f;
        }
        int iSave = canvas.save();
        canvas.translate(f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, int i5, int i6, int i7, int i8, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(i5, i6, i7, i8);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, float f6, float f7, float f8, float f9, l lVar) {
        int iSave = canvas.save();
        canvas.clipRect(f6, f7, f8, f9);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    public static final void withClip(Canvas canvas, Path path, l lVar) {
        int iSave = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }
}
