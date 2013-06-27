import static java.lang.Math.pow;

/**
 * Created with IntelliJ IDEA.
 * User: Purity_Lake
 * Date: 27/06/13
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class Fraction {

    public int numer, denom;

    public Fraction() {

        this.numer = 1;
        this.denom = 1;

    }
    public Fraction(int number) {

        this.numer = number;
        this.denom = 1;
    }
    public Fraction(float number) {

        // convert the number passed to the constructor to a string
        String num = String.valueOf(number);

        boolean afterDecimal = false; // if the for loops has reached the decimal
        int numbersAfterDecimal = 1; // as a factor of 10 i.e. 1.0 = 1 / 1 and 0.1 = 1 / 10

        // loop through the String representation of the parameter number
        // to check how many numbers are after the decimal point
        for (int i = 0; i < num.length(); i++) {

            if (afterDecimal) numbersAfterDecimal *= 10;
            if (num.charAt(i) == '.') afterDecimal = true;

        }

        // convert the float to an int after moving the numbers after the decimal point
        this.numer = (int) (number * numbersAfterDecimal);
        this.denom = numbersAfterDecimal;

        this.simplify();

    }
    public Fraction(double number) {

        // convert the number passed to the constructor to a string
        String num = String.valueOf(number);

        boolean afterDecimal = false; // if the for loops has reached the decimal
        int numbersAfterDecimal = 1; // as a factor of 10 i.e. 1.0 = 1 / 1 and 0.1 = 1 / 10

        // loop through the String representation of the parameter number
        // to check how many numbers are after the decimal point
        for (int i = 0; i < num.length(); i++) {

            if (afterDecimal) numbersAfterDecimal *= 10;
            if (num.charAt(i) == '.') afterDecimal = true;

        }

        // convert the float to an int after moving the numbers after the decimal point
        this.numer = (int) (number * numbersAfterDecimal);
        this.denom = numbersAfterDecimal;

        this.simplify();

    }
    public Fraction (int numer, int denom) {

        this.numer = numer;
        this.denom = denom;

        this.simplify();
    }

    private void simplify() {

        int[] divisors = {2, 3, 4, 5, 6, 7, 8, 9};
        int i = 0;

        do {

            if (this.numer % divisors[i] == 0 && this.denom % divisors[i] == 0) {

                this.numer /= divisors[i];
                this.denom /= divisors[i];
                i = 0;

            }

            i++;

        } while (i < 7);

        if ((this.denom < 0 && this.numer < 0) || this.denom < 0) {

            this.denom *= -1;
            this.numer *= -1;

        }
    }

    @Override
    public String toString() {
        return (String.valueOf(this.numer) + " / " + String.valueOf(this.denom));
    }

    public boolean EvaluatesToZero() {

        if (this.numer == 0 || this.denom == 0) return true;

        return false;
    }

    public void addOver(Fraction a) {

        if (a.denom == this.denom) {

            this.numer += a.numer;

        } else if (!this.EvaluatesToZero() || !a.EvaluatesToZero()) {

            int commonDenom = a.denom * this.denom;
            int aNewNumer = a.numer * (commonDenom / a.denom);
            int bNewNumer = this.numer * (commonDenom / this.denom);

            int newNumber = aNewNumer + bNewNumer;
            this.denom = commonDenom;
            this.numer = newNumber;
            this.simplify();

        }

    }
    public void addOver(int a) {

        Fraction intFraction  = new Fraction(a, 1);
        Fraction ret = this.add(intFraction);
        this.denom = ret.denom;
        this.numer = ret.numer;
        this.simplify();

    }
    public void addOver(float a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.add(floatFraction);
        this.numer = ret.numer;
        this.denom = ret.denom;

    }
    public void addOver(double a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.add(floatFraction);
        this.numer = ret.numer;
        this.denom = ret.denom;

    }

    public Fraction add(Fraction a) {

        Fraction frac = new Fraction();
        if (a.EvaluatesToZero()) {

            return this;

        } else if (this.EvaluatesToZero()) {

            return a;

        }

        if (a.denom == this.denom) {

            frac = new Fraction(a.numer + this.numer, a.numer);
            return frac;

        }

        // get the common denominator
        int commonDenom = a.denom * this.denom;
        int aNewNumer = a.numer * (commonDenom / a.denom);
        int bNewNumer = this.numer * (commonDenom / this.denom);

        int newNumber = aNewNumer + bNewNumer;
        frac = new Fraction(newNumber, commonDenom);
        return frac;
    }
    public Fraction add(int a) {

        Fraction intFraction = new Fraction(a, 1);
        Fraction ret = this.add(intFraction);
        return ret;

    }
    public Fraction add(float a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.add(floatFraction);
        return ret;
    }
    public Fraction add(double a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.add(floatFraction);
        return ret;

    }

    public void subOver(Fraction a) {

        if (a.denom == this.denom) {

            this.numer -= a.numer;

        } else if (!this.EvaluatesToZero() || !a.EvaluatesToZero()) {

            int commonDenom = a.denom * this.denom;
            int aNewNumer = a.numer * (commonDenom / a.denom);
            int bNewNumer = this.numer * (commonDenom / this.denom);

            int newNumber = aNewNumer - bNewNumer;
            this.denom = commonDenom;
            this.numer = newNumber;
            this.simplify();

        }

    }
    public void subOver(int a) {

        Fraction intFraction  = new Fraction(a, 1);
        Fraction ret = this.sub(intFraction);
        this.denom = ret.denom;
        this.numer = ret.numer;
        this.simplify();

    }
    public void subOver(float a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.sub(floatFraction);
        this.numer = ret.numer;
        this.denom = ret.denom;

    }
    public void subOver(double a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.sub(floatFraction);
        this.numer = ret.numer;
        this.denom = ret.denom;

    }

    public Fraction sub(Fraction a) {

        Fraction frac = new Fraction();
        if (a.EvaluatesToZero()) {

            return this;

        } else if (this.EvaluatesToZero()) {

            return a;

        }

        if (a.denom == this.denom) {

            frac = new Fraction(a.numer + this.numer, a.numer);
            return frac;

        }

        // get the common denominator
        int commonDenom = a.denom * this.denom;
        int aNewNumer = a.numer * (commonDenom / a.denom);
        int bNewNumer = this.numer * (commonDenom / this.denom);

        int newNumber = aNewNumer - bNewNumer;
        frac = new Fraction(newNumber, commonDenom);
        return frac;

    }
    public Fraction sub(int a) {

        Fraction intFraction = new Fraction(a, 1);
        Fraction ret = this.sub(intFraction);
        return ret;

    }
    public Fraction sub(float a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.sub(floatFraction);
        return ret;

    }
    public Fraction sub(double a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.add(floatFraction);
        return ret;

    }

    public void multiplyOver(Fraction a) {


    }
    public Fraction multiply(Fraction a) {

        Fraction ret = new Fraction((this.numer * a.numer), (this.denom * a.denom));
        return ret;

    }
    public Fraction multiply(int a) {

        Fraction ret = new Fraction((this.numer * a), this.denom);
        return ret;

    }
    public Fraction multiply(float a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.multiply(floatFraction);
        return ret;

    }
    public Fraction multiply(double a) {

        Fraction floatFraction = new Fraction(a);
        Fraction ret = this.multiply(floatFraction);
        return ret;

    }
}
