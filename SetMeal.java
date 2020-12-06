public class SetMeal {
    private String name;
    private double price;
    private String chicken;
    private Drinks drinks;
    public SetMeal(String name,double price,String chicken,Drinks drinks){
        this.name = name ;
        this.price = price;
        this.chicken = chicken ;
        this.drinks = drinks ;
    }
    public double getPrice() {
        return price;
    }
    public Drinks getDrinks() {
        return drinks;
    }
    @Override
    public String toString() {
        return "SetMeal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", chicken='" + chicken + '\'' +
                ", drinks=" + drinks +
                '}';
    }
}
