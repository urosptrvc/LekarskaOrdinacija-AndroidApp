package com.example.lekarskaordinacija.Domain

import android.os.Parcel
import android.os.Parcelable

data class DoctorsModel(
    val Address:String="",
    val Biography:String="",
    val Id:Int=0,
    val Name:String="",
    val Picture:String="",
    val Special:String="",
    val Experiese:Int=0,
    val Location:String="",
    val Mobile:String="",
    val patients:String="",
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeInt(Id)
        parcel.writeString(Name)
        parcel.writeString(Picture)
        parcel.writeString(Special)
        parcel.writeInt(Experiese)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(patients)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctorsModel> {
        override fun createFromParcel(parcel: Parcel): DoctorsModel {
            return DoctorsModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctorsModel?> {
            return arrayOfNulls(size)
        }
    }

}
