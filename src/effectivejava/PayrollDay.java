package effectivejava;

/**
 * Created by Bill on 2016/6/21.
 * 嵌套枚举，每添加一个一个枚举常量，就强制执行某种策略,这种模式为策略枚举
 */
public enum PayrollDay {
    MONDAY(PayType.WeekDay), TUESDAY(PayType.WeekDay), WENDESDAY(PayType.WeekDay), FOURSDAY(PayType.WeekDay), FRIDAY(PayType.WeekDay), SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    private enum PayType {
        WeekDay {
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? (hours - HOURS_PER_SHIFT) * 0 : payRate / 2;
            }
        },
        WEEKEND {
            @Override
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };
        private static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }

    }

}
