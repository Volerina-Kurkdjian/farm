package animals;

import java.util.ArrayList;
import java.util.List;

public class Duck {

    private String name;
    private Integer weight;
    private String gender;
    private List<String> activities=new ArrayList<>();


    public Duck(String name, Integer weight, String gender,List<String> activities){
        this.name=name;
        this.weight=weight;
        this.gender=gender;
        this.activities=activities;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", activities=" + activities +
                '}';
    }
}
