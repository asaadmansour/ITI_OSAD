import java.util.function.Function;

class Main {
    public static void main(String[] args) {
        Parameter p = new Parameter(1, -5, 6);

        Function<Parameter, Root> Roots = param -> {
            double x = (param.b * param.b) - (4 * param.a * param.c);
            double sqrtx = 0.0;
            if (x > 0) {
                sqrtx = Math.sqrt(x);
            } else if (x < 0) {
                throw new ArithmeticException("Complex roots not supported");
            }
            double x1 = (-param.b + sqrtx) / (2 * param.a);
            double x2 = (-param.b - sqrtx) / (2 * param.a);
            Root r = new Root(x1, x2);
            return r;
        };

        Root r = Roots.apply(p);
        System.out.println("x1 = " + r.x1 + ", x2 = " + r.x2);
    }
}
// static vs final
// polymorphism compile vs runtime
// default access modifier