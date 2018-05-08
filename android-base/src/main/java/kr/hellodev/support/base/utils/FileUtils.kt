package kr.hellodev.support.base.utils

import android.net.Uri
import java.io.*
import java.security.MessageDigest

/**
 * @date 2018.05.08
 * @author Cura
 */
class FileUtils {

    companion object {
        fun copy(input: File, output: File) {
            var inputStream: InputStream? = null
            var outputStream: OutputStream? = null

            inputStream = FileInputStream(input)
            outputStream = FileOutputStream(output)
            val buffer = ByteArray(1024)

            try {
                while (true) {
                    val length = inputStream.read(buffer)
                    if (length <= 0) {
                        break
                    }
                    outputStream.write(buffer, 0, length)
                }
            } catch (e: IOException) {
                throw e
            } finally {
                outputStream.flush()
                outputStream.close()
                inputStream.close()
            }
        }

        fun delete(file: File): Boolean {
            return file.exists() && file.delete()
        }

        fun getFile(path: String, name: String): File {
            val file = File(Uri.parse(path).path)
            if (!file.exists() && !file.isFile) {
                throw IllegalArgumentException(file.absolutePath + " is not file.")
            }
            return File(file, name)
        }

        fun move(input: File, output: File): Boolean {
            return input.renameTo(output)
        }

        fun getMd5(file: File): String? {
            var md5 = ""
            try {
                val input = FileInputStream(file)
                val buffer = ByteArray(1024)
                val md5Hash = MessageDigest.getInstance("MD5")
                var numRead = 0
                while (numRead != -1) {
                    numRead = input.read(buffer)
                    if (numRead > 0) {
                        md5Hash.update(buffer, 0, numRead)
                    }
                }
                input.close()
                val md5Bytes = md5Hash.digest()
                return md5Bytes.joinToString("") {
                    String.format("%02x", it)
                }
            } catch (ignore: Exception) {
                ignore.printStackTrace()
            }
            return null
        }
    }
}