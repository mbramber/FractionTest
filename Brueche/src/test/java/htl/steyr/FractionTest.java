package htl.steyr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void getNumerator() throws DenominatorException {
        Fraction f = new Fraction(10,7);
        assertEquals(10,f.getNumerator());

        f.setNumerator(20);
        assertEquals(20,f.getNumerator());
    }

    @Test
    void setNumerator() throws DenominatorException {
        getNumerator();
    }

    @Test
    void getDenominator() throws DenominatorException {
        Fraction f = new Fraction(10,7);
        assertEquals(7,f.getDenominator());

        f.setDenominator(10);
        assertEquals(10,f.getDenominator());

        assertThrows(DenominatorException.class,()->{
            f.setDenominator(0);
        });
    }

    @Test
    void setDenominator() throws DenominatorException {
        getDenominator();
    }

    @Test
    void multiply() throws DenominatorException {
        Fraction f1 =  new Fraction(10,7);
        Fraction f2 = new Fraction(20,10);
        Fraction result = f1.multiply(f2);

        assertEquals(200,result.getNumerator());
        assertEquals(70,result.getDenominator());
    }

    @Test
    void divide() throws DenominatorException {
        Fraction f1 =  new Fraction(10,7);
        Fraction f2 = new Fraction(20,10);
        Fraction result = f1.divide(f2);

        assertEquals(100,result.getNumerator());
        assertEquals(140,result.getDenominator());

        f1.setNumerator(0);
        result = f1.divide(f2);
        assertEquals(0,result.getNumerator());
        assertEquals(140,result.getDenominator());

        f2.setNumerator(0);

        assertThrows(DenominatorException.class,()->{f1.divide(f2);});
    }

    @Test
    void add() throws DenominatorException {
        Fraction f1 =  new Fraction(10,7);
        Fraction f2 = new Fraction(20,10);
        Fraction result = f1.add(f2);

        assertEquals(240,result.getNumerator());
        assertEquals(70,result.getDenominator());
    }

    @Test
    void subtract() throws DenominatorException {
        Fraction f1 =  new Fraction(10,7);
        Fraction f2 = new Fraction(20,10);
        Fraction result = f1.subtract(f2);

        assertEquals(-40,result.getNumerator());
        assertEquals(70,result.getDenominator());
    }

    @Test
    void shorten() throws DenominatorException {
        Fraction f1 =  new Fraction(20,12);
        Fraction result = f1.shorten();

        assertEquals(5,result.getNumerator());
        assertEquals(3,result.getDenominator());
    }



}