package accolite.backtracking;

import java.util.List;

public class StepInfoDTO {

  private String orderNumber;

  private int jobNumber;

  private String dueDate;

  private int quantity;

  private String shippingSet;

  private List<StepData> stepData;

  public StepInfoDTO(String orderNumber, int jobNumber, String dueDate, int quantity, String shippingSet, List<StepData> stepData) {
    this.orderNumber = orderNumber;
    this.jobNumber = jobNumber;
    this.dueDate = dueDate;
    this.quantity = quantity;
    this.shippingSet = shippingSet;
    this.stepData = stepData;
  }

  public String getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(String orderNumber) {
    this.orderNumber = orderNumber;
  }

  public int getJobNumber() {
    return jobNumber;
  }

  public void setJobNumber(int jobNumber) {
    this.jobNumber = jobNumber;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getShippingSet() {
    return shippingSet;
  }

  public void setShippingSet(String shippingSet) {
    this.shippingSet = shippingSet;
  }

  public List<StepData> getStepData() {
    return stepData;
  }

  public void setStepData(List<StepData> stepData) {
    this.stepData = stepData;
  }

  public static class StepData {

    private String manufacturingSet;

    private String machineName;

    private String machineNumberAndName;

    private String finishTime;

    private String progressStatus;

    public StepData(String manufacturingSet, String machineName, String machineNumberAndName, String finishTime, String progressStatus) {
      this.manufacturingSet = manufacturingSet;
      this.machineName = machineName;
      this.machineNumberAndName = machineNumberAndName;
      this.finishTime = finishTime;
      this.progressStatus = progressStatus;
    }

    public String getManufacturingSet() {
      return manufacturingSet;
    }

    public void setManufacturingSet(String manufacturingSet) {
      this.manufacturingSet = manufacturingSet;
    }

    public String getMachineName() {
      return machineName;
    }

    public void setMachineName(String machineName) {
      this.machineName = machineName;
    }

    public String getMachineNumberAndName() {
      return machineNumberAndName;
    }

    public void setMachineNumberAndName(String machineNumberAndName) {
      this.machineNumberAndName = machineNumberAndName;
    }

    public String getFinishTime() {
      return finishTime;
    }

    public void setFinishTime(String finishTime) {
      this.finishTime = finishTime;
    }

    public String getProgressStatus() {
      return progressStatus;
    }

    public void setProgressStatus(String progressStatus) {
      this.progressStatus = progressStatus;
    }

    @Override
    public String toString() {
      return "StepData{" +
              "machineName='" + machineName + '\'' +
              ", manufacturingSet='" + manufacturingSet + '\'' +
              //", machineNumberAndName='" + machineNumberAndName + '\'' +
              //", finishTime='" + finishTime + '\'' +
              //", progressStatus='" + progressStatus + '\'' +
              '}';
    }
  }

  @Override
  public String toString() {
    return "StepInfoDTO{" +
            "orderNumber='" + orderNumber + '\'' +
            ", jobNumber=" + jobNumber +
            ", dueDate='" + dueDate + '\'' +
            ", quantity=" + quantity +
            ", shippingSet='" + shippingSet + '\'' +
            ", stepData=" + stepData +
            '}';
  }
}
