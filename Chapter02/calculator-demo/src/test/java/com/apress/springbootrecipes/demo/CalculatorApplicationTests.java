package com.apress.springbootrecipes.demo;

import com.apress.springbootrecipes.demo.calculator.Calculator;
import com.apress.springbootrecipes.demo.calculator.Operation;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTests {
    @Rule
    public OutputCapture capture = new OutputCapture();

    @MockBean
    private Calculator calculator;

    @MockBean(name = "addition")
    private Operation mockOperation;

    @MockBean(name = "division")
    private Operation getMockOperation;

    @Test
    public void doingMultiplicationShouldSucceed() {
        calculator.calculate(12, 13, '*');
        capture.expect(Matchers.containsString("12 * 13 = 156"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void doingDivisionShouldFall() {
        calculator.calculate(12, 13, '/');
    }

    @Test
    public void calculatorShouldHave3Operation() {
        Object operations = ReflectionTestUtils.getField(calculator, "operations");
        assertThat((Collection) operations).hasSize(3);
    }

    @Test

}
