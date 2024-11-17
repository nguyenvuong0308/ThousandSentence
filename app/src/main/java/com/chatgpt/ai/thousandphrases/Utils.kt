package com.chatgpt.ai.thousandphrases

import java.util.Calendar
import java.util.concurrent.TimeUnit

object Utils {
    fun formatDate(timestamp: Long): String {
        val currentCalendar = Calendar.getInstance()
        val targetCalendar = Calendar.getInstance().apply { timeInMillis = timestamp }

        // Kiểm tra nếu cùng ngày
        return if (currentCalendar.get(Calendar.YEAR) == targetCalendar.get(Calendar.YEAR) &&
            currentCalendar.get(Calendar.DAY_OF_YEAR) == targetCalendar.get(Calendar.DAY_OF_YEAR)
        ) {
            "Hôm nay"
        } else {
            // Tính số ngày chênh lệch
            val diffInMillis = currentCalendar.timeInMillis - targetCalendar.timeInMillis
            val daysAgo = TimeUnit.MILLISECONDS.toDays(diffInMillis)
            "$daysAgo ngày trước"
        }
    }

    fun subDay(timestamp: Long): Int {
        val currentCalendar = Calendar.getInstance()
        val targetCalendar = Calendar.getInstance().apply { timeInMillis = timestamp }
        val diffInMillis = currentCalendar.timeInMillis - targetCalendar.timeInMillis
        val daysAgo = TimeUnit.MILLISECONDS.toDays(diffInMillis)
        return daysAgo.toInt()
    }

    fun queryVocabularyGPT(rootVocabulary: String): String {
        return "tìm 5 động từ, 5 tính từ , 5 danh từ, 10 câu liên quan đến từ $rootVocabulary và các từ đã tìm. Trả về kết quả json song ngữ anh việt như mẫu sau: {\n" +
                "  \"verb\": [\n" +
                "    {\n" +
                "      \"vi\": \"\",\n" +
                "      \"en\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"noun\": [\n" +
                "    {\n" +
                "      \"vi\": \"\",\n" +
                "      \"en\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"adj\": [\n" +
                "    {\n" +
                "      \"vi\": \"\",\n" +
                "      \"en\": \"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"sentence\": [\n" +
                "    {\n" +
                "      \"vi\": \"\",\n" +
                "      \"en\": \"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }
}