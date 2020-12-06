public class OverdraftBalanceException extends RuntimeException{
    private String mess;
    public OverdraftBalanceException(String mess){
        super();
        this.mess  = mess;
    }
}
