package com.bill.xiaogu.emums;

public enum RecordSortEnum {

    INCOME_inverst(1, "投资款"),
    INCOME_order_income(2, "订单-收款"),
    EXPEND_order_refund(3, "订单-退款"),
    EXPEND_error_refund(4, "订单-错单退款"),
    EXPEND_gas(5, "煤气-支出"),
    INCOME_gar(6, "煤气-收入"),
    EXPEND_rent(7, "房租-支出"),
    INCOME_rent(8, "房租-收入"),
    EXPEND_store_basic(9, "店铺-基本支出"),
    INCOME_store_basic(10, "店铺-基本收入"),
    EXPAND_store_activity(11, "店铺-活动支出"),
    EXPAND_buy_goods(12, "进货-支出"),
    EXPAND_refund_goods(13, "进货-退款"),
    INCOME_meituan_canteen(14, "提现-美团堂食"),
    INCOME_meituan_waimai(15, "提现-美团外卖"),
    INCOME_eleme_waimai(16, "提现-饿了么外卖"),
    INCOME_waste(17, "提现-废品"),
    INCOME_charger(18, "提现-充电宝"),
    EXPAND_staff_basic(19, "员工-基本支出"),
    EXPAND_staff_salary(20, "员工-工资支出"),
    EXPAND_staff_rent(21, "员工-房租支出"),
    EXPAND_staff_refund(22, "员工-退款收入"),
    EXPAND_staff_reimbursement(23, "员工-报销"),

    EXPAND_shareholder_bonus(24, "股东分红");

    private int code;

    private String message;


    RecordSortEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * Msg string.
     *
     * @return the string
     */
    public String message() {
        return message;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    /**
     * Gets enum.
     *
     * @param message the message
     * @return the enum
     */
    public static RecordSortEnum getEnum(String message) {
        for (RecordSortEnum ele : RecordSortEnum.values()) {
            if (ele.message().equals(message)) {
                return ele;
            }
        }
        System.err.println("类型不匹配 name = " + message);
        return null;
    }
}
