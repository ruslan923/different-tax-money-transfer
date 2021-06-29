import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun comissionCalc_MasterCard_Maestro() {
        val cardName = "Mastercard"
        val access = true
        val transactions = 71500

        val result = comissionCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Комиссия по карте Mastercard составила 0.0 рублей", result)
    }

    @Test
    fun comissionCalc_Visa_Mir() {
        val cardName = "Visa"
        val access = false
        val transactions = 71500

        val result = comissionCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Операция по карте $cardName отклонена", result)
    }

    @Test
    fun comissionCalc_VkPay() {
        val cardName = "VkPay"
        val access = true
        val transactions = 1500

        val result = comissionCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Комиссия по карте $cardName составила ${transactions * 0.0} рублей", result)
    }

    @Test
    fun vkPayCalc() {
        val cardName = "VkPay"
        val access = true
        val transactions = 16000

        val result = vkPayCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Комиссия по карте $cardName составила ${transactions * 0.0} рублей", result)
    }
    @Test
    fun vkPayCalc_Denaid() {
        val cardName = "VkPay"
        val access = false
        val transactions = 16000

        val result = vkPayCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Операция по карте $cardName отклонена", result)
    }

    @Test
    fun accessAllowCalc() {
        val cardName = "VkPay"
        val transactions = 15000
        val transactionsMonth = 25000

        val result = accessAllowCalc(
            cardName = cardName,
            transactions = transactions,
            transactionsMonth = transactionsMonth
        )
        assertEquals(true, result)
    }

    @Test
    fun accessAllowCalc_Denaid() {
        val cardName = "Mir"
        val transactions = 185000
        val transactionsMonth = 925000

        val result = accessAllowCalc(
            cardName = cardName,
            transactions = transactions,
            transactionsMonth = transactionsMonth
        )
        assertEquals(false, result)
    }

    @Test
    fun visaMirCalc() {
        val cardName = "Visa"
        val access = true
        val transactions = 76000

        val result = visaMirCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Комиссия по карте $cardName составила ${transactions * 0.00075} рублей", result)
    }

    @Test
    fun visaMirCalc_Denaid() {
        val cardName = "Visa"
        val access = false
        val transactions = 76000

        val result = visaMirCalc(
            cardName = cardName,
            access = access,
            transactions = transactions
        )
        assertEquals("Операция по карте $cardName отклонена", result)
    }
}