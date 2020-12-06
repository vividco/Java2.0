import java.time.LocalDate;

public class Beer extends Drinks{
    protected float degree;
    public Beer(){
        this.day = 30;
    }
    public Beer(String name,double cost,LocalDate time,float degree){
        this.day = 30;
        this.degree = degree;
        this.time = time;
        this.cost = cost;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", time=" + time +
                ", day=" + day +
                ", degree=" + degree +
                '}';
    }
}
