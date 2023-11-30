package Activity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
    @Test
    public void notEnoughFunds() {
        BankAccount account = new BankAccount(10);
        assertThrows(NotEnoughFundsException.class, () -> {
            account.withdraw(20);
        });
    }

    @Test
    public void enoughFunds() {
        BankAccount account = new BankAccount(100);
        assertDoesNotThrow(() -> {
            account.withdraw(100);
        });
    }
}