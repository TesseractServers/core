package net.proxzi.logging;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.util.Date;

/**
 * A simple {@link LogWriter} that writes to a {@link PrintStream}.
 * @since Core 1.0
 * @author Tassilo
 * @see System#out
 */
public class PrintStreamLogWriter implements LogWriter {

	// See: https://en.wikipedia.org/wiki/ANSI_escape_code#Colors
	public static final String ANSI_INFO = "\u001B[38;2;235;235;235m";
	public static final String ANSI_WARNING = "\u001B[38;2;227;161;0m";
	public static final String ANSI_SEVERE = "\u001B[93;41m";
	public static final String ANSI_DEBUG = "\u001B[38;2;195;195;195m";
	public static final String ANSI_SUCCESS = "\u001B[38;2;0;195;0m";
	public static final String ANSI_FAILURE = "\u001B[38;2;195;0;0m";
	public static final String ANSI_TERMINATOR = "\u001B[0m";



	private final PrintStream printStream;
	private final boolean useAnsi;

	/**
	 * Creates a new PrintStreamLogWriter with {@link System#out} as output and with ANSI color codes.
	 */
	public PrintStreamLogWriter() {
		this(true);
	}

	/**
	 * Creates a new PrintStreamLogWriter with {@link System#out} as output.
	 * @param useAnsi use ANSI color codes
	 */
	public PrintStreamLogWriter(boolean useAnsi) {
		this(System.out, useAnsi);
	}

	/**
	 * Creates a new PrintStreamLogWriter.
	 * @param printStream the output stream
	 * @param useAnsi use ANSI color codes
	 */
	public PrintStreamLogWriter(PrintStream printStream, boolean useAnsi) {
		this.printStream = printStream;
		this.useAnsi = useAnsi;
	}



	/**
	 * Returns an ANSI color code for the given level.
	 * @param level the level
	 * @return the ANSI color code
	 */
	protected String getAnsiForLevel(Level level) {
		switch (level) {
			case INFO: return ANSI_INFO;
			case DEBUG: return ANSI_DEBUG;
			case WARNING: return ANSI_WARNING;
			case SEVERE: return ANSI_SEVERE;
			case SUCCESS: return ANSI_SUCCESS;
			case FAILURE: return ANSI_FAILURE;
		}
		throw new IllegalArgumentException("Unknown level: " + level);
	}

	@Override
	public void writeLog(Log log) {
		// Get generics (time, prefix, suffix)
		String time = DateFormat.getDateTimeInstance().format(new Date(log.getTimestamp()));
		String prefix = time + " | " + log.getLevel().getDisplayName() + " | ";
		String suffix = "\n";
		if (useAnsi) {
			prefix = getAnsiForLevel(log.getLevel()) + prefix;
			suffix = ANSI_TERMINATOR + "\n";
		}

		// Build lines
		StringBuilder str = new StringBuilder();
		if (log.getMessage() != null) {
			str = new StringBuilder(prefix + log.getMessage() + suffix);
		}
		if (log.getError() != null) {
			StringWriter sw = new StringWriter();
			log.getError().printStackTrace(new PrintWriter(sw));
			String[] parts = sw.toString().split("\n");
			for (String part : parts) {
				str.append(prefix).append(part).append(suffix);
			}
		}

		// Print!
		printStream.print(str.toString());
	}

}
