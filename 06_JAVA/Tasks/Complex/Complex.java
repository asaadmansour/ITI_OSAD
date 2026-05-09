// import java.util.Number;
public class Complex <T extends Number> {
    private T real;
    private T imaginary;
    public Complex(T real,T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    public Complex<Double> add(Complex<? extends Number> other) {
        double r = this.real.doubleValue() + other.real.doubleValue();
        double i = this.imaginary.doubleValue() + other.imaginary.doubleValue();
        return new Complex<>(r, i);
    }
    public Complex<Double> Multiply(Complex<? extends Number> other) {
        double r = this.real.doubleValue() * other.real.doubleValue();
        double i = this.imaginary.doubleValue() * other.imaginary.doubleValue();
        return new Complex<>(r, i);
    }
    public Complex<Double> subtract(Complex<? extends Number> other) {
        double r = this.real.doubleValue() - other.real.doubleValue();
        double i = this.imaginary.doubleValue() - other.imaginary.doubleValue();
        return new Complex<>(r, i);
    }
    public Complex<Double> divide(Complex<? extends Number> other) {
        double r = this.real.doubleValue() / other.real.doubleValue();
        double i = this.imaginary.doubleValue() / other.imaginary.doubleValue();
        return new Complex<>(r,i);
    }
    public String toString() {
    if (imaginary.doubleValue() >= 0) {
        return real + " + " + imaginary + "i";
    } else {
        return real + " - " + Math.abs(imaginary.doubleValue()) + "i";
    }
    }
}