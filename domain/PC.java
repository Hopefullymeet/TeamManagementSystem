package team.domain;

public class PC implements Equipment{

    private String display;
    private String model;

    public PC() {
    }

    public PC(String model, String display) {
        this.display = display;
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getDescription() {
        return  model + "   " + display;
    }
}
