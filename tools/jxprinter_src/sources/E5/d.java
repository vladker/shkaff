package E5;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends TextureView implements a, TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f235a;
    public SurfaceTexture b;
    public Surface c;

    @Nullable
    private xyz.doikki.videoplayer.player.a mMediaPlayer;

    public d(Context context) {
        super(context);
        this.f235a = new b();
        setSurfaceTextureListener(this);
    }

    @Override // E5.a
    public void attachToPlayer(@NonNull xyz.doikki.videoplayer.player.a aVar) {
        this.mMediaPlayer = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x003e A[PHI: r11
  0x003e: PHI (r11v7 int) = (r11v5 int), (r11v9 int), (r11v12 int), (r11v14 int) binds: [B:38:0x005e, B:34:0x0053, B:31:0x004a, B:25:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        int[] iArr;
        int i7;
        b bVar = this.f235a;
        int i8 = bVar.d;
        if (i8 == 90 || i8 == 270) {
            int i9 = i5 + i6;
            i6 = i9 - i6;
            i5 = i9 - i6;
        }
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int i10 = bVar.b;
        if (i10 == 0 || (i7 = bVar.f234a) == 0) {
            iArr = new int[]{size, size2};
        } else {
            int i11 = bVar.c;
            if (i11 == 1) {
                i6 = (size / 16) * 9;
                if (size2 > i6) {
                    i5 = size;
                } else {
                    i5 = (size2 / 9) * 16;
                    i6 = size2;
                }
            } else if (i11 == 2) {
                i6 = (size / 4) * 3;
                if (size2 > i6) {
                    i5 = size;
                } else {
                    i5 = (size2 / 3) * 4;
                    i6 = size2;
                }
            } else if (i11 != 3) {
                if (i11 == 4) {
                    i6 = i10;
                    i5 = i7;
                } else if (i11 != 5) {
                    int i12 = i7 * size2;
                    int i13 = size * i10;
                    if (i12 < i13) {
                        i5 = i12 / i10;
                    } else if (i12 > i13) {
                        i6 = i13 / i7;
                        i5 = size;
                    } else {
                        i5 = size;
                    }
                    i6 = size2;
                } else {
                    int i14 = i7 * size2;
                    int i15 = size * i10;
                    if (i14 > i15) {
                        i5 = i14 / i10;
                        i6 = size2;
                    } else {
                        i6 = i15 / i7;
                        i5 = size;
                    }
                }
            }
            iArr = new int[]{i5, i6};
        }
        setMeasuredDimension(iArr[0], iArr[1]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i5, int i6) {
        SurfaceTexture surfaceTexture2 = this.b;
        if (surfaceTexture2 != null) {
            setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.b = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.c = surface;
        xyz.doikki.videoplayer.player.a aVar = this.mMediaPlayer;
        if (aVar != null) {
            xyz.doikki.videoplayer.player.c cVar = (xyz.doikki.videoplayer.player.c) aVar;
            try {
                cVar.b.setSurface(surface);
            } catch (Exception unused) {
                cVar.f8991a.f();
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void setScaleType(int i5) {
        this.f235a.c = i5;
        requestLayout();
    }

    public void setVideoRotation(int i5) {
        this.f235a.d = i5;
        setRotation(i5);
    }

    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i5, int i6) {
    }
}
