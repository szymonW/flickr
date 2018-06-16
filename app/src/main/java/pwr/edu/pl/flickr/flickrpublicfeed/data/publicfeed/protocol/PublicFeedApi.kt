package pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.protocol

import pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.response.PublicFeedJsonResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Michal S. on 05.12.2017.
 */
interface PublicFeedApi {
    @get:GET("feeds/photos_public.gne?format=json&nojsoncallback=1")
    val publicFeed: Single<PublicFeedJsonResponse>
}