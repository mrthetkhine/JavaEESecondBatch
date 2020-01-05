import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FPTest {
	public static void main(String[]args)
	{
		List<Integer> arr = Arrays.asList(1,4,6,7,9);
		
		List<Integer> square = arr
								.stream()
								.filter(ele -> ele %2 ==0)
								.map(ele -> ele * 2)
								.collect(Collectors.toList());
		Optional<Integer> sum = square
								.stream()
								.reduce( (a,b) -> a+b);
		System.out.println(square);
		System.out.println("Sum "+sum.get());
								
								
		
	}

}
