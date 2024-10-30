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

    var output = withdraw(money)
    println("The amount you withdrew is $output dollars.")

    output = debitWithdraw(money)
    println("The amount you withdrew from the debit account is $output dollars.")

    output = deposit(money)
    println("The amount you deposited is $output dollars.")

    output = creditDeposit(money)
    println("The amount you deposited into the credit account is $output dollars.")
}

fun withdraw(amount: Int): Int {
    if (accountBalance >= amount) {
        accountBalance -= amount
        println("Withdrew: $amount dollars.")
        println("Updated balance: $accountBalance dollars.")
        return amount
    } else {
        println("Not enough balance to withdraw $amount dollars.")
        return 0
    }
}

fun debitWithdraw(amount: Int): Int {
    return if (accountBalance == 0) {
        println("Can't withdraw, no money in this account!")
        accountBalance
    } else if (amount > accountBalance) {
        println("Not enough money in this account! The balance is $accountBalance dollars.")
        0
    } else {
        withdraw(amount)
    }
}

fun deposit(amount: Int): Int {
    accountBalance += amount
    println("You successfully deposited $amount dollars. The current balance is $accountBalance dollars.")
    return amount
}

fun creditDeposit(amount: Int): Int {
    return if (accountBalance == 0) {
        println("You don't need to deposit anything; the balance is already zero.")
        accountBalance
    } else if (accountBalance + amount > 0) {
        println("Deposit failed; you tried to pay off an amount greater than the credit balance. The balance is $accountBalance dollars.")
        0
    } else {
        deposit(amount)
    }
}