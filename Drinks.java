import java.time.LocalDate;

public abstract class Drinks{
    protected String name;
    protected double cost;
    protected LocalDate time;
    protected int day;  //保质期
    public Drinks(){ }
    public Drinks(String name,double cost,LocalDate time,int day){
       this.time = time;
       this.day = day;
       this.cost = cost;
       this.name = name;
   }

    public boolean overdue(LocalDate time, int day) {
        LocalDate target=time.withDayOfMonth(day);
        LocalDate now = LocalDate.now();
        return now.isBefore(target);
    }
    public abstract String toString();
}
