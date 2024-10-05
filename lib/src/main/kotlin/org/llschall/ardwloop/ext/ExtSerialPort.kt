package org.llschall.ardwloop.ext

import android.bluetooth.BluetoothSocket
import org.llschall.ardwloop.serial.port.ISerialPort

class ExtSerialPort(
    val name: String,
    private val socket: BluetoothSocket,
) : ISerialPort {

    override var baudRate: Int
        get() = 2024
        set(_) {}

    override val descriptivePortName: String
        get() = name

    override val portDescription: String
        get() = name

    override val systemPortName: String
        get() = name

    override fun bytesAvailable(): Int {
        return socket.inputStream.available()
    }

    override fun closePort() {
        return socket.close()
    }

    override fun openPort(): Boolean {
        return true
    }

    override fun readBytes(bytes: ByteArray?, n: Long) {
        val stream = socket.inputStream
        var i = 0;
        while (i < n) {
            val b = stream.read()
            bytes!![i] = b.toByte()
            i++
        }
    }

    override fun writeBytes(bytes: ByteArray?, size: Int): Int {
        if (bytes != null) {
            socket.outputStream.write(bytes)
            return bytes.size
        }
        return 0;
    }
}