package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.databinding

import android.content.Context
import android.databinding.BindingAdapter
import android.net.ConnectivityManager
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import pwr.edu.pl.flickr.R
import pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed.PublicFeedItem
import pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.view.adapter.PublicFeedListAdapter
import pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.viewmodel.PublicFeedListViewModel

/**
 * Created by Michal S. on 05.12.2017.
 * Bindings for Public Feed list activity
 */
@BindingAdapter("publicFeedList")
fun bindList(recyclerView: RecyclerView, items: List<PublicFeedItem>?) {
    if (items == null) {
        recyclerView.adapter = PublicFeedListAdapter(ArrayList(0), recyclerView.context)
    } else {
        recyclerView.adapter = PublicFeedListAdapter(items, recyclerView.context)
    }
}

@BindingAdapter("refreshBind")
fun bindRefreshAction(view: SwipeRefreshLayout, viewModel: PublicFeedListViewModel) {
    view.setOnRefreshListener({ viewModel.reloadData() })
}

@BindingAdapter("isLoadingBind")
fun bindLoadingState(view: SwipeRefreshLayout, isLoading: Boolean) {
    view.isRefreshing = isLoading
}

@BindingAdapter("showErrorBind")
fun bindShowError(view: View, error: Throwable?) {
    if (error != null){
        if(isOnline(view.context)) {
            showSnackbar(view, R.string.error_during_data_loading)
        } else {
            showSnackbar(view, R.string.error_no_internet)
        }
    }
}

private fun showSnackbar(view: View, rId: Int) {
    Snackbar.make(view, rId, Snackbar.LENGTH_LONG).show()
}

private fun isOnline(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetworkInfo
    return netInfo != null && netInfo.isConnectedOrConnecting
}



