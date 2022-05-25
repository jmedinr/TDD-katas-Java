package calculator;

import java.util.ArrayList;

public class StringCalculator {
    public Integer add(String values) throws Exception { //"1,1"
        if(values.length() > 1) {

            String delimiter;
            if(values.contains("#")){
                delimiter = "#";
            } else {
                delimiter = "[,|\n]";
            }

            String[] splitList = values.split(delimiter);
            ArrayList<Integer> numberList = new ArrayList<>();
                Integer accumulator = 0;
            for(String element: splitList) {
                int tempValue = 0;
                if (!element.equals("")) {
                    tempValue = Integer.parseInt(element);
                }
                if(tempValue < 0) {
                    throw new Exception("NegativeNumberException");
                }
                if(tempValue > 1000) {
                    continue;
                }
                numberList.add(tempValue);
            }
            for(Integer number: numberList) {
                accumulator += number;
            }
            return accumulator;
        }
        else if(values.length() == 1){
            return Integer.parseInt(values);
        }
        return 0;
    }
}
