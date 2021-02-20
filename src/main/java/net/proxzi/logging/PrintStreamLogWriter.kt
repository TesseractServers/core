package net.proxzi.logging

import java.io.PrintStream
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.IllegalArgumentException
import java.text.DateFormat
import java.util.*

/**
 * A simple [LogWriter] that writes to a [PrintStream].
 * @since Core 1.1
 * @author Tassilo
 */
class PrintStreamLogWriter(val printStream: PrintStream = System.out, val useAnsi: Boolean = true): LogWriter {

	private fun levelToAnsi(level: Level): String {
		return when (level) {
			Level.INFO -> ANSI_INFO
			Level.DEBUG -> ANSI_DEBUG
			Level.WARNING -> ANSI_WARNING
			Level.SEVERE -> ANSI_SEVERE
			Level.SUCCESS -> ANSI_SUCCESS
			Level.FAILURE -> ANSI_FAILURE
			else -> throw IllegalArgumentException("Unknown level: $level")
		}
	}

	override fun writeLog(log: Log) {
		// Get generics (time, prefix, suffix)
		val time = DateFormat.getDateTimeInstance().format(Date(log.timestamp))
		var prefix = time + " | " + log.level.displayName + " | "
		var suffix = "\n"
		if (useAnsi) {
			prefix = levelToAnsi(log.level) + prefix
			suffix = "$ANSI_TERMINATOR\n"
		}

		// Build lines
		var str = StringBuilder()
		if (log.message != null) {
			str = StringBuilder(prefix + log.message + suffix)
		}
		if (log.error != null) {
			val sw = StringWriter()
			log.error.printStackTrace(PrintWriter(sw))
			val parts = sw.toString().split("\n").toTypedArray()
			for (part in parts) {
				str.append(prefix).append(part).append(suffix)
			}
		}

		// Print!
		printStream.print(str.toString())
	}

	companion object {

		// See: https://en.wikipedia.org/wiki/ANSI_escape_code#Colors

		const val ANSI_INFO: String = "\u001B[38;2;235;235;235m"
		const val ANSI_WARNING: String = "\u001B[38;2;227;161;0m"
		const val ANSI_SEVERE: String = "\u001B[93;41m"
		const val ANSI_DEBUG: String = "\u001B[38;2;195;195;195m"
		const val ANSI_SUCCESS: String = "\u001B[38;2;0;195;0m"
		const val ANSI_FAILURE: String = "\u001B[38;2;195;0;0m"
		const val ANSI_TERMINATOR: String = "\u001B[0m"

	}

}
