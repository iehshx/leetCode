package zip

import org.apache.commons.compress.archivers.ArchiveEntry
import org.apache.commons.compress.archivers.ArchiveInputStream
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class ZipTest {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var zipFile = File("/Users/dz0400351/Downloads/ab6893cf085240c18669a452c1109830.zip")
            var inputStream: ArchiveInputStream? = null
            try {
                inputStream = ZipArchiveInputStream(
                    FileInputStream(zipFile), "UTF-8",
                    false, true
                )
                var entry: ArchiveEntry?
                while (null != inputStream.getNextEntry().also { entry = it }) {
                    if (!inputStream.canReadEntryData(entry)) {
                        println("Can't read entry: $entry")
                        continue
                    }
                    var name = entry!!.name.replace("\\.\\./".toRegex(), "")
//                    if (entry!!.isDirectory) {
//                        name = name.substring(0, name.length - 1)
//                        println("目录$name");
////                        val dir = File(skinDir.toString() + File.separator + name)
////                        if (!dir.exists()) {
////                            dir.mkdirs()
////                        }
//                    } else {
                    if (!entry!!.isDirectory && !name.startsWith("__MACOSX")) {
                        println(name)
                    }
//                        val newFile = File(skinDir.toString() + File.separator + name)
//                        if (newFile.parentFile?.exists() == true) {
//                            newFile.parentFile!!.mkdirs()
//                        }
//                        try {
//                            newFile.createNewFile()
//                        } catch (e: IOException) {
//                            e.printStackTrace()
//                        }
//                        var out: FileOutputStream? = null
//                        try {
//                            out = FileOutputStream(newFile)
//                            var i: Int
//                            val buffer = ByteArray(1024)
//                            while (inputStream.read(buffer).also { i = it } > 0) {
//                                out.write(buffer, 0, i)
//                                out.flush()
//                            }
//                        } finally {
//                            out?.close()
//                        }
//                    }
                }
                println("解压成功")
//                zipFile.delete()
//                skinDir.renameTo(zipFile)
            } catch (e: Exception) {
                e.printStackTrace()
//                LogUtil.w(TAG, "解压失败:" + e.message)
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

}