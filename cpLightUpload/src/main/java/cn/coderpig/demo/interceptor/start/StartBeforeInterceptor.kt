package cn.coderpig.demo.interceptor.start

import cn.coderpig.demo.LightUploadException
import cn.coderpig.demo.interceptor.Interceptor
import cn.coderpig.demo.task.Task
import cn.coderpig.demo.utils.FileUtils
import cn.coderpig.demo.utils.logV
import java.io.File

/**
 * Author: zpj
 * Date: 2021-07-30
 * Desc: 上传前第一个拦截器，可在此做一些常规操作
 */
class StartBeforeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Task {
        "上传文件常规校验 ============".logV()
        val task = chain.task()
        "检查文件路径是为空...".logV()
        if (task.filePath.isNullOrBlank()) throw LightUploadException("The file path is null.")
        "检查文件是否存在...".logV()
        val uploadFile = File(task.filePath!!)
        if (!uploadFile.exists()) throw NoSuchFileException(file = uploadFile, reason = "The upload file doesn't exist.")
        "获取文件名...".logV()
        task.fileName = uploadFile.name
        "获取文件类型...".logV()
        val dot = task.fileName!!.lastIndexOf('.')
        task.fileType = if (dot > -1 && dot < task.fileName!!.length - 1) uploadFile.name.substring(dot + 1) else null
        "计算文件md5...".logV()
        task.md5 = FileUtils.getFileMD5ToString(uploadFile)
        "常规校验执行完毕 → ${task.fileName} → ${task.md5}".logV()
        return chain.proceed(task)
    }
}