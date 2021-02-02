package com.tesseractservers;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DataUtilityTest {

	public void generateTestIntegersStaticLines() {
		Random r = new Random();
		final String format = "assertArrayEquals(new byte[]{(byte)0x%s, (byte)0x%s, (byte)0x%s,(byte)0x%s},DataUtility.toBytes(0x%s));";
		for (int i = 0; i < 64; i++) {
			String hex = Integer.toHexString(r.nextInt());
			if (hex.length() != 8) {
				i--;
				continue;
			}
			String str = String.format(format, hex.substring(0, 2), hex.substring(2, 4), hex.substring(4, 6), hex.substring(6, 8), hex);
			System.out.println(str);
		}
	}

	@Test
	public void testIntegersStatic() {
		assertArrayEquals(new byte[]{(byte)0x52, (byte)0xe3, (byte)0x61,(byte)0x3e},DataUtility.toBytes(0x52e3613e));
		assertArrayEquals(new byte[]{(byte)0x2a, (byte)0x4e, (byte)0x84,(byte)0x3a},DataUtility.toBytes(0x2a4e843a));
		assertArrayEquals(new byte[]{(byte)0x29, (byte)0x2e, (byte)0xee,(byte)0x31},DataUtility.toBytes(0x292eee31));
		assertArrayEquals(new byte[]{(byte)0x34, (byte)0x86, (byte)0xe9,(byte)0x30},DataUtility.toBytes(0x3486e930));
		assertArrayEquals(new byte[]{(byte)0xae, (byte)0x6a, (byte)0x32,(byte)0x16},DataUtility.toBytes(0xae6a3216));
		assertArrayEquals(new byte[]{(byte)0x84, (byte)0xd6, (byte)0xd4,(byte)0xbd},DataUtility.toBytes(0x84d6d4bd));
		assertArrayEquals(new byte[]{(byte)0xc1, (byte)0xac, (byte)0x93,(byte)0x62},DataUtility.toBytes(0xc1ac9362));
		assertArrayEquals(new byte[]{(byte)0x94, (byte)0x64, (byte)0x14,(byte)0x4a},DataUtility.toBytes(0x9464144a));
		assertArrayEquals(new byte[]{(byte)0x54, (byte)0xc9, (byte)0x65,(byte)0xa1},DataUtility.toBytes(0x54c965a1));
		assertArrayEquals(new byte[]{(byte)0x75, (byte)0x3f, (byte)0x86,(byte)0xc2},DataUtility.toBytes(0x753f86c2));
		assertArrayEquals(new byte[]{(byte)0x55, (byte)0x4e, (byte)0x2f,(byte)0x1f},DataUtility.toBytes(0x554e2f1f));
		assertArrayEquals(new byte[]{(byte)0x33, (byte)0x99, (byte)0xc7,(byte)0x51},DataUtility.toBytes(0x3399c751));
		assertArrayEquals(new byte[]{(byte)0x40, (byte)0x2e, (byte)0x20,(byte)0xb1},DataUtility.toBytes(0x402e20b1));
		assertArrayEquals(new byte[]{(byte)0x66, (byte)0x2e, (byte)0xb5,(byte)0x80},DataUtility.toBytes(0x662eb580));
		assertArrayEquals(new byte[]{(byte)0xa1, (byte)0xec, (byte)0x3e,(byte)0xac},DataUtility.toBytes(0xa1ec3eac));
		assertArrayEquals(new byte[]{(byte)0x10, (byte)0x72, (byte)0x3a,(byte)0x02},DataUtility.toBytes(0x10723a02));
		assertArrayEquals(new byte[]{(byte)0xd5, (byte)0x6b, (byte)0xea,(byte)0x5b},DataUtility.toBytes(0xd56bea5b));
		assertArrayEquals(new byte[]{(byte)0x64, (byte)0xa3, (byte)0x8d,(byte)0x60},DataUtility.toBytes(0x64a38d60));
		assertArrayEquals(new byte[]{(byte)0x51, (byte)0xb0, (byte)0x59,(byte)0x3a},DataUtility.toBytes(0x51b0593a));
		assertArrayEquals(new byte[]{(byte)0x47, (byte)0x43, (byte)0x17,(byte)0xed},DataUtility.toBytes(0x474317ed));
		assertArrayEquals(new byte[]{(byte)0xd6, (byte)0xfc, (byte)0x63,(byte)0xbb},DataUtility.toBytes(0xd6fc63bb));
		assertArrayEquals(new byte[]{(byte)0x3e, (byte)0x77, (byte)0xa3,(byte)0xbc},DataUtility.toBytes(0x3e77a3bc));
		assertArrayEquals(new byte[]{(byte)0xdc, (byte)0xcf, (byte)0xab,(byte)0xe7},DataUtility.toBytes(0xdccfabe7));
		assertArrayEquals(new byte[]{(byte)0x35, (byte)0xf3, (byte)0x31,(byte)0x22},DataUtility.toBytes(0x35f33122));
		assertArrayEquals(new byte[]{(byte)0xcd, (byte)0xa9, (byte)0x4d,(byte)0x33},DataUtility.toBytes(0xcda94d33));
		assertArrayEquals(new byte[]{(byte)0x8b, (byte)0x44, (byte)0xfb,(byte)0xca},DataUtility.toBytes(0x8b44fbca));
		assertArrayEquals(new byte[]{(byte)0x19, (byte)0x61, (byte)0xc9,(byte)0xe4},DataUtility.toBytes(0x1961c9e4));
		assertArrayEquals(new byte[]{(byte)0x2a, (byte)0xe5, (byte)0x04,(byte)0x76},DataUtility.toBytes(0x2ae50476));
		assertArrayEquals(new byte[]{(byte)0xd0, (byte)0x1a, (byte)0x46,(byte)0x7e},DataUtility.toBytes(0xd01a467e));
		assertArrayEquals(new byte[]{(byte)0x31, (byte)0xb8, (byte)0x62,(byte)0x23},DataUtility.toBytes(0x31b86223));
		assertArrayEquals(new byte[]{(byte)0xb0, (byte)0x01, (byte)0x57,(byte)0xd9},DataUtility.toBytes(0xb00157d9));
		assertArrayEquals(new byte[]{(byte)0xde, (byte)0x6a, (byte)0x3a,(byte)0xb8},DataUtility.toBytes(0xde6a3ab8));
		assertArrayEquals(new byte[]{(byte)0x7c, (byte)0x9b, (byte)0x07,(byte)0x52},DataUtility.toBytes(0x7c9b0752));
		assertArrayEquals(new byte[]{(byte)0x43, (byte)0x9b, (byte)0x5d,(byte)0x59},DataUtility.toBytes(0x439b5d59));
		assertArrayEquals(new byte[]{(byte)0xe5, (byte)0x10, (byte)0x9d,(byte)0xd4},DataUtility.toBytes(0xe5109dd4));
		assertArrayEquals(new byte[]{(byte)0x2e, (byte)0xbf, (byte)0xc5,(byte)0xcf},DataUtility.toBytes(0x2ebfc5cf));
		assertArrayEquals(new byte[]{(byte)0xe7, (byte)0xf2, (byte)0xc5,(byte)0xc6},DataUtility.toBytes(0xe7f2c5c6));
		assertArrayEquals(new byte[]{(byte)0x82, (byte)0x8c, (byte)0xf5,(byte)0x2b},DataUtility.toBytes(0x828cf52b));
		assertArrayEquals(new byte[]{(byte)0xe6, (byte)0xd8, (byte)0x09,(byte)0xa4},DataUtility.toBytes(0xe6d809a4));
		assertArrayEquals(new byte[]{(byte)0x7e, (byte)0xa2, (byte)0x75,(byte)0x7f},DataUtility.toBytes(0x7ea2757f));
		assertArrayEquals(new byte[]{(byte)0x38, (byte)0x68, (byte)0x49,(byte)0x5f},DataUtility.toBytes(0x3868495f));
		assertArrayEquals(new byte[]{(byte)0xee, (byte)0x89, (byte)0x16,(byte)0xda},DataUtility.toBytes(0xee8916da));
		assertArrayEquals(new byte[]{(byte)0x4a, (byte)0xb1, (byte)0x76,(byte)0x64},DataUtility.toBytes(0x4ab17664));
		assertArrayEquals(new byte[]{(byte)0xca, (byte)0xe0, (byte)0xb1,(byte)0xe9},DataUtility.toBytes(0xcae0b1e9));
		assertArrayEquals(new byte[]{(byte)0xf5, (byte)0x2d, (byte)0x0e,(byte)0x9d},DataUtility.toBytes(0xf52d0e9d));
		assertArrayEquals(new byte[]{(byte)0x74, (byte)0x3b, (byte)0x56,(byte)0xeb},DataUtility.toBytes(0x743b56eb));
		assertArrayEquals(new byte[]{(byte)0x21, (byte)0x99, (byte)0x7b,(byte)0xe7},DataUtility.toBytes(0x21997be7));
		assertArrayEquals(new byte[]{(byte)0x4e, (byte)0xb5, (byte)0x13,(byte)0xdd},DataUtility.toBytes(0x4eb513dd));
		assertArrayEquals(new byte[]{(byte)0xeb, (byte)0x89, (byte)0x0c,(byte)0xd8},DataUtility.toBytes(0xeb890cd8));
		assertArrayEquals(new byte[]{(byte)0x32, (byte)0x2d, (byte)0xfb,(byte)0x0a},DataUtility.toBytes(0x322dfb0a));
		assertArrayEquals(new byte[]{(byte)0x86, (byte)0x49, (byte)0x7c,(byte)0xc7},DataUtility.toBytes(0x86497cc7));
		assertArrayEquals(new byte[]{(byte)0xbf, (byte)0xf4, (byte)0x5b,(byte)0x5c},DataUtility.toBytes(0xbff45b5c));
		assertArrayEquals(new byte[]{(byte)0xd3, (byte)0x97, (byte)0x44,(byte)0x73},DataUtility.toBytes(0xd3974473));
		assertArrayEquals(new byte[]{(byte)0x34, (byte)0xc5, (byte)0x3e,(byte)0x2b},DataUtility.toBytes(0x34c53e2b));
		assertArrayEquals(new byte[]{(byte)0x6f, (byte)0x9c, (byte)0x01,(byte)0xbe},DataUtility.toBytes(0x6f9c01be));
		assertArrayEquals(new byte[]{(byte)0x17, (byte)0x45, (byte)0xca,(byte)0x58},DataUtility.toBytes(0x1745ca58));
		assertArrayEquals(new byte[]{(byte)0xd6, (byte)0x80, (byte)0x7c,(byte)0x52},DataUtility.toBytes(0xd6807c52));
		assertArrayEquals(new byte[]{(byte)0xa2, (byte)0x68, (byte)0x32,(byte)0xf1},DataUtility.toBytes(0xa26832f1));
		assertArrayEquals(new byte[]{(byte)0xa5, (byte)0x8a, (byte)0xf6,(byte)0x34},DataUtility.toBytes(0xa58af634));
		assertArrayEquals(new byte[]{(byte)0x7b, (byte)0x3f, (byte)0xe7,(byte)0xbd},DataUtility.toBytes(0x7b3fe7bd));
		assertArrayEquals(new byte[]{(byte)0xc0, (byte)0x9f, (byte)0xe2,(byte)0x88},DataUtility.toBytes(0xc09fe288));
		assertArrayEquals(new byte[]{(byte)0x3b, (byte)0x6a, (byte)0xe8,(byte)0x53},DataUtility.toBytes(0x3b6ae853));
		assertArrayEquals(new byte[]{(byte)0x93, (byte)0xfc, (byte)0x9a,(byte)0x18},DataUtility.toBytes(0x93fc9a18));
		assertArrayEquals(new byte[]{(byte)0xea, (byte)0x5f, (byte)0xee,(byte)0xb4},DataUtility.toBytes(0xea5feeb4));
	}

	@Test
	public void testIntegersRandom() {
		Random random = new Random();

		for (int i = 0; i < 4096 * 4096; i++) {
			int x = random.nextInt();
			byte[] buffer = DataUtility.toBytes(x);
			int x2 = DataUtility.fromBytes(buffer);
			if (x != x2) {
				System.err.println("---------- << ERROR INFORMATION >> ----------");
				throw new AssertionError("Integer-Bytes conversion failed for " + x + "\n" +
					"\n---------- << ERROR INFORMATION >> ----------" +
					"\nStarting value: " + Integer.toHexString(x) +
					"\nConverted value: " + Base16.encode(buffer) +
					"\nRe-converted value: " + Integer.toHexString(x2) +
					"\n---------- << ERROR INFORMATION >> ----------");
			}
		}
	}

}
