package pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed

import pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.network.NetworkConnectionService
import pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.protocol.PublicFeedApi
import pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.response.PublicFeedItemJsonResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by Michal S. on 05.12.2017.
 */
class PublicFeedData {

    fun loadData(): Single<List<PublicFeedItem>> {
        return NetworkConnectionService.generateService(PublicFeedApi::class.java)
                .publicFeed.toObservable()
                .flatMapIterable<PublicFeedItemJsonResponse>({ it.items })
                .map { publicFeedItemJsonResponse ->
                    PublicFeedItem(
                            publicFeedItemJsonResponse.title,
                            publicFeedItemJsonResponse.media.m,
                            publicFeedItemJsonResponse.getPublishedDate(),
                            publicFeedItemJsonResponse.getTags())
                }
                .toList().subscribeOn(Schedulers.io())
    }

    fun loadDataForTest(): Single<List<PublicFeedItemJsonResponse>> {
        return NetworkConnectionService.generateService(PublicFeedApi::class.java)
                .publicFeed.toObservable()
                .flatMapIterable<PublicFeedItemJsonResponse>({ it.items })
                .toList().subscribeOn(Schedulers.io())
    }

}