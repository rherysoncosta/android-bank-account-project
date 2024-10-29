fun main () {

    println("Welcome to your banking system.")

    println("What type of account would you like to create?")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")


    var accountType = ""


    while (accountType == "") {
            println("Choose an option (1, 2 or 3:")

        val input = readlnOrNull()
        val userChoice = input?.toIntOrNull() ?: 0

        println("The selected option is... $userChoice")


        when(userChoice) {
            1 -> {
                accountType = "debit"
            }
            2 -> {
                accountType = "credit"
            }
            3 -> {
                accountType = "checking"
            }
            else -> {
                println("Invalid choice, please select again.")
            }
        }

    }
    println("Account created: $accountType")
}