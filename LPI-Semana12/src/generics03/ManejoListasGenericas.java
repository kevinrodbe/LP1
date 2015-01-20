package generics03;

import java.util.ArrayList;

public class ManejoListasGenericas {

	public static void main(String[] args) {

		ArrayList<? extends Documento> documentos;
		ArrayList<? super Boleta> documentos3;
		ArrayList<?> documentos2;
		ArrayList<Boleta> boletas;

	}

	public void inserta1(ArrayList<? extends Documento> param) {

	}

	public void inserta2(ArrayList<? super Boleta> param) {

	}

	public void inserta3(ArrayList<?> param) {

	}

	public void inserta4(ArrayList<Boleta> param) {

	}
}
