package pl.umcs.diseasesimulation.aplication.modelingmethods.sir;

import pl.umcs.diseasesimulation.aplication.modelingmethods.MathUtils;

public abstract class SirDayModeler {
    public static void modelDay(SirData data, int different) {

        for (int i=0 ; i<different ; i++) {
            double maxFractional = MathUtils.maxFractional(data.s, data.i, data.r);

            if (MathUtils.fractional(data.s) == maxFractional)
                data.s = Math.floor(data.s) + 1.0;
            else if (MathUtils.fractional(data.i) == maxFractional)
                data.i = Math.floor(data.i) + 1.0;
            else if (MathUtils.fractional(data.r) == maxFractional)
                data.r = Math.floor(data.r) + 1.0;
        }
    }
}
