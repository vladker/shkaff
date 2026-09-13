package org.apache.commons.math3.ml.neuralnet.twod;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.ml.neuralnet.FeatureInitializer;
import org.apache.commons.math3.ml.neuralnet.Network;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.SquareNeighbourhood;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NeuronSquareMesh2D implements Iterable<Neuron>, Serializable {
    private static final long serialVersionUID = 1;
    private final long[][] identifiers;
    private final SquareNeighbourhood neighbourhood;
    private final Network network;
    private final int numberOfColumns;
    private final int numberOfRows;
    private final boolean wrapColumns;
    private final boolean wrapRows;

    /* JADX INFO: renamed from: org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection;

        static {
            int[] iArr = new int[SquareNeighbourhood.values().length];
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood = iArr;
            try {
                iArr[SquareNeighbourhood.MOORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood[SquareNeighbourhood.VON_NEUMANN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[VerticalDirection.values().length];
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection = iArr2;
            try {
                iArr2[VerticalDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection[VerticalDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection[VerticalDirection.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[HorizontalDirection.values().length];
            $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection = iArr3;
            try {
                iArr3[HorizontalDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection[HorizontalDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection[HorizontalDirection.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum HorizontalDirection {
        RIGHT,
        CENTER,
        LEFT
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 20130226;
        private final double[][][] featuresList;
        private final SquareNeighbourhood neighbourhood;
        private final boolean wrapColumns;
        private final boolean wrapRows;

        public SerializationProxy(boolean z6, boolean z7, SquareNeighbourhood squareNeighbourhood, double[][][] dArr) {
            this.wrapRows = z6;
            this.wrapColumns = z7;
            this.neighbourhood = squareNeighbourhood;
            this.featuresList = dArr;
        }

        private Object readResolve() {
            return new NeuronSquareMesh2D(this.wrapRows, this.wrapColumns, this.neighbourhood, this.featuresList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum VerticalDirection {
        UP,
        CENTER,
        DOWN
    }

    public NeuronSquareMesh2D(boolean z6, boolean z7, SquareNeighbourhood squareNeighbourhood, double[][][] dArr) {
        int length = dArr.length;
        this.numberOfRows = length;
        double[][] dArr2 = dArr[0];
        int length2 = dArr2.length;
        this.numberOfColumns = length2;
        if (length < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(length), 2, true);
        }
        if (length2 < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(length2), 2, true);
        }
        this.wrapRows = z6;
        this.wrapColumns = z7;
        this.neighbourhood = squareNeighbourhood;
        this.network = new Network(0L, dArr2[0].length);
        this.identifiers = (long[][]) Array.newInstance((Class<?>) Long.TYPE, length, length2);
        for (int i5 = 0; i5 < this.numberOfRows; i5++) {
            for (int i6 = 0; i6 < this.numberOfColumns; i6++) {
                this.identifiers[i5][i6] = this.network.createNeuron(dArr[i5][i6]);
            }
        }
        createLinks();
    }

    private void createLinks() {
        ArrayList arrayList = new ArrayList();
        int i5 = this.numberOfRows - 1;
        int i6 = this.numberOfColumns - 1;
        for (int i7 = 0; i7 < this.numberOfRows; i7++) {
            for (int i8 = 0; i8 < this.numberOfColumns; i8++) {
                arrayList.clear();
                int i9 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$neuralnet$SquareNeighbourhood[this.neighbourhood.ordinal()];
                if (i9 == 1) {
                    if (i7 > 0) {
                        if (i8 > 0) {
                            arrayList.add(Long.valueOf(this.identifiers[i7 - 1][i8 - 1]));
                        }
                        if (i8 < i6) {
                            arrayList.add(Long.valueOf(this.identifiers[i7 - 1][i8 + 1]));
                        }
                    }
                    if (i7 < i5) {
                        if (i8 > 0) {
                            arrayList.add(Long.valueOf(this.identifiers[i7 + 1][i8 - 1]));
                        }
                        if (i8 < i6) {
                            arrayList.add(Long.valueOf(this.identifiers[i7 + 1][i8 + 1]));
                        }
                    }
                    if (this.wrapRows) {
                        if (i7 == 0) {
                            if (i8 > 0) {
                                arrayList.add(Long.valueOf(this.identifiers[i5][i8 - 1]));
                            }
                            if (i8 < i6) {
                                arrayList.add(Long.valueOf(this.identifiers[i5][i8 + 1]));
                            }
                        } else if (i7 == i5) {
                            if (i8 > 0) {
                                arrayList.add(Long.valueOf(this.identifiers[0][i8 - 1]));
                            }
                            if (i8 < i6) {
                                arrayList.add(Long.valueOf(this.identifiers[0][i8 + 1]));
                            }
                        }
                    }
                    if (this.wrapColumns) {
                        if (i8 == 0) {
                            if (i7 > 0) {
                                arrayList.add(Long.valueOf(this.identifiers[i7 - 1][i6]));
                            }
                            if (i7 < i5) {
                                arrayList.add(Long.valueOf(this.identifiers[i7 + 1][i6]));
                            }
                        } else if (i8 == i6) {
                            if (i7 > 0) {
                                arrayList.add(Long.valueOf(this.identifiers[i7 - 1][0]));
                            }
                            if (i7 < i5) {
                                arrayList.add(Long.valueOf(this.identifiers[i7 + 1][0]));
                            }
                        }
                    }
                    if (this.wrapRows && this.wrapColumns) {
                        if (i7 == 0 && i8 == 0) {
                            arrayList.add(Long.valueOf(this.identifiers[i5][i6]));
                        } else if (i7 == 0 && i8 == i6) {
                            arrayList.add(Long.valueOf(this.identifiers[i5][0]));
                        } else if (i7 == i5 && i8 == 0) {
                            arrayList.add(Long.valueOf(this.identifiers[0][i6]));
                        } else if (i7 == i5 && i8 == i6) {
                            arrayList.add(Long.valueOf(this.identifiers[0][0]));
                        }
                    }
                } else if (i9 != 2) {
                    throw new MathInternalError();
                }
                if (i7 > 0) {
                    arrayList.add(Long.valueOf(this.identifiers[i7 - 1][i8]));
                }
                if (i7 < i5) {
                    arrayList.add(Long.valueOf(this.identifiers[i7 + 1][i8]));
                }
                if (this.wrapRows) {
                    if (i7 == 0) {
                        arrayList.add(Long.valueOf(this.identifiers[i5][i8]));
                    } else if (i7 == i5) {
                        arrayList.add(Long.valueOf(this.identifiers[0][i8]));
                    }
                }
                if (i8 > 0) {
                    arrayList.add(Long.valueOf(this.identifiers[i7][i8 - 1]));
                }
                if (i8 < i6) {
                    arrayList.add(Long.valueOf(this.identifiers[i7][i8 + 1]));
                }
                if (this.wrapColumns) {
                    if (i8 == 0) {
                        arrayList.add(Long.valueOf(this.identifiers[i7][i6]));
                    } else if (i8 == i6) {
                        arrayList.add(Long.valueOf(this.identifiers[i7][0]));
                    }
                }
                Neuron neuron = this.network.getNeuron(this.identifiers[i7][i8]);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    this.network.addLink(neuron, this.network.getNeuron(((Long) obj).longValue()));
                }
            }
        }
    }

    private int[] getLocation(int i5, int i6, HorizontalDirection horizontalDirection, VerticalDirection verticalDirection) {
        int i7;
        int i8 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$HorizontalDirection[horizontalDirection.ordinal()];
        int i9 = -1;
        if (i8 == 1) {
            i7 = -1;
        } else if (i8 == 2) {
            i7 = 1;
        } else {
            if (i8 != 3) {
                throw new MathInternalError();
            }
            i7 = 0;
        }
        int i10 = i6 + i7;
        if (this.wrapColumns) {
            i10 = i10 < 0 ? i10 + this.numberOfColumns : i10 % this.numberOfColumns;
        }
        int i11 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$ml$neuralnet$twod$NeuronSquareMesh2D$VerticalDirection[verticalDirection.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                i9 = 1;
            } else {
                if (i11 != 3) {
                    throw new MathInternalError();
                }
                i9 = 0;
            }
        }
        int i12 = i5 + i9;
        if (this.wrapRows) {
            i12 = i12 < 0 ? i12 + this.numberOfRows : i12 % this.numberOfRows;
        }
        if (i12 < 0 || i12 >= this.numberOfRows || i10 < 0 || i10 >= this.numberOfColumns) {
            return null;
        }
        return new int[]{i12, i10};
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new IllegalStateException();
    }

    private Object writeReplace() {
        double[][][] dArr = (double[][][]) Array.newInstance((Class<?>) double[].class, this.numberOfRows, this.numberOfColumns);
        for (int i5 = 0; i5 < this.numberOfRows; i5++) {
            for (int i6 = 0; i6 < this.numberOfColumns; i6++) {
                dArr[i5][i6] = getNeuron(i5, i6).getFeatures();
            }
        }
        return new SerializationProxy(this.wrapRows, this.wrapColumns, this.neighbourhood, dArr);
    }

    public synchronized NeuronSquareMesh2D copy() {
        long[][] jArr;
        try {
            jArr = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.numberOfRows, this.numberOfColumns);
            for (int i5 = 0; i5 < this.numberOfRows; i5++) {
                for (int i6 = 0; i6 < this.numberOfColumns; i6++) {
                    jArr[i5][i6] = this.identifiers[i5][i6];
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return new NeuronSquareMesh2D(this.wrapRows, this.wrapColumns, this.neighbourhood, this.network.copy(), jArr);
    }

    public Network getNetwork() {
        return this.network;
    }

    public Neuron getNeuron(int i5, int i6) {
        if (i5 < 0 || i5 >= this.numberOfRows) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(this.numberOfRows - 1));
        }
        if (i6 < 0 || i6 >= this.numberOfColumns) {
            throw new OutOfRangeException(Integer.valueOf(i6), 0, Integer.valueOf(this.numberOfColumns - 1));
        }
        return this.network.getNeuron(this.identifiers[i5][i6]);
    }

    public int getNumberOfColumns() {
        return this.numberOfColumns;
    }

    public int getNumberOfRows() {
        return this.numberOfRows;
    }

    @Override // java.lang.Iterable
    public Iterator<Neuron> iterator() {
        return this.network.iterator();
    }

    public Neuron getNeuron(int i5, int i6, HorizontalDirection horizontalDirection, VerticalDirection verticalDirection) {
        int[] location = getLocation(i5, i6, horizontalDirection, verticalDirection);
        if (location == null) {
            return null;
        }
        return getNeuron(location[0], location[1]);
    }

    public NeuronSquareMesh2D(int i5, boolean z6, int i6, boolean z7, SquareNeighbourhood squareNeighbourhood, FeatureInitializer[] featureInitializerArr) {
        if (i5 < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(i5), 2, true);
        }
        if (i6 >= 2) {
            this.numberOfRows = i5;
            this.wrapRows = z6;
            this.numberOfColumns = i6;
            this.wrapColumns = z7;
            this.neighbourhood = squareNeighbourhood;
            this.identifiers = (long[][]) Array.newInstance((Class<?>) Long.TYPE, i5, i6);
            int length = featureInitializerArr.length;
            this.network = new Network(0L, length);
            for (int i7 = 0; i7 < i5; i7++) {
                for (int i8 = 0; i8 < i6; i8++) {
                    double[] dArr = new double[length];
                    for (int i9 = 0; i9 < length; i9++) {
                        dArr[i9] = featureInitializerArr[i9].value();
                    }
                    this.identifiers[i7][i8] = this.network.createNeuron(dArr);
                }
            }
            createLinks();
            return;
        }
        throw new NumberIsTooSmallException(Integer.valueOf(i6), 2, true);
    }

    private NeuronSquareMesh2D(boolean z6, boolean z7, SquareNeighbourhood squareNeighbourhood, Network network, long[][] jArr) {
        this.numberOfRows = jArr.length;
        this.numberOfColumns = jArr[0].length;
        this.wrapRows = z6;
        this.wrapColumns = z7;
        this.neighbourhood = squareNeighbourhood;
        this.network = network;
        this.identifiers = jArr;
    }
}
