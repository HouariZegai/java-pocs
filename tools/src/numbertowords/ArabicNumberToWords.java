package numbertowords;

public class ArabicNumberToWords {

    public ArabicNumberToWords() {
    }

    public static String convert(int number) throws NumberFormatException {
        String numberStr = String.valueOf(number); 
        switch (numberStr.length()) {
            case 1:
                return convertOneDigits(numberStr);
            case 2:
                return convertTwoDigits(numberStr);
            case 3:
                return convertThreeDigits(numberStr);
            case 4:
                return convertFourDigits(numberStr);
            case 5:
                return convertFiveDigits(numberStr);
            case 6:
                return convertSixDigits(numberStr);
            default:
                return "";
        }
    }

    private static String convertOneDigits(String oneDigit) {
        switch (Integer.parseInt(oneDigit)) {
            case 1:
                return "واحد";
            case 2:
                return "إثنان";
            case 3:
                return "ثلاثه";
            case 4:
                return "أربعه";
            case 5:
                return "خمسه";
            case 6:
                return "سته";
            case 7:
                return "سبعه";
            case 8:
                return "ثمانيه";
            case 9:
                return "تسعه";
            default:
                return "";
        }
    }

    private static String convertTwoDigits(String twoDigits) {
        String returnAlpha = "00";
        // check if the first digit is 0 like 0x
        if (twoDigits.charAt(0) == '0' && twoDigits.charAt(1) != '0') { // yes
            // convert two digits to one
            return convertOneDigits(String.valueOf(twoDigits.charAt(1)));
        } else { // no
            // check the first digit 1x 2x 3x 4x 5x 6x 7x 8x 9x
            switch (getIntVal(twoDigits.charAt(0))) {
                case 1: { // 1x
                    if (getIntVal(twoDigits.charAt(1)) == 1) {
                        return "إحدى عشر";
                    }
                    if (getIntVal(twoDigits.charAt(1)) == 2) {
                        return "إثنى عشر";
                    } else {
                        return convertOneDigits(String.valueOf(twoDigits.charAt(1))) + " " + "عشر";
                    }
                }
                case 2: // 2x x:not 0
                    returnAlpha = "عشرون";
                    break;
                case 3: // 3x x:not 0
                    returnAlpha = "ثلاثون";
                    break;
                case 4: // 4x x:not 0
                    returnAlpha = "أريعون";
                    break;
                case 5: // 5x x:not 0
                    returnAlpha = "خمسون";
                    break;
                case 6: // 6x x:not 0
                    returnAlpha = "ستون";
                    break;
                case 7: // 7x x:not 0
                    returnAlpha = "سبعون";
                    break;
                case 8: // 8x x:not 0
                    returnAlpha = "ثمانون";
                    break;
                case 9: // 9x x:not 0
                    returnAlpha = "تسعون";
                    break;
                default:
                    returnAlpha = "";
                    break;
            }
        }

        // 20 - 99
        // x0 x:not 0,1
        if (convertOneDigits(String.valueOf(twoDigits.charAt(1))).length() == 0) {
            return returnAlpha;
        } else { // xx x:not 0
            return convertOneDigits(String.valueOf(twoDigits.charAt(1))) + " و " + returnAlpha;
        }
    }

    private static String convertThreeDigits(String threeDigits) {

        // check the first digit x00
        switch (getIntVal(threeDigits.charAt(0))) {

            case 1: { // 100 - 199
                if (getIntVal(threeDigits.charAt(1)) == 0) { // 10x
                    if (getIntVal(threeDigits.charAt(2)) == 0) { // 100
                        return "مائه";
                    } else { // 10x x: is not 0
                        return "مائه" + " و " + convertOneDigits(String.valueOf(threeDigits.charAt(2)));
                    }
                } else {// 1xx x: is not 0
                    return "مائه" + " و " + convertTwoDigits(threeDigits.substring(1, 3));
                }
            }
            case 2: { // 200 - 299
                if (getIntVal(threeDigits.charAt(1)) == 0) { // 20x
                    if (getIntVal(threeDigits.charAt(2)) == 0) { // 200
                        return "مائتين";
                    } else { // 20x x:not 0
                        return "مائتين" + " و " + convertOneDigits(String.valueOf(threeDigits.charAt(2)));
                    }
                } else { // 2xx x:not 0
                    return "مائتين" + " و " + convertTwoDigits(threeDigits.substring(1, 3));
                }
            }
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: { // 300 - 999
                if (getIntVal(threeDigits.charAt(1)) == 0) { // x0x x:not 0
                    if (getIntVal(threeDigits.charAt(2)) == 0) { // x00 x:not 0
                        return convertOneDigits(String.valueOf(threeDigits.charAt(1) + "مائه"));
                    } else { // x0x x:not 0
                        return convertOneDigits(String.valueOf(threeDigits.charAt(0))) + "مائه" + " و "
                                + convertOneDigits(String.valueOf(threeDigits.charAt(2)));
                    }
                } else { // xxx x:not 0
                    return convertOneDigits(String.valueOf(threeDigits.charAt(0))) + "مائه" + " و "
                            + convertTwoDigits(threeDigits.substring(1, 3));
                }
            }

            case 0: { // 000 - 099
                if (threeDigits.charAt(1) == '0') { // 00x
                    if (threeDigits.charAt(2) == '0') { // 000
                        return "";
                    } else { // 00x x:not 0
                        return convertOneDigits(String.valueOf(threeDigits.charAt(2)));
                    }
                } else { // 0xx x:not 0
                    return convertTwoDigits(threeDigits.substring(1, 3));
                }
            }
            default:
                return "";
        }
    }

    private static String convertFourDigits(String fourDigits) {
        // xxxx
        switch (getIntVal(fourDigits.charAt(0))) {

            case 1: { // 1000 - 1999
                if (getIntVal(fourDigits.charAt(1)) == 0) { // 10xx x:not 0
                    if (getIntVal(fourDigits.charAt(2)) == 0) { // 100x x:not 0
                        if (getIntVal(fourDigits.charAt(3)) == 0) { // 1000
                            return "ألف";
                        } else { // 100x x:not 0
                            return "ألف" + " و " + convertOneDigits(String.valueOf(fourDigits.charAt(3)));
                        }
                    } else { // 10xx x:not 0
                        return "ألف" + " و " + convertTwoDigits(fourDigits.substring(2, 3));
                    }
                } else { // 1xxx x:not 0
                    return "ألف" + " و " + convertThreeDigits(fourDigits.substring(1, 4));
                }
            }
            case 2: { // 2000 - 2999
                if (getIntVal(fourDigits.charAt(1)) == 0) { // 20xx
                    if (getIntVal(fourDigits.charAt(2)) == 0) { // 200x
                        if (getIntVal(fourDigits.charAt(3)) == 0) { // 2000
                            return "ألفين";
                        } else { // 200x x:not 0
                            return "ألفين" + " و " + convertOneDigits(String.valueOf(fourDigits.charAt(3)));
                        }
                    } else { // 20xx x:not 0
                        return "ألفين" + " و " + convertTwoDigits(fourDigits.substring(2, 3));
                    }
                } else { // 2xxx x:not 0
                    return "ألفين" + " و " + convertThreeDigits(fourDigits.substring(1, 4));
                }
            }
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: { // 3000 - 9999
                if (getIntVal(fourDigits.charAt(1)) == 0) { // x0xx x:not 0
                    if (getIntVal(fourDigits.charAt(2)) == 0) { // x00x x:not 0
                        if (getIntVal(fourDigits.charAt(3)) == 0) { // x000 x:not 0
                            return convertOneDigits(String.valueOf(fourDigits.charAt(0))) + " ألاف";
                        } else { // x00x x:not 0
                            return convertOneDigits(String.valueOf(fourDigits.charAt(0))) + " ألاف" + " و "
                                    + convertOneDigits(String.valueOf(fourDigits.charAt(3)));
                        }
                    } else { // x0xx x:not 0
                        return convertOneDigits(String.valueOf(fourDigits.charAt(0))) + " ألاف" + " و "
                                + convertTwoDigits(fourDigits.substring(2, 3));
                    }
                } else { // xxxx x:not 0
                    return convertOneDigits(String.valueOf(fourDigits.charAt(0))) + " ألاف" + " و "
                            + convertThreeDigits(fourDigits.substring(1, 4));
                }
            }

            default:
                return "";
        }
    }

    private static String convertFiveDigits(String fiveDigits) {
        if (convertThreeDigits(fiveDigits.substring(2, 5)).length() == 0) { // xx000
            // x:not
            // 0
            return convertTwoDigits(fiveDigits.substring(0, 2)) + " ألف ";
        } else { // xxxxx x:not 0
            return convertTwoDigits(fiveDigits.substring(0, 2)) + " ألفا " + " و "
                    + convertThreeDigits(fiveDigits.substring(2, 5));
        }
    }

    private static String convertSixDigits(String sixDigits) {

        if (convertThreeDigits(sixDigits.substring(2, 5)).length() == 0) { // xxx000
            // x:not
            // 0
            return convertThreeDigits(sixDigits.substring(0, 3)) + " ألف ";
        } else { // xxxxxx x:not 0
            return convertThreeDigits(sixDigits.substring(0, 3)) + " ألفا " + " و "
                    + convertThreeDigits(sixDigits.substring(3, 6));
        }
    }

    private static int getIntVal(char c) {
        return Integer.parseInt(String.valueOf(c));
    }
}
