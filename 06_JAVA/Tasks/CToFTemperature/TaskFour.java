import java.util.function.Function;

class TaskFour {
	public static void main(String[] args) {
		Function<Double,Double> convertToFarenheit = x-> (x * (9.0/5.0) + 32);
		System.out.println(convertToFarenheit.apply(21.0));
	}
}