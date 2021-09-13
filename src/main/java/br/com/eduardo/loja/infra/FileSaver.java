package br.com.eduardo.loja.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;

import javax.servlet.http.Part;

public class FileSaver {

	//caminho do servidor, foi separado para evitar problemas quando alterar o caminho
	public static final String SERVER_PATH = "/casadocodigo";

	//Recebe o arquivo e o Path para salvar o arquivo e escreve o arquivo no novo local
	public String write(Part arquivo, String path) {
		String relativePath = path + "/" + arquivo.getSubmittedFileName();
		try {
			arquivo.write(SERVER_PATH + "/" + relativePath);
			return relativePath;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//metodo para pegar o endereço do arquivo (INPUT), tratar e enviar o arquivo (OUTPUT) para a saída 
	public static void transfer(Path source, OutputStream outputStream) {
		try { //O input e o output precisam se fechados após o processamento, por isso o uso do Try
			FileInputStream input = new FileInputStream(source.toFile());
			try (ReadableByteChannel inputChannel = Channels.newChannel(input);
					WritableByteChannel outputChannel = Channels.newChannel(outputStream)){
						ByteBuffer buffer = ByteBuffer.allocateDirect(1024*10);
						
						//leia todo o arquivo
						while(inputChannel.read(buffer) != -1) {
							buffer.flip();
							outputChannel.write(buffer);
							buffer.clear();
						}
						
			} catch (IOException e) {
				throw new RuntimeException(e);				
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
