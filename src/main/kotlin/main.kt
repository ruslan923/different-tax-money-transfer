const val MAX_TRANSFER_DAY: Int = 150_000
const val MAX_TRANSFER_MONTH: Int = 600_000
const val MAX_TRANSFER_DAY_VK_PAY: Int = 15_000
const val MAX_TRANSFER_MONTH_VK_PAY: Int = 40_000
const val LIMIT_CARD_MONTH: Int = 75_000

fun main() {
    val transferVkPayDay = 21200
    var transferVkPayMonth = 29500
    val totalTransferVkPay = transferVkPayDay + transferVkPayMonth

    val transferCardDay = 99000
    var transferCardMonth = 900000
    val comissionCardVisaMirMin = 35
    val comissionCardVisaMir = (transferCardDay * 0.75) / 100
    val totalComissionVisaMir: Int
    if (comissionCardVisaMir < comissionCardVisaMirMin) {
        totalComissionVisaMir = comissionCardVisaMirMin
    } else {
        totalComissionVisaMir = (comissionCardVisaMir).toInt()
    }
    val totalTransferCard = transferCardDay + transferCardMonth
    val comissionMasterCardMaestro = ((transferCardDay * 0.6) / 100) + 20


        printMasterCardMaestro(transferCardMonth, transferCardDay, totalTransferCard, comissionMasterCardMaestro)

        printVisaMir(transferCardMonth, transferCardDay, totalTransferCard, totalComissionVisaMir)

        printVkPay(transferVkPayMonth, transferVkPayDay, totalTransferVkPay)

}

private fun printVkPay(transferVkPayMonth: Int, transferVkPayDay: Int, totalTransferVkPay: Int) {
    var transferVkPayMonth1 = transferVkPayMonth
    if (transferVkPayMonth1 > MAX_TRANSFER_MONTH_VK_PAY) {
        println("Вы превысили допустимый лимит переводов, дождитесь окончания месяца")
    } else if (transferVkPayDay > MAX_TRANSFER_DAY_VK_PAY) {
        println("Вы не можете перевести одним платежом больше $MAX_TRANSFER_DAY_VK_PAY руб.")
    } else if (transferVkPayDay <= MAX_TRANSFER_DAY_VK_PAY && totalTransferVkPay < MAX_TRANSFER_MONTH_VK_PAY) {
        println("Перевод разрешен")
        transferVkPayMonth1 += transferVkPayDay
    } else {
        println("В этом месяце вы можете перевести по VK Pay не более ${MAX_TRANSFER_MONTH_VK_PAY - transferVkPayMonth1} руб.")
    }
    println("В этом месяце вы перевели на VK Pay $transferVkPayMonth1 руб.")
}

private fun printVisaMir(
    transferCardMonth: Int,
    transferCardDay: Int,
    totalTransferCard: Int,
    totalComissionVisaMir: Int
) {
    var transferCardMonth1 = transferCardMonth
    if (transferCardMonth1 > MAX_TRANSFER_MONTH) {
        println("Превышен лимит переводов по карте")
    } else if (transferCardDay > MAX_TRANSFER_DAY) {
        println("Вы не можете перевести по карте больше $MAX_TRANSFER_DAY руб. в сутки")
    } else if (transferCardDay <= MAX_TRANSFER_DAY && totalTransferCard < MAX_TRANSFER_MONTH) {
        println("Перевод разрешен\nКомиссия за перевод по карте составила $totalComissionVisaMir руб.")
        transferCardMonth1 += transferCardDay
    } else {
        println("В этом месяце вы может перевести по карте не более ${MAX_TRANSFER_MONTH - transferCardMonth1} руб.")
    }
    println("В этом месяце вы перевели по карте $transferCardMonth1 руб.")
}

private fun printMasterCardMaestro(
    transferCardMonth: Int,
    transferCardDay: Int,
    totalTransferCard: Int,
    comissionMasterCardMaestro: Double
): Int {
    var transferCardMonth1 = transferCardMonth
    if (transferCardMonth1 > MAX_TRANSFER_MONTH) {
        println("Превышен лимит переводов по карте")
    } else if (transferCardDay > MAX_TRANSFER_DAY) {
        println("Вы не можете перевести по карте больше $MAX_TRANSFER_DAY руб. в сутки")
    } else if (transferCardDay < MAX_TRANSFER_DAY && transferCardMonth1 < LIMIT_CARD_MONTH) {
        println("Перевод разрешен, комиссия составила 0 руб.")
        transferCardMonth1 += transferCardDay
    } else if (transferCardDay <= MAX_TRANSFER_DAY && totalTransferCard < MAX_TRANSFER_MONTH) {
        println("Перевод разрешен, комиссия составила $comissionMasterCardMaestro руб.")
    } else {
        println("В этом месяце вы может перевести по карте не более ${MAX_TRANSFER_MONTH - transferCardMonth1} руб.")
    }
    println("В этом месяце вы перевели по карте $transferCardMonth1 руб.")
    return transferCardMonth1
}