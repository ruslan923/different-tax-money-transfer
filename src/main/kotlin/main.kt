fun main() {
    val cardName = "Visa"
    val transactions = 125000
    val transactionsMonth = 90000

    val access = accessAllowCalc(cardName, transactions, transactionsMonth)
    print(comissionCalc(cardName, access, transactions))

}

fun comissionCalc(cardName: String, access: Boolean, transactions: Int): String {
    return when (cardName) {
        "Mastercard", "Maestro" -> masterCardMaestroCalc(cardName, access, transactions)
        "Visa", "Mir" -> visaMirCalc(cardName, access, transactions)
        else -> vkPayCalc(cardName, access, transactions)
    }
}

private fun visaMirCalc(cardName: String, access: Boolean, transactions: Int): String {
    return if (access && (transactions * 0.00075) < 35.0) {
        "Комиссия по карте $cardName составила ${(transactions * 0.0) + 35.0} рублей"
    } else if (access && (transactions * 0.00075) > 35.0) {
        "Комиссия по карте $cardName составила ${transactions * 0.00075} рублей"
    } else {
        "Операция по карте $cardName отклонена"
    }
}

private fun masterCardMaestroCalc(cardName: String, access: Boolean, transactions: Int): String {
    return if (access && transactions <= 75000) {
        "Комиссия по карте $cardName составила ${transactions * 0.0} рублей"
    } else if (access && transactions > 75000) {
        "Комиссия по карте $cardName составила ${(transactions * 0.0006) + 20.0} рублей"
    } else {
        "Операция по карте $cardName отклонена"
    }
}

fun vkPayCalc(cardName: String, access: Boolean, transactions: Int): String {
    return if (access) {
        "Комиссия по карте $cardName составила ${transactions * 0.0} рублей"
    } else {
        "Операция по карте $cardName отклонена"
    }
}

fun accessAllowCalc(cardName: String, transactions: Int, transactionsMonth: Int): Boolean {
    return if ((cardName == "Mastercard" || cardName == "Maestro" ||
                cardName == "Visa" || cardName == "Mir") && transactions <= 150000 &&
        (transactionsMonth + transactions) <= 600000
    ) {
        true
    } else cardName == "VkPay" && transactions <= 15000 && (transactionsMonth + transactions) <= 40000
}