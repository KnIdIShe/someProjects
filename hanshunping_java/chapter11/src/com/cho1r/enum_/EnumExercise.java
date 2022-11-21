package com.cho1r.enum_;

/**
 * Author cho1r
 * 2021-11-25 025 08:39 上午
 */
public class EnumExercise {
    public static void main(String[] args) {
        for (Week value : Week.values()) {
            System.out.println(value);
        }
    }
}

enum Week {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private final String ch;

    Week(String ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return ch;
    }
}

//enum Week {
//    MONDAY,
//    TUESDAY,
//    WEDNESDAY,
//    THURSDAY,
//    FRIDAY,
//    SATURDAY,
//    SUNDAY;
//
//    @Override
//    public String toString() {
//        String ch = null;
//
//        ch = switch (this.ordinal()) {
//            case 0 -> "星期一";
//            case 1 -> "星期二";
//            case 2 -> "星期三";
//            case 3 -> "星期四";
//            case 4 -> "星期五";
//            case 5 -> "星期六";
//            case 6 -> "星期日";
//            default -> null;
//        };
//
////        if (this.ordinal() == 0) {
////            ch = "星期一";
////        }
////        if (this.ordinal() == 1) {
////            ch = "星期二";
////        }
////        if (this.ordinal() == 2) {
////            ch = "星期三";
////        }
////        if (this.ordinal() == 3) {
////            ch = "星期四";
////        }
////        if (this.ordinal() == 4) {
////            ch = "星期五";
////        }
////        if (this.ordinal() == 5) {
////            ch = "星期六";
////        }
////        if (this.ordinal() == 6) {
////            ch = "星期日";
////        }
//
//        return ch;
//    }
//}