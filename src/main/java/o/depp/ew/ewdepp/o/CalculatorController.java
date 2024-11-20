package o.depp.ew.ewdepp.o;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String calculator() {
        return calculatorService.calculator();
    }

    @GetMapping("/plus")
    public String plus(
            @RequestParam(name = "num1", required = false) Integer num1,
            @RequestParam(name = "num2", required = false) Integer num2
    ) {
        if (num1 == null || num2 == null) {
            return "Не указаны аргументы num1 или num2";
        }
        return calculatorService.plus(num1, num2).toString();
    }

    @GetMapping("/minus")
    public String minus(
            @RequestParam(name = "num1", required = false) Integer num1,
            @RequestParam(name = "num2", required = false) Integer num2
    ){
        if (num1 == null || num2 == null) {
            return "Не указаны аргументы num1 или num2";
        }
        return calculatorService.minus(num1, num2).toString();
    }

    @GetMapping("/multiply")
    public String multiply(
            @RequestParam(name = "num1", required = false) Integer num1,
            @RequestParam(name = "num2", required = false) Integer num2
    ){
        if (num1 == null || num2 == null) {
            return "Не указаны аргументы num1 или num2";
        }
        return calculatorService.multiply(num1, num2).toString();
    }

    @GetMapping("/divide")
    public String divide(
            @RequestParam(name = "num1", required = false) Integer num1,
            @RequestParam(name = "num2", required = false) Integer num2
    ){
        if (num1 == null || num2 == null) {
            return "Не указаны аргументы num1 или num2";
        }
        if (num2.equals(0)) {
            return "Делить на 0 нельзя";
        }
        return calculatorService.divide(num1, num2).toString();
    }
}
