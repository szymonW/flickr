package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
import pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed.PublicFeedData
import pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed.PublicFeedItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Michal S. on 05.12.2017.
 */
class PublicFeedListViewModel : ViewModel() {

    val isLoading = ObservableField(false)
    val onError = ObservableField<Throwable>()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val dataSource = PublicFeedData()

    var items: ObservableList<PublicFeedItem> = ObservableArrayList()

    init {
        reloadData()
    }

    fun reloadData() {
        isLoading.set(true)
        compositeDisposable.add(
                dataSource.loadData()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            isLoading.set(false)
                            if (it != null) {
                                items.clear()
                                items.addAll(it)
                            }
                        }, {
                            onError.set(it)
                            isLoading.set(false)
                        })
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}