package com.newsapp.withmvvm.util

class Util {

    companion object {

        fun convertErrorStatusCodeToString(statusCode: Int): String {
            return when(statusCode) {
                400 -> "Bad Request. The request was  unacceptable, often due to a missing or misconfigured parameter"
                401 -> "Unauthorized. Your API key was missing from the request, or wasn't correct"
                426 -> "Maximum Limit Reached. You exhausted the maximum limit allowed for Developer account"
                429 -> "Too Many Requests. You made too many requests within a window of time and have been rate limited. Please try again after some time"
                500 -> "Server Error. Something went wrong on our side!"
                else -> "Unknown Error Occurred!"
            }
        }

    }

}