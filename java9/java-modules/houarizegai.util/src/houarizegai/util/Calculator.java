package houarizegai.util;

import util.internal.AddHelper;

public class Calculator {

    private AddHelper addHelper = new AddHelper();

    public int add(double a, double b) {
        return addHelper.add((int) a, (int) b);
    }
}
