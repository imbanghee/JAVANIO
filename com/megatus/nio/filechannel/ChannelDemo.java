package com.megatus.nio.filechannel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo
{
	public static void main(String[] args) throws Exception
	{
//		File file = new File("file/temp.txt");
//		RandomAccessFile file = new RandomAccessFile("C:/Test/temp.txt", "r");
		FileInputStream fileInputStream = new FileInputStream("file/temp.txt");
		
		FileChannel fileChannel = fileInputStream.getChannel();
		
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024); 
		
		int readIntByte = 0;
		byte[] readByte = new byte[1024];
		while( (readIntByte = fileChannel.read(byteBuffer)) != -1) {
			byteBuffer.rewind();
			byteBuffer.get(readByte);
			System.out.println(new String(readByte,0,readIntByte));
			byteBuffer.flip();
		}
		
		byteBuffer.clear();
		fileInputStream.close();
		fileChannel.close();
		
	}
}
