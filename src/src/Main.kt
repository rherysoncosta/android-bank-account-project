var accountBalance = (0..1000).random()

fun main() {
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")

    var accountType = ""

    while (accountType == "") {
        println("Choose an option (1, 2 or 3):")
        val input = readlnOrNull()
        val userChoice = input?.toIntOrNull() ?: 0
        println("The selected option is... $userChoice")

        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> println("Invalid choice, please select again.")
        }
    }

    println("Account created successfully: $accountType")
    println("The current balance is $accountBalance dollars.")

    val money = (0..1000).random()
    println("The amount you are attempting to transfer is $money dollars.")

    // Withdraw operation
    var output = withdraw(money)
    println("The amount you withdrew is $output dollars.")

    // Debit withdraw operation
    output = debitWithdraw(money)
    println("The amount you withdrew from the debit account is $output dollars.")

    // Deposit operation
    output = deposit(money)
    println("The amount you deposited is $output dollars.")

    // Credit deposit operation
    output = creditDeposit(money)
    println("The amount you deposited into the credit account is $output dollars.")
}

fun withdraw(amount: Int): Int {
    if (amount > accountBalance) {
        println("Not enough balance to withdraw $amount dollars.")
        return 0
    }
    accountBalance -= amount
    println("You successfully withdrew $amount dollars. The current balance is $accountBalance dollars.")
    return amount
}

fun debitWithdraw(amount: Int): Int {
    if (accountBalance == 0) {
        println("Can't withdraw, no money on this account!")
        return 0
    } else if (amount > accountBalance) {
        println("Not enough money on this account! The current balance is $accountBalance dollars.")
        return 0
    } else {
        return withdraw(amount)
    }
}

fun deposit(amount: Int): Int {
    accountBalance += amount
    println("You successfully deposited $amount dollars. The current balance is $accountBalance dollars.")
    return amount
}

fun creditDeposit(amount: Int): Int {
    if (accountBalance == 0) {
        println("This account is completely paid off! Do not deposit money!")
        return accountBalance
    } else if (accountBalance + amount > 0) {
        println("Deposit failed, you tried to pay off an amount greater than the credit balance. The current balance is $accountBalance dollars.")
        return 0
    } else if (amount == -accountBalance) {
        accountBalance = 0
        println("You have paid off this account!")
        return amount
    } else {
        return deposit(amount)
    }
}
