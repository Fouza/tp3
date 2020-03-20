package com.example.myapplicationj

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*



data class Prod(val name:String, val price:Long, var qte:Int)

class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
    val name = view.findViewById<TextView>(R.id.name) as TextView
    val prod = view.findViewById<ImageView>(R.id.wut) as ImageView
}

class MyAdapter(val context: Context, var data:List<Prod> ): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main2, parent, false) as TextView
        //Set the view size, margins, paddings ...
        return MyViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = data[position].toString()
    }

     override fun getItemCount()= data.size


}


abstract class Product(val name:String, val price:Long, var qte: Int)
{
    abstract fun getType() : String
}
class Pack (   name: String,
               price: Long,
               qte: Int,
               val giftName: String,
               val giftQte: Int,
               val smartphones: List<Smartphone> )
    : Product (
    name,
    price,
    qte
) {
    override fun getType(): String {
        return "Pack"
    }
}

class Smartphone (
    name: String,
    price: Long,
    qte: Int,
    val brand: String,
    val model: String,
    val color: String,
    val qtePhone: Int?
) : Product (
    name,
    price,
    qte
) {
    override fun getType(): String {
        return "Smartphone"
    }
}

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val phone =  Smartphone(name = "LG 340", price = 30, qte = 3, brand = "LG", model = "LG", color = "Black", qtePhone = 2);
        val pack = Pack(
            name = "Premium pack",
            price = 230,
            qte = 3,
            giftName = "Alpha gift",
            giftQte = 2,
            smartphones = listOf<Smartphone>(
                Smartphone(name = "iPhone 8", price = 30,qte = 3,brand = "Apple", model = "iPhone", color = "Black", qtePhone = 2),
                Smartphone( name = "LG 340", price = 30, qte = 3,brand = "LG", model = "LG", color = "Black",qtePhone = 2)));

        displayProduct(phone)
    }

    fun displayProduct(product:Product){
        qte.text = product.qte.toString()
        price.text = product.price.toString()
        name.text = product.name
    }

}



