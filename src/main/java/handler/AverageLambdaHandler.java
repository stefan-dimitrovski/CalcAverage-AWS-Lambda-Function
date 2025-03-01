package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.List;

public class AverageLambdaHandler implements RequestHandler<AverageLambdaHandler.InputObject, String> {

    public String handleRequest(InputObject inputObject, Context context) {

        double result = inputObject.getNumbers().stream().mapToDouble(value -> value).average().orElse(0);

        return String.format("%.2f", result);
    }

    public static class InputObject {
        private List<Integer> numbers;

        public InputObject() {
        }

        public InputObject(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public String toString() {
            return "InputObject{" +
                    "numbers=" + numbers +
                    '}';
        }
    }
}
