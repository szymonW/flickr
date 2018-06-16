package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.databinding

import android.content.Context
import android.databinding.BindingAdapter
import android.support.annotation.VisibleForTesting
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.view.PublicFeedActivity
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Michal S. on 05.12.2017.
 * Bindings for Public Feed items on the list
 */
@BindingAdapter("publishedDateBind")
fun bindPublishedDate(textView: TextView, date: Date?) {
    if (date != null) {
        textView.text = SimpleDateFormat.getDateTimeInstance().format(date)
    }
}

@BindingAdapter("tBind")
fun bindTag(textView: TextView, tags: List<String>){
    textView.text = tagsToString(tags)
}

@BindingAdapter("imageBind")
fun bindImage(imageView: ImageView, imageUrl: String){
    Picasso.with(imageView.context).load(imageUrl).into(imageView)
}

fun tagsToString(tags: List<String>): String {
    val tagsStringBuilder = StringBuilder()
    for (i in tags.indices) {
        tagsStringBuilder.append(tags[i])
        tagsStringBuilder.append(" ")
    }
    return tagsStringBuilder.toString()
}
