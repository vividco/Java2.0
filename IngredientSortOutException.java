public class IngredientSortOutException extends RuntimeException{
    private String mess;
    public IngredientSortOutException(String mess){
        super();
        this.mess  = mess;
    }
}
