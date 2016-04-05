package ConexionBD;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chris
 */
public class CreateMan2 {

    public void create(HttpServletResponse response, ServletContext context) throws IOException {
        try {
            String liga_home = Constantes.APP_HOME ;
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, baos);

            doc.open();
            
            Paragraph vacio = new Paragraph("                           ", FontFactory.getFont("arial", 10, Font.BOLD));
            vacio.setAlignment(Element.ALIGN_CENTER);
            String espacios = "         ";

            String url_logo = "/Imagenes/header_ittoluca_pdf.png";
            String absolute_url_logo = context.getRealPath(url_logo);
            Image itt_logo = Image.getInstance(absolute_url_logo);
            Image Logo_itt_head = Image.getInstance(itt_logo);
            Image Logo_itt_head2 = Image.getInstance(itt_logo);

            String url_logo4 = "/Imagenes/footer_ittoluca_footer.png";
            String absolute_url_logo4 = context.getRealPath(url_logo4);
            Image itt_logo4 = Image.getInstance(absolute_url_logo4);
            Image Logo_itt_footer = Image.getInstance(itt_logo4);
            Image Logo_itt_footer2 = Image.getInstance(itt_logo4);
            
            String manual_imagen = "/Imagenes/manual_imagen2.jpg";
            String absolute_ur_lmanual_imagen = context.getRealPath(manual_imagen);
            Image itt_logo3 = Image.getInstance(absolute_ur_lmanual_imagen);
            Image Manual_imagen = Image.getInstance(itt_logo3);
            
            

            // Inicia pagina
            Logo_itt_head.setAbsolutePosition(30f, 770f);
            doc.add(Logo_itt_head);
            addEmptyLine(doc, 3);
            Paragraph depto = new Paragraph("Proceso de Registro del Aspirante.", FontFactory.getFont("arial black", 15, Font.BOLD, BaseColor.BLUE.darker()));
            depto.setAlignment(Element.ALIGN_CENTER);
            doc.add(depto);


            Paragraph p1 = new Paragraph("ETAPA 1: CREACIÓN DE PREFICHA \n", FontFactory.getFont("arial black", 11, Font.BOLD, BaseColor.BLUE.darker()));
            p1.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p1);
            Paragraph d1 = new Paragraph(""
                    + espacios + "1.1 Ingrese a la liga:"+ liga_home + "\n"
                    + espacios + "1.2 Ingrese a la liga que será enviada a su correo electrónico para empezar su registro.\n"
                    + espacios + "1.3 Responda los cuestionarios  y  siga  las indicaciones.  \n"
                    + espacios + "1.4 Obtenga la preficha  que será enviada  a su correo electrónico.", FontFactory.getFont("arial", 9, Font.BOLD));
            d1.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d1);
            Paragraph d1_1 = new Paragraph("\nNota: Es importante considerar que una vez realizado su registro tendrá dos días "
                    + "hábiles para realizar su pago. Al no realizar el pago oportuno de su preficha, su lugar en el Instituto "
                    + "no será contemplado.\n"
                    + "En caso de que su referencia expire usted podrá renovarla en el apartado de “RENOVAR REFERENCIA” y tendrá "
                    + "un día hábil para pagarla, recuerde que únicamente tendrá dos oportunidades para renovar su referencia.", FontFactory.getFont("arial", 9, Font.BOLD));
            d1_1.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d1_1);

            Paragraph p2 = new Paragraph("ETAPA 2: PAGO POR DERECHOS DE EXAMEN DE ADMISIÓN.\n", FontFactory.getFont("arial black", 11, Font.BOLD, BaseColor.BLUE.darker()));
            p2.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p2);
            Paragraph d2 = new Paragraph(" "
                    + espacios + "2.1 Realice  el  pago por  derechos a  examen de admisión,  con la   REFERENCIA que se encuentra\n"
                    + espacios + "       en la Preficha , en cualquier sucursal BANAMEX.\n"
                    + espacios + "2.2 Cuando su pago sea procesado recibirá una notificación  a su correo electrónico, además \n"
                    + espacios + "       de las indicaciones para continuar con el  proceso de registro.", FontFactory.getFont("arial black", 9, Font.BOLD));
            d2.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d2);

            Paragraph p3 = new Paragraph("ETAPA 3: OBTENCIÓN DE   FICHA.\n", FontFactory.getFont("arial black", 11, Font.BOLD, BaseColor.BLUE.darker()));
            p3.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p3);

            Paragraph d3 = new Paragraph(""
                    + espacios + "Valide  su  correo electrónico ya que le será enviada la Ficha para continuar con su registro.\n"
                    + espacios + "Importante: Se le recomienda estar al pendiente ya que vía correo electrónico recibirá la FICHA que  usará para \n"
                    + espacios + "                     su  registro  en CENEVAL.", FontFactory.getFont("arial black", 9, Font.BOLD));
            d3.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d3);
            
            Paragraph p4 = new Paragraph("ETAPA 4: REGISTRO CENEVAL.\n", FontFactory.getFont("arial black", 11, Font.BOLD, BaseColor.BLUE.darker()));
            p4.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p4);

            Paragraph d4 = new Paragraph(""
                    + espacios + "4.1 Ingrese a la liga que se  enviará  a su correo electrónico para llevar a cabo  el  registro  en CENEVAL .\n"
                    + espacios + "En dicho registro  seleccione  al Instituto Tecnológico de  Toluca en el apartado de escuela  así como la"
                    +"                                    carrera por la cual participa. Además tendrá que ingresar   la  Ficha que le fue enviada a su correo.\n"
                    + espacios + "4.2 Imprima su pase de ingreso al examen de admisión al terminar su registro CENEVAL.", FontFactory.getFont("arial black", 9, Font.BOLD));
            d4.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d4);

            Paragraph p5 = new Paragraph("ETAPA 5: ACUDA  A LAS INSTALACIONES DEL TECNOLÓGICO.", FontFactory.getFont("arial black", 11, Font.BOLD, BaseColor.BLUE.darker()));
            p5.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p5);

            Paragraph d5 = new Paragraph(""
                    + espacios + "5.1  Canjee el  comprobante  de pago.\n"
                    + espacios + "  5.1.1 Acuda al Depto.  de SERVICIOS FINANCIEROS (Edif.” A”) de Lunes a Viernes de 9:00 a 18:00 hrs.\n"
                    + espacios + "           Cambie su comprobante  de pago proporcionado por el banco  por el recibo oficial de pago de la institución.\n"
                    + espacios + "5.2  Entrege  la  documentación  correspondiente.\n"
                    + espacios + "  5.2.1 Acuda al Depto.  de SERVICIOS ESCOLARES (Edif.” X” ) de Lunes a Viernes de 9:00 a 18:00 hrs. \n"
                    + espacios + "           Entregue  su  pase de ingreso al examen de admisión firmado, recibo  oficial de pago , una fotografía\n"
                    + espacios + "           tamaño infantil (blanco/ negro o a color) y  preficha. \n"
                    + espacios + "  5.2.2 Obtenga guías de estudio.\n"
                    + espacios + "  5.2.3 Obtenga la   Ficha de examen con la información necesaria  para presentar su examen de admisión.\n", FontFactory.getFont("arial black", 9, Font.BOLD));
            d5.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d5);
            addEmptyLine(doc, 3);
            
            Logo_itt_footer.setAbsolutePosition(30f, 10f);
            doc.add(Logo_itt_footer);
            
            //New page
            doc.newPage();
            
            Logo_itt_head2.setAbsolutePosition(30f, 770f);
            doc.add(Logo_itt_head2);
            
            addEmptyLine(doc, 1);
            
            Paragraph p6 = new Paragraph("Aviso Importante.", FontFactory.getFont("arial black", 13, Font.BOLD, BaseColor.RED));
            p6.setAlignment(Element.ALIGN_CENTER);
            doc.add(p6);

            Paragraph d6 = new Paragraph(""
                    + "Para recuperar la preficha   ingrese a la siguiente liga" + liga_home  + "en el apartado de “Recuperar preficha”.\n"
                    + "Deberá contar con su clave CURP para  poder acceder.\n"
                    + "Verifique  que el folio de su  pase de ingreso al examen  de admisión (folio  CENEVAL)  y la FICHA PARA EL EXAMEN DE ADMISIÓN  en la Ficha de examen coincidan.\n"
                    + "Presente  el examen de admisión y el examen de matemáticas  en la fecha, hora y el aula que se marca  en su  Ficha de examen.\n", FontFactory.getFont("arial black", 9, Font.BOLD, BaseColor.BLACK));
            d6.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d6);

            Paragraph d7 = new Paragraph("Durante el proceso de registro recibirá los siguientes correos, por favor permanezca al pendiente:\n"
                    + "1.-Correo de la liga para el  registro. (Etapa 1).\n"
                    + "2.-Correo de generación de preficha, que se le enviará al concluir el registro de sus datos. (Etapa 1)\n"
                    + "3.-Correo de liberación de pago, en un periodo máximo de 3 a 4 días hábiles después de haber realizado el pago bancario. (Etapa 2)\n"
                    + "4.-Correo de alta en CENEVAL, máximo 2 días hábiles después de haber recibido el correo de liberación de pago.\n"
                    + "    Es importante que reciba estos dos últimos correos. (Etapa 3 )\n"
                    + "5.-Correo de generación de ficha, que se enviará al concluir el proceso de registro, esto es después de haber entregado\n"
                    + "    sus papeles en el departamento de servicios escolares edif. X. (Etapa 5)\n", FontFactory.getFont("arial black", 9, Font.BOLD, BaseColor.BLACK));
            d7.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(d7);
            
            Manual_imagen.setAbsolutePosition(135f,60f);
            Manual_imagen.scalePercent(38f);
            doc.add(Manual_imagen);
           
            
            Logo_itt_footer2.setAbsolutePosition(30f, 10f);
            doc.add(Logo_itt_footer2);

            doc.close();
            
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            OutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        } catch (DocumentException docE) {
            throw new IOException(docE.getMessage());
        }
    }
    
    private static void addEmptyLine (Document doc, int number) throws DocumentException {
        for (int i = 0; i < number; i++) {
            doc.add(new Paragraph(" "));
        }
    }
}
