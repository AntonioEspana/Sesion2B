package pkg;

import pkg.Empleado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author AntonioEspana
 */
public class EmpleadoTest {

    public EmpleadoTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    private final Empleado emp = new Empleado();
    
    private Empleado.TipoEmpleado vendedor = Empleado.TipoEmpleado.Vendedor;
    private Empleado.TipoEmpleado encargado = Empleado.TipoEmpleado.Encargado;

    @Test
    void testBruta_Vendedor_Ventas999_SinHoras() {
        float resultado = emp.calculoNominaBruta(vendedor, 999, 0);
        assertEquals(2000, resultado);
    }

    @Test
    void testBruta_Vendedor_Ventas1000_SinHoras() {
        float resultado = emp.calculoNominaBruta(vendedor, 1000, 0);
        assertEquals(2000 + 100, resultado);
    }

    @Test
    void testBruta_Vendedor_Ventas1500_SinHoras() {
        float resultado = emp.calculoNominaBruta(vendedor, 1500, 0);
        assertEquals(2000 + 200, resultado);
    }

    @Test
    void testBruta_Encargado_Ventas999_1Hora() {
        float resultado = emp.calculoNominaBruta(encargado, 999, 1);
        assertEquals(2500 + 30, resultado);
    }

    @Test
    void testBruta_Encargado_Ventas1600_10Horas() {
        float resultado = emp.calculoNominaBruta(encargado, 1600, 10);
        assertEquals(2500 + 200 + (10 * 30), resultado);
    }

    @Test
    void testNeta_Bruta2099_SinRetencion() {
        float resultado = emp.calculoNominaNeta(2099);
        assertEquals(2099, resultado);
    }

    @Test
    void testNeta_Bruta2100_Con15() {
        float resultado = emp.calculoNominaNeta(2100);
        assertEquals(2100 * 0.85f, resultado);
    }

    @Test
    void testNeta_Bruta2200_Con15() {
        float resultado = emp.calculoNominaNeta(2200);
        assertEquals(2200 * 0.85f, resultado);
    }

    @Test
    void testNeta_Bruta2500_Con18() {
        float resultado = emp.calculoNominaNeta(2500);
        assertEquals(2500 * 0.82f, resultado);
    }

    @Test
    void testNeta_Bruta2600_Con18() {
        float resultado = emp.calculoNominaNeta(2600);
        assertEquals(2600 * 0.82f, resultado);
    }
}
