package com.example.realmprototype

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class FavoriteModel (
    @PrimaryKey
    var id: String = UUID.randomUUID().toString(),

    var Company :String?= "",

    var FP_version : String?="",

    var Family : String?="",

    var CAN_ID : String?="",

    var DT_UTC : String?="",

    var user : Int = 0,

    var unit : Int = 0,

    var DD_localisation : String?="",

    var parameterModel : RealmList<ParameterModel> = RealmList()
): RealmObject()
open class ParameterModel (

    var pid : String? = "",

    var restore: Int = 0,

    var value: Int = 0,
    ): RealmObject()

