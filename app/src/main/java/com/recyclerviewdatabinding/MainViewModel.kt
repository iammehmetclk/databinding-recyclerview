package com.recyclerviewdatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _counter: Int = 5
    private val _counterText: MutableLiveData<String> = MutableLiveData("Counter: $_counter")
    private val _itemList: MutableLiveData<List<MyItem>> = MutableLiveData(listOf(
        MyItem("Title1", "Description1", "https://picsum.photos/101"),
        MyItem("Title2", "Description2", "https://picsum.photos/102"),
        MyItem("Title3", "Description3", "https://picsum.photos/103"),
        MyItem("Title4", "Description4", "https://picsum.photos/104"),
        MyItem("Title5", "Description5", "https://picsum.photos/105")))

    val counterText: LiveData<String> = _counterText
    val itemList: LiveData<List<MyItem>> = _itemList

    fun addItem() {
        _counter++
        _counterText.postValue("Counter: $_counter")
        _itemList.postValue(_itemList.value?.plus(MyItem("Title$_counter",
            "Description$_counter", "https://picsum.photos/${_counter + 100}")))
    }
}