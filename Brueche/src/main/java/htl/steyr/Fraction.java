package htl.steyr;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws DenominatorException {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) throws DenominatorException{
        if (denominator == 0){
            throw new DenominatorException("Denominator should be greater than zero");
        }

        this.denominator = denominator;
    }

    public Fraction multiply(Fraction other) {
        Fraction result = null;

        try {
             result = new Fraction(getNumerator() * other.getNumerator(),
                    getDenominator() * other.getDenominator());
        } catch (DenominatorException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public Fraction divide(Fraction other) throws DenominatorException {
        Fraction result = null;

        result = new Fraction(getNumerator() * other.getDenominator(),
                getDenominator() * other.getNumerator());

        return result;
    }

    public Fraction add(Fraction other) throws DenominatorException {
        Fraction result = null;

        result = new Fraction(getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator(),
                getDenominator() * other.getDenominator());

        return result;
    }

    public Fraction subtract(Fraction other) throws DenominatorException {
        Fraction result = null;

        result = new Fraction(getNumerator() * other.getDenominator() - other.getNumerator() * getDenominator(),
                getDenominator() * other.getDenominator());

        return result;
    }

    public Fraction shorten() throws DenominatorException {
        int commondivisor = gcd(getNumerator(), getDenominator());

        return new Fraction(getNumerator() / commondivisor,
                getDenominator() /commondivisor);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

