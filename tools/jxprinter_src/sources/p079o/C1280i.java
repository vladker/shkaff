package p079o;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Type;
import p050j.a;
import p050j.d;
import p067m.b;
import p067m.g;
import p067m.h;
import p067m.i;
import p073n.p;

/* JADX INFO: renamed from: o.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1280i implements Q, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1280i f6412a = new C1280i();

    public static Color c(b bVar) {
        g gVar = bVar.e;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = gVar.f6092a;
            if (i9 == 13) {
                gVar.m();
                return new Color(i5, i6, i7, i8);
            }
            if (i9 != 4) {
                throw new d("syntax error");
            }
            String strJ = gVar.J();
            gVar.o();
            if (gVar.f6092a != 2) {
                throw new d("syntax error");
            }
            int iG = gVar.g();
            gVar.m();
            if (strJ.equalsIgnoreCase("r")) {
                i5 = iG;
            } else if (strJ.equalsIgnoreCase("g")) {
                i6 = iG;
            } else if (strJ.equalsIgnoreCase("b")) {
                i7 = iG;
            } else {
                if (!strJ.equalsIgnoreCase("alpha")) {
                    throw new d("syntax error, ".concat(strJ));
                }
                i8 = iG;
            }
            if (gVar.f6092a == 16) {
                gVar.n(4);
            }
        }
    }

    public static Font d(b bVar) {
        g gVar = bVar.e;
        int iG = 0;
        String strJ = null;
        int iG2 = 0;
        while (true) {
            int i5 = gVar.f6092a;
            if (i5 == 13) {
                gVar.m();
                return new Font(strJ, iG, iG2);
            }
            if (i5 != 4) {
                throw new d("syntax error");
            }
            String strJ2 = gVar.J();
            gVar.o();
            if (strJ2.equalsIgnoreCase("name")) {
                if (gVar.f6092a != 4) {
                    throw new d("syntax error");
                }
                strJ = gVar.J();
                gVar.m();
            } else if (strJ2.equalsIgnoreCase("style")) {
                if (gVar.f6092a != 2) {
                    throw new d("syntax error");
                }
                iG = gVar.g();
                gVar.m();
            } else {
                if (!strJ2.equalsIgnoreCase("size")) {
                    throw new d("syntax error, ".concat(strJ2));
                }
                if (gVar.f6092a != 2) {
                    throw new d("syntax error");
                }
                iG2 = gVar.g();
                gVar.m();
            }
            if (gVar.f6092a == 16) {
                gVar.n(4);
            }
        }
    }

    public static Point e(b bVar, Object obj) {
        int iE;
        g gVar = bVar.e;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = gVar.f6092a;
            if (i7 == 13) {
                gVar.m();
                return new Point(i5, i6);
            }
            if (i7 != 4) {
                throw new d("syntax error");
            }
            String strJ = gVar.J();
            if (a.c.equals(strJ)) {
                gVar.o();
                if (gVar.f6092a != 4) {
                    throw new d("type not match error");
                }
                if (!"java.awt.Point".equals(gVar.J())) {
                    throw new d("type not match error");
                }
                gVar.m();
                if (gVar.f6092a == 16) {
                    gVar.m();
                }
            } else {
                if ("$ref".equals(strJ)) {
                    gVar.o();
                    String strJ2 = gVar.J();
                    bVar.p(bVar.f6067f, obj);
                    bVar.b(new p067m.a(bVar.f6067f, strJ2));
                    bVar.o();
                    bVar.f6071j = 1;
                    gVar.n(13);
                    bVar.a(13);
                    return null;
                }
                gVar.o();
                int i8 = gVar.f6092a;
                if (i8 == 2) {
                    iE = gVar.g();
                    gVar.m();
                } else {
                    if (i8 != 3) {
                        throw new d("syntax error : ".concat(h.a(gVar.f6092a)));
                    }
                    iE = (int) gVar.e();
                    gVar.m();
                }
                if (strJ.equalsIgnoreCase("x")) {
                    i5 = iE;
                } else {
                    if (!strJ.equalsIgnoreCase("y")) {
                        throw new d("syntax error, ".concat(strJ));
                    }
                    i6 = iE;
                }
                if (gVar.f6092a == 16) {
                    gVar.n(4);
                }
            }
        }
    }

    public static Rectangle f(b bVar) {
        int iE;
        g gVar = bVar.e;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = gVar.f6092a;
            if (i9 == 13) {
                gVar.m();
                return new Rectangle(i5, i6, i7, i8);
            }
            if (i9 != 4) {
                throw new d("syntax error");
            }
            String strJ = gVar.J();
            gVar.o();
            int i10 = gVar.f6092a;
            if (i10 == 2) {
                iE = gVar.g();
                gVar.m();
            } else {
                if (i10 != 3) {
                    throw new d("syntax error");
                }
                iE = (int) gVar.e();
                gVar.m();
            }
            if (strJ.equalsIgnoreCase("x")) {
                i5 = iE;
            } else if (strJ.equalsIgnoreCase("y")) {
                i6 = iE;
            } else if (strJ.equalsIgnoreCase("width")) {
                i7 = iE;
            } else {
                if (!strJ.equalsIgnoreCase("height")) {
                    throw new d("syntax error, ".concat(strJ));
                }
                i8 = iE;
            }
            if (gVar.f6092a == 16) {
                gVar.n(4);
            }
        }
    }

    public static boolean g(Class cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    public static char h(b0 b0Var, Class cls) {
        if (!b0Var.d(c0.WriteClassName)) {
            return '{';
        }
        b0Var.write(123);
        b0Var.g(a.c);
        b0Var.q(cls.getName());
        return ',';
    }

    @Override // p073n.p
    public final int a() {
        return 12;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        Point pointD;
        g gVar = bVar.e;
        int i5 = gVar.f6092a;
        if (i5 == 8) {
            gVar.n(16);
            return null;
        }
        if (i5 != 12 && i5 != 16) {
            throw new d("syntax error");
        }
        gVar.m();
        if (type == Point.class) {
            pointD = e(bVar, obj);
        } else if (type == Rectangle.class) {
            pointD = f(bVar);
        } else if (type == Color.class) {
            pointD = c(bVar);
        } else {
            if (type != Font.class) {
                throw new d("not support awt class : " + type);
            }
            pointD = d(bVar);
        }
        i iVar = bVar.f6067f;
        bVar.p(pointD, obj);
        bVar.r(iVar);
        return pointD;
    }

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) {
        b0 b0Var = g6.f6325j;
        if (obj == null) {
            b0Var.n();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            b0Var.h(h(b0Var, Point.class), "x", point.x);
            b0Var.h(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            b0Var.j("name", h(b0Var, Font.class), font.getName());
            b0Var.h(',', "style", font.getStyle());
            b0Var.h(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            b0Var.h(h(b0Var, Rectangle.class), "x", rectangle.x);
            b0Var.h(',', "y", rectangle.y);
            b0Var.h(',', "width", rectangle.width);
            b0Var.h(',', "height", rectangle.height);
        } else {
            if (!(obj instanceof Color)) {
                throw new d("not support awt class : ".concat(obj.getClass().getName()));
            }
            Color color = (Color) obj;
            b0Var.h(h(b0Var, Color.class), "r", color.getRed());
            b0Var.h(',', "g", color.getGreen());
            b0Var.h(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                b0Var.h(',', "alpha", color.getAlpha());
            }
        }
        b0Var.write(125);
    }
}
