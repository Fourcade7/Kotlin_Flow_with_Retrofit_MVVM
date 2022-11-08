package com.pr7.kotlin_flow_with_retrofit_mvvm.model.postrepository

import com.pr7.kotlin_flow_with_retrofit_mvvm.model.network.RetrofitInstance
import com.pr7.kotlin_flow_with_retrofit_mvvm.model.postmodel.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class MainRepository {

//    fun getAllPosts():Flow<List<Posts>> = flow {
//        emit(RetrofitInstance.getapi().getdata())
//    }.flowOn(Dispatchers.IO)

    fun getallposts2():Flow<List<Posts>> {
        val myflow= flow {
            emit(RetrofitInstance.getapi().getdata())
        }
        return myflow
    }

}