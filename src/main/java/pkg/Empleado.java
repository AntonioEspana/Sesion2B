/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author AntonioEspana
 */
public class Empleado {

    public enum TipoEmpleado {
        Vendedor,
        Encargado
    }
    
    float salarioBase = 0;
    float prima = 0;
    float pagoHorasExtra = 0;

    public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
        

        switch (tipo) {
            case Vendedor:
                salarioBase = 2000;
                break;
            case Encargado:
                salarioBase = 2500;
                break;
            default:
                throw new IllegalArgumentException("Tipo de empleado no válido");
        }
        
        if (ventasMes >= 1500) {
            prima = 200;
        } else if (ventasMes >= 1000) {
            prima = 100;
        }

        // Pago por horas extra
        pagoHorasExtra = horasExtra * 30;

        return salarioBase + prima + pagoHorasExtra;
    }

    public float calculoNominaNeta(float nominaBruta) {
        float retencion = 0;

        if (nominaBruta >= 2100 && nominaBruta < 2500) {
            retencion = 0.15f;
        } else if (nominaBruta >= 2500) {
            retencion = 0.18f;
        }

        return nominaBruta * (1 - retencion);
    }
}
