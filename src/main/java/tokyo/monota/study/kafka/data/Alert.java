package tokyo.monota.study.kafka.data;

public class Alert {

    private int alertId;
    private String stageId;
    private String alertLevel;
    private String alertMessage;

    public Alert(int alertId, String stageId, String alertLevel, String alertMessage) {
        this.alertId = alertId;
        this.stageId = stageId;
        this.alertLevel = alertLevel;
        this.alertMessage = alertMessage;
    }

    public int getAlertId() {
        return alertId;
    }

    public String getStageId() {
        return stageId;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}
