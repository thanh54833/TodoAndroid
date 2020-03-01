package com.thanh.todoandroid

class Application {
    var application: Application? = null

    //other variable
    fun getInstance(): Application? {
        if (application == null) {
            application = Application()
        }
        return application
    }


}