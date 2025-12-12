public class TransactionProcessor {

    public static void transfer(BankAccount bank, BankAccount bankToTransfer, double amount){
        double transferAmount = bank.withdraw(amount);
        bankToTransfer.deposit(transferAmount);
    }
}
