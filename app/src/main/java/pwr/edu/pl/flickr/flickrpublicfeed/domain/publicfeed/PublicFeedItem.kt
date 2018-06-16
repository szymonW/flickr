package pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed

import java.util.*

/**
 * Created by Michal S. on 05.12.2017.
 */
data class PublicFeedItem(
        val title: String,
        val imageUrl: String,
        val publishedDate: Date?,
        val tags: List<String>)