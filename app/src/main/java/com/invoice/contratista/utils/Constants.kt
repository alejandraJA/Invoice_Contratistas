package com.invoice.contratista.utils

object Constants {
    enum class Priority {
        Low,
        Medium,
        Important,
        Urgent
    }

    enum class Steps {
        Event,
        Budget,
        Receipt,
        Invoice
    }

    enum class EventStatus {
        Start,
        Process,
        Finish,
    }

    const val ID_CUSTOMER = "idCustomer"
    const val ID_BUDGET = "idBudget"
    const val ID_PART = "idPart"
    const val ID_EVENT = "idEvent"
    const val ID_USER = "idUser"
    const val ID_PRODUCT = "idProduct"
}