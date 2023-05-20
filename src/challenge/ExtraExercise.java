package challenge;

public class ExtraExercise {

	public static void main(String[] args) {
		System.out.println("1 - Monte a estrutura condicional if/else para as regras abaixo e no final o que será mostrado para cada valores:");
//			Regras:
//			- homens a partir de 65 anos, escrever APOSENTADO;
//			- mulheres a partir de 60 anos, escrever APOSENTADA;
//			- pessoas entre 13 que 18 anos, escrever ADOLESCENTE;
//			- pessoas menores que 13 anos, escrever CRIANÇAS;
//			- todos os outros, escrever ADULTO;
		
//			Lista de valores para o teste: sexo;idade
//
//			a) masculino;74
//			b) feminino;4
//			c) feminino;13
//			d) masculino;60
//			e) masculino;19
//			f) feminino;60
			
		
		class Person{
			private String name;
			private int age;
			
			public Person(String name, int age) {
				this.name = name;
				this.age = age;
			}
		}
		
		Person[] personSituation = new Person[6]; 
		
		personSituation[0] = new Person("masculino", 74); // a)
		personSituation[1] = new Person("feminino", 4);   // b)
		personSituation[2] = new Person("feminino", 13);  // c)
		personSituation[3] = new Person("masculino", 60); // d)
		personSituation[4] = new Person("masculino", 19); // e)
		personSituation[5] = new Person("feminino", 60);  // f)
		
		for (Person person : personSituation) {
			if (person.age >= 65 && person.name.equals("masculino")){
				System.out.println("APOSENTADO");
			} else if (person.age >= 60 && person.name.equals("feminino")){
				System.out.println("APOSENTADA");
			} else if (person.age >= 13 && person.age <= 18){
				System.out.println("ADOLESCENTE");
			} else if (person.age < 13) {
				System.out.println("CRIANÇA");
			} else {
				System.out.println("ADULTO");
			}
		}
		
		System.out.println("");
		System.out.println("2 - De acordo com o algoritmo a seguir, escolha uma das alternativas abaixo:");
		
//		contador :=  3
//		soma  := 57
//		for (contador <= 10 ) {
//			if (contador < 5 || contador == 8 ) {
//				soma := soma - contador
//		    } else {
//		            soma = soma + contador
//		    }
//			contador++
//		} 
//		print(“O valor da soma é ” + soma)
//		a) O valor da soma é 57
//		b) O valor da soma é 69
//		c) O valor da soma é 79
//		d) O valor da soma é 93
		
		System.out.println("A resposta correta será letra: C");		
		System.out.println("");
		System.out.println("Como o contador começa no numero 3 e vai até o numero 10 e a soma inicial é = 57, usando a lógica proposta:"
				+ "contador sendo 3, subtrai de 57 que resulta em 54.\r\n"
				+ "contador sendo 4, subtrai de 54 que resulta em 50.\r\n"
				+ "contador sendo 5, soma ao 50 que resulta em 55.\r\n"
				+ "contador sendo 6, soma ao 55 que resulta em 61.\r\n"
				+ "contador sendo 7, soma ao 61 que resulta em 68.\r\n"
				+ "contador sendo 8, subrtrai de 68 que resulta em 60.\r\n"
				+ "contador sendo 9, soma ao 60 que resulta em 69.\r\n"
				+ "contador sendo 10, soma ao 69 que resulta em 79.\r\n");
	}

}
