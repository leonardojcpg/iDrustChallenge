package challenge;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class ChallengeSolution {

	private static final Set<Recebivel> RECEBIVEIS;

	public static void main(String[] args) throws Exception {

		System.out.println("Faça os exercícios abaixo usando os dados pré-criados na variável `RECEBIVEIS`.");
		System.out.println("Peço que prepare a resolução logo abaixo de cada enunciado.");
		System.out.println("");

		System.out.println("1 - Print a soma agrupando as mesmas datas de vencimentos");
		BigDecimal totalByDueDate = BigDecimal.ZERO;
		Map<LocalDate, BigDecimal> sumByDueDate = new HashMap<>();

		for (Recebivel recebivel : RECEBIVEIS) {
			LocalDate dueDate = recebivel.dataVencimento;
			BigDecimal receivableValue = recebivel.valor;
			sumByDueDate.put(dueDate, sumByDueDate.getOrDefault(dueDate, BigDecimal.ZERO).add(receivableValue));
		}

		for (Map.Entry<LocalDate, BigDecimal> entry : sumByDueDate.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
			totalByDueDate = totalByDueDate.add(entry.getValue());
		}
		System.out.println("");
		System.out.println("The sum of all values:\r\n" + totalByDueDate);

		System.out.println("");
		System.out.println("2 - Print a soma dos recebiveis ja vencidos");

		BigDecimal totalOverdue = BigDecimal.ZERO;
		LocalDate currentDate = LocalDate.now();

		for (Recebivel recebivel : RECEBIVEIS) {
			LocalDate dueDate = recebivel.dataVencimento;
			BigDecimal receivableValue = recebivel.valor;

			if (currentDate.isAfter(dueDate)) {
				totalOverdue = totalOverdue.add(receivableValue);
			}
		}
		System.out.println("Total dos recebíveis ja vencidos: " + totalOverdue);
		System.out.println("");

		System.out.println("3 - Formate para moeda Real o valor do recebivel com vencimento 25/07/2023");

		LocalDate targetDueDate = LocalDate.of(2023, 7, 25);
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

		for (Recebivel recebivel : RECEBIVEIS) {
			if (recebivel.dataVencimento.equals(targetDueDate)) {
				BigDecimal receivableValue = recebivel.valor;
				String formattedValue = currencyFormat.format(receivableValue);
				System.out.println("Valor do recebivel em 25/07/2023: " + formattedValue);
				break;
			}
		}
		System.out.println("");

		System.out
				.println("4 - Print o prazo em dias entre emissao e vencimento do recebivel com vencimento 12/10/2023");

		LocalDate targetDueDateProblemFour = LocalDate.of(2023, 10, 12);
		for (Recebivel recebivel : RECEBIVEIS) {
			if (recebivel.dataVencimento.equals(targetDueDateProblemFour)) {
				LocalDate issuanceDate = recebivel.dataEmissao;
				long daysBetween = ChronoUnit.DAYS.between(issuanceDate, targetDueDateProblemFour);
				System.out.println("Prazo entre emissao e vencimento em 12/10/2023: " + daysBetween + " dias");
				break;
			}
		}
		System.out.println("");

		System.out.println("5 - Print a concatenação de todos os campos do recebivel separando por ;");

		for (Recebivel recebivel : RECEBIVEIS) {
			String concatenatedFields = 
					recebivel.codigo +
					";" + recebivel.dataEmissao + 
					";" + recebivel.dataVencimento +
					";" + recebivel.valor;
			System.out.println(concatenatedFields);
		}
		System.out.println("");

		System.out.println("6 - Formate a data 2023-06-25 do recebivel para o formato dd/MM/yyyy");

		LocalDate dataRecebivel = LocalDate.parse("2023-06-25");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = dataRecebivel.format(formatter);
		System.out.println(dataFormatada);

		System.out.println("");
		System.out.println("Exercício extra:");
		System.out.println("");
		System.out.println(
				"7 - Dado uma lista da variável `valores` abaixo, acrescente um novo valor de acordo com as regras a seguir:");
		System.out.println("  -  R$5,90 para valores menor e igual que R$100,00");
		System.out.println("  -  R$15,00 para valores menor que R$20,00");
		System.out.println("  -  R$4,33 para valores maior que R$100,00");
		System.out.println("  -  R$2,10 para valores maior que R$200,00");
		System.out.println("  -  R$3,55 para valores igual que R$150,00");
		System.out.println(
				"Print o novo resultado na saída da condição de validação e no final print a soma de todos os novos valores da lista");
		System.out.println("");
		List<BigDecimal> arrayValues = Arrays.asList(
				new BigDecimal("88.88"), 
				new BigDecimal("17.01"),
				new BigDecimal("20.00"), 
				new BigDecimal("150.00"), 
				new BigDecimal("124.21"), 
				new BigDecimal("247.09"),
				new BigDecimal("100.00"), 
				new BigDecimal("4.99")
				);

		for (int i = 0; i < arrayValues.size(); i++) {
			BigDecimal valor = arrayValues.get(i);

			if (valor.compareTo(new BigDecimal("100.00")) <= 0) {
				arrayValues.set(i, valor.add(new BigDecimal("5.90")));
				
			} else if (valor.compareTo(new BigDecimal("20.00")) < 0) {
				arrayValues.set(i, valor.add(new BigDecimal("15.00")));
				
			} else if (valor.compareTo(new BigDecimal("200.00")) > 0) {
				arrayValues.set(i, valor.add(new BigDecimal("4.33")));
				
			} else if (valor.compareTo(new BigDecimal("150.00")) == 0) {
				arrayValues.set(i, valor.add(new BigDecimal("3.55")));
				
			} else {
				arrayValues.set(i, valor.add(new BigDecimal("2.10")));
			}
		}

		for (BigDecimal valor : arrayValues) {
			System.out.println(valor);
		}

		BigDecimal sum = BigDecimal.ZERO;
		for (BigDecimal valor : arrayValues) {
			sum = sum.add(valor);
		}
		System.out.println("");
		System.out.println("Soma dos novos valores: " + sum);

	}

	static {
		Set<Recebivel> rs = new HashSet<>();
		rs.add(Recebivel.create(
				"1H01R6HA1", 
				LocalDate.parse("2023-05-02"), 
				LocalDate.parse("2023-08-09"),
				new BigDecimal("146.99")
				));
		rs.add(Recebivel.create(
				"1H01R6HB1", 
				LocalDate.parse("2023-05-02"), 
				LocalDate.parse("2023-05-08"),
				new BigDecimal("592.18")
				));
		rs.add(Recebivel.create(
				"1H01R6HC1", 
				LocalDate.parse("2023-05-03"), 
				LocalDate.parse("2023-06-28"),
				new BigDecimal("98.20")
				));
		rs.add(Recebivel.create(
				"1H01R6HD1", 
				LocalDate.parse("2023-05-06"), 
				LocalDate.parse("2023-09-19"),
				new BigDecimal("726.01")
				));
		rs.add(Recebivel.create(
				"1H01R6HE1", 
				LocalDate.parse("2023-05-02"), 
				LocalDate.parse("2023-05-08"),
				new BigDecimal("81.88")
				));
		rs.add(Recebivel.create(
				"1H01R6HF1", 
				LocalDate.parse("2023-05-03"), 
				LocalDate.parse("2023-07-15"),
				new BigDecimal("221.34")
				));
		rs.add(Recebivel.create(
				"1H01R6HG1", 
				LocalDate.parse("2023-05-02"), 
				LocalDate.parse("2023-07-25"),
				new BigDecimal("711.98")
				));
		rs.add(Recebivel.create(
				"1H01R6HH1", 
				LocalDate.parse("2023-05-05"), 
				LocalDate.parse("2023-10-10"),
				new BigDecimal("100.27")
				));
		rs.add(Recebivel.create(
				"1H01R6HI1", 
				LocalDate.parse("2023-05-02"), 
				LocalDate.parse("2023-10-12"),
				new BigDecimal("3021.83")
				));
		rs.add(Recebivel.create(
				"1H01R6HJ1", 
				LocalDate.parse("2023-05-03"), 
				LocalDate.parse("2023-09-19"),
				new BigDecimal("1930.76")
				));

		RECEBIVEIS = Collections.unmodifiableSet(rs);
	}

	public static class Recebivel {
		
		public static Recebivel create(String codigo, LocalDate dataEmissao, LocalDate dataVencimento,
				BigDecimal valor) {
			Recebivel r = new Recebivel();
			r.codigo = codigo;
			r.dataEmissao = dataEmissao;
			r.dataVencimento = dataVencimento;
			r.valor = valor;
			return r;
		}

		private String codigo;
		private LocalDate dataEmissao;
		private LocalDate dataVencimento;
		private BigDecimal valor;

	}
}
