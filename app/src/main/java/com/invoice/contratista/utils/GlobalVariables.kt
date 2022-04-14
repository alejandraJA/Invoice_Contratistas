package com.invoice.contratista.utils

class GlobalVariables {
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
}