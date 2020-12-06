import java.time.LocalDate;

public class Juice extends Drinks{
    public Juice(){this.day = 2;}
    public Juice(String name, double cost,LocalDate time){
        this.day = 2;
    }
    @Override
    public String toString() {
        return "Juice{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", time=" + time +
                ", day=" + day +
                '}';
    }
}
