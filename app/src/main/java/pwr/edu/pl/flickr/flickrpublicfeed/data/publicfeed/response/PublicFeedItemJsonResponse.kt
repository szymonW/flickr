package pwr.edu.pl.flickr.flickrpublicfeed.data.publicfeed.response

/**
 * Created by Michal S. on 04.12.2017.
 * Public Feed Item POJO for json format response
 */
data class PublicFeedItemJsonResponse(
        val title: String,
        val published: String?,
        val tags: String,
        val media: MediaJsonResponse)