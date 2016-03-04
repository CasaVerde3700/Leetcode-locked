/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, 
it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that 
reads n characters from the file.

Note: The read function may be called multiple times.
*/

public class Solution extends Read4 {
	/**
     * @param buf Destination buffer 
     * 足够大的buffer，需要将读到的file放到这个buffer里面去
     * @param n Maximum number of characters to read 
     * 读n个char，但是有可能读不到那么多，因为有可能n比文件的size大
     * @return The number of characters read
     * 读到的char数，小于等于n
     */
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int haveRead = 0;
		//flag of read4 ending
		boolean lessThan4 = false;

		// as long as have sth to read, and less than n
		while (!lessThan4 && haveRead < n) {
			int oneRead = read4(buffer);
			if (oneRead < 4) {
				lessThan4 = true;
			}
			// tail of the buffer, corner case
			int needRead = Math.min(n - haveRead, oneRead);
			// put into buffer
			for (int i = 0; i < needRead; i++) {
				buf[haveRead + i] = buffer[i];
			}
			// buffer index
			haveRead += needRead;
		}
		return haveRead;
	}
}