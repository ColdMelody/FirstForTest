package effectivejava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bill on 2016/6/21.
 * 为每个枚举绑定操作
 */
public enum Operation {
    PLUS("+") {
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    private static final Map<String, Operation> stringToEnum = new HashMap<>();

    static {
        for (Operation operation : values()) {
            stringToEnum.put(operation.toString(), operation);
        }
    }

    /**
     * 根据标志获得枚举名称
     * @param symbol 字符串标志
     * @return 枚举名称
     */
    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    public static void main(String args[]) {
        double x = 4.f;
        double y = 2.0f;
        for (Operation operation : Operation.values()) {
            System.out.printf("%s %f %s %f = %f%n", fromString(operation.toString()),x, operation, y, operation.apply(x, y));

        }
    }
}
