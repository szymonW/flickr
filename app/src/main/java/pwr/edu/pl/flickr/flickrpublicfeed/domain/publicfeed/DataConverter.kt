package pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed

import android.util.Log
import pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.response.PublicFeedItemJsonResponse
import java.text.DateFormat
import java.text.ParseException
import java.util.Date

/**
 * Created by Michal S. on 05.12.2017.
 * Converters for json data strings to final structure
 */
fun PublicFeedItemJsonResponse.getTags(): List<String> {
    tags?.let {
        val list = ArrayList<String>()
        return try {
            var items = it.split(" ")

            Log.v("tagi", items[0])

            if (items.isNotEmpty()) for(i in 1..items.size) if (i<=3) list.add(items[i-1])

            Log.v("tagi", items.toString())
            Log.v("tagi", list.toString())

            return list
        } catch (e: ParseException) {
            emptyList()
        }
    }
}



fun PublicFeedItemJsonResponse.getPublishedDate(): Date? {
    val datePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    val dateFormatter: DateFormat = java.text.SimpleDateFormat(datePattern, java.util.Locale.getDefault())
    published?.let {
        return try {
            dateFormatter.parse(it)
        } catch (e: ParseException) {
            null
        }
    }
    return null
}