package cn.coderpig.demo.interceptor.end

import cn.coderpig.demo.interceptor.Interceptor
import cn.coderpig.demo.task.Task
import cn.coderpig.demo.utils.logV

/**
 * Author: zpj
 * Date: 2021-07-30
 * Desc: 准备上传最后一个拦截器
 */
class EndReadyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Task {
        "上传前的准备工作已完成.".logV()
        return chain.task()
    }
}