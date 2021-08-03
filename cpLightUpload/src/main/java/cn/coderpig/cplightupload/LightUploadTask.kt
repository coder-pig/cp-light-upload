package cn.coderpig.cplightupload

import cn.coderpig.cplightupload.entity.ReqData
import cn.coderpig.cplightupload.upload.Response
import cn.coderpig.cplightupload.upload.Upload


/**
 * Author: zpj
 * Date: 2021-07-30
 * Desc:上传任务相关
 */

data class Response(var statusCode: Int, var content: String)

/** 上传文件类型的枚举 */
enum class LightUploadTask {
    IMAGE, VIDEO, AUDIO, FILE, ELSE
}

/** 上传任务状态枚举，依次为：上传前、准备上传、开始上传、上传中、上传后 */
enum class TaskStatus {
    BEFORE, START, UPLOADING, FAILURE, DONE
}

/** 上传任务基类(抽取共有属性) */
abstract class Task {
    var md5: String? = null         // 文件md5
    var fileName: String? = null    // 文件名
    var fileType: String? = null    // 文件类型
    var filePath: String? = null    // 文件路径
    var fileUrl: String? = null     // 服务器文件URL
    var reqData: ReqData? = null    // 任务请求参数
    var status: TaskStatus? = TaskStatus.BEFORE  // 任务状态，初始化默认Before
    var callback: Upload.CallBack? = null   // 上传回调
    var response: Response? = null  // 上传结果
    var throwable: Throwable? = null  // 异常信息
}

/** 图片类型的上传任务 */
class ImageTask : Task() {
    var needCompress: Boolean? = false  // 图片是否需要压缩
    var compressPercent: Int? = 30  // 图片的压缩比例
}

/** 视频类型的上传任务 */
class VideoTask : Task() {
    var compressVideoPath: String? = null   // 压缩视频路径
    var compressVideoMD5: String? = null   // 压缩视频MD5
}

/** 音频类型的上传任务 */
class AudioTask : Task()

/** 文件类型的上传任务 */
class FileTask : Task()

/** 其他类型的上传任务 */
class ElseTask: Task()
