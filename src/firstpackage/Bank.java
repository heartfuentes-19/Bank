package firstpackage;

import java.util.Optional;

/**
 * Minimal Bank contract.
 */
public interface Bank {

    /**
     * Returns the account for the given id, or an empty Optional if not found.
     *
     * @param id account identifier
     * @return an Optional containing the BankAccount if present
     */
    Optional<BankAccount> getAccount(int id);

    /**
     * Adds the given account to the bank.
     *
     * @param account the account to add
     */
    void addAccount(BankAccount account);
}
