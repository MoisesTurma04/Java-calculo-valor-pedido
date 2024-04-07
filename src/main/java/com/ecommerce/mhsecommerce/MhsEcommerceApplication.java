package com.ecommerce.mhsecommerce;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.mhsecommerce.entities.Order;
import com.ecommerce.mhsecommerce.exceptions.ExceptionUtil;
import com.ecommerce.mhsecommerce.services.OrderService;

@SpringBootApplication
public class MhsEcommerceApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(MhsEcommerceApplication.class, args);

	}

	@Override
	public void run(String... args) {
		Locale.setDefault(Locale.US);

		int code;
		double basic;
		double discount;

		try (Scanner sc = new Scanner(System.in)) {
			while (true) {
				try {
					System.out.println("Digite os dados do pedido: ");
					System.out.println("Código: ");
					code = sc.nextInt();
					if (code < 0) {
						ExceptionUtil.handleNegativeNumberException();
						continue;
					}
					System.out.println("Valor básico: ");
					basic = sc.nextDouble();
					if (basic < 0) {
						ExceptionUtil.handleNegativeNumberException();
						continue;
					}
					System.out.println("Porcentagem de desconto: ");
					discount = sc.nextDouble();
					if (discount < 0) {
						ExceptionUtil.handleNegativeNumberException();
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					ExceptionUtil.handleInputMismatchException(e);
				} catch (Exception e) {
					System.out.println("Erro: " + e.getMessage());
				} finally {
					sc.nextLine();
				}
			}

			Order order = new Order(code, basic, discount);
			double total = orderService.total(order);

			System.out.println("Pedido código: " + code);
			System.out.printf("Valor total: R$ %.2f ", total);
		}
	}

}
