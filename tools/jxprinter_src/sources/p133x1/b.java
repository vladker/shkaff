package p133x1;

import A1.a;
import A1.c;
import A1.e;
import A1.j;
import A1.k;
import A1.l;
import A1.m;
import A1.n;
import A1.o;
import A1.p;
import A1.q;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final Bitmap createNewBitmap(Bitmap bitmap, int i5, int i6) {
        E.f(bitmap, "<this>");
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i5, i6, config);
        E.e(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public static final Bitmap draw(Bitmap bitmap, c option) {
        E.f(bitmap, "<this>");
        E.f(option, "option");
        Bitmap bitmapCreateNewBitmap = createNewBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
        Canvas canvas = new Canvas(bitmapCreateNewBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        for (e eVar : option.getDrawPart()) {
            if (eVar instanceof j) {
                j jVar = (j) eVar;
                canvas.drawLine(jVar.getStart().x, jVar.getStart().y, jVar.getEnd().x, jVar.getEnd().y, jVar.getPaint());
            } else if (eVar instanceof q) {
                drawRect(canvas, (q) eVar);
            } else if (eVar instanceof m) {
                drawOval(canvas, (m) eVar);
            } else if (eVar instanceof p) {
                drawPoints(canvas, (p) eVar);
            } else if (eVar instanceof n) {
                drawPath(canvas, (n) eVar);
            }
        }
        return bitmapCreateNewBitmap;
    }

    public static final void drawOval(Canvas canvas, m drawPart) {
        E.f(canvas, "canvas");
        E.f(drawPart, "drawPart");
        canvas.drawOval(new RectF(drawPart.getRect()), drawPart.getPaint());
    }

    public static final void drawPath(Canvas canvas, n drawPart) {
        E.f(canvas, "canvas");
        E.f(drawPart, "drawPart");
        Path path = new Path();
        Object obj = drawPart.getMap().get("autoClose");
        E.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        for (o oVar : drawPart.getPaths()) {
            if (oVar instanceof l) {
                l lVar = (l) oVar;
                path.moveTo(lVar.getOffset().x, lVar.getOffset().y);
            } else if (oVar instanceof k) {
                k kVar = (k) oVar;
                path.lineTo(kVar.getOffset().x, kVar.getOffset().y);
            } else if (oVar instanceof a) {
                a aVar = (a) oVar;
                path.arcTo(new RectF(aVar.getRect()), aVar.getStart().floatValue(), aVar.getSweep().floatValue(), aVar.f22a);
            } else if (oVar instanceof A1.b) {
                A1.b bVar = (A1.b) oVar;
                int i5 = bVar.f23a;
                if (i5 == 2) {
                    path.quadTo(bVar.getControl1().x, bVar.getControl1().y, bVar.getTarget().x, bVar.getTarget().y);
                } else if (i5 == 3) {
                    float f6 = bVar.getControl1().x;
                    float f7 = bVar.getControl1().y;
                    Point control2 = bVar.getControl2();
                    E.c(control2);
                    path.cubicTo(f6, f7, control2.x, bVar.getControl2().y, bVar.getTarget().x, bVar.getTarget().y);
                }
            }
        }
        if (zBooleanValue) {
            path.close();
        }
        canvas.drawPath(path, drawPart.getPaint());
    }

    public static final void drawPoints(Canvas canvas, p drawPart) {
        E.f(canvas, "canvas");
        E.f(drawPart, "drawPart");
        List<Point> offsets = drawPart.getOffsets();
        Paint paint = drawPart.getPaint();
        for (Point point : offsets) {
            canvas.drawPoint(point.x, point.y, paint);
        }
    }

    public static final void drawRect(Canvas canvas, q drawPart) {
        E.f(canvas, "canvas");
        E.f(drawPart, "drawPart");
        canvas.drawRect(drawPart.getRect(), drawPart.getPaint());
    }
}
