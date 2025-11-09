package ict.22.ClassNames;

public class MainClass {

    // Create static instances
    static SumClass sumObj = new SumClass();
    static DivisorMultipleClass dmObj = new DivisorMultipleClass();
    static NumberConversionClass ncObj = new NumberConversionClass();
    static CustomPrintClass prObj = new CustomPrintClass();

    public static void main(String[] args) {
        prObj.pr("===== Package: ict.22.ClassNames =====");

        // 1. SumClass
        double result = SumClass.sumSeries();
        prObj.pr("Sum of 1 + 0.9 + ... + 0.1 = " + result);

        // 2. DivisorMultipleClass
        int a = 12, b = 18;
        prObj.pr("\nGCD of " + a + " and " + b + " = " + DivisorMultipleClass.gcd(a, b));
        prObj.pr("LCM of " + a + " and " + b + " = " + DivisorMultipleClass.lcm(a, b));

        // 3. NumberConversionClass
        int num = 25;
        prObj.pr("\nDecimal: " + num);
        prObj.pr("Binary: " + NumberConversionClass.decimalToBinary(num));
        prObj.pr("Hexadecimal: " + NumberConversionClass.decimalToHex(num));
        prObj.pr("Octal: " + NumberConversionClass.decimalToOctal(num));

        // 4. Conversion back to decimal
        prObj.pr("\nBinary 11001 to Decimal: " + NumberConversionClass.binaryToDecimal("11001"));
        prObj.pr("Hex 19 to Decimal: " + NumberConversionClass.hexToDecimal("19"));
        prObj.pr("Octal 31 to Decimal: " + NumberConversionClass.octalToDecimal("31"));

        prObj.pr("\n===== End of Program =====");
    }
}
