package com.timpolicar.recyclerviewtutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.timpolicar.recyclerviewtutorial.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //typicaly we are going to have more viewholders so when statement is a practice. is means: is of type
        when(holder){
            is BlogViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(blogList: List<BlogPost>){
        items = blogList
    }

    inner class BlogViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

        val blogImage = itemView.blog_image
        val blogTitle = itemView.blog_title
        val blogAuthor = itemView.blog_author

        fun bind(blogPost: BlogPost){
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)

            //glide dependency is for loading images
            //request is object that we have to make. Sets some default values to images
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background) //if image cant be displayed display this image
                .error(R.drawable.ic_launcher_background) //if there is some error display this image
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image) //load that image URL
                .into(blogImage) //loading this image into blogimage
        }
    }

}