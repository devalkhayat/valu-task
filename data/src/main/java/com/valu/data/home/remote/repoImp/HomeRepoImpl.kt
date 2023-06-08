package com.valu.data.home.remote.repoImp
import com.valu.data.home.remote.EndPoints
import com.valu.data.common.RetrofitBuilder
import com.valu.domain.common.FinalResponse
import com.valu.domain.home.models.Product
import com.valu.domain.home.repositories.HomeRepo

class HomeRepoImpl(private val retrofitBuilder: RetrofitBuilder): HomeRepo {


    private val endPoints=retrofitBuilder.start()?.create(EndPoints::class.java)
    override suspend fun getAll(): FinalResponse<MutableList<Product>> {

        try {

            val result =  endPoints?.getAllProducts()

            result.let {

                when (it?.code()) {
                    //Success

                    200 ->  {
                        return FinalResponse(data =it.body()!!, status = true)
                    }

                    else -> {
                        return FinalResponse(message = result?.message(), status = false)
                    }
                }

            }


        }catch (ex:Exception){

            return FinalResponse( message = ex.message!!, status = false)
        }
    }


}