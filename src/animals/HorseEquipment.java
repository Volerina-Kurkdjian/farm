package animals;

public class HorseEquipment {

    private String saddle;
    private String boots;

  public  HorseEquipment(String saddle,String boots){
        this.saddle=saddle;
        this.boots=boots;
    }

    public String getSaddle() {
        return saddle;
    }

    public void setSaddle(String saddle) {
        this.saddle = saddle;
    }

    public String getBoots() {
        return boots;
    }

    public void setBoots(String boots) {
        this.boots = boots;
    }

    @Override
    public String toString() {
        return "HorseEquipment{" +
                "saddle='" + saddle + '\'' +
                ", boots='" + boots + '\'' +
                '}';
    }
}
