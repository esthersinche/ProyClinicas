package domain.model.aggregates;

import com.Clinica1.myApp.appointments.domain.model.valueobjects.Email;
import com.Clinica1.myApp.SharedKernel.IDEntidad;
import com.Clinica1.myApp.appointments.domain.model.aggregates.Paciente;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PacienteTest {

    @Test
    void testConstructorCompleto() {
        IDEntidad id = IDEntidad.generar();
        Date fecha = new Date();
        Email email = new Email("paciente@mail.com");

        Paciente paciente = new Paciente(
                id,
                "Juan Pérez",
                "Peruana",
                "12345678",
                "987654321",
                email,
                fecha,
                "Masculino"
        );

        assertEquals(id, paciente.getId_pac());
        assertEquals("Juan Pérez", paciente.getNombre_com_pac());
        assertEquals("Peruana", paciente.getNacionalidad_pac());
        assertEquals("12345678", paciente.getDni_pac());
        assertEquals("987654321", paciente.getTel_pac());
        assertEquals(email, paciente.getEmail_pac());
        assertEquals(fecha, paciente.getFec_nac_pac());
        assertEquals("Masculino", paciente.getSexo_pac());
    }

    @Test
    void testFactoryMethod() {
        Date fecha = new Date();
        Email email = new Email("factory@mail.com");

        Paciente paciente = Paciente.createpac(
                "Carlos Ramos",
                "Colombiana",
                "87654321",
                "912345678",
                email,
                fecha,
                "Masculino"
        );

        assertNotNull(paciente.getId_pac());
        assertEquals("Carlos Ramos", paciente.getNombre_com_pac());
        assertEquals("Colombiana", paciente.getNacionalidad_pac());
        assertEquals("87654321", paciente.getDni_pac());
        assertEquals("912345678", paciente.getTel_pac());
        assertEquals(email, paciente.getEmail_pac());
        assertEquals(fecha, paciente.getFec_nac_pac());
        assertEquals("Masculino", paciente.getSexo_pac());
    }

    @Test
    void testEqualsDebeCompararSoloPorId() {
        IDEntidad id = IDEntidad.generar();

        Date fecha = new Date();
        Email email = new Email("test@mail.com");

        Paciente p1 = new Paciente(
                id, "Nombre1", "Nac", "111", "222", email, fecha, "M"
        );

        Paciente p2 = new Paciente(
                id, "OtroNombre", "OtraNac", "999", "888", email, fecha, "F"
        );

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testEqualsDebeSerFalsoSiIdEsDistinto() {
        Paciente p1 = new Paciente(
                IDEntidad.generar(), "A", "B", "1", "2", new Email("a@mail.com"), new Date(), "M"
        );
        Paciente p2 = new Paciente(
                IDEntidad.generar(), "A", "B", "1", "2", new Email("a@mail.com"), new Date(), "M"
        );

        assertNotEquals(p1, p2);
    }
}
