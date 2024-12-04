package com.example.postjson

import android.app.RemoteAction

class posts(

    val posts : ArrayList<post>,
    val total : Int,
    val skip :Int,
    val limit: Int
)

class post(

    val id    : Int,
    val title : String,
    val body  : String,
    val tags  : ArrayList<String>,
    val reactions : Reaction,
    val views : Int,
    val userId: Int
)
class  Reaction(


)