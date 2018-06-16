package pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.protocol

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Michal S. on 05.12.2017.
 */
internal object GsonConverter {

    private var gsonConverter: GsonConverterFactory =
            GsonConverterFactory.create(GsonBuilder().create())

    val converter: GsonConverterFactory
        get() {
            return gsonConverter
        }
}
