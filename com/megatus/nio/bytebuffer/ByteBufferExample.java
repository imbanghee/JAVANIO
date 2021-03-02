package com.megatus.nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferExample
{
	public static void main(String[] args)
	{
		// 문자열 -> 인코딩 -> ByteBuffer
		String message = "안녕하세요";
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer byteBuffer =  charset.encode(message);
		
		// ByteBuffer -> 디코딩 -> 문자열
		message = charset.decode(byteBuffer).toString();
		System.out.println("복원 메시지 : " + message);
		
	}
}
