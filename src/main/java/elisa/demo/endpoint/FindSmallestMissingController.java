package elisa.demo.endpoint;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
public class FindSmallestMissingController {



    @PostMapping("/findSmallestMissing")
    public int findMissingInteger(@RequestBody int[] numbers) {

        // Faster implementation

        return FindSmallestPositive.findSmallestMissing(numbers);


//        Initial implementation:

//        int[] positiveNumbers = Arrays.stream(numbers)
//                .filter(n -> n >= 0)
//                .sorted()
//                .toArray();
//
//        int smallestNumber = 1;
//
//        for (int positiveNumber : positiveNumbers) {
//            if (positiveNumber > smallestNumber) {
//                return smallestNumber;
//            }
//            if (positiveNumber == smallestNumber) {
//                smallestNumber = smallestNumber + 1;
//            }
//        }
//        return smallestNumber; //
    }


}
