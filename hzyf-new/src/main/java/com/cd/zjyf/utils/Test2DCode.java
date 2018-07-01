package com.cd.zjyf.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/**
 * 这个没有logo，如果是单位二维码，需要logo，这个不能用
 * @author chen.shuodong
 *
 */
public class Test2DCode {
	//生成二维码
	public static void main(String[] args) throws IOException {
		String text = "www.baidu.com";
		int width = 100;
		int height = 100;
		String format = "png";
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("C:\\Users\\chen.shuodong\\Desktop\\linux\\new.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 解析二维码：
	@Test
	public void testPrase() throws NotFoundException {
		MultiFormatReader formatReader = new MultiFormatReader();
		File file = new File("C:\\Users\\chen.shuodong\\Desktop\\linux\\new.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		Result result = formatReader.decode(binaryBitmap, hints);
		System.err.println("解析结果：" + result.toString());
		System.out.println(result.getBarcodeFormat());
		System.out.println(result.getText());
	}
}
