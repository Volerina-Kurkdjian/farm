package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Horse {

    private String name;
    private Integer age;
    private String gender;
    private String pedegree;
    private List<String> activities=new ArrayList<>();

    private Optional<HorseEquipment> horseEquipment= Optional.empty();

    public Optional<HorseEquipment> getHorseEquipment() {
        return horseEquipment;
    }

    public void setHorseEquipment(Optional<HorseEquipment> horseEquipment) {
        this.horseEquipment = horseEquipment;
    }

    public Horse(String name, Integer age, String gender, String pedegree, List<String> activities, Optional<HorseEquipment> horseEquipment){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.pedegree=pedegree;
        this.activities=activities;
        this.horseEquipment=horseEquipment;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPedegree() {
        return pedegree;
    }

    public void setPedegree(String pedegree) {
        this.pedegree = pedegree;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", pedegree='" + pedegree + '\'' +
                ", activities=" + activities + '\'' +
                ", horse equipment=" + getHorseEquipment() +
                '}';
    }
}
