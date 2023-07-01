public class Taskk {
private String name;
private String options;
private String date;
private int priority;
private String status;

public Taskk (String name,String options, String date, int priority) {
    this.name = name;
    this.options = options;
    this.date = date;
    this.priority = priority;
    this.status = "в процессе";
}
 public void setName(String name) {
        this.name = name;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getOptions() {
        return options;
    }
    public String getDate() {
        return date;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return name + " (" +status+ ") " ;
    }
}
