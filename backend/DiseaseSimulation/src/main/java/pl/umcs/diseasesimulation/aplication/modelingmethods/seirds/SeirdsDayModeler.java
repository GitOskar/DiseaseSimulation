package pl.umcs.diseasesimulation.aplication.modelingmethods.seirds;

import pl.umcs.diseasesimulation.aplication.modelingmethods.MathUtils;

public abstract class SeirdsDayModeler {

    public static void modelDay(SeirdsData data, int different) {
        for (int i=0 ; i<different ; i++) {
            double maxFractional = MathUtils.maxFractional(data.s, data.e, data.i, data.r, data.d);

            if (MathUtils.fractional(data.s) == maxFractional)
                data.s = Math.floor(data.s) + 1.0;
            else if (MathUtils.fractional(data.e) == maxFractional)
                data.e = Math.floor(data.e) + 1.0;
            else if (MathUtils.fractional(data.i) == maxFractional)
                data.i = Math.floor(data.i) + 1.0;
            else if (MathUtils.fractional(data.r) == maxFractional)
                data.r = Math.floor(data.r) + 1.0;
            else if (MathUtils.fractional(data.d) == maxFractional)
                data.d = Math.floor(data.d) + 1.0;
        }
    }
}
