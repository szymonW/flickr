package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed.PublicFeedData
import pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.viewmodel.PublicFeedListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import pwr.edu.pl.flickr.R
import pwr.edu.pl.flickr.databinding.ActivityPublicFeedBinding

class PublicFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val publicFeedViewModel = ViewModelProviders.of(this).get(PublicFeedListViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityPublicFeedBinding>(this, R.layout.activity_public_feed)
        binding.listViewModel = publicFeedViewModel

        val dataSource  = PublicFeedData()
        dataSource.loadDataForTest()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it != null) {
                        Log.d("ELEMENTS", "Size of data ${it.size}")
                    }
                }, {
                })

    }
}
