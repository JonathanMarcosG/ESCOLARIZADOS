package ConexionBD;

import beans.PrefichaModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import modelos.GeneraAuditoria;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Chris
 */
public class CreatePreficha2 {

    public void noRenovar(HttpServletResponse response, ServletContext context, String mje) {
        try {
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, baos);
            //PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());

            doc.open();

            //PdfContentByte canvas = writer.getDirectContent();
            Paragraph vacio = new Paragraph("  ", FontFactory.getFont("arial", 10, Font.BOLD));
            vacio.setAlignment(Element.ALIGN_CENTER);

            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);

            Paragraph curpNoEncontrada = new Paragraph("                                                        Lo sentimos pero no es posible renovar "
                    + "                                                                             por la siguiente razón: ", FontFactory.getFont("arial", 14, Font.BOLD));
            curpNoEncontrada.setAlignment(Element.ALIGN_LEFT);
            doc.add(curpNoEncontrada);

            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);

            Paragraph curp_no = new Paragraph(mje, FontFactory.getFont("arial", 19, Font.PLAIN));
            curp_no.setAlignment(Element.ALIGN_CENTER);
            doc.add(curp_no);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);

            Paragraph lamenta = new Paragraph(""
                    + "El departamento de servicios escolares lamenta los inconvenientes."
                    + "", FontFactory.getFont("arial", 19, Font.BOLD));
            lamenta.setAlignment(Element.ALIGN_CENTER);
            doc.add(lamenta);

            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);

            Paragraph msjCurp = new Paragraph("\n"
                    + "\n\n\n\n\n\n\n"
                    + ""
                    + "", FontFactory.getFont("arial", 10, Font.BOLD));
            msjCurp.setAlignment(Element.ALIGN_LEFT);
            doc.add(msjCurp);

            doc.add(vacio);
            doc.add(vacio);
            doc.add(vacio);

            Paragraph no_comprobante = new Paragraph(""
                    + "Este documento carece de validéz oficial, su función es servir como medio de comunicación.", FontFactory.getFont("arial", 8, Font.PLAIN, BaseColor.RED));
            no_comprobante.setAlignment(Element.ALIGN_CENTER);
            doc.add(no_comprobante);

            String url_logo = "/Imagenes/itt_logo_opt.jpg";
            String absolute_url_logo = context.getRealPath(url_logo);
            Image itt_logo = Image.getInstance(absolute_url_logo);

            Image Logo_itt = Image.getInstance(itt_logo);
            Logo_itt.setAbsolutePosition(140f, 640f);
            doc.add(Logo_itt);

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
        } catch (DocumentException | IOException dex) {
        }
    }

    public void create(HttpServletResponse response, ServletContext context, String curp) {
        PrefichaModel preficha = canConnect(curp);

        try {
            Document doc = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(doc, baos);
            PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());

            doc.open();

            //PdfContentByte canvas = writer.getDirectContent();
            Paragraph vacio = new Paragraph("  ", FontFactory.getFont("arial", 10, Font.BOLD));
            vacio.setAlignment(Element.ALIGN_CENTER);

            if (preficha.getExiste() == 1) {
                //La CURP ingresada tiene una prficha asociada
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph periodo_text = new Paragraph("Convocatoria de nuevo ingreso periodo: " + preficha.getPeriodobd(), FontFactory.getFont("arial", 10, Font.BOLD));
                periodo_text.setAlignment(Element.ALIGN_CENTER);
                doc.add(periodo_text);

                doc.add(vacio);
                doc.add(vacio);

                Paragraph fotografia = new Paragraph("", FontFactory.getFont("arial", 10, Font.BOLD));
                fotografia.setAlignment(Element.ALIGN_CENTER);
                doc.add(fotografia);
                doc.add(vacio);

                String url_logo = "/Imagenes/itt_logo_opt.jpg";
                String absolute_url_logo = context.getRealPath(url_logo);
                Image itt_logo = Image.getInstance(absolute_url_logo);
                Image Logo_itt = Image.getInstance(itt_logo);
                Logo_itt.setAbsolutePosition(260f, 640f);
                doc.add(Logo_itt);

                PdfContentByte rectangulo_periodo = writer.getDirectContentUnder();
                rectangulo_periodo.rectangle(125, 725, 350, 20);
                rectangulo_periodo.fill();
                drawRectangleSC(rectangulo_periodo, 125, 725, 350, 20);

                String url_logo_bnmx = "/Imagenes/bnmx_color_opt.jpg";
                String absolute_url_logo_bnmx = context.getRealPath(url_logo_bnmx);
                Image bnmx_logo = Image.getInstance(absolute_url_logo_bnmx);

                Image Logo_banco = Image.getInstance(bnmx_logo);
                Logo_banco.setAbsolutePosition(380f, 310f);
                doc.add(Logo_banco);

                doc.add(vacio);

                PdfContentByte fechaimpr = writer.getDirectContentUnder();
                fechaimpr.rectangle(416, 635, 100, 35);
                fechaimpr.fill();
                drawRectangleSC(fechaimpr, 416, 635, 100, 35);

                Paragraph fechapdf_impr = new Paragraph("\tFecha de impresión                ", FontFactory.getFont("arial", 10, com.itextpdf.text.Font.BOLD));
                fechapdf_impr.setAlignment(Element.ALIGN_RIGHT);
                doc.add(fechapdf_impr);

                Paragraph fechapdf_fec = new Paragraph("\t" + preficha.getFechapdf() + "                          ", FontFactory.getFont("arial", 10, com.itextpdf.text.Font.BOLD));
                fechapdf_fec.setAlignment(Element.ALIGN_RIGHT);
                doc.add(fechapdf_fec);

                doc.add(vacio);

                Paragraph no_preficha = new Paragraph("Preficha N°: " + preficha.getPrefichabd(), FontFactory.getFont("arial", 20, Font.BOLD));
                no_preficha.setAlignment(Element.ALIGN_CENTER);
                doc.add(no_preficha);

                doc.add(vacio);

                PdfContentByte rectangulo_preficha_no = writer.getDirectContentUnder();
                rectangulo_preficha_no.rectangle(85, 590, 430, 25);
                rectangulo_preficha_no.fill();
                drawRectangleSC(rectangulo_preficha_no, 85, 590, 430, 25);

                PdfContentByte rectangulo_datos = writer.getDirectContentUnder();
                rectangulo_datos.rectangle(85, 480, 430, 105);
                rectangulo_datos.fill();
                drawRectangleSC(rectangulo_datos, 85, 480, 430, 105);

                Paragraph nombre = new Paragraph("                                                                              Nombre:   " + preficha.getNombrebd(),
                        FontFactory.getFont("arial", 10, Font.BOLD));
                nombre.setAlignment(Element.ALIGN_LEFT);
                doc.add(nombre);

                Paragraph apellidos = new Paragraph("                                                                                               " + preficha.getApellidosbd(),
                        FontFactory.getFont("arial", 10, Font.BOLD));
                apellidos.setAlignment(Element.ALIGN_LEFT);
                doc.add(apellidos);

                Paragraph CURP = new Paragraph("                                                                                 CURP:   " + preficha.getCurpbd(),
                        FontFactory.getFont("arial", 10, Font.BOLD));
                CURP.setAlignment(Element.ALIGN_LEFT);
                doc.add(CURP);

                Paragraph carrera = new Paragraph("Carrera Solicitada:",
                        FontFactory.getFont("arial", 10, Font.BOLD));
                carrera.setAlignment(Element.ALIGN_CENTER);
                doc.add(carrera);

                Paragraph Nomcarrera = new Paragraph(preficha.getCarrerabd(),
                        FontFactory.getFont("arial", 10, Font.BOLD));
                Nomcarrera.setAlignment(Element.ALIGN_CENTER);
                doc.add(Nomcarrera);

                Paragraph modalidad = new Paragraph("                                                                          Modalidad:   " + preficha.getModalidadbd(),
                        FontFactory.getFont("arial", 10, Font.BOLD));
                modalidad.setAlignment(Element.ALIGN_LEFT);
                doc.add(modalidad);

                doc.add(vacio);
//                    doc.add(vacio);

                Paragraph formatoBanamex = new Paragraph("\nFORMATO UNIVERSAL PARA DEPÓSITOS EN SUCURSALES BANAMEX", FontFactory.getFont("arial", 10, Font.BOLD));
                formatoBanamex.setAlignment(Element.ALIGN_CENTER);
                doc.add(formatoBanamex);

                PdfContentByte rectanguloDepositoB = writer.getDirectContentUnder();
                rectanguloDepositoB.rectangle(85, 440, 430, 20);
                rectanguloDepositoB.fill();
                drawRectangle(rectanguloDepositoB, 85, 440, 430, 20);

                PdfContentByte rectanguloPago = writer.getDirectContentUnder();
                rectanguloPago.rectangle(85, 250, 430, 190);
                rectanguloPago.fill();
                drawRectangleSC(rectanguloPago, 85, 250, 430, 190);

                doc.add(vacio);

                PdfContentByte rectanguloConcepto = writer.getDirectContentUnder();
                rectanguloConcepto.rectangle(150, 395, 295, 35);
                rectanguloConcepto.fill();
                drawRectangleSC(rectanguloConcepto, 150, 395, 295, 35);

                Paragraph formatoConceptoPre = new Paragraph("CONCEPTO: PAGO DE DERECHO A EXAMEN DE ADMISIÓN", FontFactory.getFont("arial", 10, Font.BOLD));
                formatoConceptoPre.setAlignment(Element.ALIGN_CENTER);
                doc.add(formatoConceptoPre);
                Paragraph fechaEmision = new Paragraph("FECHA LÍMITE DE PAGO: " + preficha.getFecha_limite_pago(), FontFactory.getFont("arial", 10, Font.BOLD));
                fechaEmision.setAlignment(Element.ALIGN_CENTER);
                doc.add(fechaEmision);

                doc.add(vacio);
                doc.add(vacio);

                Paragraph importe = new Paragraph("IMPORTE A PAGAR: $" + preficha.getImporte_bd() + ".°°", FontFactory.getFont("arial", 15, Font.BOLD));
                importe.setAlignment(Element.ALIGN_CENTER);
                doc.add(importe);

                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

//                    String ref = "44353452342353464765634523434";
                String ref = preficha.getRef_bancaria();

                Paragraph referencia = new Paragraph("REFERENCIA (B): " + ref, FontFactory.getFont("arial", 10, Font.BOLD));
                referencia.setAlignment(Element.ALIGN_CENTER);
                doc.add(referencia);

                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph atencion = new Paragraph("Atención", FontFactory.getFont("arial", 15, Font.BOLD));
                atencion.setAlignment(Element.ALIGN_CENTER);
                doc.add(atencion);

                PdfContentByte rectangulo_atencion = writer.getDirectContentUnder();
                rectangulo_atencion.rectangle(245, 215, 100, 25);
                rectangulo_atencion.fill();
                drawRectangle(rectangulo_atencion, 245, 215, 100, 25);

                PdfContentByte rectangulo_info = writer.getDirectContentUnder();
                rectangulo_info.rectangle(85, 60, 430, 150);
                rectangulo_info.fill();
                drawRectangle(rectangulo_info, 85, 60, 430, 150);

                doc.add(vacio);

                Paragraph informacion = new Paragraph(
                        "                             Para continuar con el proceso de preinscripción deberá:\n"
                        + "                           - Realizar el pago para su examen de admisión con la \"REFERENCIA\" que aparece\n"
                        + "                             en este documento en cualquier sucursal BANAMEX.\n"
                        + "                           - Estar al pendiente de su cuenta de correo electrónico ya que duante el proceso \n"
                        + "                             de registro recibirá las siguiente notificaciones: \n"
                        + "                                 1.-Correo  de generación de preficha, que se le enviará  al concluir el registro de sus datos. \n"
                        + "                                 2.-Correo de liberación de pago, en un periodo máximo de 3 a 4 días hábiles después de haber realizado el pago bancario. \n"
                        + "                                 3.-Correo de alta en Ceneval, máximo 2 días  hábiles después del correo anterior. \n"
                        + "                                    Es importante que reciba estos dos últimos correos. \n "
                        + "                                 4.-Correo de generación de ficha, que le será  enviado  al concluir el proceso de registro, esto después de haber entregado\n"
                        + "                                    sus papeles en el departamento de servicios escolares edif. X \n"
                        + "                             Advertencia:\n"
                        + "                             Es importante que considere que tendrá dos días hábiles para realizar su pago bancario anter de que su referencia expire.", FontFactory.getFont("arial", 7, Font.BOLD));
                informacion.setAlignment(Element.ALIGN_LEFT);
                doc.add(informacion);

            } else {
                //No se encontraron coincidencias con la CURP ingresada

                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph curpNoEncontrada = new Paragraph("                                                              Lo sentimos, no se encontraron "
                        + "                                                                                coincidencias con su clave CURP.", FontFactory.getFont("arial", 14, Font.BOLD));
                curpNoEncontrada.setAlignment(Element.ALIGN_LEFT);
                doc.add(curpNoEncontrada);

                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph curp_no = new Paragraph(curp, FontFactory.getFont("arial", 19, Font.PLAIN));
                curp_no.setAlignment(Element.ALIGN_CENTER);
                doc.add(curp_no);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph lamenta = new Paragraph(""
                        + "El deparamento de servicios escolares lamenta los inconvenientes ocurridos al intentar recuperar su preficha."
                        + "", FontFactory.getFont("arial", 19, Font.BOLD));
                lamenta.setAlignment(Element.ALIGN_CENTER);
                doc.add(lamenta);

                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph se_le_aconseja = new Paragraph("           RECOMENDACIONES", FontFactory.getFont("arial", 14, Font.BOLD));
                se_le_aconseja.setAlignment(Element.ALIGN_LEFT);
                doc.add(se_le_aconseja);

                Paragraph msjCurp = new Paragraph("\n"
                        + "              - Le aconsejamos revisar su CURP, ya que sin esta, no podrá recuperar su preficha.\n"
                        + "              - Si el problema continúa, acuda con esta hoja al departamento de SERVICIOS ESCOLARES (Edif.\n"
                        + "                X) de lunes a viernes de 9:00 a 18:00 horas, de lo contrario \n"
                        + "                haga su registro.\n"
                        + "              - Revise que en el proceso de registro cada paso se haya terminado correctamente\n"
                        + "              - Revise el manual de proceso de registro que se encuentra en la página www.ittoluca.edu.mx\n"
                        + "              - Revise el apartado de preguntas frecuentes que se encuentra en la página www.ittoluca.edu.mx\n"
                        + "              - En la sección de contacto, se encuentran el teléfono de contacto y la extensión.\n"
                        + "              - Otra alternativa es enviar un correo exponiendo su situación al departamento de servicios \n"
                        + "                escolares."
                        + "\n"
                        + ""
                        + "", FontFactory.getFont("arial", 10, Font.BOLD));
                msjCurp.setAlignment(Element.ALIGN_LEFT);
                doc.add(msjCurp);

                doc.add(vacio);
                doc.add(vacio);
                doc.add(vacio);

                Paragraph no_comprobante = new Paragraph(""
                        + "Este documento carece de validéz oficial, su función es servir como medio de comunicación.", FontFactory.getFont("arial", 8, Font.PLAIN, BaseColor.RED));
                no_comprobante.setAlignment(Element.ALIGN_CENTER);
                doc.add(no_comprobante);

                String url_logo = "/Imagenes/itt_logo_opt.jpg";
                String absolute_url_logo = context.getRealPath(url_logo);
                Image itt_logo = Image.getInstance(absolute_url_logo);

                Image Logo_itt = Image.getInstance(itt_logo);
                Logo_itt.setAbsolutePosition(140f, 640f);
                doc.add(Logo_itt);
            }
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
        } catch (DocumentException | IOException dex) {
        }
    }

    public static void drawRectangle(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
        content.setGState(state);
        content.setRGBColorFill(232, 232, 232);
        content.setColorStroke(BaseColor.BLUE);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public static void drawRectangleSC(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
        content.setGState(state);
        content.setRGBColorFill(0xFF, 0xFF, 0xFA);
        content.setColorStroke(BaseColor.BLUE);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public static void drawRectangleText(PdfContentByte content, float x, float y, float width, float height) {
        content.saveState();
        PdfGState state = new PdfGState();
        content.setGState(state);
        content.setRGBColorFill(0, 230, 255);
        content.setColorStroke(BaseColor.BLUE);
        content.setLineWidth((float) .5);
        content.rectangle(x, y, width, height);
        content.fillStroke();
        content.restoreState();
    }

    public PrefichaModel canConnect(String curp) {
        String user = Constantes.BD_NAME;
        String pass = Constantes.BD_PASS;

        PrefichaModel prefichaTmp = new PrefichaModel();

        try {
            String resultado_error;
            Conexion con = new Conexion(user, pass);
            CallableStatement cst;
            String nombrebd;

            cst = con.getConnection().prepareCall("{call FICHAS.PQ_GET_ASPIRANTE_2.GET_RECUPERAR_PREFICHA_ASP_SP(?,?,?,?)}");
            cst.setString("paCurpAspirante", curp);
            cst.registerOutParameter("paCurRetorno", OracleTypes.CURSOR);
            cst.registerOutParameter("paCodigoError", OracleTypes.NUMBER);
            cst.registerOutParameter("paMjeDescError", OracleTypes.VARCHAR);
            cst.execute();
            resultado_error = cst.getString("paCodigoError");

            if ("0".equals(resultado_error)) {
                ResultSet rset = (ResultSet) cst.getObject("paCurRetorno");
                while (rset.next()) {
                    nombrebd = rset.getString("NOMBRE");
                    if ("".equals(nombrebd) || nombrebd == null) {
                        prefichaTmp.setExiste(0);
                    } else {

                        String appat = rset.getObject("APELLIDO_PAT").toString();
                        String apmat = rset.getObject("APELLIDO_MAT").toString();
                        String date_exp_ref = rset.getString("FECHA_EXPIRA_REF");

                        prefichaTmp.setNombrebd(rset.getObject("NOMBRE").toString());
                        prefichaTmp.setApellidosbd(appat + " " + apmat);
                        prefichaTmp.setCarrerabd(rset.getObject("NOMBRE_CARRERA").toString());
                        prefichaTmp.setPrefichabd(rset.getObject("PREFICHA").toString());
                        prefichaTmp.setPeriodobd(rset.getObject("PERIODO_CONSURSA").toString());
                        prefichaTmp.setModalidadbd(rset.getObject("MODALIDAD").toString());
                        prefichaTmp.setRef_bancaria(rset.getObject(11).toString());
                        prefichaTmp.setImporte_bd(rset.getObject("IMPORTE").toString());
                        //prefichaTmp.set(rset.getObject("FECHA_EMISION").toString());
                        prefichaTmp.setFechapdf(rset.getObject("FECHA_ACTUAL").toString());

                        //Revisamos si el aspirate tiene fecha de expriacion de referecia:
                        // Si la fecha no viene valida, ponemos 'No asignada'
                        // Si la fecha es valida, simplemente la asignamos.
                        prefichaTmp.setFecha_limite_pago((date_exp_ref == null || "".equals(date_exp_ref)) ? "No asignada" : date_exp_ref);
//                        fechalim = rset.getObject("FECHA_LIMITE_PAGO").toString();

                        prefichaTmp.setCurpbd(curp);
                        prefichaTmp.setExiste(1);
                    }
                }
                cst.close();
                con.CerraConexion();
            } else {
                con.CerraConexion();
                GeneraAuditoria ob = new GeneraAuditoria();
                ob.crea_archivo(resultado_error, "No se logró crear la preficha", "Error al generar la Preficha.");
                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(servlets.PrefichaPDF.class.getName()).log(Level.SEVERE, null, ex);
            prefichaTmp.setExiste(0);
        }

        return prefichaTmp;
    }

}
