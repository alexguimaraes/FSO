import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Comunicar extends ProcessoM implements Mensagem{
	
	Comunicar(String cliente){
		super(cliente);
	}
	Comunicar(FileChannel canal){
		super(canal);
	}

	public byte[] parar(boolean bool) {
		byte size = 0x02;
		byte [] array = new byte[size+1];
		array[0] = size;
		array[1] = PARAR;
		array[2] = (byte) (bool? 0xFF : 0x00);
		return array;
	}

	public byte[] reta(int distancia) {
		byte size = 0x05;
		byte [] array = new byte[size+1];
		array[0] = size;
		array[1] = RETA;
		array[2] = (byte) (distancia & 0xFF);
		array[3] = (byte) ((distancia >> 8) & 0xFF);
		array[4] = (byte) ((distancia >> 16) & 0xFF);
		array[5] = (byte) ((distancia >> 24) & 0xFF);
		return array;
	}

	public byte[] vmd(int offsetD) {
		byte size = 0x05;
		byte [] array = new byte[size+1];
		array[0] = size;
		array[1] = VMD;
		array[2] = (byte) (offsetD & 0xFF);
		array[3] = (byte) ((offsetD >> 8) & 0xFF);
		array[4] = (byte) ((offsetD >> 16) & 0xFF);
		array[5] = (byte) ((offsetD >> 24) & 0xFF);
		return array;
	}

	public byte[] vme(int offsetE) {
		byte size = 0x05;
		byte [] array = new byte[size+1];
		array[0] = size;
		array[1] = VME;
		array[2] = (byte) (offsetE & 0xFF);
		array[3] = (byte) ((offsetE >> 8) & 0xFF);
		array[4] = (byte) ((offsetE >> 16) & 0xFF);
		array[5] = (byte) ((offsetE >> 24) & 0xFF);
		return array;
	}

	public byte[] curvad(int r, int a) {
		byte size = 0x09;
		byte [] array = new byte[size+1];
		array[0] = size;
		array[1] = CURVAD;
		array[2] = (byte) (r & 0xFF);
		array[3] = (byte) ((r >> 8) & 0xFF);
		array[4] = (byte) ((r >> 16) & 0xFF);
		array[5] = (byte) ((r >> 24) & 0xFF);
		array[6] = (byte) (a & 0xFF);
		array[7] = (byte) ((a >> 8) & 0xFF);
		array[8] = (byte) ((a >> 16) & 0xFF);
		array[9] = (byte) ((a >> 24) & 0xFF);
		return array;
	}

	public byte[] curvae(int r, int a) {
		byte size = 0x09;
		byte [] array = new byte[size+1];
		array[0] = size;
		array[1] = CURVAE;
		array[2] = (byte) (r & 0xFF);
		array[3] = (byte) ((r >> 8) & 0xFF);
		array[4] = (byte) ((r >> 16) & 0xFF);
		array[5] = (byte) ((r >> 24) & 0xFF);
		array[6] = (byte) (a & 0xFF);
		array[7] = (byte) ((a >> 8) & 0xFF);
		array[8] = (byte) ((a >> 16) & 0xFF);
		array[9] = (byte) ((a >> 24) & 0xFF);
		return array;
	}
	
	public void GetandSet() throws IOException{
		FileLock lock = canal.lock();
		
	}

	public byte[] getMSG() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] setMSG(byte[] b) {
		// TODO Auto-generated method stub
		return null;
	}

	public void print() {
		System.out.println("ola");
	}
}


