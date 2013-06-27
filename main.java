/**
 * Created with IntelliJ IDEA.
 * User: Purity_Lake
 * Date: 27/06/13
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class main {

    public static void main(String[] args) {

        Fraction frac1 = new Fraction(3, -10);
        Fraction frac2 = new Fraction(1.221f);
        Fraction frac3 = frac2.add(frac1);

        System.out.println(frac1.toString() + " + " + frac2.toString() + " = " + frac3.toString());
    }
}
