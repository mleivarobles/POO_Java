/*
 * EJEMPLO INTEGRADOR - Sistema de Cine
 * Consolidacion Modulos 4, 5, 6 y 7
 *
 * Este Main demuestra cada concepto por separado, en secciones numeradas,
 * para facilitar la explicacion en clase.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  SISTEMA DE CINE - EJEMPLO INTEGRADOR");
        System.out.println("========================================\n");

        // ---------------------------------------------------------------
        // SECCION 1: Abstraccion y Herencia (Modulo 5)
        // Persona es abstracta — no se puede instanciar directamente.
        // Cliente y Director heredan de Persona e implementan mostrarRol().
        // ---------------------------------------------------------------
        System.out.println("--- SECCION 1: Abstraccion y Herencia ---");

        Director nolan = new Director("Christopher Nolan", "11.111.111-1", "Britanico");
        Director bongJoon = new Director("Bong Joon-ho", "22.222.222-2", "Surcoreano");

        Cliente maria = new Cliente("Maria Lopez", "33.333.333-3", "maria@mail.com", "estudiante");
        Cliente pedro = new Cliente("Pedro Soto", "44.444.444-4", "pedro@mail.com", "tercera_edad");
        Cliente ana = new Cliente("Ana Ruiz", "55.555.555-5", "ana@mail.com", "general");

        // Polimorfismo: todos son Persona, cada uno muestra su rol
        Persona[] personas = {nolan, bongJoon, maria, pedro, ana};
        for (Persona p : personas) {
            p.mostrarRol();
        }

        // ---------------------------------------------------------------
        // SECCION 2: Interfaces (Modulo 5)
        // Pelicula implementa Proyectable y Vendible.
        // Sala trabaja con Proyectable (no con Pelicula directa) — DIP.
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 2: Interfaces ---");

        Pelicula inception = new Pelicula("Inception", 148, "Ciencia Ficcion",
                "14+", 5500, nolan);
        Pelicula parasite = new Pelicula("Parasite", 132, "Thriller",
                "14+", 5000, bongJoon);
        Pelicula interstellar = new Pelicula("Interstellar", 169, "Ciencia Ficcion",
                "TE+7", 6000, nolan);

        // Usar como Proyectable (interfaz)
        Proyectable contenido = inception;
        System.out.println("Titulo: " + contenido.getTitulo());
        System.out.println("Duracion: " + contenido.getDuracionMinutos() + " min");
        System.out.println("Apta para menores: " + contenido.esAptaParaMenores());

        // Usar como Vendible (interfaz)
        Vendible producto = inception;
        System.out.println("Precio base: $" + producto.getPrecioBase());

        // ---------------------------------------------------------------
        // SECCION 3: Asociacion — Pelicula <-> Director (Modulo 6)
        // Ambos existen independientemente. Pelicula referencia a Director
        // pero no lo crea ni lo destruye.
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 3: Asociacion (Pelicula - Director) ---");

        System.out.println(inception);  // muestra director asociado
        System.out.println(parasite);

        // El director existe aunque no tenga pelicula asignada aqui
        Director tarantino = new Director("Quentin Tarantino", "66.666.666-6", "Estadounidense");
        tarantino.mostrarRol(); // existe por si mismo

        // ---------------------------------------------------------------
        // SECCION 4: Composicion — Cine contiene Salas (Modulo 6)
        // Las Salas se crean DENTRO del constructor de Cine.
        // No existen sin el Cine.
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 4: Composicion (Cine - Sala) ---");

        Cine cinePOO = new Cine("CinePOO", 3, 50);
        // Las 3 salas ya fueron creadas dentro del constructor
        // No se pueden crear salas sueltas y agregarlas desde fuera

        // ---------------------------------------------------------------
        // SECCION 5: Agregacion — Cine recibe Peliculas (Modulo 6)
        // Las peliculas fueron creadas fuera y se agregan al catalogo.
        // Si el cine desaparece, las peliculas siguen existiendo.
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 5: Agregacion (Cine - Pelicula) ---");

        cinePOO.agregarAlCatalogo(inception);
        cinePOO.agregarAlCatalogo(parasite);
        cinePOO.agregarAlCatalogo(interstellar);

        System.out.println("Peliculas en catalogo: " + cinePOO.getCantidadPeliculas());

        // Programar funciones
        cinePOO.programarFuncion(1, inception);
        cinePOO.programarFuncion(2, parasite);
        cinePOO.programarFuncion(3, interstellar);

        cinePOO.mostrarCartelera();

        // ---------------------------------------------------------------
        // SECCION 6: Dependencia — CalculadoraPrecio (Modulo 6)
        // y OCP / Strategy Pattern (Modulo 7)
        //
        // Al vender un boleto, Sala crea una CalculadoraPrecio como
        // variable local (dependencia) y le pasa la estrategia de
        // descuento (OCP: nuevos descuentos sin modificar Sala).
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 6: Dependencia + OCP (Strategy) ---");

        // Diferentes estrategias de descuento — OCP
        EstrategiaDescuento sinDescuento = new SinDescuento();
        EstrategiaDescuento descEstudiante = new DescuentoEstudiante();
        EstrategiaDescuento descTerceraEdad = new DescuentoTerceraEdad();

        // Vender boletos con distintas estrategias
        Boleto boleto1 = cinePOO.venderBoleto(1, 15, inception, sinDescuento);
        Boleto boleto2 = cinePOO.venderBoleto(1, 16, inception, descEstudiante);
        Boleto boleto3 = cinePOO.venderBoleto(2, 1, parasite, descTerceraEdad);

        System.out.println("\n" + boleto1);
        System.out.println("\n" + boleto2);
        System.out.println("\n" + boleto3);

        // ---------------------------------------------------------------
        // SECCION 7: Encapsulamiento en accion (Modulo 4)
        // No se puede acceder a listas internas, solo a cantidades.
        // Los boletos son inmutables despues de crearse.
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 7: Encapsulamiento ---");

        System.out.println("Salas del cine: " + cinePOO.getCantidadSalas());
        System.out.println("Peliculas en catalogo: " + cinePOO.getCantidadPeliculas());
        // cinePOO.salas → ERROR: es private
        // cinePOO.catalogo → ERROR: es private
        // boleto1.setPrecioFinal(0) → ERROR: no existe setter

        System.out.println("Boleto #" + boleto1.getNumero() + " precio: $" + boleto1.getPrecioFinal());
        System.out.println("El precio no se puede modificar despues de emitido (inmutable)");

        // ---------------------------------------------------------------
        // SECCION 8: Principios de diseno en resumen (Modulo 7)
        // ---------------------------------------------------------------
        System.out.println("\n--- SECCION 8: Principios de Diseno ---");
        System.out.println("SRP: Cada clase tiene una responsabilidad:");
        System.out.println("  - Cine: coordina salas y catalogo");
        System.out.println("  - Sala: gestiona asientos y vende boletos");
        System.out.println("  - CalculadoraPrecio: solo calcula precios");
        System.out.println("  - Boleto: solo almacena datos de la venta");

        System.out.println("\nOCP: Agregar DescuentoGrupal solo requiere:");
        System.out.println("  1. Crear clase DescuentoGrupal implements EstrategiaDescuento");
        System.out.println("  2. Nada mas — Sala y Cine no se modifican");

        System.out.println("\nDIP: Las clases dependen de abstracciones:");
        System.out.println("  - Sala trabaja con Proyectable, no con Pelicula");
        System.out.println("  - CalculadoraPrecio recibe EstrategiaDescuento, no SinDescuento");
        System.out.println("  - Cine guarda List<Proyectable>, no List<Pelicula>");

        System.out.println("\n========================================");
        System.out.println("  FIN DEL EJEMPLO INTEGRADOR");
        System.out.println("========================================");
    }
}
