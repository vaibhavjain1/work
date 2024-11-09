package accolite.backtracking;

import java.util.*;

public class StepDataManipulation {
    public static void main(String[] args) {
        List<StepInfoDTO> stepInfoDTOList = new ArrayList<>();

        StepInfoDTO order1 = new StepInfoDTO("Order1", 1, "DueDate1", 1, "S1", Arrays.asList(
                new StepInfoDTO.StepData(null, "L1", "L1", "F11", "P11"),
                new StepInfoDTO.StepData("M2", "BS", "BS", "F12", "P12"),
                new StepInfoDTO.StepData(null, "SDC", "SDC", "F13", "P13"),
                new StepInfoDTO.StepData("M1", "JM", "JM", "F14", "P14"),
                new StepInfoDTO.StepData(null, "NS", "NS", "F15", "P15"),
                new StepInfoDTO.StepData(null, "S", "S", "F16", "P16"),
                new StepInfoDTO.StepData(null, "PW", "PW", "F17", "P17")
        ));
        StepInfoDTO order2 = new StepInfoDTO("Order2", 1, "DueDate2", 1, null, Arrays.asList(
                new StepInfoDTO.StepData("M2", "L0", "L0", "F11", "P11"),
                new StepInfoDTO.StepData(null, "L1", "L1", "F12", "P12"),
                new StepInfoDTO.StepData(null, "L2", "L2", "F13", "P13"),
                new StepInfoDTO.StepData(null, "BS", "BS", "F14", "P14"),
                new StepInfoDTO.StepData(null, "SDC", "SDC", "F15", "P15"),
                new StepInfoDTO.StepData(null, "NS", "NS", "F16", "P16"),
                new StepInfoDTO.StepData("M1", "JM", "JM", "F17", "P17")
        ));
        StepInfoDTO order3 = new StepInfoDTO("Order3", 1, "DueDate3", 1, "S1", Arrays.asList(
                new StepInfoDTO.StepData(null, "BS", "BS", "F11", "P11"),
                new StepInfoDTO.StepData(null, "LP", "LP", "F12", "P12"),
                new StepInfoDTO.StepData(null, "NS", "NS", "F13", "P13"),
                new StepInfoDTO.StepData(null, "S", "S", "F14", "P14")
        ));


        stepInfoDTOList.addAll(Arrays.asList(order1, order2, order3));
        StepDataManipulation obj = new StepDataManipulation();
        obj.printStepInfoDTOList(stepInfoDTOList);
        obj.scanSteps(stepInfoDTOList);
        obj.printEntry();
        obj.manipulation(stepInfoDTOList);
        obj.printStepInfoDTOList(stepInfoDTOList);
    }

    void printStepInfoDTOList(List<StepInfoDTO> stepInfoDTOList) {
        for (StepInfoDTO stepInfoDTO : stepInfoDTOList) {
            System.out.println("For: " + stepInfoDTO.getOrderNumber());
            for (StepInfoDTO.StepData stepData : stepInfoDTO.getStepData())
                System.out.println(stepData);
        }
    }

    void printEntry() {
        for (Map.Entry<String, Integer> entrySet : maxMap.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
        for (Map.Entry<String, ArrayList<Pair>> entrySet : orderMap.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
    }

    class Pair {
        String manufacturingSet;
        Integer seq;

        Pair(String manufacturingSet, Integer seq) {
            this.manufacturingSet = manufacturingSet;
            this.seq = seq;
        }
    }

    Map<String, Integer> maxMap = new LinkedHashMap<>();
    Map<String, ArrayList<Pair>> orderMap = new LinkedHashMap();

    private void scanSteps(List<StepInfoDTO> stepInfoDTOList) {
        for (StepInfoDTO stepInfoDTO : stepInfoDTOList) {
            int maxCount = 0;
            orderMap.put(stepInfoDTO.getOrderNumber(), new ArrayList<>());
            for (StepInfoDTO.StepData stepData : stepInfoDTO.getStepData()) {
                String manufacturingSet = stepData.getManufacturingSet();
                if (manufacturingSet != null) {
                    Integer currCount = maxMap.get(manufacturingSet);
                    if (currCount == null || maxCount > currCount) {
                        maxMap.put(manufacturingSet, maxCount);
                    }
                    orderMap.get(stepInfoDTO.getOrderNumber()).add(new Pair(manufacturingSet, maxCount));
                    maxCount = 0;
                } else {
                    maxCount++;
                }
            }
        }
    }

    void manipulation(List<StepInfoDTO> stepInfoDTOList) {
        for (StepInfoDTO stepInfoDTO : stepInfoDTOList) {
            ArrayList<Pair> pairs = orderMap.get(stepInfoDTO.getOrderNumber());
            if (pairs.size() != 0) {
                ArrayList<StepInfoDTO.StepData> orderStepDataList = new ArrayList<>();
                int startPos = 0;
                for (Pair pair : pairs) {
                    int diff = maxMap.get(pair.manufacturingSet) - pair.seq;
                    while (diff != 0) {
                        orderStepDataList.add(null);
                        diff--;
                    }
                    for (int currPointer = startPos; currPointer < stepInfoDTO.getStepData().size(); currPointer++) {
                        orderStepDataList.add(stepInfoDTO.getStepData().get(currPointer));
                        if (stepInfoDTO.getStepData().get(currPointer).getManufacturingSet() == pair.manufacturingSet) {
                            startPos = currPointer + 1;
                            break;
                        }
                    }
                }
                while (startPos < stepInfoDTO.getStepData().size()){
                    orderStepDataList.add(stepInfoDTO.getStepData().get(startPos));
                    startPos++;
                }

                stepInfoDTO.setStepData(orderStepDataList);
            }
        }
    }

}