public class Funciones {
	private final static char ZERO_CHAR = '0';
	private final static char ONE_CHAR = '1';
	
	private String numero;

	private boolean validaNumeroBinario(String numero) {

		final String REGEX = "[01]+";
		return numero.matches(REGEX);

	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public Funciones(String numero) {
		if (!this.validaNumeroBinario(numero)) {
			throw new IllegalArgumentException("El numero no es binario");
		}
		this.numero = numero;
	}

	private String fillWithLeadingZeros(String numero, int longitud) {
		if (longitud == numero.length()) {
			return numero;
		}

		int missing = longitud - numero.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < missing; i++) {
			sb.append(ZERO_CHAR);
		}
		sb.append(numero);
		return sb.toString();
	}

	private String fillWithTrailingZeros(String numero, int longitud) {
		if (longitud == numero.length()) {
			return numero;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(numero);
		for (int i = 0; i < longitud; i++) {
			sb.append(ZERO_CHAR);
		}
		return sb.toString();
	}

	public Funciones sumar(Funciones otroNumero) {

		int maxLength = Math.max(this.numero.length(), otroNumero.numero.length());
		String zfNumero = fillWithLeadingZeros(this.numero, maxLength);
		String zfOtroNumero = fillWithLeadingZeros(otroNumero.numero, maxLength);
		char carry = ZERO_CHAR;
		char[] result = new char[maxLength + 1];
		for (int i = maxLength - 1; i >= 0; i--) {
			char zfNumeroCharAtI = zfNumero.charAt(i);
			char zfOtroNumeroCharAtI = zfOtroNumero.charAt(i);
			if (zfNumeroCharAtI == zfOtroNumeroCharAtI) {
				if (ZERO_CHAR == zfNumeroCharAtI) {
					if (ONE_CHAR == carry) {
						result[i + 1] = ONE_CHAR;
						carry = ZERO_CHAR;
					} else {
						result[i + 1] = ZERO_CHAR;
						carry = ZERO_CHAR;
					}
				} else {
					if (ONE_CHAR == carry) {
						result[i + 1] = ONE_CHAR;
						carry = ONE_CHAR;
					} else {
						result[i + 1] = ZERO_CHAR;
						carry = ONE_CHAR;
					}
				}

			} else {
				if (ONE_CHAR == carry) {
					result[i + 1] = ZERO_CHAR;
					carry = ONE_CHAR;
				} else {
					result[i + 1] = ONE_CHAR;
					carry = ZERO_CHAR;
				}
			}

		}
		result[0] = carry;
		return new Funciones(new String(result).trim());
	}

	public Funciones restar(Funciones otroNumero) {
		int maxLength = Math.max(this.numero.length(), otroNumero.numero.length());
		String zfOtroNumero = fillWithLeadingZeros(otroNumero.numero, maxLength);
		char[] complement = new char[maxLength];
		for (int i = 0; i < maxLength; i++) {
			complement[i] = ZERO_CHAR == zfOtroNumero.charAt(i) ? ONE_CHAR : ZERO_CHAR;
		}

		Funciones one = new Funciones(Character.toString(ONE_CHAR));
		Funciones tmp = new Funciones(new String(complement));

		Funciones result = tmp.sumar(one);

		result = this.sumar(result);
		result.numero = result.getNumero().substring(2);
		return result;

	}

	public Funciones multiplicar(Funciones otroNumero) {
		int maxLength = otroNumero.numero.length();
		Funciones sum = new Funciones(Character.toString(ZERO_CHAR));
		int limit = maxLength - 1;
		for (int i = limit; i >= 0; i--) {
			if (otroNumero.numero.charAt(i) == ONE_CHAR) {
				String trail = this.fillWithTrailingZeros(this.numero, limit - i);
				Funciones tmp = new Funciones(trail);
				sum = sum.sumar(tmp);
				sum.setNumero(sum.numero.substring(1));
			}
		}
		return sum;
	}
}
