/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import static java.lang.System.*;

// Classe não funcional

public class Bitmap{
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	byte[] data; // pixel data
	String name;
	
	public Bitmap(String name){
		try{
			this.name=name;
			RandomAccessFile ra = new RandomAccessFile(name, "r");
			ra.seek(0);
			
			short c1 = Short.reverseBytes(ra.readShort());
			int size = Integer.reverseBytes(ra.readInt());
			short reserved1 = Short.reverseBytes(ra.readShort());
			short reserved2 = Short.reverseBytes(ra.readShort());
			int offBits = Integer.reverseBytes(ra.readInt());
			
			bitmapFileHeader = new BitmapFileHeader(c1, size, reserved1, reserved2, offBits);
		
			size = Integer.reverseBytes(ra.readInt());
			int width = Integer.reverseBytes(ra.readInt());
			int height = Integer.reverseBytes(ra.readInt())*(-1);
			short planes = Short.reverseBytes(ra.readShort());
			short bitCount = Short.reverseBytes(ra.readShort());
			int compression = Integer.reverseBytes(ra.readInt());
			int sizeImage = Integer.reverseBytes(ra.readInt());
			int xPelsPerMeter = Integer.reverseBytes(ra.readInt());
			int yPelsPerMeter = Integer.reverseBytes(ra.readInt());
			int clrUsed = Integer.reverseBytes(ra.readInt());
			int crlImportant = Integer.reverseBytes(ra.readInt());
			
			bitmapInfoHeader = new BitmapInfoHeader(size, width, height, planes, bitCount, compression, sizeImage, xPelsPerMeter, yPelsPerMeter, clrUsed, crlImportant);
			
            int pos = 49;
            if (this.bitmapInfoHeader.clrUsed == 0){
            	pos++;
            	this.rgbQuad=null;
            }
            else{
            	//rgbQuad[ra.read()];
            	pos += this.rgbQuad.length;
            }
            
            ra.seek(pos);
			
            int j = 0;
            data = new byte[(int) (ra.length()-pos)];
            for (long i=pos; i < ra.length(); i++) {
                    ra.seek(i);
                    this.data[j++]+=ra.readByte();
            }
            
		}
		catch(IOException e){
			err.println("Erro na leitura do ficheiro.");
			exit(1);
		}
	}
	
	public void saveRaw(){
		
		try{
			RandomAccessFile ra = new RandomAccessFile(name+".raw","rw");
			ra.seek(0);
			ra.write(data);
			ra.close();
		}
		catch(IOException e){
			err.println("");
			exit(1);
		}
		
	}
	
	public void resize(String newFile) throws IOException {
        double ratio = 0.25;
        
        int aWidth, aHeight;
        
        aWidth = (int) (this.bitmapInfoHeader.width - (this.bitmapInfoHeader.width * ratio)); 
        aHeight = (int) (this.bitmapInfoHeader.height - (this.bitmapInfoHeader.height * ratio));
        
        RandomAccessFile temp = new RandomAccessFile(newFile, "rw");
        temp.seek(0);
        temp.writeByte((short) this.bitmapFileHeader.type);
        temp.writeInt(Integer.reverseBytes(this.bitmapFileHeader.size-(this.bitmapInfoHeader.sizeImage-(aWidth*aHeight))));
        temp.writeShort(Short.reverseBytes(this.bitmapFileHeader.reserved1));
        temp.writeShort(Short.reverseBytes(this.bitmapFileHeader.reserved2));
        temp.writeInt(Integer.reverseBytes(this.bitmapFileHeader.offBits));
        temp.writeInt(Integer.reverseBytes(this.bitmapInfoHeader.size));
        temp.writeInt(Integer.reverseBytes(aWidth));
        temp.writeInt(Integer.reverseBytes(-aHeight));
        temp.writeShort(Short.reverseBytes(this.bitmapInfoHeader.planes));
        temp.writeShort(Short.reverseBytes(this.bitmapInfoHeader.bitCount));
        temp.writeInt(Integer.reverseBytes(this.bitmapInfoHeader.compression));
        temp.writeInt(Integer.reverseBytes(0));
        temp.writeInt(Integer.reverseBytes(this.bitmapInfoHeader.xPelsPerMeter));
        temp.writeInt(Integer.reverseBytes(this.bitmapInfoHeader.yPelsPerMeter));
        temp.writeInt(Integer.reverseBytes(this.bitmapInfoHeader.clrUsed));
        temp.writeInt(Integer.reverseBytes(this.bitmapInfoHeader.clrImportant));
        
        if (this.rgbQuad != null)
                if (this.rgbQuad.length>0)
                        temp.write(this.rgbQuad);
        
        byte[][] b = new byte[aHeight][aWidth];
        byte[] array = new byte[aHeight*aWidth];
        int x = 0;
        
        for (int i=0; i<b.length; i++)
                for (int j=0; j<b[i].length; j++){
                        b[i][j] = getColor(this.data, x, 4);
                        x += 4;
                }
        
        for (int k=0; k<array.length; k++)
                for (int i=0; i<b.length; i++)
                        for (int j=0; j<b[i].length; j++)
                                array[k] = b[i][j];
        
        temp.write(array);
        temp.close();
	}
	private byte getColor(byte[] data, int pos, int number) {
        
        byte b;
        int c = 0;
        
        for (int x=pos; x<pos+number; x++)
                c = c + Integer.reverseBytes(data[x]);
        c = (int) (c/number);
        b = (byte) Integer.reverseBytes(c);
        
        return b;
	}
	
	public BitmapFileHeader getBitmapFileHeader() {
		return bitmapFileHeader;
	}
	public BitmapInfoHeader getBitmapInfoHeader() {
		return bitmapInfoHeader;
	}
	public byte[] getRgbQuad() {
		return rgbQuad;
	}
	public byte[] getData() {
		return data;
	}
	
	@Override
	public String toString(){
		return bitmapFileHeader.toString()+bitmapInfoHeader.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bitmapFileHeader == null) ? 0 : bitmapFileHeader.hashCode());
		result = prime * result + ((bitmapInfoHeader == null) ? 0 : bitmapInfoHeader.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + Arrays.hashCode(rgbQuad);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bitmap other = (Bitmap) obj;
		if (bitmapFileHeader == null) {
			if (other.bitmapFileHeader != null)
				return false;
		} else if (!bitmapFileHeader.equals(other.bitmapFileHeader))
			return false;
		if (bitmapInfoHeader == null) {
			if (other.bitmapInfoHeader != null)
				return false;
		} else if (!bitmapInfoHeader.equals(other.bitmapInfoHeader))
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (!Arrays.equals(rgbQuad, other.rgbQuad))
			return false;
		return true;
	}
	
	
	
}

class BitmapFileHeader {
	short type; // must be 'BM' to declare a bmp-file
	int size; // specifies the size of the file in bytes
	short reserved1; // must always be set to zero
	short reserved2; // must always be set to zero
	int offBits; // specifies the offset from the
	// beginning of the file to the bitmap data
	
	public BitmapFileHeader(short type, int size,  short reserved1, short reserved2, int offBits){
		this.type = type;
		this.size = size;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.offBits = offBits;
	}

	public short getType() {
		return type;
	}

	public int getSize() {
		return size;
	}

	public short getReserved1() {
		return reserved1;
	}

	public short getReserved2() {
		return reserved2;
	}

	public int getOffBits() {
		return offBits;
	}
	
	@Override
    public String toString() {
		return " ** File Header ** \nType: "+this.getType()+"\nFile Size: "+this.size+"\nReserved 1: "+this.reserved1+"\nReserved 2: "+this.reserved2+"\nOffset: "+this.offBits+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offBits;
		result = prime * result + reserved1;
		result = prime * result + reserved2;
		result = prime * result + size;
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BitmapFileHeader other = (BitmapFileHeader) obj;
		if (offBits != other.offBits)
			return false;
		if (reserved1 != other.reserved1)
			return false;
		if (reserved2 != other.reserved2)
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}

class BitmapInfoHeader{
	int size; // the size of this header (40 bytes)
	int width; // the bitmap width in pixels
	int height; // the bitmap height in pixels
	short planes; // the number of color planes being used. Must be set to 1
	short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	int compression; // the compression method being used
	int sizeImage; // the image size. This is the size of the raw bitmap data
	int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
	int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
	int clrUsed; // the number of colors in the color palette,
	// or 0 to default to 2n
	int clrImportant; // the number of important colors used,
	// or 0 when every color is important
	
	public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression, int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) {

    this.size = size;
    this.width = width;
    this.height = height;
    this.planes = planes;
    this.bitCount = bitCount;
    this.compression = compression;
    this.sizeImage = sizeImage;
    this.xPelsPerMeter = xPelsPerMeter;
    this.yPelsPerMeter = yPelsPerMeter;
    this.clrUsed = clrUsed;
    this.clrImportant = clrImportant;
	}



	public int getSize() {
	      return size;
	}
	
	
	
	public int getWidth() {
	      return width;
	}
	
	
	
	public int getHeight() {
	      return height;
	}
	
	
	
	public short getPlanes() {
	      return planes;
	}
	
	
	
	public short getBitCount() {
	      return bitCount;
	}
	
	
	
	public int getCompression() {
	      return compression;
	}
	
	
	
	public int getSizeImage() {
	      return sizeImage;
	}
	
	
	
	public int getxPelsPerMeter() {
	      return xPelsPerMeter;
	}
	
	
	
	public int getyPelsPerMeter() {
	      return yPelsPerMeter;
	}
	
	
	
	public int getClrUsed() {
	      return clrUsed;
	}
	
	
	
	public int getClrImportant() {
	      return clrImportant;
	}
	
	
	
	@Override
	public String toString() {
	
	      return " ** Info Header ** \nHeader Size: "+this.size+"\nImage Width: "+this.width+"\nImage Height: "+this.height+"\nColor Planes: "+this.planes+
	              "\nBits/Pixel: "+this.bitCount+"\nCompression : "+this.compression+"\nImage Size: "+this.sizeImage+"\nHorizontal Resolution (pixel per meter): "
	              +this.xPelsPerMeter+"\nVertical Resolution (pixel per meter): "+this.yPelsPerMeter+"\nColor Palette: "+this.clrUsed+"\nImportant Color: "
	              +this.clrImportant+"\n";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bitCount;
		result = prime * result + clrImportant;
		result = prime * result + clrUsed;
		result = prime * result + compression;
		result = prime * result + height;
		result = prime * result + planes;
		result = prime * result + size;
		result = prime * result + sizeImage;
		result = prime * result + width;
		result = prime * result + xPelsPerMeter;
		result = prime * result + yPelsPerMeter;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BitmapInfoHeader other = (BitmapInfoHeader) obj;
		if (bitCount != other.bitCount)
			return false;
		if (clrImportant != other.clrImportant)
			return false;
		if (clrUsed != other.clrUsed)
			return false;
		if (compression != other.compression)
			return false;
		if (height != other.height)
			return false;
		if (planes != other.planes)
			return false;
		if (size != other.size)
			return false;
		if (sizeImage != other.sizeImage)
			return false;
		if (width != other.width)
			return false;
		if (xPelsPerMeter != other.xPelsPerMeter)
			return false;
		if (yPelsPerMeter != other.yPelsPerMeter)
			return false;
		return true;
	}

	

}