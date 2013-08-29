package test.wadl;

/**
 *
 * @author david
 */
public class Reader
{
    /*public static void main(String arg[])
    {
        ApplicationDocument ad = ApplicationDocument.Factory.parse(new File());
        Application application = ad.getApplication();
        Resources resources = application.getResources();
        String base = resources.getBase();

        // <Resource>
        Resource resource = resources.getResource();
        String path   = resource.getPath();
        Method method = resource.getMethod();

        String id         = method.getId();
        String methodName = method.getName();
        Request  request  = method.getRequest();
        Response response = method.getResponse();

        //Request
        Param param = request.getParam();
        String paramName = param.getName();
        Boolean required = param.getRequired();
        String style     = param.getStyle();
        String type      = param.getType();

        //Response
        Representation representation = response.getRepresentation();
        Fault fault                   = response.getFault();

        String mediaTypeRepresentation = representation.getMediaType();

        String mediaTypeFault = fault.getMediaType();
        int status            = fault.getStatus();
        // </Resource>

        //ServiceGenerator.generate(serviceName, url, parameters, jsUrl);
    }*/

//    public static void main(String arg[])
//    {
//            try
//        {
//            ApplicationDocument ad = ApplicationDocument.Factory.parse(new File("/home/david/NetBeansProjects/MyCocktailSF/test.xml"));
//            Application application = ad.getApplication();
//            UnitActionPackage unitActionPackage = Converter.convertWADLtoUnitActionPackage(application);
//            System.out.println(ServiceGenerator.generateUnitActionPackage(unitActionPackage));
//        }
//        catch (JSONException ex)
//        {
//            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (IOException ex)
//        {
//            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (XmlException ex)
//        {
//            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
