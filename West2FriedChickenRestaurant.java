import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double balance; //余额
    private ArrayList<Beer> BeerArrayList;
    private ArrayList<Juice> JuiceArrayList;
    private static ArrayList<SetMeal> MealArrayList = new ArrayList<SetMeal>(){{
        add(new SetMeal("Meal1",23.0,"Boneless chicken",new Beer("BaiWei",8.0, LocalDate.of(2020,8,10),11)));
        add(new SetMeal("Meal2",20.0,"Bone chicken",new Beer("Qingdao",4.0, LocalDate.of(2020,8,10),4)));
        add(new SetMeal("Meal3",18.0,"Boneless chicken",new Juice("Tongyi",5.0, LocalDate.of(2020,8,10)) ));
        add(new SetMeal("Meal4",18.0,"Bone chicken",new Juice("Tongyi",5.0, LocalDate.of(2020,8,10))));
    }};
    public West2FriedChickenRestaurant(){ }
    public West2FriedChickenRestaurant(double balance,ArrayList<Beer> BeerArrayList,ArrayList<Juice> JuiceArrayList){
        this.balance = balance ;
        this.BeerArrayList = BeerArrayList ;
        this.JuiceArrayList = JuiceArrayList ;
    }
    private boolean use(Beer beer){
        for(int i=0;i<BeerArrayList.size();i++){
            Beer b2=BeerArrayList.get(i);
            if(b2.name.equals(beer.name)&& b2.overdue(b2.time, b2.day)){
                BeerArrayList.remove(i);
                return true;
            }
        }
        String ss = beer.name + " sold out";
        throw new IngredientSortOutException(ss);
    }
    private boolean use(Juice juice){
        for(int i=0;i<JuiceArrayList.size();i++){
            Juice j2=JuiceArrayList.get(i);
            if(j2.name.equals(juice.name)&& j2.overdue(j2.time, j2.day)){
                JuiceArrayList.remove(i);
                return true;
            }
        }
        String ss = juice.name + " sold out";
        throw new IngredientSortOutException(ss);
    }
    public void sale_SetMeal(SetMeal S){
        if(S.getDrinks() instanceof Beer ){
            Beer b = (Beer)S.getDrinks();
            if(use(b)) balance += S.getPrice();
        }
        else if(S.getDrinks() instanceof Juice ){
            Juice j = (Juice)S.getDrinks();
            if(use(j)) balance += S.getPrice();
        }
    }
    public void stock(ArrayList<Beer> BArrayList,ArrayList<Juice> JArrayList){
        double sum = 0;
        for(int i=0;i<BArrayList.size();i++) {
            Beer b = BArrayList.get(i);
            BeerArrayList.add(b);
            sum += b.cost;
        }
        for(int i=0;i<JArrayList.size();i++) {
            Juice j = JArrayList.get(i);
            sum += j.cost;
        }
        if(sum>balance){ //余额不足
            double m = balance - sum;
            String ss = "The purchase is "+m+" less";
            throw new OverdraftBalanceException(ss);
        }
        else {
            BArrayList.addAll(BArrayList);
            JuiceArrayList.addAll(JArrayList);
            balance -= sum;
        }
    }
}
