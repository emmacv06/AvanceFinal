/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package visual;

/**
 *
 * @author emmac
 */
public class Visual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socio socio = Socio.registrarSocio();

        SalaDePesas salaDePesas = new SalaDePesas();
        Cabina cabina = new Cabina();
        Auditorio auditorio = new Auditorio();
        ClasesGrupales clasesGrupales = new ClasesGrupales();
        EspacioRecreativo espacioRecreativo = new EspacioRecreativo();
        Parqueo parqueo = new Parqueo();

        VentanaMenuPrincipal menu = new VentanaMenuPrincipal(
                socio, salaDePesas, cabina, auditorio,
                clasesGrupales, espacioRecreativo, parqueo);
        menu.setVisible(true);
    }
}
