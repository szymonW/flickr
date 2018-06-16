package pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.view.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pwr.edu.pl.flickr.flickrpublicfeed.domain.publicfeed.PublicFeedItem
import pwr.edu.pl.flickr.R
import pwr.edu.pl.flickr.databinding.ItemFeedBinding
import pwr.edu.pl.flickr.flickrpublicfeed.ui.publicfeed.viewmodel.PublicFeedItemViewModel

/**
 * Created by Michal S. on 05.12.2017.
 */
internal class PublicFeedListAdapter(private val items: List<PublicFeedItem>, context: Context) : RecyclerView.Adapter<PublicFeedListAdapter.ViewHolder>() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemFeedBinding>(layoutInflater, R.layout.item_feed, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val publicFeedItem = items[position]
        holder.bind(publicFeedItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    internal class ViewHolder(private val binding: ItemFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        private val publicFeedItemViewModel: PublicFeedItemViewModel = PublicFeedItemViewModel()

        init {
            binding.itemViewModel = publicFeedItemViewModel
        }

        fun bind(item: PublicFeedItem) {
            publicFeedItemViewModel.setItem(item)
            binding.executePendingBindings()
        }
    }
}